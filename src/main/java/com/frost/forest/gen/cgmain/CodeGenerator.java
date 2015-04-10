package com.frost.forest.gen.cgmain;

import com.frost.forest.gen.anotation.query.Header;
import com.frost.forest.gen.viewmodel.FacadeModel;
import com.frost.forest.gen.viewmodel.ModelMetadata;
import javassist.CannotCompileException;
import javassist.NotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenkui on 2015/4/4.
 */
public class CodeGenerator {
    public static final String OUTPUT_DIR = "src/main/java/com/frost/forest/gen/bean/";
    public static final String FACADE_DIR = OUTPUT_DIR.concat("service/");
    public static final String CONTROLLER_DIR = OUTPUT_DIR.concat("controller/");
    public static final String VIEW_DIR = "src/main/webapp/WEB-INF/views/gen/";
    public static final String VIEW_BASE = "src/main/webapp/WEB-INF/views/";
    static {
        File[] gen = new File[]{
                new File(FACADE_DIR),
                new File(CONTROLLER_DIR),
                new File(VIEW_DIR)
        };
        for (File f : gen) {
            if (!f.exists()) {
                f.mkdirs();
            }
        }
    }

    public static void main(String[] args) throws IOException {




        String s = FreeMakerUtil.renderCode(new HashMap<String, Object>(), "login.ftl");
        File f=new File("C:\\Users\\wenkui\\Desktop\\osss\\frostforest\\src\\main\\webapp\\WEB-INF\\views\\login.ftl");
        FileWriter fw=new FileWriter(f);
        fw.write(s);
        fw.flush();
        fw.close();

        List<Class> target = getModelClasses(new String[]{
                "com.frost.forest.pen.model"
        });

        for (Class c : target) {
            makeFacade(c);
            makeCtr(c);
            makeMutipleView(c,new String[]{"list","detail","precreate","preedit"});
        }

        List<Class> ctrs=CodeGenerator.getClasses(new String[]{
                "com.frost.forest.pen.bean.controller",
                "com.frost.forest.gen.bean.controller"
        });
        CodeGenerator.makeIndex(ctrs);

    }

    public static void makeIndex(List<Class> ctrs) throws IOException {
        System.out.println(ctrs.size());
        List list=new ArrayList();
        for (final Class ctr : ctrs) {
            final RequestMapping requestMapping= (RequestMapping) ctr.getAnnotation(RequestMapping.class);
            if(requestMapping!=null){
                list.add(new PathFinder(){
                        public String getPath(){
                            return requestMapping.value()[0];
                        }
                        public String getName(){
                            return ctr.getSimpleName();
                        }
                });
            }
        }
        Map<String,Object> root=new HashMap<>();
        root.put("controllers",list);
        String code = FreeMakerUtil.renderCode(root, "index.ftl");
        File f = new File(VIEW_BASE.concat("index.ftl"));
        try (FileWriter fw = new FileWriter(f)) {
            fw.write(code);
            fw.flush();
        }
    }

    public static void makeMutipleView(Class c,String[] viewNames){
        for(String v:viewNames){
            makeViewPage(c,v);
        }
    }
    public static void makeViewPage(Class c,String viewName){
        try {
            ModelMetadata modelMetadata = Assist.getModelMeatadata(c);

            String code = FreeMakerUtil.renderCode(modelMetadata, viewName.concat(".ftl"));
            File dir=new File(VIEW_DIR.concat(modelMetadata.getModel().getSimpleName().toLowerCase()));
            if(!dir.exists()){
                dir.mkdirs();
            }
            File f = new File(VIEW_DIR.concat(modelMetadata.getModel().getSimpleName().toLowerCase())
                    .concat("/").concat(viewName).concat(".ftl"));

            try (FileWriter fw = new FileWriter(f)) {
                fw.write(code);

                fw.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void makeListPage(Class c) {
        makeViewPage(c,"list");
    }

    public static void makeCtr(Class c) throws IOException {
        try {
            ModelMetadata modelMetadata = Assist.getModelMeatadata(c);

            String code = FreeMakerUtil.renderCode(modelMetadata, "ctr.ftl");

            File f = new File(CONTROLLER_DIR.concat(c.getSimpleName().concat("Controller.java")));

            try (FileWriter fw = new FileWriter(f)) {
                fw.write(code);
                fw.flush();
            }
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        }
    }

    public static void makeFacade(Class c) throws IOException {
        FacadeModel facadeModel = new FacadeModel(c);
        String code = FreeMakerUtil.renderCode(facadeModel, "facade.ftl");
        File f = new File(OUTPUT_DIR.concat("service/").concat(facadeModel.getName().concat("Facade.java")));

        try (FileWriter fw = new FileWriter(f)) {
            fw.write(code);
            fw.flush();
        }
    }

    public static  List<Class> getClasses(String[] packageToScan){
        List<Class> result = new ArrayList<Class>();
        String base = Thread.currentThread().getContextClassLoader().getResource("").getFile();
        for (String pkg : packageToScan) {
            File dir = new File(base.concat(pkg.replaceAll("\\.", "/")));
            if (dir.exists() && dir.isDirectory()) {

                for (File clsf : dir.listFiles()) {
                    try {
                        Class c = Class.forName(pkg.concat(".").concat(clsf.getName().split("\\.")[0]));
                        result.add(c);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    public static List<Class> getModelClasses(String[] packageToScan) {
        List<Class> result = new ArrayList<Class>();
        String base = Thread.currentThread().getContextClassLoader().getResource("").getFile();
        for (String pkg : packageToScan) {
            File dir = new File(base.concat(pkg.replaceAll("\\.", "/")));
            if (dir.exists() && dir.isDirectory()) {

                for (File clsf : dir.listFiles()) {
                    outer:
                    try {
                        Class c = Class.forName(pkg.concat(".").concat(clsf.getName().split("\\.")[0]));

                        for (Field field : c.getDeclaredFields()) {
                            System.out.println(field);
                            if (field.getAnnotation(Header.class) != null) {
                                result.add(c);
                                break outer;
                            }
                        }
                        for (Method method : c.getDeclaredMethods()) {
                            System.out.println(method);
                            if (method.getAnnotation(Header.class) != null) {
                                result.add(c);
                                break outer;
                            }
                        }

                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        return result;
    }
}

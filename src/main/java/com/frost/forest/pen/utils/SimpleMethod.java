package com.frost.forest.pen.utils;

import com.alibaba.druid.util.IOUtils;
import com.frost.forest.gen.cgmain.FreeMakerUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wenkui on 2015/4/8.
 */
public class SimpleMethod {
    private String name;
    private String args;
    private String unit;
    private String quantifiers;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getArgs() {
        return args;
    }

    public void setArgs(String args) {
        this.args = args;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getQuantifiers() {
        return quantifiers;
    }

    public void setQuantifiers(String quantifiers) {
        this.quantifiers = quantifiers;
    }


    public static String methodUtil() throws FileNotFoundException {
        File f = new File("d:/pt.txt");
        List<SimpleMethod> lsm = new ArrayList<>();
        String read = IOUtils.read(new FileInputStream(f));
        String[] lines = read.split("\\s*[\n\r]+\\s*");
        String firstName = "";

        String ntm = "Boundary";
        String n = "ExactN";
        String moreThanN = "AtLeastN";

        for (String line : lines) {
            String lastName = "";
            SimpleMethod sm = new SimpleMethod();
            String args ="";
            String quantifiers = "";

            line = line.trim();
            if(line.isEmpty()){
                continue;
            }
            if (!line.startsWith("X")) {
                firstName = line.split("\\s+")[0];
                continue;
            } else {

                if (line.startsWith("X{n,m}")) {
                    lastName = ntm;
                    args="int n,int m";
                    quantifiers = "{\"+n+\",\"+m+\"}"+line.split("\\s+")[0].substring(6);

                } else if (line.startsWith("X{n,}")) {
                    lastName = moreThanN;
                    args="int n";
                    quantifiers = "{\"+n+\",}"+line.split("\\s+")[0].substring(5);

                } else if (line.startsWith("X{n}")) {
                    lastName = n;
                    args="int n";
                    quantifiers = "{\"+n+\"}"+line.split("\\s+")[0].substring(4);

                } else if (line.startsWith("X?")) {
                    lastName="OnceOrNot";
                    quantifiers=line.split("\\s+")[0].substring(1);

                } else if (line.startsWith("X*")) {
                    lastName="ZeroOrMore";
                    quantifiers=line.split("\\s+")[0].substring(1);

                } else if (line.startsWith("X+")) {
                    lastName="OneOrMore";
                    quantifiers=line.split("\\s+")[0].substring(1);

                }else {
                    System.out.println(line);
                    continue;
                }
            }
            sm.setName(firstName + lastName);
            sm.setArgs(args);
            sm.setQuantifiers(quantifiers);
            lsm.add(sm);
        }
        Map<String,Object> root=new HashMap<>();
        root.put("lsm",lsm);

        String code= FreeMakerUtil.renderCode(root,"method.ftl");
        return code;
    }

    public static void main(String[] args) throws FileNotFoundException {
        String s = methodUtil();
        System.out.println(s);
    }
}

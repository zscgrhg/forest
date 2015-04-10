package com.frost.forest.gen.viewmodel;

import com.frost.forest.gen.anotation.query.Header;
import com.frost.forest.gen.anotation.update.Assistant;
import com.frost.forest.gen.cgmain.Assist;
import com.frost.forest.gen.literal.AssistStrategy;
import com.frost.forest.pen.utils.EasyUnicode;
import javassist.CtField;
import javassist.NotFoundException;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Field;
import java.util.Collection;

/**
 * Created by wenkui on 2015/4/5.
 */
public class CtFieldWrapper {
    private final CtField ctField;
    private final boolean assistantIgnore;
    private final boolean isCollection;
    private final AssistStrategy assistStrategy;
    private final Class entityClass;
    private String msg;
    private String patternFlag;
    private Header header;


    public CtFieldWrapper(CtField ctField) {
        this.ctField = ctField;
        boolean isToMany = false;
        boolean ignore = true;
        AssistStrategy a = AssistStrategy.NONE;
        Class etc = null;
        try {
            if (!ctField.getType().isPrimitive()) {
                String name = ctField.getType().getName();
                System.out.println(name + "<<<<<<<<<<<<<<<<<<<");
                Class cls = Class.forName(name);
                isToMany = Collection.class.isAssignableFrom(cls);
                if (isToMany) {
                    OneToMany oneToMany = (OneToMany) ctField.getAnnotation(OneToMany.class);
                    ManyToMany manyToMany = (ManyToMany) ctField.getAnnotation(ManyToMany.class);
                    if (oneToMany != null) {
                        Assistant assistant = (Assistant) oneToMany.targetEntity().getAnnotation(Assistant.class);
                        Entity entity = (Entity) oneToMany.targetEntity().getAnnotation(Entity.class);
                        if (entity != null && assistant != null
                                && (!assistant.value().equals(AssistStrategy.NONE))) {
                            ignore = false;
                            etc = oneToMany.targetEntity();
                            a = assistant.value();
                        }
                    } else if (manyToMany != null) {


                        Assistant assistant = (Assistant) manyToMany.targetEntity().getAnnotation(Assistant.class);
                        Entity entity = (Entity) manyToMany.targetEntity().getAnnotation(Entity.class);

                        if (entity != null && assistant != null
                                && (!assistant.value().equals(AssistStrategy.NONE))) {
                            ignore = false;
                            etc = manyToMany.targetEntity();
                            a = assistant.value();
                        }
                    }
                } else {
                    Assistant assistant = (Assistant) ctField.getType().getAnnotation(Assistant.class);
                    Entity entity = (Entity) ctField.getType().getAnnotation(Entity.class);
                    if (entity != null &&
                            assistant != null &&
                            !assistant.value().equals(AssistStrategy.NONE)) {
                        ignore = false;
                        etc = cls;
                        a = assistant.value();
                    }
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.isCollection = isToMany;
        this.assistantIgnore = ignore;
        this.assistStrategy = a;
        this.entityClass = etc;
        try {
            System.out.println("------------------");
            System.out.println(ctField.getType().getName());
            System.out.println(Assist.objectMapper.writeValueAsString(this));
            System.out.println("++++++++++++++++++");
        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public boolean isCollection() {
        return isCollection;
    }

    public boolean isAssistantIgnore() {
        return assistantIgnore;
    }


    public AssistStrategy getAssistStrategy() {
        return assistStrategy;
    }

    public boolean isAssistant() {
        return !assistantIgnore;
    }

    public Class getEntityClass() {
        return entityClass;
    }

    public String getEntitySimpleName() {
        if (entityClass == null || entityClass.equals(Void.class)) {
            return null;
        }
        return entityClass.getSimpleName();
    }

    public String getRequestParamName() {
        if (entityClass == null || entityClass.equals(Void.class)) {
            return null;
        }
        String pn = getEntityClass().getSimpleName().concat("_").concat(getEntityId());
        return pn;
    }

    public String getEntityId() {
        if (entityClass != null) {
            for (Field field : entityClass.getDeclaredFields()) {
                if (field.getAnnotation(Id.class) != null) {
                    return field.getName();
                }
            }

        }
        return null;
    }

    public String getEntityIdType() {
        String id = "String";
        if (entityClass != null) {
            for (Field field : entityClass.getDeclaredFields()) {
                if (field.getAnnotation(Id.class) != null) {
                    id = field.getType().getTypeName();
                    if (id.startsWith("java.lang.")) {
                        id = id.substring(10);
                    }
                    return id;
                }
            }

        }
        return id;
    }

    public String getEntityClassName() {
        if (entityClass == null || entityClass.equals(Void.class)) {
            return null;
        }
        return entityClass.getName();
    }

    public boolean isSelectAssistant() {
        return AssistStrategy.SELECT.equals(assistStrategy);
    }

    public String getReference() {
        return ctField.getName();
    }

    public String getSetterName() {
        String name = getReference();
        return "set".concat(name.substring(0, 1).toUpperCase()).concat(name.substring(1));
    }

    public boolean isBool() {
        boolean r = false;
        try {
            r = ctField.getType().getName().equals("boolean");
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

    public boolean isHidden() {
        boolean r = false;
        try {
            Header header = (Header) ctField.getAnnotation(Header.class);
            if (header != null) {
                r = header.hidden();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return r;
    }

    public boolean isShow() {
        return !isHidden();
    }


    public String getPattern() {
        String pattern = "";
        String end = ".*";
        msg="";
        patternFlag="i";
        try {
            for (Object o : ctField.getAnnotations()) {
                if (o instanceof javax.validation.constraints.AssertFalse) {
                    pattern = pattern.concat("(?=false$)");
                    msg="必须=false";
                    break;
                } else if (o instanceof javax.validation.constraints.AssertTrue) {
                    pattern = pattern.concat("(?=true$)");
                    msg="必须=true";
                    break;
                } else if (o instanceof javax.validation.constraints.DecimalMax) {

                } else if (o instanceof javax.validation.constraints.DecimalMin) {

                } else if (o instanceof javax.validation.constraints.Digits) {
                    pattern = pattern.concat("(?=\\d*$)");
                    msg+="必须是数字;";
                } else if (o instanceof javax.validation.constraints.Future) {

                } else if (o instanceof javax.validation.constraints.Max) {

                } else if (o instanceof javax.validation.constraints.Min) {

                } else if (o instanceof javax.validation.constraints.NotNull) {
                    end = ".+";
                } else if (o instanceof javax.validation.constraints.Null) {

                } else if (o instanceof Past) {

                } else if (o instanceof Pattern) {
                    Pattern p=((Pattern) o);
                    pattern = EasyUnicode.toPortableRegex(p.regexp(),true,true);

                    end="";
                    msg=p.message();
                    for (Pattern.Flag flag : p.flags()) {
                            if(flag.equals(Pattern.Flag.CASE_INSENSITIVE)){
                                patternFlag+="i";
                            }else if(flag.equals(Pattern.Flag.MULTILINE)){
                                patternFlag+="m";
                            }
                    }

                    break;
                } else if (o instanceof javax.validation.constraints.Size) {
                    Integer max = ((javax.validation.constraints.Size) o).max();
                    Integer min = ((javax.validation.constraints.Size) o).min();
                    pattern = pattern.concat("(?=.{").concat(min.toString()).concat(",").concat(max.toString()).concat("}$)");
                    msg+="长度必须大于"+min.toString()+"且小于"+max.toString()+";";
                }
            }
            pattern = pattern.concat(end);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return pattern.replaceAll("/","\\\\/");
    }

    public String getMsg(){
        if(msg==null){
            getPattern();
        }
        return msg;
    }

    public String getFlag(){
        if(patternFlag==null){
            getPattern();
        }
        return patternFlag;
    }

    public boolean isUpdater(){
        boolean u=false;
       if(getHeader()!=null){
           u=header.updater();
       }
        return u;
    }
    private Header getHeader(){
        if(this.header==null){
            try {
                this.header = (Header) ctField.getAnnotation(Header.class);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return header;
    }
    public boolean isEditable(){
        boolean u=false;
        if(getHeader()!=null){
            u=header.editable();
        }
        return u;
    }
}



























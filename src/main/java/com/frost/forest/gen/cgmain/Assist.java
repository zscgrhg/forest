package com.frost.forest.gen.cgmain;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.frost.forest.gen.viewmodel.CtFieldWrapper;
import com.frost.forest.gen.viewmodel.EntityWrapper;
import com.frost.forest.gen.viewmodel.ModelMetadata;
import javassist.*;

import javax.persistence.Transient;

/**
 * Created by wenkui on 2015/4/5.
 */
public class Assist {

    public static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws NotFoundException, CannotCompileException {

    }

    public static ModelMetadata getModelMeatadata(Class c) throws NotFoundException, CannotCompileException {
        ClassPool pool = ClassPool.getDefault();
        pool.insertClassPath(new ClassClassPath(Assist.class));
        CtClass ctClass = pool.get(c.getName());
        ModelMetadata modelMetadata = new ModelMetadata(new EntityWrapper(c));
        for (CtField ctField : ctClass.getDeclaredFields()) {

            boolean isStatic = (ctField.getModifiers() & 8) == 8;
            if (isStatic) {
                continue;
            }

            try {
                /*Transient */
               /* Header header = (Header) ctField.getAnnotation(Header.class);
                if (header != null) {
                    modelMetadata.addHeader(new CtFieldWrapper(ctField));

                }*/
                Transient aTransient = (Transient) ctField.getAnnotation(Transient.class);
                if (aTransient == null) {
                    modelMetadata.addHeader(new CtFieldWrapper(ctField));
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        }
        return modelMetadata;
    }
}

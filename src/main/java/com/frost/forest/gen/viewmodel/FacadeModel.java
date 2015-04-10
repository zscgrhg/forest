package com.frost.forest.gen.viewmodel;

/**
 * Created by wenkui on 2015/4/4.
 */
public class FacadeModel {
   private final Class model;

    public FacadeModel(Class model) {
        this.model=model;
    }
    public String getName(){
        return model.getSimpleName();
    }
    public String getPackageName(){
        return model.getPackage().getName();
    }
    public String getFullName(){
        return model.getCanonicalName();
    }
}

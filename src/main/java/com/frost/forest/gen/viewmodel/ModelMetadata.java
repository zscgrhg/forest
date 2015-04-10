package com.frost.forest.gen.viewmodel;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wenkui on 2015/4/5.
 */
public class ModelMetadata {
    private final EntityWrapper model;
    private final List<CtFieldWrapper> headers;

    public ModelMetadata(EntityWrapper model) {
        this.model = model;
        headers=new ArrayList<>();
    }
    @JsonIgnore
    public List<CtFieldWrapper> getHeaders() {
        return headers;
    }

    public void addHeader(CtFieldWrapper header) {
        this.headers.add(header);
    }

    public EntityWrapper getModel() {
        return model;
    }


    public String f2l(String s){

        if(s.length()<2){
            return s.toLowerCase();
        }else{
            if(Character.isUpperCase(s.charAt(0))
                    &&Character.isUpperCase(s.charAt(1))){
                return s;
            }
        }
        return s.substring(0,1).toLowerCase().concat(s.substring(1));
    }

    public String f2u(String s){
        return s.substring(0,1).toUpperCase().concat(s.substring(1));
    }

    public String a2l(String s){
        return s.toLowerCase();
    }



}

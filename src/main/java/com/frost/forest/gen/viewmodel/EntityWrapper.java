package com.frost.forest.gen.viewmodel;

import com.frost.forest.gen.anotation.update.Assistant;
import com.frost.forest.gen.literal.AssistStrategy;

import javax.persistence.Id;
import java.lang.reflect.Field;

/**
 * Created by wenkui on 2015/4/5.
 */
public class EntityWrapper {
    private final Class entity;
    private final AssistStrategy assistStrategy;

    public EntityWrapper(Class entity) {
        this.entity = entity;
        Assistant assistant= (Assistant) entity.getAnnotation(Assistant.class);
        this.assistStrategy=(assistant!=null?assistant.value():AssistStrategy.NONE);
    }

    public String getSimpleName(){
        return entity.getSimpleName();
    }

    public String getName(){
        return entity.getName();
    }
    public String getFullName(){
        return entity.getCanonicalName();
    }
    public boolean isAssistant(){
        return AssistStrategy.NONE.equals(assistStrategy);
    }
    public AssistStrategy getAssistStrategy(){
        return assistStrategy;
    }
    public String getSimpleId(){
        String id="";
        for (Field field : entity.getDeclaredFields()) {
            if(field.getAnnotation(Id.class)!=null){
                id=field.getName();
            }
        }
        return id;
    }

    public String getEntityIdType(){
        String id="String";
        for (Field field : entity.getDeclaredFields()) {
            if(field.getAnnotation(Id.class)!=null){
                id=field.getType().getName();
                if(id.startsWith("java.lang.")){
                    id=id.substring(10);
                }
                return id;
            }
        }
        return id;
    }

    public boolean isSelectAssistant(){
        return AssistStrategy.SELECT.equals(assistStrategy);
    }

    public boolean isCompleteAssistant(){
        return AssistStrategy.AUTO_COMPLETE.equals(assistStrategy);
    }
}

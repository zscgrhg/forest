package com.frost.forest.pen.utils;

/**
 * Created by wenkui on 2015/4/9.
 */
public enum Unit {
    HAN,
    JAVA;

    public  Character.UnicodeScript getUnicodeBlock(){
        return Character.UnicodeScript.forName(this.name());
    }

    public static void main(String[] args) {
        Character.UnicodeScript unicodeBlock = Unit.HAN.getUnicodeBlock();
        System.out.println(unicodeBlock);
    }
}

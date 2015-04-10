package com.frost.forest.pen.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;


/**
 * Created by wenkui on 2015/4/7.
 */
public class UBS {

    private static final Map<String, String> SCRIPTS = new HashMap<String, String>();
    private static final Map<String, String> BLOCKS = new HashMap<String, String>();

    static {
        <#list sm as s>
        ${s}
        </#list >

        <#list bm as b>
        ${b}
        </#list >
    }

    public static String getUnicodeScriptsUnit(String unicodeScriptsName) {
        return SCRIPTS.get(unicodeScriptsName);
    }

    public static String getUBSUnit(String unicodeScriptsName) {
        return BLOCKS.get(unicodeScriptsName);
    }

    public static String getJsCompatibleRegex(String unit){
         return getPrintableRegex(unit,true);
    }

    public static String getPrintableRegex(String unit,boolean jsCompatible){
        StringBuilder stringBuilder=new StringBuilder("[");

        for (int[] ints : UBS.getCodePointsRange(unit)) {
            int a=ints[0];
            int b=ints[1];
            assert b>=a;
            if(a>0xFFFF&&jsCompatible){
                continue;
            }
            char[]  range1=Character.toChars(a);
            char[]  range2=Character.toChars(b);
            StringBuilder sb1=new StringBuilder();
            for(char c1:range1){
            sb1.append("\\\\u").append(CharacterEnhance.leftPadding(Integer.toHexString(c1).toUpperCase()));
        }
        sb1.append("-");
        for(char c2:range2){
            sb1.append("\\\\u").append(CharacterEnhance.leftPadding(Integer.toHexString(c2).toUpperCase()));
        }
        stringBuilder.append(sb1);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }



    public static String getPortableRegex(String unicodeBlockOrScripts){
        String p=RegexUtil.replace(unicodeBlockOrScripts, "\\Q\\p{\\E(I[ns])([^}]*)\\Q}\\E", new Replacement() {
            @Override
            public String format(Matcher m) {
                    switch (m.group(1)){
                    case "Is":
                    return UBS.getPrintableRegex(UBS.getUnicodeScriptsUnit(m.group(2).toUpperCase()),true);
                    case "In":
                    return UBS.getPrintableRegex(UBS.getUBSUnit(m.group(2)),true);
                    default:
                    return m.group(0);
                }
            }
        });
        return p;
    }

    public static List<int[]> getCodePointsRange(String sc) {
        List<int[]> lc = new ArrayList<>();
        for (int i = 1; i < sc.length() - 1; ) {
            int start;
            int end;
            if (Character.isHighSurrogate(sc.charAt(i))) {
                start = ((sc.charAt(i) - 0xD800) << 10) + (sc.charAt(i + 1) - 0xDC00) + 0x10000;
                end = ((sc.charAt(i + 3) - 0xD800) << 10) + (sc.charAt(i + 4) - 0xDC00) + 0x10000;
                i = i + 5;
            } else {
                start = sc.charAt(i);
                end = sc.charAt(i + 2);
                i = i + 3;
            }
            lc.add(new int[]{
                    start, end
            });
        }
        return lc;
    }

    public static String getAllCodePointsCeil0xFFFF(String unit) {
        StringBuilder sb = new StringBuilder();
        List<int[]> list = UBS.getCodePointsRange(unit);
        for (int[] ints : list) {
            for (int i = ints[0]; i <= ints[1]; i++) {
                if (i <= 0xFFFF) {
                    sb.append(((char) i));
                }
            }
        }
        return sb.toString();
    }
    public static String prettyBlockRange(){
        StringBuilder sb=new StringBuilder();
        for (int[] ints : UBS.getCodePointsRange(UBS.Scripts.HAN)) {
            for (int anInt : ints) {
                String r=Integer.toHexString(anInt);
                switch (r.length()){
                    case 4:
                    sb.append(r).append("      >      ");
                    break;
                    case 5:
                    sb.append(r).append("     >     ");
                    break;
                    case 6:
                    sb.append(r).append("    >    ");
                }

            }
            sb.append("\n");
        }
        return sb.toString().replaceAll("(?m)[\\s>]*$","");
    }

    ${methods}

    public static class Scripts {
<#list sc   as s>
        ${s}
</#list>
    }

    public static class Blocks {
<#list bc  as b>
        ${b}
 </#list>
    }
}

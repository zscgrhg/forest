package com.frost.forest.pen.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
* Created by wenkui on 2015/4/7.
* <p>
    * Character information is based on the Unicode Standard, version 6.2.0.
    * <p>
    *
<ul>
    *
    <li><a href="http://www.unicode.org">http://www.unicode.org</a>
        *
</ul>
*/
public enum EasyUnicode {


${sbn}


private static final Map
<EasyUnicode, String> UnitsMap = new HashMap
<EasyUnicode, String>();

static {
/*UnicodeScripts */
<#list sm as s>
${s}
</#list >
/*UnicodeBlocks */
<#list bm as b>
${b}
</#list >
}


private Pattern pattern;


${methods}


private String asPortableTxt(boolean jsCompatible,boolean doubleEscaped) {
String estr="\\u";
if(doubleEscaped){
estr="\\\\u";
}
StringBuilder stringBuilder = new StringBuilder("[");
StringBuilder forJS = new StringBuilder();
for (int[] ints : range()) {
int a = ints[0];
int b = ints[1];
assert b >= a;

if (a > 0xFFFF && jsCompatible) {
StringBuilder sb2 = new StringBuilder("");
List
<int[]> splits = split(a, b);
for (int[] split : splits) {
int aa = split[0];
int bb = split[1];
char[] range11 = Character.toChars(aa);
char[] range22 = Character.toChars(bb);
System.out.println("debug: split " + Integer.toHexString(range11[0]) + "  ==   " + Integer.toHexString(range22[0]));
if (aa == bb) {
sb2.append("|").append(estr).append(leftPadding(Integer.toHexString(range11[0]).toUpperCase()))
.append(estr)
.append(leftPadding(Integer.toHexString(range11[1]).toUpperCase()));
} else {
sb2.append("|")
.append(estr)
.append(leftPadding(Integer.toHexString(range11[0]).toUpperCase()))
.append("[").append(estr)
.append(leftPadding(Integer.toHexString(range11[1]).toUpperCase()))
.append("-").append(estr)
.append(leftPadding(Integer.toHexString(range22[1]).toUpperCase()))
.append("]");
}
}
forJS.append(sb2);

} else {
char[] range1 = Character.toChars(a);
char[] range2 = Character.toChars(b);
StringBuilder sb1 = new StringBuilder();
for (char c1 : range1) {
sb1.append(estr).append(CharacterEnhance.leftPadding(Integer.toHexString(c1).toUpperCase()));
}
sb1.append("-");
for (char c2 : range2) {
sb1.append(estr).append(CharacterEnhance.leftPadding(Integer.toHexString(c2).toUpperCase()));
}
stringBuilder.append(sb1);
}
}
stringBuilder.append("]");
String result;
if (stringBuilder.length() == 2) {
result =forJS.substring(1);
} else {
result= stringBuilder.append(forJS).toString();
}
boolean branch=result.contains("|");
if(branch){
result="(?:"+result+")";
}
return result;

}

public List
<int[]> split(int s, int e) {

assert s >= 0x10000;
assert s <= e;
assert e <= 0x10FFFF;
List
<int[]> result = new ArrayList<>();
int a = (s - 0x10000) % 0x400;
for (int i = s; i <= e; ) {
int start = i;
int end;
if (a > 0) {
end = Math.min(i + 0x3FF - a, e);
} else {
int t = e - e % 0x400;
end = (t == i ? e : t-1);
}
result.add(new int[]{start, end});
i = end + 1;
a = 0;
}
return result;
}


public String asRegex() {
return UnitsMap.get(this);
}

public String pattern() {
return asPortableTxt(false,false);
}

public String asJSCompatible() {
return asPortableTxt(true,false);
}

public String doubleEscaped() {
return asPortableTxt(false, true);
}

public String doubleEscapedJs() {
return asPortableTxt(true, true);
}


public  List
<int[]> range() {
String sc=UnitsMap.get(this);
List
<int[]> lc = new ArrayList<>();
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

public  String prettyRange(){
StringBuilder sb=new StringBuilder();
for (int[] ints : range()) {
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

/**
* 此处内容来自维基百科<a href="http://zh.wikipedia.org/wiki/Unicode%E5%AD%97%E7%AC%A6%E5%B9%B3%E9%9D%A2%E6%98%A0%E5%B0%84">unicode字符平面映射</a>
* 0号平面    U+0000 - U+FFFF    基本多文种平面    Basic Multilingual Plane,简称BMP
* 1号平面    U+10000 - U+1FFFF    多文种补充平面    Supplementary Multilingual Plane,简称SMP
* 2号平面    U+20000 - U+2FFFF    表意文字补充平面    Supplementary Ideographic Plane,简称SIP
* 3号平面    U+30000 - U+3FFFF    表意文字第三平面（未正式使用[1]）    Tertiary Ideographic Plane,简称TIP
* 4号平面
* 至
* 13号平面    U+40000 - U+DFFFF    （尚未使用）
* 14号平面    U+E0000 - U+EFFFF    特别用途补充平面    Supplementary Special-purpose Plane,简称SSP
* 15号平面    U+F0000 - U+FFFFF    保留作为私人使用区（A区）[2]    Private Use Area-A,简称PUA-A
* 16号平面    U+100000 - U+10FFFF    保留作为私人使用区（B区）[2]    Private Use Area-B,简称PUA-B
*/

public String joinBMPCodePoints() {
StringBuilder sb = new StringBuilder();
List
<int[]> list = range();
for (int[] ints : list) {
for (int i = ints[0]; i <= ints[1]; i++) {
if (i <= 0xFFFF) {
sb.append(((char) i));
}
}
}
return sb.toString();
}


public boolean matches(String target){
if(target==null||target.isEmpty()){
return false;
}else {
return target.matches(GreedyOneOrMore());
}
}

private Pattern getPattern(){
if (pattern == null) {
pattern = Pattern.compile(GreedyOneOrMore());
}
return pattern;
}
public List
<String> extract(String target) {
    assert target != null;
    List
    <String> result = new ArrayList
        <String>();

            Matcher m = getPattern().matcher(target);
            while (m.find()) {
            result.add(m.group());
            }
            return result;
            }

            public boolean find(String target){
            Matcher m=getPattern().matcher(target);
            if(m.find()){
            return true;
            }else {
            return false;
            }
            }

            public static String toPortableRegex(String javaRegex,final boolean jsCompatible, final boolean
            doubleEscaped) {
            String p = RegexUtil.replace(javaRegex, "\\Q\\p{\\E(I[ns])([^}]*)\\Q}\\E", new Replacement() {
            @Override
            public String format(Matcher m) {
            switch (m.group(1)) {
            case "Is":

            return EasyUnicode.valueOf(m.group(2).toUpperCase()).asPortableTxt(jsCompatible,doubleEscaped);
            case "In":
            return EasyUnicode.valueOf(m.group(2).toLowerCase()).asPortableTxt(jsCompatible, doubleEscaped);
            default:
            return m.group(0);
            }
            }
            });
            return p;
            }

            public static String leftPadding(String s) {
            String t = ("0000" + s);
            return t.substring(t.length() - 4);
            }

            }

package com.frost.forest.pen.utils;

import java.io.IOException;

/**
 * Created by wenkui on 2015/4/9.
 */
public class Test {
    public static void main(String[] args) throws IOException {
        /*String s = EasyUnicode.HAN.prettyRange();
        System.out.println(s);
        String ss="毕";
        System.out.println();
        System.out.println(EasyUnicode.HAN);
        System.out.println(EasyUnicode.HAN.pattern());
        System.out.println(EasyUnicode.HAN);
        StringWriter sw=new StringWriter();
        sw.write(EasyUnicode.HAN.asRegex());
        System.out.println(ss.matches(sw.toString()));



        File f=new File("d:/regex.txt");
        FileWriter fw=new FileWriter(f);

        fw.write(EasyUnicode.HAN.asRegex());
        fw.flush();
        fw.close();

        String read = IOUtils.read(new FileInputStream(f));
        System.out.println(ss.matches(read));
        System.out.println(Integer.toHexString((int)'汗'));
        int c=0x10FFFF;
        for (char c1 : Character.toChars(c)) {
            System.out.println(Integer.toHexString(c1));
        }

        System.out.println(0x03ff);
        System.out.println(0x400);*/


        System.out.println(EasyUnicode.HAN.doubleEscapedJs());
        System.out.println();
        System.out.println(EasyUnicode.HAN.asJSCompatible());

       /*String A="\udb40\udc00";
        System.out.println(A.codePointCount(0,2));
        System.out.println(Integer.toHexString(A.codePointAt(0)));
        System.out.println(EasyUnicode.HAN.prettyRange());*/
    }
}

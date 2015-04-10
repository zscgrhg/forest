package com.frost.forest.pen.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zscgrhg
 */
public class RegexUtil {

    public static String replace(String dst, String regex, Replacement c) {
        System.out.println(dst);
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(dst);
        StringBuffer sb = new StringBuffer();
        while (m.find()) {
            m.appendReplacement(sb, c.format(m));
        }
        m.appendTail(sb);
        return sb.toString();
    }
}

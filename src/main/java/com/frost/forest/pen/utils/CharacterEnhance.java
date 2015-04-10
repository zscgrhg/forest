package com.frost.forest.pen.utils;

import com.alibaba.druid.util.IOUtils;
import com.frost.forest.gen.cgmain.FreeMakerUtil;
import javassist.NotFoundException;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by wenkui on 2015/4/4.
 */
public class CharacterEnhance {
    private int c;

    public static void main(String[] args) throws NotFoundException, ClassNotFoundException, IOException {
        File fs = new File("d:/Char.txt");
        String read = IOUtils.read(new FileInputStream(fs));

        Map<String, String> mus = getMap(getScriptStringFromCjava(read));
        Map<String, String> mub = getMap(getBlockStringFromCjava(read));
        List<String> names = new ArrayList<>();
        StringBuilder sbn = new StringBuilder();


        List<String> sm_statements = new ArrayList<>();
        List<String> sc_statements = new ArrayList<>();
        List<String> bm_statements = new ArrayList<>();
        List<String> bc_statements = new ArrayList<>();
        for (Map.Entry<String, String> entry : mus.entrySet()) {
            String keysc=entry.getKey();
            sm_statements.add("UnitsMap.put(" + keysc + ",\"" + entry.getValue() + "\");");
            sc_statements.add("public static final String " + keysc+ "=\"" + entry.getValue() + "\";");
            names.add(keysc);
            if (sbn.length() > 0) {
                sbn.append(",\n");
            }
            sbn.append(keysc);
        }

        for (Map.Entry<String, String> entry : mub.entrySet()) {
            String keybc=entry.getKey().toLowerCase();
            bm_statements.add("UnitsMap.put(" + keybc + ",\"" + entry.getValue() + "\");");
            bc_statements.add("public static final String " + keybc + "=\"" + entry.getValue() + "\";");
            names.add(keybc);
            if (sbn.length() > 0) {
                sbn.append(",\n");
            }
            sbn.append(keybc);
        }
        sbn.append(";");

        Collections.sort(sm_statements);
        Collections.sort(sc_statements);
        Collections.sort(bm_statements);
        Collections.sort(bc_statements);
        Collections.sort(names);
        Map root = new HashMap();

        root.put("sm", sm_statements);
        root.put("sc", sc_statements);
        root.put("bm", bm_statements);
        root.put("bc", bc_statements);
        String methods = SimpleMethod.methodUtil();
        root.put("methods", methods);
        root.put("names", names);
        root.put("sbn",sbn);

        String s = FreeMakerUtil.renderCode(root, "EasyUnicode.ftl");


        File ff = new File("C:\\Users\\wenkui\\Desktop\\osss\\frostforest\\src\\main\\java\\com\\frost\\forest\\pen\\utils\\EasyUnicode.java");

        try (FileWriter fw = new FileWriter(ff)) {
            fw.write(s);
            fw.flush();
        }

    }


    public static String leftPadding(String s) {
        String t = ("0000" + s);
        return t.substring(t.length() - 4);

    }

    public static String escape(String s) {
        String ss = s.replaceAll("(?i)\\\\u000a", "\\\\n")
                .replaceAll("(?i)\\\\u000d", "\\\\r");
        return ss;
    }

    public static Map<String, String> getMap(String read) throws FileNotFoundException {

        System.out.println(read);
        HashMap<String, List<String>> map = new HashMap<>();

        String[] lines = read.split("[\r\n]+");


        int size = lines.length;
        for (int i = 0; i < size; i++) {
            String line_ = lines[i];
            if (!line_.contains(";")) {
                int start = 0;
                int end = 0x10FFFF;
                if (i == 0) {
                    String nextLine = lines[i + 1];
                    String hex = nextLine.split("\\Q..\\E")[0].trim();
                    end = Integer.parseInt(hex, 16) - 1;
                } else if (i == size - 1) {
                    String lastLine = lines[i - 1];
                    String hex = lastLine.split("\\Q..\\E")[1].trim();
                    start = Integer.parseInt(hex, 16) + 1;
                }
                lines[i] = leftPadding(Integer.toHexString(start)) + ".." + leftPadding(Integer.toHexString(end)) + ";" + line_;

            }
        }
        for (String s : lines) {
            String[] entry = s.trim().split(";");
            if (!map.containsKey(entry[1])) {
                map.put(entry[1], new ArrayList<String>());
            }
            String range = entry[0];
            range = RegexUtil.replace(range, "(.*?)\\Q..\\E(.*)", new Replacement() {
                @Override
                public String format(Matcher m) {
                    String start = m.group(1);
                    String end = m.group(2);
                    int a = Integer.parseInt(start, 16);
                    int b = Integer.parseInt(end, 16);
                    assert b > a;
                    char[] range1 = Character.toChars(a);
                    char[] range2 = Character.toChars(b);
                    StringBuilder sb1 = new StringBuilder();
                    for (char c1 : range1) {
                        sb1.append("\\\\u").append(leftPadding(Integer.toHexString(c1).toUpperCase()));
                    }
                    sb1.append("-");
                    for (char c2 : range2) {
                        sb1.append("\\\\u").append(leftPadding(Integer.toHexString(c2).toUpperCase()));
                    }
                    return sb1.toString();
                }
            });
            map.get(entry[1]).add(range);
        }

        Map<String, String> result = new HashMap<>();
        for (Map.Entry<String, List<String>> stringListEntry : map.entrySet()) {
            StringBuilder sb = new StringBuilder();
            sb.append("[");
            for (String s : stringListEntry.getValue()) {
                sb.append(s);
            }
            sb.append("]");
            String sss = escape(sb.toString());
            result.put(escapeKey(stringListEntry.getKey().trim()), sss);
        }
        return result;
    }

    public static String escapeKey(String key) {

        String r = RegexUtil.replace(key, "([\\W\\w])", new Replacement() {
            int i = 0;

            @Override
            public String format(Matcher m) {
                String r1 = m.group(1);
                char r0 = r1.charAt(0);
                if (!Character.isJavaIdentifierPart(r0) ||
                        (i == 0 && !Character.isJavaIdentifierStart(r0))) {
                    return "_";
                }
                return r1;
            }
        });
        return r;
    }


    public static String getBlockStringFromCjava(String cjava) {
        Pattern pattern = Pattern.compile("(?m)^\\s*\\Qprivate static final int blockStarts[] = {\\E\\s*([\\w\\W]*?)\\s*}");
        Matcher m = pattern.matcher(cjava);
        if (m.find()) {
            return m.group(1).replaceAll("(?m)^.*//(.*?)$", "$1");
        }
        return null;
    }

    public static String getScriptStringFromCjava(String cjava) {
        Pattern pattern = Pattern.compile("(?m)^\\s*\\Qprivate static final int[] scriptStarts = {\\E\\s*([\\w\\W]*?)\\s*}");
        Matcher m = pattern.matcher(cjava);
        if (m.find()) {
            return m.group(1).replaceAll("(?m)^.*//(.*?)$", "$1");
        }
        return null;
    }
}

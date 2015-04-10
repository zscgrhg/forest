package com.frost.forest.gen.cgmain;

import com.alibaba.druid.util.IOUtils;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by wenkui on 2015/3/14.
 */
public class FreeMakerUtil {
    public final static Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);

    static {
        cfg.setClassLoaderForTemplateLoading(Thread.currentThread().getContextClassLoader(), "gen/ftl");
        cfg.setDefaultEncoding("utf-8");
    }

    public static String renderCode(Object root, String template) {

        StringWriter out = new StringWriter();
        try {
            Template temp = FreeMakerUtil.cfg.getTemplate(template);
            temp.process(root, out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) throws IOException {
        String S = IOUtils.readFromResource("gen/ftl/facade.ftl");
        System.out.println(S);
        System.out.println(cfg.getTemplate("facade.ftl"));
    }
}

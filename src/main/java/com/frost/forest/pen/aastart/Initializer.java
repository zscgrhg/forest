package com.frost.forest.pen.aastart;


import com.frost.forest.pen.bean.config.WebConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by wenkui on 2015/3/13.
 */

public class Initializer  implements WebApplicationInitializer {

    private static final String DISPATCHER_SERVLET_NAME = "dispatcher";
    private static final String DISPATCHER_SERVLET_MAPPING = "/";



    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // TODO Auto-generated method stub

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);

        CharacterEncodingFilter cef = new CharacterEncodingFilter();
        cef.setEncoding("UTF-8");
        cef.setForceEncoding(true);
        FilterRegistration.Dynamic fd = servletContext.addFilter("encodingFilter", cef);
        fd.addMappingForUrlPatterns(null, false, "/*");

        /*OpenEntityManagerInViewFilter oemf=new OpenEntityManagerInViewFilter();
        oemf.setServletContext(servletContext);
        oemf.setEntityManagerFactoryBeanName("entityManagerFactory");
        FilterRegistration.Dynamic fdo = servletContext.addFilter("Spring OpenEntityManagerInViewFilter", oemf);
        fd.addMappingForUrlPatterns(null, false, "*//*");*/

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DISPATCHER_SERVLET_NAME, new DispatcherServlet(rootContext));

        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping(DISPATCHER_SERVLET_MAPPING);

        servletContext.addListener(new ContextLoaderListener(rootContext));
    }

}

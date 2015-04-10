package com.frost.forest.pen.bean.config;


import com.frost.forest.pen.interceptor.SecureFilterChainCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import java.util.List;

/**
 * Created by wenkui on 2015/3/13.
 */
@Configuration
@ComponentScan(basePackages = {
        "com.frost.forest.pen.bean",
        "com.frost.forest.gen.bean"
})
@EnableWebMvc
@EnableTransactionManagement
@PropertySource("classpath:global.properties")
public class WebConfig extends WebMvcConfigurerAdapter {
    private static final String PROPERTY_NAME_MESSAGESOURCE_BASENAME = "message.source.basename";
    private static final String PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE = "message.source.use.code.as.default.message";


    @Resource
    private Environment environment;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();

        messageSource.setBasename(environment
                .getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_BASENAME));
        messageSource
                .setUseCodeAsDefaultMessage(Boolean.parseBoolean(environment
                        .getRequiredProperty(PROPERTY_NAME_MESSAGESOURCE_USE_CODE_AS_DEFAULT_MESSAGE)));

        return messageSource;
    }

    @Bean
    public ViewResolver viewResolver() {
        FreeMarkerViewResolver viewResolver = new FreeMarkerViewResolver();

        viewResolver.setContentType("text/html;charset=UTF-8");
        viewResolver.setSuffix(".ftl");

        viewResolver.setRequestContextAttribute("__req");
        viewResolver.setExposeSessionAttributes(true);
        viewResolver.setExposeRequestAttributes(true);
        return viewResolver;
    }
    @Bean
    @Autowired
    public FreeMarkerConfigurer freeMarkerConfigurer(ServletContext servletCotext) {
        FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_22);
        /*cfg.setClassLoaderForTemplateLoading(Thread.currentThread().getContextClassLoader(), "ftl");*/
        cfg.setServletContextForTemplateLoading(servletCotext,"WEB-INF/views/");
        cfg.setDefaultEncoding("utf-8");

        configurer.setConfiguration(cfg);


        return configurer;
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecureFilterChainCheckInterceptor());
    }

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        super.configureHandlerExceptionResolvers(exceptionResolvers);
    }
}

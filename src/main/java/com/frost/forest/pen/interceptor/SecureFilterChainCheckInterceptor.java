package com.frost.forest.pen.interceptor;


import com.frost.forest.pen.visitor.UserDetailVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.FilterRegistration;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.Map;

/**
 * Created by wenkui on 2015/3/20.
 */
public class SecureFilterChainCheckInterceptor implements HandlerInterceptor {

    private class TabularCookie extends Cookie{
        public TabularCookie(String name, String value) {
            super(name, value);
        }


    }
    final static Logger logger = LoggerFactory.getLogger(SecureFilterChainCheckInterceptor.class);
    @Override
    public boolean preHandle(final HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        final Principal userPrincipal = httpServletRequest.getUserPrincipal();
        UserDetailVisitor userDetailVisitor=new UserDetailVisitor(){
            @Override
            public String getUsername() {
                return isLogin()?userPrincipal.getName():null;
            }

            @Override
            public boolean isLogin() {
                return userPrincipal!=null;
            }


        };

        httpServletRequest.setAttribute("principal",userDetailVisitor);
        Map<String,? extends FilterRegistration> filters=httpServletRequest.getServletContext().getFilterRegistrations();
        if(!filters.keySet().contains("springSecurityFilterChain")){
            logger.error("springSecurityFilterChain  doesn't work");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

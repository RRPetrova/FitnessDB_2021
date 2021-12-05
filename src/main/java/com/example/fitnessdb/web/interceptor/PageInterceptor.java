package com.example.fitnessdb.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.logging.FileHandler;

@Component
public class PageInterceptor implements HandlerInterceptor {

    private static final String LOGIN_URL = "http://localhost:8080/users/login";

    private static Logger logger = LoggerFactory.getLogger(PageInterceptor.class);
    FileHandler fileHandler;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        try {

            if (request.getRequestURL().toString().equals(LOGIN_URL)) {
                long startTime = System.currentTimeMillis();
                logger.info(String.format("Requested URL is %s starting time at %s",
                        request.getRequestURL().toString(), System.currentTimeMillis()));
                request.setAttribute("startTime", startTime);
            }
        } catch (SecurityException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {

        if (request.getRequestURL().toString().equals(LOGIN_URL)) {
            logger.info(String.format("Requested URL is %s and post handler current time is %s",
                    request.getRequestURL().toString(), System.currentTimeMillis()));
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex)
            throws Exception {


        if (request.getRequestURL().toString().equals(LOGIN_URL)) {
            long startTime = (Long) request.getAttribute("startTime");
            logger.info(String.format("Requested URL is %s and after completion time is %s",
                    request.getRequestURL().toString(), System.currentTimeMillis()));
            logger.info(String.format("Requested URL is %s and the time toked was %s ",
                    request.getRequestURL().toString(), System.currentTimeMillis() - startTime));
        }
    }
}

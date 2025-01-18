package com.example.india.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@Component
public class RestApiFilter implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HandlerMethod handlerMethod= (HandlerMethod) handler;
        RequiredHeader requiredHeader= handlerMethod.getMethodAnnotation(RequiredHeader.class);
        if(requiredHeader==null){
            requiredHeader = handlerMethod.getMethod().getDeclaringClass().getAnnotation(RequiredHeader.class);
        }
        String dcName = request.getHeader(requiredHeader.dcName());
        String dcNum= request.getHeader(requiredHeader.dcNumber());
        if(Objects.isNull(dcName) || Objects.isNull(dcNum)){
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return false;
            }
        System.out.println("preHandle called..");
       return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
        System.out.println("afterCompletion called..");
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
        System.out.println("postHandler called..");
    }
}

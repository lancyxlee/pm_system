package edu.cqut.pm_system.config.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 过滤器功能自定义
 *
 * @author llx
 * @date 2019/9/28
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {       //请求进入这个拦截器
        HttpSession session = request.getSession();
        if (session.getAttribute("loginName") == null) {
            //判断session中有没有user信息
            //System.out.println("进入拦截器");
            // 此处应该添加上server.servlet.context-path在你需要调用的页面前。
            // 防止重定向和拦截器现成的死循环
            response.sendRedirect("/pm/login.html");
            return false;
        }
        //有的话就继续操作
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}

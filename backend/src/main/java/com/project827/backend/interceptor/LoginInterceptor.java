package com.project827.backend.interceptor;

import com.project827.backend.dto.AccountDto;
import com.project827.backend.utils.Sessions;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession httpSession = request.getSession();
        AccountDto accountDto = (AccountDto) httpSession.getAttribute(Sessions.SESSION_ID);

        if (accountDto == null) {
            //response.sendRedirect("/login");
            return false;
        } else {
            return true;
        }
    }

}

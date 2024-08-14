package com.app.springcoolapp.configs;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DemoFilter extends HttpFilter {




    @Override
    @Order(1)
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Filter....");

        boolean isPwdExpired = false;

        if(request.getSession(false).getAttribute("pwdExpires")!=null){
            int val = (int)request.getSession(false).getAttribute("pwdExpires");
            if(val==1){
                isPwdExpired = true;
            }
        }
        if(isPwdExpired && !isUrlExcluded(request)) {
            System.out.println("Password expired..");
            changePassword(request, response);

        } else{
            chain.doFilter(request, response);
        }

    }

    public void changePassword(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String redirectURL = request.getContextPath() + "/change_password";
        response.sendRedirect(redirectURL);
    }
    private boolean isAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || AnonymousAuthenticationToken.class.
                isAssignableFrom(authentication.getClass())) {
            return false;
        }
        return authentication.isAuthenticated();
    }

    private boolean isUrlExcluded(HttpServletRequest httpRequest)
            throws IOException, ServletException {
        String url = httpRequest.getRequestURL().toString();

        if (url.endsWith(".css") || url.endsWith(".png") || url.endsWith(".js")
                || url.endsWith("/change_password")) {
            return true;
        }

        return false;
    }
}

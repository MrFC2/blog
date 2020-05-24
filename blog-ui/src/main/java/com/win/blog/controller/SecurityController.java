package com.win.blog.controller;

import com.win.blog.model.vo.AuthorityResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/security")
public class SecurityController {

    // 原请求信息的缓存及恢复
    private RequestCache requestCache = new HttpSessionRequestCache();

    // 用于重定向
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    //当需要身份认证时，跳转到这里进行处理。
    @GetMapping(value = "/requireAuthority")
    @ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public AuthorityResponse requireAuthority(HttpServletRequest request, HttpServletResponse response) throws IOException {
        SavedRequest savedRequest = requestCache.getRequest(request, response);
        if (savedRequest != null) {
            String targetUrl = savedRequest.getRedirectUrl();
            System.out.println("引发跳转的请求是：" + targetUrl);
            //如果请求的是html页面，则将其放行重定向到登录页面
            //if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
            //    redirectStrategy.sendRedirect(request, response, "/login.html");
            //}
        }
        //直接返回信息到页面
        return new AuthorityResponse("访问的服务需要身份认证，请引导用户到登录页");
    }
}

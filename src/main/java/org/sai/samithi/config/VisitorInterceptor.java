package org.sai.samithi.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.sai.samithi.entities.Visitor;
import org.sai.samithi.repositories.VisitorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class VisitorInterceptor implements HandlerInterceptor {

    @Autowired
    private VisitorRepository visitorRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        Visitor visitor = new Visitor();
        String uri = request.getRequestURI();
        if(uri.contains("/css/") || uri.contains("/js/") || uri.contains("/img/") || uri.contains("/favicon"))
            return true;
        visitor.setIpAddress(request.getRemoteAddr());
        visitor.setUserAgent(request.getHeader("User-Agent"));
        visitor.setUrl(uri);
        visitor.setVisitTime(Date.from(Instant.now()));

        visitorRepository.save(visitor);
        return true;
    }
}

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
        visitor.setIpAddress(request.getRemoteAddr());
        visitor.setUserAgent(request.getHeader("User-Agent"));
        visitor.setUrl(request.getRequestURI());
        visitor.setVisitTime(Date.from(Instant.now()));

        visitorRepository.save(visitor);
        return true;
    }
}

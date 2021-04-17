package com.eci.ieti.configuration;

import java.io.IOException;




import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.eci.ieti.services.UserService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;


@Component
public class JwtFilterRequest extends GenericFilterBean   {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private UserService userService;

    private static Logger log = LoggerFactory.getLogger(JwtFilterRequest.class);

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        System.out.println("FILTER");
        String authorizationHeader = request.getHeader("Authorization");
        String userName = null;
        String jwtToken = null;
        log.info("FILTER");
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            jwtToken = authorizationHeader.substring(7);
            userName = jwtUtils.extractUsernane(jwtToken);
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null ){
            UserDetails currentUserDetails = userService.loadUserByUsername(userName);
            Boolean tockenValidated  = jwtUtils.validateToken(jwtToken, currentUserDetails);
            if (Boolean.TRUE.equals(tockenValidated)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =new UsernamePasswordAuthenticationToken(currentUserDetails, null, currentUserDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        doFilterInternal((HttpServletRequest) request, (HttpServletResponse) response, chain);
    }
}

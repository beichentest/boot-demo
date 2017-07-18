package com.hys.boot.consumer.framework.security.ss3;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;

import com.hys.api.domain.SysUserVo;
import com.hys.boot.consumer.framework.security.SecurityAuthProvider;
import com.hys.boot.consumer.servlet.RequestHolder;

public class SS3AuthProvider implements SecurityAuthProvider {

private static final Logger log = LoggerFactory.getLogger(SS3AuthProvider.class);
    
    private SessionAuthenticationStrategy sessionStrategy;
    
    private AuthenticationManager authenticationManager;
    
    /**
     * 获取用户授权信息
     * 
     * @return
     */
    private static Authentication getAuthentication() {
        Authentication authentication = null;
        SecurityContext context = SecurityContextHolder.getContext();
        if(context != null) {
            authentication = context.getAuthentication();
        }
        
        if(authentication == null) {
            HttpServletRequest request = RequestHolder.getRequest();
            if(request == null) {
                log.warn("Security httpRequest is null!");
                return null;
            }
            
            HttpSession session = request.getSession(false);
            if(session == null) {
                log.warn("Security httpSession is null!");
                return null;
            }
            context = (SecurityContext)session.getAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY);
            if(context != null) {
                authentication = context.getAuthentication();
            }
        }
        return authentication;
    }
    
    /**
     * 用户是否已经登陆
     * @return 
     */
    @Override
    public boolean isAuthenticated() {
        Authentication auth = getAuthentication();
        return auth != null;
    }
    
    /**
     * 获取登录用户信息
     *
     * @return
     */
    @Override
    public SysUserVo getPrincipal() {
        Authentication auth = getAuthentication();
        if(auth == null)
            return null;
        if(auth.getPrincipal() instanceof CustomUserDetails) {
            CustomUserDetails ue = (CustomUserDetails)auth.getPrincipal();
            return ue.getCustomUserDetails();
        }
        return null;
    }

    @Override
    public void auth(String accountname, String accountpassword) {
        HttpServletRequest request = RequestHolder.getRequest();
        
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(accountname, accountpassword);
        token.setDetails(new WebAuthenticationDetails(request));

//        if(authenticationManager == null)
//            throw new FrameworkRuntimeException("not found authenticationManager instance!");
        
        // 以下代码节选自 org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
        Authentication authResult;

        try {
            authResult = authenticationManager.authenticate(token);
            if (authResult == null) {
                return;
            }
            if(sessionStrategy != null)
                sessionStrategy.onAuthentication(authResult, request, null);
        } 
        catch(InternalAuthenticationServiceException failed) {
            SecurityContextHolder.clearContext();
            return;
        }
        catch (AuthenticationException failed) {
            SecurityContextHolder.clearContext();
            return;
        }
        
        SecurityContextHolder.getContext().setAuthentication(authResult);
        RequestHolder.getRequest().getSession().setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, SecurityContextHolder.getContext());
        
    }
    
    @Override
    public void logout() {
        HttpServletRequest request = RequestHolder.getRequest();
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(null);

        SecurityContextHolder.clearContext();
    }

    public void setSessionStrategy(SessionAuthenticationStrategy sessionStrategy) {
        this.sessionStrategy = sessionStrategy;
    }

    public void setAuthenticationManager(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
}

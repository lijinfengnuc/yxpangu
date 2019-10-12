/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.security;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * ClassName: CustomAccessDecisionManager <br/>
 * Function: <br/>
 * date: 2019年03月26日 17:34 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Component
public class CustomAccessDecisionManager implements AccessDecisionManager {

    @Override
    public void decide(Authentication authentication, Object object, Collection<ConfigAttribute> configAttributes)
            throws AccessDeniedException, InsufficientAuthenticationException {
        // configAttributes空检验在beforeInvocation方法中已经判断
        if(null != authentication) {
            Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
            if(!CollectionUtils.isEmpty(authorities)) {
                boolean hasAccess = hasAccess(configAttributes, authentication.getAuthorities());
                if (hasAccess) {
                    return;
                }
            }
        }
        // 当前用户认证对象为null || 当前用户权限为空 || 当前用户没有权限访问当前URL，抛出异常
        throw new AccessDeniedException("");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }

    private boolean hasAccess(Collection<ConfigAttribute> configAttributes,
                              Collection<? extends GrantedAuthority> authorities) {
        Set configAttributeSet = configAttributes.stream()
                .map(configAttribute -> configAttribute.getAttribute())
                .collect(Collectors.toSet());
        return authorities.stream()
                .map(grantedAuthority -> ((GrantedAuthority) grantedAuthority).getAuthority())
                .anyMatch(authority -> configAttributeSet.contains(authority));
    }

}

/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.security;

import com.google.common.collect.Lists;
import nuc.ljf.pangu.constants.Constants;
import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: CustomFilterInvocationSecurityMetadataSource <br/>
 * Function: <br/>
 * date: 2019年03月26日 16:54 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Component
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private AccessService accessService;

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        HttpServletRequest request = ((FilterInvocation) object).getRequest();
        String requestURI = request.getRequestURI();
        String method = request.getMethod();
        List<Access> accesses = accessService.listAllAccesses();
        if(CollectionUtils.isEmpty(accesses)) {
            return Lists.newArrayList();
        }
        else{
            AntPathMatcher antPathMatcher = new AntPathMatcher();
            return accesses.stream()
                    .filter(access -> antPathMatcher.match(access.getUrl(), requestURI) &&
                            (method.equals(access.getAction()) || Constants.HTTPMethod.ALL.value.equals(access.getAction())))
                    .map(access -> new SecurityConfig(String.valueOf(access.getId())))
                    .collect(Collectors.toList());
        }
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

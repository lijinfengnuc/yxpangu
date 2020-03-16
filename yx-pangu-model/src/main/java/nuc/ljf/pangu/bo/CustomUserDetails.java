/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.bo;

import com.google.common.collect.Lists;
import nuc.ljf.pangu.constants.Constants;
import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.po.rbac.UserInfo;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: CustomUserDetails <br/>
 * Function: <br/>
 * date: 2019年03月27日 09:41 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

public class CustomUserDetails implements UserDetails {

    private UserInfo user;

    private List<Access> accesses;

    public CustomUserDetails(UserInfo user, List<Access> accesses) {
        this.user = user;
        this.accesses = accesses;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if(!CollectionUtils.isEmpty(this.accesses)) {
            grantedAuthorities.addAll(this.accesses.stream()
                    .map(access -> new SimpleGrantedAuthority(String.valueOf(access.getId())))
                    .collect(Collectors.toList()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsernameType() == Constants.UsernameType.EMAIL.value ?
                user.getEmail() : user.getPhoneNumber();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}

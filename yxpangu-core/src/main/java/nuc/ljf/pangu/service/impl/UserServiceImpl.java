/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.service.impl;

import com.google.common.collect.Lists;
import nuc.ljf.pangu.bo.CustomUserDetails;
import nuc.ljf.pangu.constants.Constants;
import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.po.rbac.Role;
import nuc.ljf.pangu.po.rbac.UserInfo;
import nuc.ljf.pangu.po.rbac.UserRoleRelation;
import nuc.ljf.pangu.repository.rbac.UserRepository;
import nuc.ljf.pangu.repository.rbac.UserRoleRelationRepository;
import nuc.ljf.pangu.service.RoleService;
import nuc.ljf.pangu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: UserServiceImpl <br/>
 * Function: <br/>
 * date: 2019年03月27日 10:49 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Service("userDetailsService")
public class UserServiceImpl implements UserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRelationRepository userRoleRelationRepository;

    @Autowired
    private RoleService roleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo user = this.getUserByUsername(username);
        if(user != null) {
            List<Access> accesses = this.listAccessesByUserId(user.getId());
            return new CustomUserDetails(user, accesses);
        }
        throw new UsernameNotFoundException("UserInfo " + username + " is not found");
    }

    @Override
    public UserInfo getUserByUsername(String username) {
        UserInfo user = null;
        List<UserInfo> usersByEmail = userRepository.findByEmail(username);
        if(CollectionUtils.isEmpty(usersByEmail)) {
            List<UserInfo> usersByPhoneNumber = userRepository.findByPhoneNumber(username);
            if(!CollectionUtils.isEmpty(usersByPhoneNumber)) {
                user = usersByPhoneNumber.get(0);
                user.setUsernameType(Constants.UsernameType.PHONE_NUMBER.value);
            }
        }else {
            user = usersByEmail.get(0);
            user.setUsernameType(Constants.UsernameType.EMAIL.value);
        }
        return user;
    }

    @Override
    public List<Long> listRoleIdsByUserId(long userId) {
        List<UserRoleRelation> userRoleRelations = userRoleRelationRepository.findByUserId(userId);
        return userRoleRelations.stream()
                .map(userRoleRelation -> userRoleRelation.getRoleId())
                .collect(Collectors.toList());
    }

    @Override
    public List<Role> listRolesByUserId(long userId) {
        List<Long> roleIds = this.listRoleIdsByUserId(userId);
        return CollectionUtils.isEmpty(roleIds) ? Lists.newArrayList() : roleService.listRolesByRoleIds(roleIds);
    }

    @Override
    public List<Long> listAccessIdsByUserId(long userId) {
        List<Long> roleIds = this.listRoleIdsByUserId(userId);
        return CollectionUtils.isEmpty(roleIds) ? Lists.newArrayList() : roleService.listAccessIdByRoleIds(roleIds);
    }

    @Override
    public List<Access> listAccessesByUserId(long userId) {
        List<Long> roleIds = this.listRoleIdsByUserId(userId);
        return CollectionUtils.isEmpty(roleIds) ? Lists.newArrayList() : roleService.listAccessesByRoleIds(roleIds);
    }

}

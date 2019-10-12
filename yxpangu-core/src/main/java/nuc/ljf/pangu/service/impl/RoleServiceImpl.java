/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.service.impl;

import com.google.common.collect.Lists;
import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.po.rbac.Role;
import nuc.ljf.pangu.po.rbac.RoleAccessRelation;
import nuc.ljf.pangu.repository.rbac.RoleAccessRelationRepository;
import nuc.ljf.pangu.repository.rbac.RoleRepository;
import nuc.ljf.pangu.service.AccessService;
import nuc.ljf.pangu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: RoleServiceImpl <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:33 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private RoleAccessRelationRepository roleAccessRelationRepository;

    @Autowired
    private AccessService accessService;

    @Override
    public List<Role> listRolesByRoleIds(List<Long> roleIds) {
        return roleRepository.findByIdIn(roleIds);
    }

    @Override
    public List<Long> listAccessIdByRoleIds(List<Long> roleIds) {
        List<RoleAccessRelation> roleAccessRelations = roleAccessRelationRepository.findByRoleIdIn(roleIds);
        return roleAccessRelations.stream()
                .map(roleAccessRelation -> roleAccessRelation.getAccessId())
                .collect(Collectors.toList());
    }

    @Override
    public List<Access> listAccessesByRoleIds(List<Long> roleIds) {
        List<Long> accessIds = this.listAccessIdByRoleIds(roleIds);
        return CollectionUtils.isEmpty(accessIds) ? Lists.newArrayList() :
                accessService.listAccessesByAccessIds(accessIds);
    }

}

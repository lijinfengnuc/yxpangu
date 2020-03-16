/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.service;

import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.po.rbac.Role;

import java.util.List;

/**
 * InterfaceName: RoleService <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:30 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface RoleService {

    List<Role> listRolesByRoleIds(List<Long> roleIds);

    List<Long> listAccessIdByRoleIds(List<Long> roleIds);

    List<Access> listAccessesByRoleIds(List<Long> roleIds);

}

/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.service;

import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.po.rbac.Role;
import nuc.ljf.pangu.po.rbac.UserInfo;

import java.util.List;

/**
 * InterfaceName: UserService <br/>
 * Function: <br/>
 * date: 2019年03月27日 10:48 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface UserService {

    UserInfo getUserByUsername(String username);

    List<Long> listRoleIdsByUserId(long userId);

    List<Role> listRolesByUserId(long userId);

    List<Long> listAccessIdsByUserId(long userId);

    List<Access> listAccessesByUserId(long userId);

}

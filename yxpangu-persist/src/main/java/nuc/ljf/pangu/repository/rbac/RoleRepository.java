/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.repository.rbac;

import nuc.ljf.pangu.po.rbac.Role;
import nuc.ljf.pangu.repository.base.BaseRepository;

import java.util.List;

/**
 * InterfaceName: RoleRepository <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:27 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface RoleRepository extends BaseRepository<Role, Long> {

    List<Role> findByIdIn(List<Long> ids);

}

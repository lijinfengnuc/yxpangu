/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.repository.rbac;

import nuc.ljf.pangu.po.rbac.RoleAccessRelation;
import nuc.ljf.pangu.repository.base.BaseRepository;

import java.util.List;

/**
 * InterfaceName: RoleAccessRelationRepository <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:39 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface RoleAccessRelationRepository extends BaseRepository<RoleAccessRelation, Long> {

    List<RoleAccessRelation> findByRoleIdIn(List<Long> roleIds);

}

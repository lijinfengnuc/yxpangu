/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.repository.rbac;

import nuc.ljf.pangu.po.rbac.UserRoleRelation;
import nuc.ljf.pangu.repository.base.BaseRepository;

import java.util.List;

/**
 * InterfaceName: UserRoleRelationRepository <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:37 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface UserRoleRelationRepository extends BaseRepository<UserRoleRelation, Long> {

    List<UserRoleRelation> findByUserId(long userId);

}

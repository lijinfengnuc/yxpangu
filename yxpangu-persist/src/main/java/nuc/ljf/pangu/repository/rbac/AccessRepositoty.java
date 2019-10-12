/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.repository.rbac;

import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.repository.base.BaseRepository;

import java.util.List;

/**
 * InterfaceName: AccessRepositoty <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:36 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface AccessRepositoty extends BaseRepository<Access, Long> {

    List<Access> findByIdIn(List<Long> accessIds);

}

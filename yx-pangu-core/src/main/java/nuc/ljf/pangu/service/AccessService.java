/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.service;

import nuc.ljf.pangu.po.rbac.Access;

import java.util.List;

/**
 * InterfaceName: AccessService <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:34 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface AccessService {

    List<Access> listAccessesByAccessIds(List<Long> accessIds);

    List<Access> listAllAccesses();

}

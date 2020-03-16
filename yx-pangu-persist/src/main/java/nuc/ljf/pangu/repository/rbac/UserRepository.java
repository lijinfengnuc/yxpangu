/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.repository.rbac;

import nuc.ljf.pangu.po.rbac.UserInfo;
import nuc.ljf.pangu.repository.base.BaseRepository;

import java.util.List;

/**
 * InterfaceName: UserRepository <br/>
 * Function: <br/>
 * date: 2019年03月27日 10:55 <br/>
 *
 * @author lijinfeng
 * @since JDK1.8
 */

public interface UserRepository extends BaseRepository<UserInfo, Long> {

    List<UserInfo> findByEmail(String email);

    List<UserInfo> findByPhoneNumber(String phoneNumber);

}

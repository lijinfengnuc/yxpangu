/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.service.impl;

import nuc.ljf.pangu.po.rbac.Access;
import nuc.ljf.pangu.repository.rbac.AccessRepositoty;
import nuc.ljf.pangu.service.AccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ClassName: AccessServiceImpl <br/>
 * Function: <br/>
 * date: 2019年03月27日 14:35 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Service
public class AccessServiceImpl implements AccessService {

    @Autowired
    private AccessRepositoty accessRepositoty;

    @Override
    public List<Access> listAccessesByAccessIds(List<Long> accessIds) {
        return accessRepositoty.findByIdIn(accessIds);
    }

    @Override
    public List<Access> listAllAccesses() {

        return null;
    }

}

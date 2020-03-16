/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.po.rbac;

import lombok.Data;
import lombok.ToString;
import nuc.ljf.pangu.po.base.BasePOWithVersion;

import javax.persistence.Entity;

/**
 * ClassName: UserRoleRelation <br/>
 * Function: <br/>
 * date: 2019年03月25日 17:20 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Data
@ToString(callSuper = true)
@Entity
public class UserRoleRelation extends BasePOWithVersion {

    private long userId;

    private long roleId;

}

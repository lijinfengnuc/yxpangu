/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.po.rbac;

import lombok.Data;
import lombok.ToString;
import nuc.ljf.pangu.po.base.BasePOWithVersion;

import javax.persistence.Entity;

/**
 * ClassName: RoleAccessRelation <br/>
 * Function: <br/>
 * date: 2019年03月25日 17:17 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Data
@ToString(callSuper = true)
@Entity
public class RoleAccessRelation extends BasePOWithVersion {

    private long roleId;

    private long accessId;

}

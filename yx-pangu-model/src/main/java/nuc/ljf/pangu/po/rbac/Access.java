/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.po.rbac;

import lombok.Data;
import lombok.ToString;
import nuc.ljf.pangu.po.base.BasePOWithVersion;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * ClassName: Access <br/>
 * Function: <br/>
 * date: 2019年03月25日 17:16 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Data
@ToString(callSuper = true)
@Entity
public class Access extends BasePOWithVersion {

    @Column(length = 20)
    private String name;

    @Column(length = 200)
    private String url;

    @Column(length = 10)
    private String action;

    @Column(length = 100)
    private String description;

}

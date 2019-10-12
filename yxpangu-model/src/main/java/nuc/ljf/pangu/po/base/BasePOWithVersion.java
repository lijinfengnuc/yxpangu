/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.po.base;

import lombok.Data;
import lombok.ToString;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * ClassName: BasePOWithVersion <br/>
 * Function: <br/>
 * date: 2019年03月24日 18:14 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Data
@ToString(callSuper = true)
@MappedSuperclass
public class BasePOWithVersion extends BasePO{

    @Version
    private long version;

}

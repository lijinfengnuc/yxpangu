/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.po.rbac;

import lombok.Data;
import lombok.ToString;
import nuc.ljf.pangu.po.base.BasePOWithVersion;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import java.time.LocalDate;

/**
 * ClassName: UserInfo <br/>
 * Function: <br/>
 * date: 2019年03月24日 18:32 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Data
@ToString(callSuper = true)
@Entity
public class UserInfo extends BasePOWithVersion {

    @Column(length = 30, updatable = false, unique = true)
    private String email;

    @Column(length = 11, updatable = false, unique = true)
    private String phoneNumber;

    @Column(length = 20)
    private String nickname;

    @Column(length = 16)
    private String password;

    @Column(length = 100)
    private String signature;

    private int gender;

    private LocalDate birthDate;

    private int career;

    private int workingLife;

    private int currentPlace;

    private int birthPlace;

    @Transient
    private int usernameType;

}

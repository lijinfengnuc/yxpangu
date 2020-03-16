/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.api;

import nuc.ljf.pangu.po.rbac.UserInfo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName: TestC <br/>
 * Function: <br/>
 * date: 2019年03月01日 16:31 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */
@RestController
@RequestMapping("/test")
public class Test {

    @CrossOrigin
    @GetMapping("/hello")
    public String test() {
        ThreadPoolExecutor l;
        System.out.println(new UserInfo().setCareer(11).setVersion(111).setId(222).toString());
        return "hello";
    }

    public static void main(String[] args) {
        System.out.println(-1 << 29);
        System.out.println(0 << 29);
        System.out.println(1 << 29);
        System.out.println(2 << 29);
        System.out.println(3 << 29);
        System.out.println(3 << 29 & ~((1 << 29) - 1));
    }




}

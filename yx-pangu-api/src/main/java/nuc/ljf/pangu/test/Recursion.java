/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.test;

import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: Recursion <br/>
 * Function: <br/>
 * date: 2019年05月06日 18:12 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

public class Recursion {

    private static Map<Integer, Integer> totalMap = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(total(5));
        System.out.println(totalMap);
    }

    private static int total(int n) {
        if(n == 1)
            return 1;
        else if(n == 2)
            return 2;
        else if(totalMap.containsKey(n)){
            return totalMap.get(n);
        }else{
            int total = total(n-1) + total(n-2);
            totalMap.put(n, total);
            return total;
        }
    }

}

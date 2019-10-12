/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.utils;


import cn.hutool.http.HttpStatus;
import nuc.ljf.pangu.constants.Constants;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * ClassName: ResultUtil <br/>
 * Function: <br/>
 * date: 2019年03月21日 15:06 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

public class ResultUtil {

    public static Result buildResult(int code, String reasonPhrase) {
        return buildResult(code, reasonPhrase, null);
    }

    public static Result buildResult(int code, String reasonPhrase, String... msgs) {
        String msg = ArrayUtils.isEmpty(msgs) ? reasonPhrase :
                reasonPhrase + Constants.Symbol.POINT.value + StringUtils.join(msgs, Constants.Symbol.POINT.value);
        return new Result(String.valueOf(code), msg);
    }

    public static <T> Result buildResult(T data) {
        return new Result(String.valueOf(HttpStatus.HTTP_OK), data);
    }

}

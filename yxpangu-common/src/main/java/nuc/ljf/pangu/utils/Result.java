/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * ClassName: Result <br/>
 * Function: <br/>
 * date: 2019年03月21日 14:55 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result<T> {

    private String code;

    private String msg;

    private T data;

    public Result(String code, T data){
        this.code = code;
        this.data = data;
    }

    public Result(String code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

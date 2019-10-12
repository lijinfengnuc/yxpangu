/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.constants;

/**
 * ClassName: Constants <br/>
 * Function: <br/>
 * date: 2019年03月21日 15:01 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

public class Constants {

    public static final String PROJECT_NAME = "yxpangu";
    public static final String ERROR_PATH = "/error";
    public static final String STATUS_ATTRIBUTE_NAME = "javax.servlet.error.status_code";

    public enum LogPrefixEnum {
        ERROR("Error occurred:"),
        EXCEPTION("Exception occurred:");
        public final String value;
        LogPrefixEnum(String value) {
            this.value = value;
        }
    }

    public enum UsernameType {
        EMAIL(1),
        PHONE_NUMBER(2);
        public final int value;
        UsernameType(int value) {
            this.value = value;
        }
    }

    public enum HTTPMethod {
        GET("GET"),
        POST("POST"),
        PUT("PUT"),
        DELETE("DELETE"),
        ALL("ALL");
        public final String value;
        HTTPMethod(String value) {
            this.value = value;
        }
    }

    public enum Symbol {
        UNDERLINE("_"),
        POINT(".");
        public final String value;
        Symbol(String value) {
            this.value = value;
        }
    }


}

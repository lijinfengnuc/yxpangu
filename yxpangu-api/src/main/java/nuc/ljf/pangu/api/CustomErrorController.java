/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.api;

import lombok.extern.slf4j.Slf4j;
import nuc.ljf.pangu.constants.Constants;
import nuc.ljf.pangu.utils.Result;
import nuc.ljf.pangu.utils.ResultUtil;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * ClassName: ErrorController <br/>
 * Function: <br/>
 * date: 2019年03月21日 16:39 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */
@Slf4j
@RestController
public class CustomErrorController implements ErrorController {

    private static final boolean INCLUDE_EXCEPTION = true;

    @Autowired
    private ErrorAttributes errorAttributes;

    @RequestMapping(Constants.ERROR_PATH)
    @ResponseBody
    public Result handleError(HttpServletRequest request){
        Map<String, Object> errorAttributes =
                this.errorAttributes.getErrorAttributes(new ServletWebRequest(request), INCLUDE_EXCEPTION);
        int status = MapUtils.getIntValue(errorAttributes, "status");
        String error = MapUtils.getString(errorAttributes, "error");
        String message = MapUtils.getString(errorAttributes, "message");
        log.warn(StringUtils.joinWith(Constants.Symbol.POINT.value, Constants.LogPrefixEnum.ERROR.value, error, message));
        return ResultUtil.buildResult(status, error);
    }

    @Override
    public String getErrorPath() {
        return Constants.ERROR_PATH;
    }

}

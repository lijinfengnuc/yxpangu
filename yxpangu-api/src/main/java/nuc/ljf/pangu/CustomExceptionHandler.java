/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu;

import lombok.extern.slf4j.Slf4j;
import nuc.ljf.pangu.constants.Constants;
import nuc.ljf.pangu.utils.Result;
import nuc.ljf.pangu.utils.ResultUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * ClassName: ExceptionHandler <br/>
 * Function: <br/>
 * date: 2019年03月21日 15:36 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler
    @ResponseBody
    public Result exceptionHandler(Exception exception) {
        log.error(Constants.LogPrefixEnum.EXCEPTION.value, exception);
        return ResultUtil.buildResult(HttpStatus.INTERNAL_SERVER_ERROR.value(),
                HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(), exception.getMessage());
    }

}

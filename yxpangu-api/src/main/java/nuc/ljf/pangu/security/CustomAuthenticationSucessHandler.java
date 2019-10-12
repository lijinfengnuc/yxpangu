/*
 * Copyright (c) 1997, 2019, BONC. All rights reserved.
 */

package nuc.ljf.pangu.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * ClassName: CustomAuthenticationSucessHandler <br/>
 * Function: <br/>
 * date: 2019年03月29日 11:19 <br/>
 *
 * @author lijinfeng
 * @version 1
 * @since JDK1.8
 */

@Component
public class CustomAuthenticationSucessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {



        super.onAuthenticationSuccess(request, response, authentication);
    }
}

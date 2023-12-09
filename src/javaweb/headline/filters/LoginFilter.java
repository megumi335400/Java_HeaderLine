package javaweb.headline.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.headline.common.Result;
import javaweb.headline.common.ResultCodeEnum;
import javaweb.headline.util.JwtHelper;
import javaweb.headline.util.WebUtil;

import java.io.IOException;

/**
 * ClassName: LoginFilter
 * Package: javaweb.headline.filters
 * Description:
 *
 * @Author yzy
 * @Create 12/10/2023 12:25 AM
 * @Version 1.0
 */
@WebFilter("/headline/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String token = request.getHeader("token");
        boolean flag = token!=null&&!JwtHelper.isExpiration(token) ?true:false;

        if (flag){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            WebUtil.writeJson(response, Result.build(null, ResultCodeEnum.NOTLOGIN));
        }
    }
}

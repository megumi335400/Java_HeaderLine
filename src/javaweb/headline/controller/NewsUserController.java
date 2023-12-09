package javaweb.headline.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.headline.common.Result;
import javaweb.headline.common.ResultCodeEnum;
import javaweb.headline.pojo.NewsUser;
import javaweb.headline.service.NewsUserService;
import javaweb.headline.service.impl.NewsUserServiceImpl;
import javaweb.headline.util.JwtHelper;
import javaweb.headline.util.MD5Util;
import javaweb.headline.util.WebUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NewsUserController
 * Package: javaweb.headline.controller
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:14 PM
 * @Version 1.0
 */
@WebServlet("/user/*")
public class NewsUserController extends BaseController{
    private NewsUserService userService = new NewsUserServiceImpl();
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser paramUser =  WebUtil.readJson(req, NewsUser.class);
        NewsUser loginUser = userService.findByUsername(paramUser.getUsername());
        Result result = null;
        if (loginUser==null){
            result = Result.build(null, ResultCodeEnum.USERNAME_ERROR);
        }else {
            String paramPwd = MD5Util.encrypt(paramUser.getUserPwd());
            if(loginUser.getUserPwd().equalsIgnoreCase(paramPwd)){
                String jwt_token = JwtHelper.createToken(loginUser.getUid().longValue());
                Map map_token = new HashMap();
                map_token.put("token",jwt_token);

                result = Result.ok(map_token);
            }else {
                result = Result.build(null,ResultCodeEnum.PASSWORD_ERROR);
            }
        }
        WebUtil.writeJson(resp,result);

    }

    protected void getUserInfo(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result = null;
        if(token!=null&&!token.equalsIgnoreCase("")){
            if(!JwtHelper.isExpiration(token)){
                Integer userId = JwtHelper.getUserId(token).intValue();
                NewsUser newsUser = userService.findByUid(userId);
                if(newsUser!=null){
                    Map data = new HashMap();
                    newsUser.setUserPwd("");
                    data.put("loginUser",newsUser);
                    result = Result.ok(data);
                }
            }
        }
        WebUtil.writeJson(resp,result);
    }

    protected void checkUserName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username =  req.getParameter("username");
        NewsUser newsUser = userService.findByUsername(username);
        Result result = Result.ok(null);
        if (newsUser!=null){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsUser newsUser = WebUtil.readJson(req,NewsUser.class);
        Integer rows = userService.registUser(newsUser);
        Result result = Result.ok(null);
        if (rows==0){
            result = Result.build(null,ResultCodeEnum.USERNAME_USED);
        }
        WebUtil.writeJson(resp,result);
    }
    protected void checkLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        Result result = Result.build(null,ResultCodeEnum.NOTLOGIN);
        if (token!=null){
            if (!JwtHelper.isExpiration(token)){
                result = Result.ok(null);
            }
        }

        WebUtil.writeJson(resp,result);

    }



}


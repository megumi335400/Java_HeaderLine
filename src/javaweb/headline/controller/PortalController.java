package javaweb.headline.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.headline.common.Result;
import javaweb.headline.pojo.NewsType;
import javaweb.headline.pojo.vo.HeadlineQueryVo;
import javaweb.headline.service.NewsHeadlineService;
import javaweb.headline.service.NewsTypeService;
import javaweb.headline.service.impl.NewsHeadlineServiceImpl;
import javaweb.headline.service.impl.NewsTypeServiceImpl;
import javaweb.headline.util.WebUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: PortalController
 * Package: javaweb.headline.controller
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:14 PM
 * @Version 1.0
 */
@WebServlet("/portal/*")
public class PortalController extends BaseController{
    private NewsTypeService typeService = new NewsTypeServiceImpl();
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();
    protected void findAllTypes(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsType> newsTypeList  =  typeService.findAll();
        Result result = Result.ok(newsTypeList);

        WebUtil.writeJson(resp,result);
    }
    protected void findNewsPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HeadlineQueryVo headlineQueryVo =  WebUtil.readJson(req,HeadlineQueryVo.class);
        Map pageInfo =  headlineService.findPage(headlineQueryVo);
        Map data = new HashMap();
        data.put("pageInfo",pageInfo);
        WebUtil.writeJson(resp,Result.ok(data));
    }
}

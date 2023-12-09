package javaweb.headline.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import javaweb.headline.common.Result;
import javaweb.headline.pojo.NewsHeadline;
import javaweb.headline.service.NewsHeadlineService;
import javaweb.headline.service.impl.NewsHeadlineServiceImpl;
import javaweb.headline.util.JwtHelper;
import javaweb.headline.util.WebUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName: NewsHeadlineController
 * Package: javaweb.headline.controller
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:13 PM
 * @Version 1.0
 */
@WebServlet("/headline/*")
public class NewsHeadlineController extends BaseController {
    private NewsHeadlineService headlineService = new NewsHeadlineServiceImpl();
    protected void publish(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String token = req.getHeader("token");
        int userId = JwtHelper.getUserId(token).intValue();
        NewsHeadline newsHeadline = WebUtil.readJson(req,NewsHeadline.class);
        newsHeadline.setPublisher(userId);
        headlineService.addHeadline(newsHeadline);
        Result result = Result.ok(null);
        WebUtil.writeJson(resp,result);

    }


    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsHeadline newsHeadline = WebUtil.readJson(req,NewsHeadline.class);
        headlineService.updateHeadline(newsHeadline);
        Result result =Result.ok(null);
        WebUtil.writeJson(resp,result);

    }


    protected void removeByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int hid = Integer.parseInt(req.getParameter("hid"));
        headlineService.removeByHid(hid);
        WebUtil.writeJson(resp,Result.ok(null));
    }

    protected void findHeadlineByHid(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer hid = Integer.parseInt(req.getParameter("hid"));
        Map data = new HashMap();
        NewsHeadline newsHeadline = headlineService.findHeadlineByHid(hid);
        data.put("headline",newsHeadline);
        Result result = Result.ok(data);
        WebUtil.writeJson(resp,result);


    }
}

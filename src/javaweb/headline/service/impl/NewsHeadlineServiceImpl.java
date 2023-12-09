package javaweb.headline.service.impl;

import javaweb.headline.dao.NewsHeadLineDao;
import javaweb.headline.dao.impl.NewsHeadlineDaoImpl;
import javaweb.headline.pojo.vo.HeadlinePageVo;
import javaweb.headline.pojo.vo.HeadlineQueryVo;
import javaweb.headline.service.NewsHeadlineService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ClassName: NewsHeadlineServiceImpl
 * Package: javaweb.headline.service.impl
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:03 PM
 * @Version 1.0
 */
public class NewsHeadlineServiceImpl  implements NewsHeadlineService {
    private NewsHeadLineDao headLineDao = new NewsHeadlineDaoImpl();
    @Override
    public Map findPage(HeadlineQueryVo headlineQueryVo) {
        int pageNum = headlineQueryVo.getPageNum();
        int pageSize = headlineQueryVo.getPageSize();
        List<HeadlinePageVo> pageData = headLineDao.findPageList(headlineQueryVo);
        int totalSize = headLineDao.findPageCount(headlineQueryVo);
        int totalPage = totalSize%pageSize==0?totalSize/pageSize:totalSize/pageSize+1;
        Map pageInfo = new HashMap();
        pageInfo.put("pageData",pageData);
        pageInfo.put("pageNum",pageNum);
        pageInfo.put("pageSize",pageSize);
        pageInfo.put("totalPage",totalPage);
        pageInfo.put("totalSize",totalSize);
        return pageInfo;
    }
}
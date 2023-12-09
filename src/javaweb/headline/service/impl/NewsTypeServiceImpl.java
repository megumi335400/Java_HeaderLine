package javaweb.headline.service.impl;

import javaweb.headline.dao.NewsTypeDao;
import javaweb.headline.dao.impl.NewsTypeDaoImpl;
import javaweb.headline.pojo.NewsType;
import javaweb.headline.service.NewsTypeService;

import java.util.List;

/**
 * ClassName: NewsTypeServiceImpl
 * Package: javaweb.headline.service.impl
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:03 PM
 * @Version 1.0
 */
public class NewsTypeServiceImpl implements NewsTypeService {
    private NewsTypeDao newsTypeDao = new NewsTypeDaoImpl();
    @Override
    public List<NewsType> findAll() {
        return newsTypeDao.findAll() ;
    }
}
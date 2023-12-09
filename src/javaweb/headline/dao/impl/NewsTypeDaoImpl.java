package javaweb.headline.dao.impl;

import javaweb.headline.dao.BaseDao;
import javaweb.headline.dao.NewsTypeDao;
import javaweb.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeDaoImpl
 * Package: javaweb.headline.dao.impl
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:59 PM
 * @Version 1.0
 */
public class NewsTypeDaoImpl extends BaseDao implements NewsTypeDao {

    @Override
    public List<NewsType> findAll() {
        String sql = "select tid,tname from news_type;";

        return baseQuery(NewsType.class,sql);
    }
}

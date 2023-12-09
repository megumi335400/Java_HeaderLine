package javaweb.headline.dao;

import javaweb.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeDao
 * Package: javaweb.headline.dao
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:58 PM
 * @Version 1.0
 */
public interface NewsTypeDao {
    List<NewsType> findAll();
}

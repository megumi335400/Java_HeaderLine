package javaweb.headline.dao;

import javaweb.headline.pojo.NewsUser;

/**
 * ClassName: NewsUserDao
 * Package: javaweb.headline.dao
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:58 PM
 * @Version 1.0
 */
public interface NewsUserDao {
    NewsUser findByUsername(String username);

    NewsUser findByUid(Integer userId);

    Integer insertUser(NewsUser newsUser);
}

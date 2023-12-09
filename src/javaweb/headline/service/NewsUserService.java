package javaweb.headline.service;

import javaweb.headline.pojo.NewsUser;

/**
 * ClassName: NewsUserService
 * Package: javaweb.headline.service
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:01 PM
 * @Version 1.0
 */
public interface NewsUserService {
    NewsUser findByUsername(String username);

    NewsUser findByUid(Integer userId);

    Integer registUser(NewsUser newsUser);
}

package javaweb.headline.service.impl;

import javaweb.headline.dao.NewsUserDao;
import javaweb.headline.dao.impl.NewsUserDaoImpl;
import javaweb.headline.pojo.NewsUser;
import javaweb.headline.service.NewsUserService;
import javaweb.headline.util.MD5Util;

/**
 * ClassName: NewsUserServiceImpl
 * Package: javaweb.headline.service.impl
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:03 PM
 * @Version 1.0
 */
public class NewsUserServiceImpl implements NewsUserService {
    private NewsUserDao userDao = new NewsUserDaoImpl();
    @Override
    public NewsUser findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        return userDao.findByUid(userId);
    }

    @Override
    public Integer registUser(NewsUser newsUser) {
        newsUser.setUserPwd(MD5Util.encrypt(newsUser.getUserPwd()));
        return userDao.insertUser(newsUser);
    }
}

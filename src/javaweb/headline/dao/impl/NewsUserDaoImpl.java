package javaweb.headline.dao.impl;

import javaweb.headline.dao.BaseDao;
import javaweb.headline.dao.NewsUserDao;
import javaweb.headline.pojo.NewsUser;

import java.util.List;

/**
 * ClassName: NewsUserDaoImpl
 * Package: javaweb.headline.dao.impl
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:59 PM
 * @Version 1.0
 */
public class NewsUserDaoImpl extends BaseDao implements NewsUserDao {

    @Override
    public NewsUser findByUsername(String username) {
        String sql = "select uid,username,user_pwd userPwd,nick_name nickName from news_user where username=?";
        List<NewsUser> newsUserList =  baseQuery(NewsUser.class,sql,username);
        return newsUserList!=null && newsUserList.size()>0? newsUserList.get(0) : null;
    }

    @Override
    public NewsUser findByUid(Integer userId) {
        String sql = "select uid,username,user_pwd userPwd,nick_name nickName from news_user where uid=?";
        List<NewsUser> newsUserList =  baseQuery(NewsUser.class,sql,userId);
        return newsUserList!=null && newsUserList.size()>0? newsUserList.get(0) : null;
    }

    @Override
    public Integer insertUser(NewsUser newsUser) {
        String sql = "insert into news_user values (DEFAULT,?,?,?)";

        return baseUpdate(sql,newsUser.getUsername(),newsUser.getUserPwd(),newsUser.getNickName());
    }
}

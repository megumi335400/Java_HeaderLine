package javaweb.headline.dao;

import javaweb.headline.pojo.NewsHeadline;
import javaweb.headline.pojo.vo.HeadlineDetailVo;
import javaweb.headline.pojo.vo.HeadlinePageVo;
import javaweb.headline.pojo.vo.HeadlineQueryVo;

import java.util.List;

/**
 * ClassName: NewsHeadLineDao
 * Package: javaweb.headline.dao
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:58 PM
 * @Version 1.0
 */
public interface NewsHeadLineDao {
    List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo);

    Integer findPageCount(HeadlineQueryVo headlineQueryVo);

    int incrPageViews(Integer hid);

    HeadlineDetailVo findHeadlineDetail(Integer hid);

    int addHeadline(NewsHeadline newsHeadline);

    NewsHeadline findHeadlineByHid(Integer hid);

    int updateHeadline(NewsHeadline newsHeadline);

    int removeByHid(int hid);
}

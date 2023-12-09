package javaweb.headline.service;

import javaweb.headline.pojo.vo.HeadlineDetailVo;
import javaweb.headline.pojo.vo.HeadlineQueryVo;

import java.util.Map;

/**
 * ClassName: NewsHeadlineService
 * Package: javaweb.headline.service
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:00 PM
 * @Version 1.0
 */
public interface NewsHeadlineService {
    Map findPage(HeadlineQueryVo headlineQueryVo);

    HeadlineDetailVo findHeadlineDetail(Integer hid);
}

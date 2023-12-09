package javaweb.headline.service;

import javaweb.headline.pojo.NewsType;

import java.util.List;

/**
 * ClassName: NewsTypeService
 * Package: javaweb.headline.service
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 3:00 PM
 * @Version 1.0
 */
public interface NewsTypeService {
    List<NewsType> findAll();
}

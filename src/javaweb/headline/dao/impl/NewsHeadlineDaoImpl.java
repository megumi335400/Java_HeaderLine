package javaweb.headline.dao.impl;

import javaweb.headline.dao.BaseDao;
import javaweb.headline.dao.NewsHeadLineDao;
import javaweb.headline.pojo.vo.HeadlinePageVo;
import javaweb.headline.pojo.vo.HeadlineQueryVo;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName: NewsHeadlineDaoImpl
 * Package: javaweb.headline.dao.impl
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:59 PM
 * @Version 1.0
 */
public class NewsHeadlineDaoImpl extends BaseDao implements NewsHeadLineDao {

    @Override
    public List<HeadlinePageVo> findPageList(HeadlineQueryVo headlineQueryVo) {
        List params = new ArrayList();
        String sql  = """
                select 
                hid,title,type,page_views pageViews,
                TIMESTAMPDIFF(HOUR,create_time,now()) pastHours,
                publisher
                from news_headline
                where is_deleted =0
                """;
        if (headlineQueryVo.getType()!=0){
            sql = sql.concat(" and type =? ") ;
            params.add(headlineQueryVo.getType());
        }
        if (headlineQueryVo.getKeyWords()!=null &&!headlineQueryVo.getKeyWords().equals("")){
            sql = sql.concat(" and title like ? ");
            params.add("%"+headlineQueryVo.getKeyWords()+"%");
        }
        sql = sql.concat(" order by pastHours ASC, pageViews DESC ");
        sql = sql.concat(" limit ? , ? ");
        params.add((headlineQueryVo.getPageNum()-1)*headlineQueryVo.getPageSize());
        params.add(headlineQueryVo.getPageSize());
        return baseQuery(HeadlinePageVo.class,sql,params.toArray());
    }

    @Override
    public Integer findPageCount(HeadlineQueryVo headlineQueryVo) {
        List params = new ArrayList();
        String sql = """
                select 
                count(1)
                from news_headline
                where is_deleted =0
                """;
        if (headlineQueryVo.getType()!=0){
            sql = sql.concat(" and type =? ") ;
            params.add(headlineQueryVo.getType());
        }
        if (headlineQueryVo.getKeyWords()!=null &&!headlineQueryVo.getKeyWords().equals("")){
            sql = sql.concat(" and title like ? ");
            params.add("%"+headlineQueryVo.getKeyWords()+"%");
        }
        Long count = baseQueryObject(Long.class,sql,params.toArray());
        return count.intValue();
    }
}

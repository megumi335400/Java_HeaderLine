package javaweb.headline.pojo.vo;

/**
 * ClassName: HeadlineQueryVo
 * Package: javaweb.headline.pojo.vo
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:55 PM
 * @Version 1.0
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlineQueryVo implements Serializable {
    private String keyWords;
    private Integer type ;
    private Integer pageNum;
    private Integer pageSize;
}

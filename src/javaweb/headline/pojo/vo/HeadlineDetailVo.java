package javaweb.headline.pojo.vo;

/**
 * ClassName: HeadlineDetailVo
 * Package: javaweb.headline.pojo.vo
 * Description:
 *
 * @Author yzy
 * @Create 12/7/2023 2:56 PM
 * @Version 1.0
 */
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HeadlineDetailVo implements Serializable {
    private Integer hid;
    private String title;
    private String article;
    private Integer type;
    private String typeName;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;
    private String author;
}

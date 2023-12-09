package javaweb.headline.pojo.vo;

/**
 * ClassName: HeadlinePageVo
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
public class HeadlinePageVo implements Serializable {
    private Integer hid;
    private String title;
    private Integer type;
    private Integer pageViews;
    private Long pastHours;
    private Integer publisher;
}

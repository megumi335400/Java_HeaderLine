package javaweb.headline.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * ClassName: NewsType
 * Package: javaweb.headline.pojo
 * Description:
 *
 * @Author yzy
 * @Create 12/6/2023 7:50 PM
 * @Version 1.0
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class NewsType implements Serializable {
    private Integer tid;
    private String tname;
}

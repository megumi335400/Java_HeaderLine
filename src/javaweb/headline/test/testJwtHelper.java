package javaweb.headline.test;

import javaweb.headline.util.JwtHelper;
import org.testng.annotations.Test;

/**
 * ClassName: testJwtHelper
 * Package: javaweb.headline.test
 * Description:
 *
 * @Author yzy
 * @Create 12/8/2023 2:08 PM
 * @Version 1.0
 */
public class testJwtHelper {
    @Test
    public void  testAllMethod(){
        String token = JwtHelper.createToken(1L);
        System.out.println(token);

        Long userid = JwtHelper.getUserId(token);
        System.out.println(userid);
        System.out.println(JwtHelper.isExpiration(token));

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(JwtHelper.isExpiration(token));

    }


}

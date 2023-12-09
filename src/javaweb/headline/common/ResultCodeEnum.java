package javaweb.headline.common;

/**
 * ClassName: ResultCodeEnum
 * Package: javaweb.headline.common
 * Description:
 *
 * @Author yzy
 * @Create 12/6/2023 6:51 PM
 * @Version 1.0
 */
public enum ResultCodeEnum {

    SUCCESS(200,"success"),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed")
    ;

    private Integer code;
    private String message;
    private ResultCodeEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }
}
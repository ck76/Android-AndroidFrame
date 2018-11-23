package cn.ck.mvp.business.account.model.request;

/**
 * Created by ck on 2018/9/19.
 */
public class RegisteredRequestModel {

    /**
     * login_num : 123456
     * password : 123456
     * is_teacher : 1
     */

    private String login_num;
    private String password;
    private String is_teacher;

    public RegisteredRequestModel(String login_num, String password, String is_teacher) {
        this.login_num = login_num;
        this.password = password;
        this.is_teacher = is_teacher;
    }

    public String getLogin_num() {
        return login_num;
    }

    public void setLogin_num(String login_num) {
        this.login_num = login_num;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIs_teacher() {
        return is_teacher;
    }

    public void setIs_teacher(String is_teacher) {
        this.is_teacher = is_teacher;
    }
}

package cn.ck.mvp.business.account.model.request;

/**
 * Created by ck on 2018/9/19.
 */
public class LoginRequestModel {

    /**
     * login_num : 123456
     * password : 123456
     */

    private String login_num;
    private String password;

    public LoginRequestModel(String login_num, String password) {
        this.login_num = login_num;
        this.password = password;
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
}

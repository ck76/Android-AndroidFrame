package cn.ck.mvp.business.account.model.response;

/**
 * Created by ck on 2018/9/19.
 */
public class RegisteredResponseModel {
    /**
     * user_id : 5
     * token : bd1edbceea5742d278d352a0348b76c8
     */

    private int user_id;
    private String token;

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

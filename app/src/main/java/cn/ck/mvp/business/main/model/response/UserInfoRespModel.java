package cn.ck.mvp.business.main.model.response;

/**
 * Created by ck on 2018/10/15.
 */
public class UserInfoRespModel {
    /**
     * id : 1
     * login_num : 15076067012
     * name : user5ba4d003038ed
     * coin : 0
     * role : student
     */

    private int id;
    private String login_num;
    private String name;
    private int coin;
    private String role;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin_num() {
        return login_num;
    }

    public void setLogin_num(String login_num) {
        this.login_num = login_num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

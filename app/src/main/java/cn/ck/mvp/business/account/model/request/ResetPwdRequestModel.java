package cn.ck.mvp.business.account.model.request;

/**
 * Created by ck on 2018/9/26.
 */
public class ResetPwdRequestModel {
    /**
     * old_password : tang13673520794
     * new_password : tang13673520794
     */

    private String old_password;
    private String new_password;

    public String getOld_password() {
        return old_password;
    }

    public void setOld_password(String old_password) {
        this.old_password = old_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        this.new_password = new_password;
    }
}

package cn.ck.mvp.business.account.contract;

import cn.ck.mvp.base.mvp.impl.IBaseContract;
import cn.ck.mvp.business.account.model.request.LoginRequestModel;

/**
 * Created by ck on 2018/9/19.
 */
public interface LoginContract {

    interface Presenter extends IBaseContract.IBasePresenter {
        void login(LoginRequestModel loginRequestModel);
    }

    interface View extends IBaseContract.IBaseView{
        void onLoginSuccess(String s);
        void onLoginFaild();
    }
}

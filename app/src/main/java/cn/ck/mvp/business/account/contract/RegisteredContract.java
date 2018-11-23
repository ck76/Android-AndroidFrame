package cn.ck.mvp.business.account.contract;

import android.support.annotation.StringRes;

import cn.ck.mvp.base.mvp.impl.IBaseContract;

/**
 * Created by ck on 2018/9/19.
 */
public interface RegisteredContract {
    interface View extends IBaseContract.IBaseView {
        void onRegisteredSuccess(String s);

        void onRegisteredFailed(@StringRes int failedDetail);
    }

    interface Presenter extends IBaseContract.IBasePresenter {
        void registered(String account, String pwd, String confirmPwd);
    }
}

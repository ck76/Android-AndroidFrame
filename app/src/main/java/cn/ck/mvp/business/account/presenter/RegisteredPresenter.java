package cn.ck.mvp.business.account.presenter;

import android.text.TextUtils;

import cn.ck.mvp.R;
import cn.ck.mvp.base.mvp.impl.IDataCallback;
import cn.ck.mvp.base.mvp.presenter.BasePresenter;
import cn.ck.mvp.business.account.contract.RegisteredContract;
import cn.ck.mvp.business.account.model.helper.LoginHelper;
import cn.ck.mvp.business.account.model.request.RegisteredRequestModel;
import cn.ck.mvp.common.CacheKey;
import cn.ck.mvp.utils.CacheUtil;

/**
 * Created by ck on 2018/9/19.
 */
public class RegisteredPresenter extends BasePresenter<RegisteredContract.View> implements RegisteredContract.Presenter {
    public RegisteredPresenter(RegisteredContract.View view) {
        super(view);
    }

    @Override
    public void registered(String account, String pwd, String confirmPwd) {
        if (TextUtils.isEmpty(account)) {
            mView.onRegisteredFailed(R.string.toast_account_null);
            return;
        }
        if (account.length() < 6 || account.length() > 10) {
            mView.onRegisteredFailed(R.string.toast_account_num_error);
            return;
        }
        if (pwd.length() < 6 || pwd.length() > 20) {
            mView.onRegisteredFailed(R.string.toast_pwd_error);
            return;
        }

        if (!TextUtils.equals(pwd, confirmPwd)) {
            mView.onRegisteredFailed(R.string.toast_pwd_different_error);
            return;
        }

        IDataCallback.Callback<String> callback = new IDataCallback.Callback<String>() {
            @Override
            public void onOverLoaded() {

            }

            @Override
            public void onFailedLoaded() {
                if (mView != null) {
                    mView.onRegisteredFailed(R.string.register_error);
                }
            }

            @Override
            public void onSuccessLoaded(String s) {
                if (mView != null) {
                    //保存到文件
                    CacheUtil.put(CacheKey.TOKEN, s);
                    mView.onRegisteredSuccess(s);
                }
            }
        };
        RegisteredRequestModel registeredRequestModel = new RegisteredRequestModel(account, pwd, "-1");
        LoginHelper.getInstance().register(registeredRequestModel, callback);
    }
}

package cn.ck.mvp.business.account.presenter;

import cn.ck.mvp.base.mvp.impl.IDataCallback;
import cn.ck.mvp.base.mvp.presenter.BasePresenter;
import cn.ck.mvp.business.account.contract.LoginContract;
import cn.ck.mvp.business.account.model.helper.LoginHelper;
import cn.ck.mvp.business.account.model.request.LoginRequestModel;
import cn.ck.mvp.common.CacheKey;
import cn.ck.mvp.utils.CacheUtil;

/**
 * Created by ck on 2018/9/19.
 */
public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {
    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void login(LoginRequestModel loginRequestModel) {
        IDataCallback.Callback<String> callback=new IDataCallback.Callback<String>() {
            @Override
            public void onOverLoaded() {

            }

            @Override
            public void onFailedLoaded() {
                if (mView!=null) {
                    mView.onLoginFaild();
                }
            }

            @Override
            public void onSuccessLoaded(String s) {
                if (mView!=null) {
                    //保存到文件
                    CacheUtil.put(CacheKey.TOKEN,s);
                    mView.onLoginSuccess(s);
                }
            }
        };
        LoginHelper.getInstance().login(loginRequestModel,callback);
    }
}

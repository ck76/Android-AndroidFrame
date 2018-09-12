package cn.ck.androidframe;

import cn.ck.androidframe.base.contract.IBaseContract;

/**
 * Created by ck on 2018/9/13.
 */
public interface LoginContract extends IBaseContract {

    interface ILoginView{
        void onSuccess(String data);
    }

    interface ILoginPresenter{
        void login();
    }
}

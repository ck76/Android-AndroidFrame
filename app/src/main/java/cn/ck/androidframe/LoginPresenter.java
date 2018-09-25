package cn.ck.androidframe;

import java.util.List;

import cn.ck.androidframe.base.presenter.BasePresenter;
import cn.ck.androidframe.network.observer.HttpRxObserver;
import cn.ck.androidframe.test.Goods;
import cn.ck.androidframe.test.HttpPageResult;

/**
 * Created by ck on 2018/9/13.
 */
public class LoginPresenter extends BasePresenter<LoginContract.ILoginView,MainActivity> implements LoginContract.ILoginPresenter {
    public LoginPresenter(LoginContract.ILoginView view, MainActivity activity) {
        super(view, activity);
    }

    @Override
    public void login() {
//        Observer observer=new Observer<String>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(String s) {
//            getView().onSuccess(s);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Toast.makeText(getActivity(),"ck",Toast.LENGTH_LONG).show();
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        };

       /* HttpRxObserver<String> httpRxObserver=new HttpRxObserver<String>() {
            @Override
            public void onSuccess(String s) {

            }

            @Override
            public void onError(String msg) {
                getView().onSuccess(msg);
            }
        };
         new LoginModel().login(getActivity(),httpRxObserver);*/

       HttpRxObserver<HttpPageResult<List<Goods>>> httpPageResultHttpRxObserver=new HttpRxObserver<HttpPageResult<List<Goods>>>() {
           @Override
           public void onSuccess(HttpPageResult<List<Goods>> listHttpPageResult) {
               getView().onSuccess("ckaaaa~~~~");
           }

           @Override
           public void onError(String msg) {

           }
       };

        new LoginModel().login(getActivity(),httpPageResultHttpRxObserver);
    }
}

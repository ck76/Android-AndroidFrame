package cn.ck.androidframe;

import com.trello.rxlifecycle2.LifecycleProvider;

import cn.ck.androidframe.base.model.HttpResult;
import cn.ck.androidframe.network.ApiUtil;
import cn.ck.androidframe.network.function.HttpResultFunction;
import cn.ck.androidframe.network.function.ServerResultFunction;
import cn.ck.androidframe.utils.RxJavaUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by ck on 2018/9/13.
 */
public class LoginModel {


    public void login(MainActivity activity,Observer<String> observer){
        ApiUtil.getLoginAPI().login()
                .compose(activity.<HttpResult<String>>bindToLifecycle())
                .compose(RxJavaUtil.<HttpResult<String>>toMain())
                .map(new ServerResultFunction<String>())
                .subscribe(observer);


    }
}

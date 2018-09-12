package cn.ck.androidframe.network.observer;

import android.util.Log;

import cn.ck.androidframe.network.exception.ApiException;
import cn.ck.androidframe.network.exception.ExceptionEngine;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

/**
 * //TODO Observer基类
 * Created by ck on 2018/9/13.
 */
public abstract class HttpRxObserver <T> implements Observer<T> {

    public abstract void onSuccess(T t);

    public abstract void onError(String msg);


    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(T t) {
    onSuccess(t);
    }

    @Override
    public void onError(Throwable e) {
        String msg=ExceptionEngine.handleException(e).getMsg();
        onError(msg);

    }

    @Override
    public void onComplete() {

    }
}

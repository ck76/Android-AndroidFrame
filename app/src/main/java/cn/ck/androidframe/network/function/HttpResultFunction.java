package cn.ck.androidframe.network.function;

import cn.ck.androidframe.network.exception.ExceptionEngine;
import cn.ck.androidframe.utils.LogUtil;

import io.reactivex.Observable;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;

/**
 * TODO 为完成
 * Http错误/异常处理
 * Created by ck
 */

public class HttpResultFunction<T> implements Function<Throwable, Observable<T>> {
    private static final String TAG = "HttpResultFunction";
    @Override
    public Observable<T> apply(@NonNull Throwable throwable) throws Exception {
        LogUtil.d(TAG, TAG + " " + throwable.toString());
        return Observable.error(ExceptionEngine.handleException(throwable));
    }
}

package cn.ck.mvp.network.response;

import cn.ck.mvp.network.exception.ExceptionEngine;
import cn.ck.mvp.utils.ToastUtil;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * @author chengkun
 * @since 2018/11/24 03:16
 */
public abstract class BaseObserver<T> implements Observer<ApiResponse<T>> {

    protected abstract void onDataBack(ApiResponse<T> responseBody);

    protected abstract void onError(int code, String msg);

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(ApiResponse<T> tApiResponse) {
        onDataBack(tApiResponse);
    }

    @Override
    public void onError(Throwable e) {
        onError(ExceptionEngine.handleException(e).getCode(), ExceptionEngine.handleException(e).getMsg());
        ToastUtil.showToast(ExceptionEngine.handleException(e).getMsg());
    }

    @Override
    public void onComplete() {

    }
}

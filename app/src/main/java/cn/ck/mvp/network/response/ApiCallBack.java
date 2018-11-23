package cn.ck.mvp.network.response;

import android.support.annotation.NonNull;

import cn.ck.mvp.network.exception.ExceptionEngine;
import cn.ck.mvp.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author chengkun
 * @since 2018/11/24 01:03
 */
public abstract class ApiCallBack<T> implements Callback<ApiResponse<T>> {

    protected ApiCallBack() {
    }

    protected abstract void onDataBack(ApiResponse<T> responseBody);

    protected abstract void onError(int code, String msg);

    @Override
    public void onResponse(@NonNull Call<ApiResponse<T>> call, @NonNull Response<ApiResponse<T>> response) {
        if (response.body() != null) {
            onDataBack(response.body());
        }
    }

    @Override
    public void onFailure(@NonNull Call call, Throwable t) {
        onError(ExceptionEngine.handleException(t).getCode(), ExceptionEngine.handleException(t).getMsg());
        ToastUtil.showToast(ExceptionEngine.handleException(t).getMsg());
    }
}

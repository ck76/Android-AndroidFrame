package cn.ck.androidframe.base;

/**
 * P层通过接口与M层交互
 *
 * Created by ck on 2018/9/12 22:50.
 */


public interface IDataCallback {

    /**
     * 数据加载失败和成功都关注
     *
     * @param <T> 返回数据类型
     */
    interface Callback<T> extends SuccessCallback<T>, FailedCallback {
    }

    /**
     * 只关注数据加载成功的接口
     *
     * @param <T>
     */
    interface SuccessCallback<T>  {
        void onDataLoaded(T t);
    }

    /**
     * 只关注数据加载失败的接口
     */
    interface FailedCallback  {
        void onFailedLoaded(String error);
    }
}

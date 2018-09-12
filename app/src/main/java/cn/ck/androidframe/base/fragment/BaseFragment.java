package cn.ck.androidframe.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trello.rxlifecycle2.components.RxFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.ck.androidframe.listener.ActivityLifeCycleListener;

/**
 * Created by ck on 2018/9/13.
 */
public abstract class BaseFragment extends RxFragment {

    protected final String TAG = getClass().getSimpleName();
    protected Unbinder unbinder;
    protected ActivityLifeCycleListener activityLifeCycleListener;
    protected Context context;
    protected Activity activity;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutId(), container, false);
        initConfig(savedInstanceState);

        Bundle arguments = getArguments();
        initArguments(arguments);

        context = getContext();

        unbinder = ButterKnife.bind(this, view);

        return view;
    }

    /**
     * 设置生命周期监听
     * @param lifecycleListener
     */
    public void setOnLifeCycleListener(ActivityLifeCycleListener lifecycleListener) {
        this.activityLifeCycleListener = lifecycleListener;
    }


    /**
     * 初始化Activity配置,
     */
    protected abstract void initConfig(Bundle savedInstanceState);

    /**
     * 初始化Bundle参数
     *
     * @param arguments
     */
    protected abstract void initArguments(Bundle arguments);

    /**
     * 获取 xml layout
     */
    protected abstract int setLayoutId();

    /**
     * 业务逻辑代码
     */
    protected abstract void doBusiness();

    /**
     * 页面跳转
     *
     * @param clazz
     */
    public void startActivity(Class<?> clazz) {
        Intent intent = new Intent(context, clazz);
        startActivity(intent);
    }

    /**
     * 页面携带数据跳转
     *
     * @param clazz
     * @param bundle
     */
    public void startActivity(Class<?> clazz, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 包含回调的页面跳转
     *
     * @param clazz
     * @param requestCode
     */
    public void startActivityForResult(Class<?> clazz, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(context, clazz);
        startActivityForResult(intent, requestCode);
    }

    /**
     * 包含回调和数据的页面跳转
     *
     * @param clazz
     * @param bundle
     * @param requestCode
     */
    public void startActivityForResult(Class<?> clazz, Bundle bundle, int requestCode) {
        Intent intent = new Intent();
        intent.setClass(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }

    /**
     * 包含回调和数据的页面跳转
     *
     * @param clazz
     * @param bundle
     * @param requestCode
     */
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public void startActivityForResult(Class<?> clazz, int requestCode, Bundle bundle, Bundle options) {
        Intent intent = new Intent();
        intent.setClass(context, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode, options);
    }

}

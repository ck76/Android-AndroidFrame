package cn.ck.androidframe.base.presenter;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import cn.ck.androidframe.base.activity.BaseActivity;

import cn.ck.androidframe.base.fragment.BaseFragment;
import cn.ck.androidframe.listener.ActivityLifeCycleListener;

/**
 * Created by ck on 2018/9/12.
 */
public class BasePresenter <V,T> implements ActivityLifeCycleListener {

    protected final String TAG = getClass().getSimpleName();

    protected Reference<V> viewRef;
    protected V view;
    protected Reference<T> activityRef;
    protected T activity;

    public BasePresenter (V view ,T activity) {
        attachView(view);
        attachActivity(activity);
        setListener(activity);

    }

    /**
     * 设置生命周期监听
     *
     * @param activity
     */
    private void setListener(T activity) {
        if (getActivity() != null) {
            if (view instanceof BaseActivity) {
                ((BaseActivity) getActivity()).setOnLifeCycleListener(this);
            } else if (view instanceof BaseFragment) {
                ((BaseFragment) getActivity()).setOnLifeCycleListener(this);
            }
        }
    }

    /**
     * 绑定View
     *
     * @param view
     */
    private void attachView(V view) {
        viewRef = new WeakReference<V>(view);
        this.view = viewRef.get();
    }

    /**
     * 绑定Activity
     *
     * @param activity
     */
    private void attachActivity(T activity) {
        activityRef = new WeakReference<T>(activity);
        this.activity = activityRef.get();
    }

    /**
     * 解除View绑定
     */
    private void detachView() {
        if (isViewAttached()) {
            viewRef.clear();
            viewRef = null;
        }
    }

    /**
     * 解除Activity绑定
     */
    private void detachActivity() {
        if (isActivityAttached()) {
            activityRef.clear();
            activityRef = null;
        }
    }

    /**
     * 获取View
     *
     * @return
     */
    public V getView() {
        if (viewRef == null) {
            return null;
        }
        return viewRef.get();
    }

    /**
     * 获取Activity
     *
     * @return
     */
    public T getActivity() {
        if (activityRef == null) {
            return null;
        }
        return activityRef.get();
    }

    /**
     * 判断是否已经绑定View
     *
     * @return
     */
    public boolean isViewAttached() {
        return viewRef != null && viewRef.get() != null;
    }

    /**
     * 判定是否已经绑定Activity
     *
     * @return
     */
    public boolean isActivityAttached() {
        return activityRef != null && activityRef.get() != null;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onRestart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {
        if (activity instanceof BaseActivity) {
            detachView();
            detachActivity();
        }

    }

    @Override
    public void onAttach(Activity activity) {

    }

    @Override
    public void onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle bundle) {

    }

    @Override
    public void onActivityCreated(Bundle bundle) {

    }

    @Override
    public void onDestroyView() {

    }

    @Override
    public void onDetach() {

    }
}

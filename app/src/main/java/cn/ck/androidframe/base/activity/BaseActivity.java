package cn.ck.androidframe.base.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.ck.androidframe.listener.ActivityLifeCycleListener;
import cn.ck.androidframe.manager.ActivityStackManager;
import cn.ck.androidframe.utils.LogUtil;

/**
 * * 基类Activity
 * 备注:所有的Activity都继承自此Activity
 *
 * Created by ck on 2018/9/12 22:58.
 */

public abstract class BaseActivity extends RxAppCompatActivity {


    protected final String TAG = getClass().getSimpleName();
    protected Context context;
    protected Unbinder unbinder;
    protected ActivityLifeCycleListener lifecycleListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.d(TAG, TAG + "-->onCreate()");
        if (lifecycleListener != null) {
            lifecycleListener.onCreate(savedInstanceState);
        }
        ActivityStackManager.getManager().push(this);
        setContentView(setLayoutId());
        context=this;
        unbinder= ButterKnife.bind(this);
        Bundle bundle = getIntent().getExtras();
        initBundleData(bundle);
        doBusiness();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtil.d(TAG, TAG + "-->onRestart()");
        if (lifecycleListener != null) {
            lifecycleListener.onRestart();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtil.d(TAG, TAG + "-->onStart()");
        if (lifecycleListener != null) {
            lifecycleListener.onStart();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtil.d(TAG, TAG + "-->onResume()");
        if (lifecycleListener != null) {
            lifecycleListener.onResume();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtil.d(TAG, TAG + "-->onPause()");
        if (lifecycleListener != null) {
            lifecycleListener.onPause();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtil.d(TAG, TAG + "-->onStop()");
        if (lifecycleListener != null) {
            lifecycleListener.onStop();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, TAG + "-->onDestroy()");
        ActivityStackManager.getManager().remove(this);
        if (lifecycleListener != null) {
            lifecycleListener.onDestroy();
        }
        if (unbinder != null) {
            unbinder.unbind();
        }
    }



    /**
     * 初始化Bundle参数
     *
     * @param bundle
     */
    protected abstract void initBundleData(Bundle bundle);

    /**
     * 获取 xml layout
     */
    protected abstract int setLayoutId();

    /**
     * 业务逻辑代码
     */
    protected abstract void doBusiness();

    /**
     * 设置生命周期监听
     *
     * @param lifecycleListener
     */
    public void setOnLifeCycleListener(ActivityLifeCycleListener lifecycleListener) {
        this.lifecycleListener = lifecycleListener;
    }

    /**
     * 页面跳转
     *
     * @param clazz
     */
    public void startActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
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
        intent.setClass(this, clazz);
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
        intent.setClass(this, clazz);
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
        intent.setClass(this, clazz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivityForResult(intent, requestCode);
    }
}

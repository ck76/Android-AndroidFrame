package cn.ck.mvp.business.courses.view.activity;

import android.os.Bundle;

import cn.ck.mvp.R;
import cn.ck.mvp.base.annotation.ContentView;
import cn.ck.mvp.base.mvp.view.BasePresenterActivity;
import cn.ck.mvp.business.courses.contract.CourseMainContract;
import cn.ck.mvp.business.courses.presenter.CourseMainPresenter;

@ContentView(R.layout.activity_course__mian)
public class CourseMainActivity extends BasePresenterActivity<CourseMainPresenter> implements CourseMainContract.View {

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);


    }

    @Override
    protected CourseMainPresenter getPresenter() {
        return new CourseMainPresenter(this);
    }


    @Override
    public void showLoading() {

    }

    @Override
    public void closeLoading() {

    }

    @Override
    public void showMessage(String msg) {

    }
}


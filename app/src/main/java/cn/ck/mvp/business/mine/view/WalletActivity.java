package cn.ck.mvp.business.mine.view;

import android.os.Bundle;

import cn.ck.mvp.R;
import cn.ck.mvp.base.annotation.ContentView;
import cn.ck.mvp.base.mvp.impl.IBaseContract;
import cn.ck.mvp.base.mvp.view.BasePresenterActivity;


@ContentView(R.layout.activity_vallet)

public class WalletActivity extends BasePresenterActivity {

    @Override
    protected void initData(Bundle savedInstanceState) {
    }

    @Override
    protected void initView() {
    }

    @Override
    protected IBaseContract.IBasePresenter getPresenter() {
        return null;
    }

}

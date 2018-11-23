package cn.ck.mvp.business.account.view;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import butterknife.BindView;
import butterknife.OnClick;
import cn.ck.mvp.R;
import cn.ck.mvp.base.annotation.ContentView;
import cn.ck.mvp.base.mvp.view.BasePresenterActivity;
import cn.ck.mvp.business.account.contract.RegisteredContract;
import cn.ck.mvp.business.account.presenter.RegisteredPresenter;
import cn.ck.mvp.utils.ToastUtil;

@ContentView(R.layout.activity_registered)
public class RegisteredActivity extends BasePresenterActivity<RegisteredContract.Presenter> implements RegisteredContract.View {

    @BindView(R.id.edt_name)
    EditText edtName;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.edt_once_pwd)
    EditText edtOncePwd;
    @BindView(R.id.btn_register)
    Button btnRegister;

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);
        setLayoutNoLimits(true);


    }

    @Override
    protected RegisteredContract.Presenter getPresenter() {
        return new RegisteredPresenter(this);
    }

    /**
     * 注册成功失败回调
     *
     * @param s
     */
    @Override
    public void onRegisteredSuccess(String s) {
        dismissProgressDialog();
        ToastUtil.showToast("注册成功！");
        startActivity(LoginActivity.class);
        finish();
    }

    @Override
    public void onRegisteredFailed(int errorId) {
        dismissProgressDialog();
        ToastUtil.showToast(errorId);
    }

    @Override
    public void showProgressDialog() {
        super.showProgressDialog();
    }

    @OnClick({R.id.btn_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_register:
                showProgressDialog();
                String account = edtName.getText().toString();
                String password = edtPwd.getText().toString();
                String confirmPwd = edtOncePwd.getText().toString().trim();
                mPresenter.registered(account, password, confirmPwd);
                break;
            default:
        }
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

package cn.ck.mvp.business.account.view;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.ck.mvp.R;
import cn.ck.mvp.base.annotation.ContentView;
import cn.ck.mvp.base.mvp.view.BasePresenterActivity;
import cn.ck.mvp.business.account.contract.LoginContract;
import cn.ck.mvp.business.account.model.request.LoginRequestModel;
import cn.ck.mvp.business.account.presenter.LoginPresenter;
import cn.ck.mvp.business.main.view.MainActivity;
import cn.ck.mvp.common.CacheKey;
import cn.ck.mvp.utils.CacheUtil;
import cn.ck.mvp.utils.ToastUtil;

@ContentView(R.layout.activity_login)
public class LoginActivity extends BasePresenterActivity<LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.edt_account)
    EditText edtAccount;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.tv_new_user)
    TextView tvNewUser;

    Context context=this;

    private String updateUrl="https://www.baidu.com";//放最新版本APK

    @Override
    protected void initData(Bundle savedInstanceState) {

    }

    @Override
    protected void initView() {
        setImmersiveStatusBar(true);
        setLayoutNoLimits(true);



        /**
         * 验证token是否为空，开启服务器取消注释
         */
        String token= CacheUtil.getSP().getString(CacheKey.TOKEN,"");
        if (!"".equals(token)){
            startActivity(MainActivity.class);
            finish();
        }
    }

    @Override
    protected LoginContract.Presenter getPresenter() {
        return new LoginPresenter(this);
    }

    /**
     * 登录成功与失败回调
     */
    @Override
    public void onLoginSuccess(String s) {
        dismissProgressDialog();
        ToastUtil.showToast("登陆成功！");
        startActivity(MainActivity.class);
        finish();
    }

    @Override
    public void onLoginFaild() {
        dismissProgressDialog();
        ToastUtil.showToast("登录失败！");

    }


    @Override
    public void showProgressDialog() {
        super.showProgressDialog();
    }

    @OnClick({R.id.edt_account, R.id.edt_pwd, R.id.btn_login, R.id.tv_forget_pwd, R.id.tv_new_user})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                String userName=edtAccount.getText().toString();
                String password=edtPwd.getText().toString();
                showProgressDialog();
                mPresenter.login(new LoginRequestModel(userName,password));
                //startActivity(MainActivity.class);
                break;
            case R.id.tv_forget_pwd:

                break;
            case R.id.tv_new_user:
                startActivity(RegisteredActivity.class);
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

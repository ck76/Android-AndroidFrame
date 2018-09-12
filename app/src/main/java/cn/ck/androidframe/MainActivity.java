package cn.ck.androidframe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.ck.androidframe.base.activity.BaseActivity;

public class MainActivity extends BaseActivity implements LoginContract.ILoginView{

    @BindView(R.id.login)
    TextView login;

    private LoginPresenter loginPresenter;
    @Override
    protected void initBundleData(Bundle bundle) {

    }

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void doBusiness() {
        loginPresenter=new LoginPresenter(this,this);

    }

    @OnClick(R.id.login)
    public void onViewClicked(View view) {
        switch (view.getId()){
            case R.id.login:
                loginPresenter.login();
                break;
                default:

        }

    }

    @Override
    public void onSuccess(String data) {
        login.setText(data);
    }
}

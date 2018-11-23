package cn.ck.mvp.business.mine;


import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.ck.mvp.R;
import cn.ck.mvp.base.fragment.BaseFragment;
import cn.ck.mvp.business.account.view.LoginActivity;
import cn.ck.mvp.business.mine.view.WalletActivity;
import cn.ck.mvp.common.CacheKey;
import cn.ck.mvp.utils.CacheUtil;
import cn.ck.mvp.utils.CommonDialog;
import cn.ck.mvp.utils.ToastUtil;
import de.hdodenhof.circleimageview.CircleImageView;

public class MineFragment extends BaseFragment {

    @BindView(R.id.tv_wallet)
    TextView tvWallet;
    @BindView(R.id.tv_change_pwd)
    TextView tvChangePwd;
    @BindView(R.id.tv_settings)
    TextView tvSettings;
    @BindView(R.id.tv_collection)
    TextView tvCollection;
    @BindView(R.id.tv_myinfo)
    TextView tvMyinfo;
    @BindView(R.id.img_avatar)
    CircleImageView imgAvatar;
    @BindView(R.id.tv_logout)
    TextView tvLogout;


    @Override
    protected int getLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }

    @OnClick({R.id.tv_wallet, R.id.tv_change_pwd, R.id.tv_settings, R.id.tv_collection, R.id.tv_myinfo, R.id.tv_logout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_wallet:
                Intent intent = new Intent(getActivity(), WalletActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_change_pwd:
            case R.id.tv_settings:
            case R.id.tv_collection:
            case R.id.tv_myinfo:
                ToastUtil.showToast("敬请期待");
                break;
            case R.id.tv_logout:
                final CommonDialog commonDialog = new CommonDialog(getContext());
                commonDialog.setMessage("确认退出？")
                        .setPositiveButton("确认", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                CacheUtil.put(CacheKey.TOKEN, "");
                                Intent intent2 = new Intent(getActivity(), LoginActivity.class);
                                startActivity(intent2);
                                getActivity().finish();
                                commonDialog.dismiss();
                            }
                        }).
                        setNegativeButton("取消", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                commonDialog.dismiss();
                            }
                        }).show();
                break;
            default:
        }
    }

}

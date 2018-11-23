package cn.ck.mvp.business.main.view;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import com.next.easynavigition.view.EasyNavigitionBar;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.PermissionListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.ck.mvp.App;
import cn.ck.mvp.R;
import cn.ck.mvp.base.annotation.ContentView;
import cn.ck.mvp.base.mvp.view.BasePresenterActivity;
import cn.ck.mvp.business.courses.CourseFragment;
import cn.ck.mvp.business.main.contract.IMainContract;
import cn.ck.mvp.business.main.presenter.MainPresenter;
import cn.ck.mvp.business.main.view.fragment.MainFragment;
import cn.ck.mvp.business.mine.MineFragment;
import cn.ck.mvp.business.notes.NoteFragment;

/**
 * @author FanHongyu.
 * @since 18/5/31 20:01.
 * email fanhongyu@hrsoft.net.
 */
@ContentView(R.layout.activity_main)
public class MainActivity extends BasePresenterActivity<MainPresenter> implements IMainContract.View {

    @BindView(R.id.vp_main)
    ViewPager vpMain;
    @BindView(R.id.navigitionBar)
    EasyNavigitionBar navigitionBar;

    private String[] tabText = {"首页", "课程", "笔记", "我的"};
    private List<Fragment> fragments = new ArrayList<>();

    private int[] normalIcons = {R.drawable.ic_main_normal, R.drawable.ic_course_normal,
            R.drawable.ic_note_normal, R.drawable.ic_mine_normal};
    private int[] selectIcons = {R.drawable.ic_main_selected, R.drawable.ic_course_selected,
            R.drawable.ic_note_selected, R.drawable.ic_mine_selected};

    @Override
    protected void initData(Bundle savedInstanceState) {
        checkPermission();

        fragments.add(new MainFragment());
        fragments.add(new CourseFragment());
        fragments.add(new NoteFragment());
        fragments.add(new MineFragment());
    }

    @Override
    protected void initView() {
        navigitionBar.titleItems(tabText)
                .normalIconItems(normalIcons)
                .selectIconItems(selectIcons)
                .iconSize(27)
                .tabTextSize(12)
                .tabTextTop(2)
                .fragmentList(fragments)
                .fragmentManager(getSupportFragmentManager())
                .build();

    }

    @Override
    protected MainPresenter getPresenter() {
        return new MainPresenter(this);
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

    @Override
    public void onBackPressed() {
        App.getInstance().exitAppWithTwiceClick();
    }

    /**
     * 权限申请
     */
    public void checkPermission() {
        String[] permissions = new String[]{
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
        };
        AndPermission
                .with(MainActivity.this)
                .requestCode(200)
                .permission(permissions)
                .callback(new PermissionListener() {
                    @Override
                    public void onSucceed(int requestCode, @NonNull List<String> grantPermissions) {
                        Log.d("ck", "成功");
                    }

                    @Override
                    public void onFailed(int requestCode, @NonNull List<String> deniedPermissions) {
                        Log.d("ck", "失败");
                    }
                })
                .start();
    }
}

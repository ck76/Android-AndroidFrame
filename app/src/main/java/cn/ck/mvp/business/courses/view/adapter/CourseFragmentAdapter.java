package cn.ck.mvp.business.courses.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.ck.mvp.business.courses.view.fragment.DirectoryFragment;
import cn.ck.mvp.business.courses.view.fragment.IntroductiFragment;
import cn.ck.mvp.business.courses.view.fragment.EvaluatFragment;

/**
 * //TODO Fragment里的界面基本上画好了，根据返回的数据类型再进行更改。。。
 * Created by ck on 2018/9/20.
 */
public class CourseFragmentAdapter extends FragmentPagerAdapter {

    private IntroductiFragment mainFragment;
    private DirectoryFragment courseFragment;
    private EvaluatFragment noteFragment;

    List<String> titiles;


    public CourseFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    public CourseFragmentAdapter(FragmentManager fm, List<String> titiles) {
        super(fm);
        this.titiles = titiles;
        mainFragment=new IntroductiFragment();
        courseFragment=new DirectoryFragment();
        noteFragment=new EvaluatFragment();
    }

    @Override
    public Fragment getItem(int position) {

        Fragment fragment = null;
        switch (position) {
            //注意数字问题，要不然会崩。。。
            case 0:fragment=mainFragment;
                break;
            case 1:fragment=courseFragment;
                break;
            case 2:fragment=noteFragment;
                break;
            default:
        }
        return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titiles.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}

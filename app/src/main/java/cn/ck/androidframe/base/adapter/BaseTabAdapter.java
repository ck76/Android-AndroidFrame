package cn.ck.androidframe.base.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

import cn.ck.androidframe.utils.ListUtils;

/**TabLayout with ViewPager 通用适配器
 *
 * Created by ck on 2018/9/13 0:44.
 */


public class BaseTabAdapter extends FragmentPagerAdapter {
    private List<String> titleList;
    private List<Fragment> fragmentList;

    public BaseTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public BaseTabAdapter(FragmentManager fm, List<Fragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public BaseTabAdapter(FragmentManager fm, List<String> titleList, List<Fragment> fragmentList) {
        super(fm);
        this.titleList = titleList;
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList == null? 0 : fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return ListUtils.isEmpty(titleList) ? super.getPageTitle(position) : titleList.get(position);
    }
}

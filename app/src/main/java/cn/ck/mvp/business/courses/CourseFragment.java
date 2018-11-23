package cn.ck.mvp.business.courses;

import cn.ck.mvp.R;
import cn.ck.mvp.base.fragment.BaseFragment;

public class CourseFragment extends BaseFragment {

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_course;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        getCourseList();
    }


    public void getCourseList() {


    }

}

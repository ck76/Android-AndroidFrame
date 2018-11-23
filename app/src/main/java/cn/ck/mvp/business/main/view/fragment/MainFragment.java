package cn.ck.mvp.business.main.view.fragment;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.ck.mvp.R;
import cn.ck.mvp.base.fragment.BaseFragment;
import cn.ck.mvp.business.main.view.wedget.GlideImageLoader;
import cn.ck.mvp.utils.ToastUtil;

public class MainFragment extends BaseFragment {

    List<Integer> images = new ArrayList<Integer>();
    @BindView(R.id.banner)
    Banner banner;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_main;
    }


    @Override
    protected void initView() {
        initBanner();
    }

    @Override
    protected void initData() {

    }


    /**
     * 初始化banner
     */
    public void initBanner() {
        images.add(R.drawable.img_banner_gakki);
        images.add(R.drawable.img_banner_aoiyu);
        images.add(R.drawable.img_banner_emitakei);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //设置资源
        banner.setImages(images);
        banner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                ToastUtil.showToast("点击了第" + position + "个ck~");
            }
        });
        //设置banner动画效果
        banner.setBannerAnimation(Transformer.DepthPage);
        //设置自动轮播，默认为true
        banner.isAutoPlay(true);
        //设置轮播时间
        banner.setDelayTime(1500);
        //设置指示器位置（当banner模式中有指示器时）
        banner.setIndicatorGravity(BannerConfig.CENTER);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

}

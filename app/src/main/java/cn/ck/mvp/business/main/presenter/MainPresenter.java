package cn.ck.mvp.business.main.presenter;

import cn.ck.mvp.base.mvp.presenter.BasePresenter;
import cn.ck.mvp.business.main.contract.IMainContract;

/**
 * @author fhyPayaso
 * @since 2018/7/28 on 上午9:36
 * fhyPayaso@qq.com
 */
public class MainPresenter extends BasePresenter<IMainContract.View> implements IMainContract.Presenter{

    public MainPresenter(IMainContract.View view) {
        super(view);
    }


}

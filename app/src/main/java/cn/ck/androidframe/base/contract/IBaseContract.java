package cn.ck.androidframe.base.contract;

/**
 * 基础契约类
 *
 * Created by ck on 2018/9/12.
 */
public interface IBaseContract {

    interface IBaseView {

        void showLoading();

        void closeLoading();

        void showMessage(String msg);

    }

}

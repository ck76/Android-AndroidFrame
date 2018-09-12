package cn.ck.androidframe.utils;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ck on 2018/8/29.
 */
public class RxJavaUtil {

    public static <T> ObservableTransformer<T, T> toMain() {

        return new ObservableTransformer<T, T>() {

            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

}

//observable =apiObservable
//        .map(new ServerResultFunction())
//        .compose(lifecycle.bindToLifecycle())//需要在这个位置添加
//        .onErrorResumeNext(new HttpResultFunction<>())
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread());
//两个compose一个map。compose先LifeCycle后线程
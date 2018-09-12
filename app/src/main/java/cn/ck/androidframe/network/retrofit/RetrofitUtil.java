package cn.ck.androidframe.network.retrofit;

import android.support.annotation.NonNull;

import java.util.concurrent.TimeUnit;

import cn.ck.androidframe.common.Constans;
import cn.ck.androidframe.utils.LogUtil;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ck on 2018/9/13.
 */
public class RetrofitUtil {

    private static final String TAG = "RetrofitUtils";

    public static String BASE_URL = Constans.API_BASE_URL;
    public static final int CONNECT_TIME_OUT = 10;//连接超时时长x秒
    public static final int READ_TIME_OUT = 10;//读数据超时时长x秒
    public static final int WRITE_TIME_OUT = 10;//写数据接超时时长x秒
    private volatile static RetrofitUtil instance;

    private RetrofitUtil() {
    }

    public static RetrofitUtil getInstance() {
        if (instance == null) {
            synchronized (RetrofitUtil.class) {
                if (instance == null) {
                    instance = new RetrofitUtil();
                }
            }
        }
        return instance;
    }

    /**
     * 配置OkHttp
     *
     * @return OkHttpClient
     */
    private static OkHttpClient okHttpClient() {
//
//        // log用拦截器
//        HttpLoggingInterceptor loggingInterceptor= new HttpLoggingInterceptor();
//        // 开发模式记录整个body，否则只记录基本信息如返回200，http协议版本等
//        if (BuildConfig.DEBUG) {
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        } else {
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//        }

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                LogUtil.d(TAG, "okHttp：" + message+"\n----------------------------------");

            }
        });
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                .connectTimeout(CONNECT_TIME_OUT, TimeUnit.SECONDS)
                .writeTimeout(WRITE_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(READ_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build();
    }

    /**
     * 获取Retrofit
     *
     * @return Retrofit
     */
    public Retrofit retrofit() {
        return new Retrofit.Builder()
                .client(okHttpClient())
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}

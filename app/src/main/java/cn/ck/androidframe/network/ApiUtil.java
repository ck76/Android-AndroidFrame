package cn.ck.androidframe.network;

import cn.ck.androidframe.network.api.LoginApi;
import cn.ck.androidframe.network.retrofit.RetrofitUtil;
import retrofit2.Retrofit;

/**
 * Created by ck on 2018/9/13.
 */
public class ApiUtil {

    private static Retrofit retrofit = RetrofitUtil.getInstance().retrofit();

    private static LoginApi loginApi;


    public static LoginApi getLoginAPI() {

        if (loginApi == null) {
            loginApi = retrofit.create(LoginApi.class);
        }
        return loginApi;
    }

}

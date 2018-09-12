package cn.ck.androidframe.network.api;

import cn.ck.androidframe.base.model.HttpResult;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ck on 2018/9/13.
 */
public interface LoginApi {

    @GET("master/staticAPI/TEST/login.json")
    Observable<HttpResult<String>> login();
}

package cn.ck.androidframe.network.api;

import java.util.List;

import cn.ck.androidframe.base.model.HttpResult;
import cn.ck.androidframe.test.Goods;
import cn.ck.androidframe.test.HttpPageResult;
import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by ck on 2018/9/13.
 */
public interface LoginApi {

    @GET("master/staticAPI/TEST/login.json")
    Observable<HttpResult<String>> login();

    /**
     * 获取商品
     *
     * @return
     */
    @GET("master/staticAPI/getGoodsNew.json")
    Observable<HttpPageResult<List<Goods>>> getGoodsList();
}

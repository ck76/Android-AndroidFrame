package cn.ck.androidframe.network.function;

import cn.ck.androidframe.base.model.HttpResult;
import cn.ck.androidframe.network.exception.ServerException;
import io.reactivex.functions.Function;

/**
 * Created by ck on 2018/9/1.
 */
//public class ServerResultFunction<T> implements Function<HttpResult<T>, HttpResult<T>> {
//
//
//    @Override
//    public HttpResult<T> apply(HttpResult<T> response) throws Exception {
//        //打印服务器回传结果
//        //遍历正确码
//        if (response.getCode()!=200) {
//            throw new ServerException(response.getCode(), response.getMsg());
//        }
//        return response;
//    }
//}
public class ServerResultFunction<T> implements Function<HttpResult<T>, T>  {


    @Override
    public T apply(HttpResult<T> response) throws Exception {
        //打印服务器回传结果
        //遍历正确码
        if (response.getCode()!=2001) {
            throw new ServerException(response.getCode(), response.getMsg());
        }
        return response.getData();
    }
}


package cn.ck.mvp.business.account.model.helper;
import cn.ck.mvp.base.mvp.impl.IDataCallback;
import cn.ck.mvp.business.account.model.request.LoginRequestModel;
import cn.ck.mvp.business.account.model.request.RegisteredRequestModel;
import cn.ck.mvp.business.account.model.response.LoginResponseModel;
import cn.ck.mvp.business.account.model.response.RegisteredResponseModel;
import cn.ck.mvp.network.NetworkFactory;
import cn.ck.mvp.network.response.ApiCallBack;
import cn.ck.mvp.network.response.ApiResponse;
import cn.ck.mvp.network.services.ApiService;
import cn.ck.mvp.utils.ToastUtil;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ck on 2018/9/19.
 */
public class LoginHelper {

    private LoginHelper(){

    }

    private static class LoginHelperHoder{
        private static final LoginHelper INSTANSE=new LoginHelper();

    }

    public static LoginHelper getInstance(){
        return LoginHelper.LoginHelperHoder.INSTANSE;
    }


    /**
     * 登录
     */
    public void login(LoginRequestModel loginRequestModel, final IDataCallback.Callback<String> callback){

        NetworkFactory
                .getInstance()
                .creatService(ApiService.class)
                .login(loginRequestModel)
                .enqueue(new ApiCallBack<LoginResponseModel>() {
                    @Override
                    protected void onDataBack(ApiResponse<LoginResponseModel> responseBody) {
                        callback.onSuccessLoaded(responseBody.getData().getToken());
                    }

                    @Override
                    protected void onError(int code, String msg) {
                        ToastUtil.showToast(msg);
                    }
                });

        NetworkFactory
                .getInstance()
                .creatService(ApiService.class)
                .login(loginRequestModel)
                .enqueue(new Callback<ApiResponse<LoginResponseModel>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<LoginResponseModel>> call, Response<ApiResponse<LoginResponseModel>> response) {
                        response.body().getData();
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<LoginResponseModel>> call, Throwable t) {

                    }
                });
    }

    /**
     * 注册
     */
    public void register(RegisteredRequestModel registeredRequestModel, final IDataCallback.Callback<String> callback){
        NetworkFactory
                .getInstance()
                .creatService(ApiService.class)
                .register(registeredRequestModel)
                .enqueue(new ApiCallBack<RegisteredResponseModel>() {
                    @Override
                    protected void onDataBack(ApiResponse<RegisteredResponseModel> responseBody) {
                        callback.onSuccessLoaded(responseBody.getData().getToken());
                    }

                    @Override
                    protected void onError(int code, String msg) {
                        ToastUtil.showToast(msg);
                    }
                });
    }
}
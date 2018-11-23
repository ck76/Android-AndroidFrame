package cn.ck.mvp.common;

/**
 * @author FanHongyu.
 * @since 18/4/18 17:31.
 * email fanhongyu@hrsoft.net.
 */

public class Config {


    /**
     * 当前app版本号
     */
    public static final String APP_VERSION = "";

    /**
     * 网络请求BaseURL
     */
    public static final String APP_SERVER_BASE_URL = "http://mooc.andyhui.top/";

    /**
     * 是否为测试版本
     */
    public static final boolean DEBUG = false;

    /**
     * 网络请求连接超时时间，单位：s
     */
    public static final int APP_SERVER_CONNECT_TIME_OUT = 8;

    /**
     * 正确返回码
     */
    public static final int[] NET_CORRECT_CODE = {1000,0};





    /**
     * 主页广播Action
     */
    public static final String MainBroadcast = "cn.fhypayaso.androidscaffold.mainbroadcast";

    /**
     * 笔记广播Action
     */
    public static final String NoteBroadcast = "cn.fhypayaso.androidscaffold.notebroadcast";


}

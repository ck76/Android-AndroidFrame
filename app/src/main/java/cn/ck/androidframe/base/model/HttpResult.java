package cn.ck.androidframe.base.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by ck on 2018/9/13.
 */
public class HttpResult <T> {

    /**
     * 状态码
     */
    @SerializedName("code")
    private int code;

    /**
     * 描述信息
     */
    @SerializedName("msg")
    private String msg;

    /**
     * 数据对象
     */
    @SerializedName("data")
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

package me.xueyao.common;

import me.xueyao.constant.ResponseStatus;

/**
 * @author: Simon.Xue
 * @date: 2019/3/22 14:15
 */
public class BaseResponse {

    private int code;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public BaseResponse() {
    }

    public BaseResponse(ResponseStatus status) {
        this.code = status.getCode();
        this.msg = status.getMsg();
    }

    public BaseResponse(ResponseStatus status, String msg) {
        this.code = status.getCode();
        this.msg = msg;
    }
}

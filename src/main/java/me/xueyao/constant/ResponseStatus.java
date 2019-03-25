package me.xueyao.constant;

/**
 * @Description:
 * @Author: Simon.Xue
 * @Date: 2019/3/22 14:13
 */
public enum ResponseStatus {
    SUCCESS(10000, "成功"),
    INVALID_SIGNATURE(20002, "无效签名"),
    SEND_SMS_MAXIMUM(20003, "短信发送次数达到上限"),
    SEND_SMS_FAIL(20004,"短信发送失败"),
    BAD_REQUEST(40000,"请求有误"),
    BADPARAM(40001, "参数错误"),
    UNAUTHORIZED(40401, "用户未身份认证"),
    NO_PERMISSION(40403, "没有接口权限"),
    NOT_FOUND(40404,"您所访问的资源不存在"),
    Method_NOT_ALLOWED(40405,"方法不被允许"),
    EXCEPTION(50000, "业务处理失败，请稍后再试"),
    NOT_AUDIT(40007, "企业尚未审核");
    int code;
    String msg;

    ResponseStatus() {
    }

    ResponseStatus(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}

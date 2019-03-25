package me.xueyao.entity;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 12:29
 */
public class WeiXinToken implements Serializable {
    //获取到的凭证
    private String accessToken;
    //凭证有效时间
    private Integer expiresIn;
    //错误码
    private Integer errcode;
    //错误信息
    private String errmsg;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}

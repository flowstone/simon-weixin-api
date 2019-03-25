package me.xueyao.entity;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 16:44
 */
public class UserToken extends WeiXinToken implements Serializable {
    //网页授权接口调用凭证,注意：此access_token与基础支持的access_token不同
    private String refreshToken;
    //用户唯一标识，请注意，在未关注公众号时，用户访问公众号的网页，也会产生一个用户和公众号唯一的OpenID
    private String openid;
    //用户授权的作用域，使用逗号（,）分隔
    private String scope;

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}

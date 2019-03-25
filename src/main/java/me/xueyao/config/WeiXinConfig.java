package me.xueyao.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 10:09
 */
@Configuration
public class WeiXinConfig {
    @Value("${weixin.appId}")
    private String appId;

    @Value("${weixin.appSecret}")
    private String appSecret;

    @Value("${weixin.token}")
    private String token;

    @Value("${weixin.token_url}")
    private String tokenUrl;

    @Value("${weixin.login_url}")
    private String loginUrl;

    @Value("${weixin.access_token}")
    private String accessToken;

    @Value("${weixin.pull_userInfo}")
    private String pullUserInfo;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTokenUrl() {
        return tokenUrl;
    }

    public void setTokenUrl(String tokenUrl) {
        this.tokenUrl = tokenUrl;
    }

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getPullUserInfo() {
        return pullUserInfo;
    }

    public void setPullUserInfo(String pullUserInfo) {
        this.pullUserInfo = pullUserInfo;
    }
}

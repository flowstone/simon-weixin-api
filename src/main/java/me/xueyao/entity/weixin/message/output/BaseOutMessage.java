package me.xueyao.entity.weixin.message.output;

/**
 * 回复消息的公共字段类
 * @author: Simon.Xue
 * @date: 2019/3/26 19:34
 */
public abstract class BaseOutMessage {
    //接收方帐号(openId)
    private String toUsername;
    //开发者微信号
    private String fromUsername;
    //消息创建时间(整型)
    private Long createTime;

    public abstract String getMsgType();

    public String getToUsername() {
        return toUsername;
    }

    public void setToUsername(String toUsername) {
        this.toUsername = toUsername;
    }

    public String getFromUsername() {
        return fromUsername;
    }

    public void setFromUsername(String fromUsername) {
        this.fromUsername = fromUsername;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}

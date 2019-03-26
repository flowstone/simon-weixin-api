package me.xueyao.entity.weixin.event;

/**
 * 事件消息
 * @author: Simon.Xue
 * @date: 2019/3/26 19:21
 */
public class BaseEvent {
    //开发者微信号
    private String toUserName;
    //发送方帐号OpenId
    private String fromUsername;
    //消息创建时间(整型)
    private Long createTime;
    //消息类型
    private String msgType;
    //事件类型
    private String event;

    public String getToUserName() {
        return toUserName;
    }

    public void setToUserName(String toUserName) {
        this.toUserName = toUserName;
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

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public String getEvent() {
        return event;
    }

    public void setEvent(String event) {
        this.event = event;
    }
}

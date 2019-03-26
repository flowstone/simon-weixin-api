package me.xueyao.entity.weixin.message.input;

import me.xueyao.constant.MessageType;

/**
 * 链接消息
 * @author: Simon.Xue
 * @date: 2019/3/26 18:51
 */
public class LinkMessage extends BaseMessage {
    //消息标题
    private String title;
    //消息描述
    private String description;
    //消息链接
    private String url;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String getMsgType() {
        return MessageType.LINK_MESSAGE.name();
    }
}

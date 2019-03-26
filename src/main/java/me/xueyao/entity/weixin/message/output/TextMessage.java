package me.xueyao.entity.weixin.message.output;

import me.xueyao.constant.MessageType;

/**
 * 文本回复消息
 * @author: Simon.Xue
 * @date: 2019/3/26 19:38
 */
public class TextMessage extends BaseOutMessage {
    //文本消息
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_TEXT.name();
    }
}

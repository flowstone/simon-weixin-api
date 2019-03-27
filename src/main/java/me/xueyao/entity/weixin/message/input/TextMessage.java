package me.xueyao.entity.weixin.message.input;

import me.xueyao.constant.MessageType;

/**
 * 文本消息
 * @author: Simon.Xue
 * @date: 2019/3/26 17:40
 */
public class TextMessage extends BaseMessage {
    //内容
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getMsgType() {
        return MessageType.TEXT_MESSAGE;
    }
}

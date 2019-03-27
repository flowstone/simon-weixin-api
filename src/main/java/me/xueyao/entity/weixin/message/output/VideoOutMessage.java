package me.xueyao.entity.weixin.message.output;

import me.xueyao.constant.MessageType;

/**
 * 回复视频消息
 * @author: Simon.Xue
 * @date: 2019/3/26 19:46
 */
public class VideoOutMessage extends BaseOutMessage {
    private Video video;

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_VIDEO;
    }
}

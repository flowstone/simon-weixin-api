package me.xueyao.entity.weixin.message.input;

import me.xueyao.constant.MessageType;

/**
 * 语音消息
 * @author: Simon.Xue
 * @date: 2019/3/26 17:52
 */
public class VoiceMessage extends BaseMessage {
    //语音消息媒体id,可以调用多媒体文件下载接口拉取数据
    private String mediaId;
    //语音格式，如amr,speex等
    private String format;
    //语音识别结果，使用UTF8编码
    private String recognition;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getRecognition() {
        return recognition;
    }

    public void setRecognition(String recognition) {
        this.recognition = recognition;
    }

    @Override
    public String getMsgType() {
        return MessageType.VOICE_MESSAGE;
    }
}

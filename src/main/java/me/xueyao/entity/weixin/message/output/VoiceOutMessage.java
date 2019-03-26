package me.xueyao.entity.weixin.message.output;

import me.xueyao.constant.MessageType;

/**
 * 语音回复消息
 * @author: Simon.Xue
 * @date: 2019/3/26 19:43
 */
public class VoiceOutMessage extends BaseOutMessage {
    private Voice voice;

    public Voice getVoice() {
        return voice;
    }

    public void setVoice(Voice voice) {
        this.voice = voice;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_VOICE.name();
    }
}

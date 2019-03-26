package me.xueyao.entity.weixin.message.output;

import me.xueyao.constant.MessageType;

/**
 * 回复音乐消息
 * @author: Simon.Xue
 * @date: 2019/3/26 19:49
 */
public class MusicOutMessage extends BaseOutMessage {
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_MUSIC.name();
    }
}

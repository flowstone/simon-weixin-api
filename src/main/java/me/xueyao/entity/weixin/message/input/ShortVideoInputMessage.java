package me.xueyao.entity.weixin.message.input;

import me.xueyao.constant.MessageType;

/**
 * 小视频
 * @author: Simon.Xue
 * @date: 2019/3/26 18:03
 */
public class ShortVideoInputMessage extends BaseMessage {
    //视频消息媒体id,可以调用多媒体文件下载接口拉取数据
    private String mediaId;
    //视频消息  视频消息缩略图的媒体id,可以调用多媒体下载接口拉取数据
    private String thumbMediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMediaId() {
        return thumbMediaId;
    }

    public void setThumbMediaId(String thumbMediaId) {
        this.thumbMediaId = thumbMediaId;
    }

    @Override
    public String getMsgType() {
        return MessageType.SHORTVIDEO_MESSAGE;
    }
}

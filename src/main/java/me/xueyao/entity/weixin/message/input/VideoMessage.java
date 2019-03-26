package me.xueyao.entity.weixin.message.input;

import me.xueyao.constant.MessageType;

/**
 * 视频消息
 * @author: Simon.Xue
 * @date: 2019/3/26 17:58
 */
public class VideoMessage extends BaseMessage {
    //视频消息媒体id,可以调用多媒体文件下载接口拉取数据
    private String mediaId;
    //视频消息  视频消息缩略图的媒体id,可以调用多媒体文件下载接口拉取数据
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
        return MessageType.VIDEO_MESSAGE.name();
    }
}

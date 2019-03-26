package me.xueyao.entity.weixin.message.input;

import me.xueyao.constant.MessageType;

/**
 * 图片消息
 * @author: Simon.Xue
 * @date: 2019/3/26 17:49
 */
public class ImageMessage extends BaseMessage {
    //图片地址
    private String picUrl;
    //图片消息媒体id,可以调用多媒体文件下载接口拉取数据
    private String mediaId;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    @Override
    public String getMsgType() {
        return MessageType.IMAGE_MESSAGE.name();
    }
}

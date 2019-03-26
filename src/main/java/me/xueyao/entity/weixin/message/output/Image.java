package me.xueyao.entity.weixin.message.output;

/**
 * 照片回复消息
 * @author: Simon.Xue
 * @date: 2019/3/26 19:40
 */
public class Image {
    //通过上传多媒体，得到id
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}

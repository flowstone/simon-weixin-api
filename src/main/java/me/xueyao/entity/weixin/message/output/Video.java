package me.xueyao.entity.weixin.message.output;

/**
 * @author: Simon.Xue
 * @date: 2019/3/26 19:44
 */
public class Video {
    //媒体文件id
    private String mediaId;
    //缩略图媒体id
    private String thumbMeidaId;
    //视频消息标题
    private String title;
    //视频消息描述
    private String description;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public String getThumbMeidaId() {
        return thumbMeidaId;
    }

    public void setThumbMeidaId(String thumbMeidaId) {
        this.thumbMeidaId = thumbMeidaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

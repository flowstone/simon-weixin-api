package me.xueyao.entity.weixin.message.output;

/**
 * 图文消息实体
 * @author: Simon.Xue
 * @date: 2019/3/26 19:50
 */
public class Articles {
    //图文消息标题
    private String title;
    //图文消息描述
    private String description;
    //图片链接，支持JPG、PNG格式，较好的效果为大图640*320，小图80*80
    private String picUrl;
    //点击图文消息跳转链接
    private String url;


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

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

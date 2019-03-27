package me.xueyao.entity.weixin.message.output;

import me.xueyao.constant.MessageType;

/**
 * 图片输出内容
 * @author: Simon.Xue
 * @date: 2019/3/26 19:41
 */
public class ImageOutMessage extends BaseOutMessage {
    private Image image;

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public String getMsgType() {
        return MessageType.RESP_MESSAGE_TYPE_IMAGE;
    }
}

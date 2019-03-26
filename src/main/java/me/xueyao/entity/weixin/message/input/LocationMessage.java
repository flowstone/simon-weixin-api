package me.xueyao.entity.weixin.message.input;

import me.xueyao.constant.MessageType;

/**
 * 地理位置消息
 * @author: Simon.Xue
 * @date: 2019/3/26 18:45
 */
public class LocationMessage extends BaseMessage {
    //地理位置维度
    private String locationX;
    //地理位置经度
    private String locationY;
    //地图缩放大小
    private Long scale;
    //地理位置信息
    private String label;

    public String getLocationX() {
        return locationX;
    }

    public void setLocationX(String locationX) {
        this.locationX = locationX;
    }

    public String getLocationY() {
        return locationY;
    }

    public void setLocationY(String locationY) {
        this.locationY = locationY;
    }

    public Long getScale() {
        return scale;
    }

    public void setScale(Long scale) {
        this.scale = scale;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String getMsgType() {
        return MessageType.POSOTION_MESSAGE.name();
    }
}

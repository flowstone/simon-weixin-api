package me.xueyao.constant;

/**
 * @author: Simon.Xue
 * @date: 2019/3/26 16:40
 */
public enum  MessageType {
    TEXT_MESSAGE("text"),  //文本消息
    IMAGE_MESSAGE("image"),  //图片消息
    VOICE_MESSAGE("voice"),  //语音消息
    VIDEO_MESSAGE("video"),  //视频消息
    SHORTVIDEO_MESSAGE("shortvideo"),  //小视频消息消息
    POSOTION_MESSAGE("location"),  //地理位置消息
    LINK_MESSAGE("link"),  //链接消息
    MUSIC_MESSAGE("music"),  //音乐消息
    IMAGE_TEXT_MESSAGE("news"),  //图文消息
    REQ_MESSAGE_TYPE_EVENT("event"),  //请求消息类型：事件推送
    EVENT_TYPE_SUBSCRIBE("subscribe"),  //事件类型：subscribe(订阅)
    EVENT_TYPE_UNSUBSCRIBE("unsubscribe"),  //事件类型：unsubscribe(取消订阅)
    EVENT_TYPE_SCAN("scan"),  //事件类型：scan(用户已关注时的扫描带参数二维码)
    EVENT_TYPE_LOCATION("location"),  //事件类型：LOCATION(上报地理位置)
    EVENT_TYPE_CLICK("click"),  // 事件类型：CLICK(自定义菜单)
    RESP_MESSAGE_TYPE_TEXT("text"),  //响应消息类型：文本
    RESP_MESSAGE_TYPE_IMAGE("image"),  //响应消息类型：图片
    RESP_MESSAGE_TYPE_VOICE("voice"),  //响应消息类型：语音
    RESP_MESSAGE_TYPE_VIDEO("video"),  //响应消息类型：视频
    RESP_MESSAGE_TYPE_MUSIC("music"),  //响应消息类型：音乐
    RESP_MESSAGE_TYPE_NEWS("news");  //响应消息类型：图文

    String messageType;

    MessageType(String messageType) {
        this.messageType = messageType;
    }
}

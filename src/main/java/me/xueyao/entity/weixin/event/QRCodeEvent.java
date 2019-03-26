package me.xueyao.entity.weixin.event;

/**
 * 扫描带参数二维码事件
 * @author: Simon.Xue
 * @date: 2019/3/26 19:26
 */
public class QRCodeEvent extends BaseEvent {
    //事件key值
    private String eventKey;
    //用于换取二维码图片
    private String ticket;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }
}

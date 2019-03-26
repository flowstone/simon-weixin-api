package me.xueyao.entity.weixin.event;

/**
 * 自定义菜单事件
 * @author: Simon.Xue
 * @date: 2019/3/26 19:31
 */
public class MenuEvent extends BaseEvent {
    //事件key值，与自定义菜单接口中key值对应
    private String eventKey;

    public String getEventKey() {
        return eventKey;
    }

    public void setEventKey(String eventKey) {
        this.eventKey = eventKey;
    }
}

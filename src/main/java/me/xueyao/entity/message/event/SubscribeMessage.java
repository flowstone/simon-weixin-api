package me.xueyao.entity.message.event;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * 关注事件
 * @author: Simon.Xue
 * @date: 2019/4/2 12:12
 */
@Data
@XStreamAlias("xml")
public class SubscribeMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Event")
    private String event;
}

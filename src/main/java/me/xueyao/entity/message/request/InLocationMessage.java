package me.xueyao.entity.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * 地理位置消息
 * @author: Simon.Xue
 * @date: 2019/4/1 12:56
 */
@Data
@XStreamAlias("xml")
public class InLocationMessage extends BaseMessage implements Serializable {
    @XStreamAlias("LocationX")
    private Double locationX;
    @XStreamAlias("LocationY")
    private Double locationY;
    @XStreamAlias("Scale")
    private Long scale;
}

package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * 回复文本消息
 * @author: Simon.Xue
 * @date: 2019/4/1 13:10
 */
@Data
@XStreamAlias("xml")
public class OutTextMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Content")
    private String content;
}

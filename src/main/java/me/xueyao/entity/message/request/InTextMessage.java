package me.xueyao.entity.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/3/28 17:59
 */
@Data
@XStreamAlias("xml")
public class InTextMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Content")
    private String content;
}

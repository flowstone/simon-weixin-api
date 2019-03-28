package me.xueyao.entity.message;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/3/28 17:59
 */
@XStreamAlias("xml")
@Data
public class TextMessage implements Serializable {
    @XStreamAlias("ToUserName")
    private String toUser;
    @XStreamAlias("FromUserName")
    private String fromUser;
    @XStreamAlias("CreateTime")
    private Long createTime;
    @XStreamAlias("MsgType")
    private String msgType;
    @XStreamAlias("Content")
    private String content;
    @XStreamAlias("MsgId")
    private String msgId;
}

package me.xueyao.entity.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * 语音消息
 * @author: Simon.Xue
 * @date: 2019/4/1 12:43
 */
@XStreamAlias("xml")
@Data
public class InVoiceMessage extends BaseMessage implements Serializable {
    @XStreamAlias("MediaId")
    private Long mediaId;
    @XStreamAlias("Format")
    private String format;
}

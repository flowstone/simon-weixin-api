package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/4/1 13:45
 */
@XStreamAlias("xml")
@Data
public class OutVoiceMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Voice")
    private Voice voice;
}

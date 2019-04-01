package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/4/1 13:11
 */
@Data
@XStreamAlias("xml")
public class OutImageMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Image")
    private Image image;
}

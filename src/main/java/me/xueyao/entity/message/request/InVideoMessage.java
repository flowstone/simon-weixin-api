package me.xueyao.entity.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * 视频消息
 * @author: Simon.Xue
 * @date: 2019/4/1 12:46
 */
@XStreamAlias("xml")
@Data
public class InVideoMessage extends BaseMessage implements Serializable {
    @XStreamAlias("MediaId")
    private Long mediaId;
    @XStreamAlias("ThumbMediaId")
    private Long thumbMediaId;
}

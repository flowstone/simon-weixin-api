package me.xueyao.entity.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * 图片消息
 * @author: Simon.Xue
 * @date: 2019/4/1 12:39
 */
@XStreamAlias("xml")
@Data
public class InImageMessage extends BaseMessage implements Serializable {
    @XStreamAlias("PicUrl")
    private String picUrl;
    @XStreamAlias("MediaId")
    private Long mediaId;
}

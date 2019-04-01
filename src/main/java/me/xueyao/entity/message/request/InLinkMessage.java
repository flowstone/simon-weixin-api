package me.xueyao.entity.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * 链接消息
 * @author: Simon.Xue
 * @date: 2019/4/1 12:59
 */
@XStreamAlias("xml")
@Data
public class InLinkMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("Url")
    private String url;
}

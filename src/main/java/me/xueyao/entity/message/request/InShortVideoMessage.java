package me.xueyao.entity.message.request;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * 小视频消息
 * @author: Simon.Xue
 * @date: 2019/4/1 12:53
 */
@XStreamAlias("xml")
@Data
public class InShortVideoMessage extends InVideoMessage implements Serializable {
}

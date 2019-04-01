package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import me.xueyao.entity.message.request.BaseMessage;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/4/1 14:37
 */
@Data
@XStreamAlias("xml")
public class OutMusicMessage extends BaseMessage implements Serializable {
    @XStreamAlias("Music")
    private Music music;
}

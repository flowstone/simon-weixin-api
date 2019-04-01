package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 *
 * @author: Simon.Xue
 * @date: 2019/4/1 13:46
 */
@Data
public class Voice implements Serializable {
    @XStreamAlias("MediaId")
    private Long mediaId;
}

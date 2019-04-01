package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/4/1 13:48
 */
@Data
public class Video implements Serializable {
    @XStreamAlias("MediaId")
    private Long mediaId;
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
}

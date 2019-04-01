package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Simon.Xue
 * @date: 2019/4/1 14:29
 */
@Data
public class Music implements Serializable {
    @XStreamAlias("Title")
    private String title;
    @XStreamAlias("Description")
    private String description;
    @XStreamAlias("MusicUrl")
    private String musicUrl;
    @XStreamAlias("HQMusicUrl")
    private String hQMusicUrl;
    @XStreamAlias("ThumbMediaId")
    private Long thumbMediaId;


}

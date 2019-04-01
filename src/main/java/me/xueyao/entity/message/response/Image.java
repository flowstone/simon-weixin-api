package me.xueyao.entity.message.response;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;

/**
 * 图片
 * @author: Simon.Xue
 * @date: 2019/4/1 13:12
 */
@Data
public class Image {
    @XStreamAlias("MediaId")
    private Long mediaId;

}

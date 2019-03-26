package me.xueyao.util;

import me.xueyao.entity.weixin.message.output.Articles;
import me.xueyao.entity.weixin.message.output.MusicOutMessage;
import me.xueyao.entity.weixin.message.output.NewsOutMessage;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 回复消息工具类
 * @author: Simon.Xue
 * @date: 2019/3/26 19:58
 */
public class ReplyMessageUtils implements Serializable {

    /**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[news]]></MsgType>
     *   <ArticleCount>1</ArticleCount>
     *   <Articles>
     *     <item>
     *       <Title><![CDATA[title1]]></Title>
     *       <Description><![CDATA[description1]]></Description>
     *       <PicUrl><![CDATA[picurl]]></PicUrl>
     *       <Url><![CDATA[url]]></Url>
     *     </item>
     *   </Articles>
     * </xml>
     * 回复图文消息
     * @param message
     * @return
     */
    public static String sendImageTextMessage(NewsOutMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[" + message.getToUsername() + "]]></ToUserName>")
                .append("<FromUserName><![CDATA[" + message.getFromUsername() + "]]></FromUserName>")
                .append("<CreateTime>" + message.getCreateTime() + "</CreateTime>")
                .append("<MsgType><![CDATA[" + message.getMsgType() + "]]></MsgType>")
                .append("<ArticleCount>" + message.getArticleCount() + "</ArticleCount>")
                .append("<Articles>");
        for (Articles article : message.getArticles()) {
            sb.append("<item>");
            if (!StringUtils.isEmpty(article.getTitle())) {
                sb.append("<Title><![CDATA[" + article.getTitle() + "]]></Title>");
            }
            if (!StringUtils.isEmpty(article.getDescription())) {
                sb.append("<Description><![CDATA[" + article.getDescription() + "]]></Description>");
            }

            if (!StringUtils.isEmpty(article.getPicUrl())) {
                sb.append("<PicUrl><![CDATA[" + article.getPicUrl() + "]]></PicUrl>");
            }

            if (!StringUtils.isEmpty(article.getUrl())) {
                sb.append("<Url><![CDATA[" + article.getUrl() + "]]></Url>");
            }
            sb.append("</item>");
        }
        sb.append("</Articles>")
                .append("</xml>");
        return sb.toString();
    }


    /**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[music]]></MsgType>
     *   <Music>
     *     <Title><![CDATA[TITLE]]></Title>
     *     <Description><![CDATA[DESCRIPTION]]></Description>
     *     <MusicUrl><![CDATA[MUSIC_Url]]></MusicUrl>
     *     <HQMusicUrl><![CDATA[HQ_MUSIC_Url]]></HQMusicUrl>
     *     <ThumbMediaId><![CDATA[media_id]]></ThumbMediaId>
     *   </Music>
     * </xml>
     * 回复音乐消息
     * @param message
     * @return
     */
    public static String sendMusicMessage(MusicOutMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[" + message.getToUsername() + "]]></ToUserName>")
                .append("<FromUserName><![CDATA[" + message.getFromUsername() + "]]></FromUserName>")
                .append("<CreateTime>" + message.getCreateTime() + "</CreateTime>")
                .append("<MsgType><![CDATA[" + message.getMsgType() + "]]></MsgType>")
                .append("<Music>");
        if (!StringUtils.isEmpty(message.getMusic().getTitle())) {
            sb.append("<Title><![CDATA[" + message.getMusic().getTitle() + "]]></Title>");
        }
        if (!StringUtils.isEmpty(message.getMusic().getDescription())) {
            sb.append("<Description><![CDATA[" + message.getMusic().getDescription() + "]]></Description>");
        }

        if (!StringUtils.isEmpty(message.getMusic().getMusicUrl())) {
            sb.append("<MusicUrl><![CDATA[" + message.getMusic().getMusicUrl() + "]]></MusicUrl>");
        }

        if (!StringUtils.isEmpty(message.getMusic().gethQMusicUrl())) {
            sb.append("<HQMusicUrl><![CDATA[" + message.getMusic().gethQMusicUrl() + "]]></HQMusicUrl>");
        }
        if (!StringUtils.isEmpty(message.getMusic().getThumbMediaId())) {
            sb.append("<ThumbMediaId><![CDATA[" + message.getMusic().getThumbMediaId() + "]]></ThumbMediaId>");
        }
        sb.append("</Music>")
                .append("</xml>");
        return sb.toString();
    }
}

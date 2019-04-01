package me.xueyao.util;


import me.xueyao.entity.message.request.InTextMessage;
import me.xueyao.entity.message.response.OutImageMessage;
import me.xueyao.entity.message.response.OutMusicMessage;
import me.xueyao.entity.message.response.OutVideoMessage;
import me.xueyao.entity.message.response.OutVoiceMessage;
import org.springframework.util.StringUtils;

import java.io.Serializable;

/**
 * 回复消息工具类
 * @author: Simon.Xue
 * @date: 2019/3/26 19:58
 * */


public class ReplyMessageUtil implements Serializable {

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

    /*public static String sendImageTextMessage(NewsOutMessage message) {
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
    }*/


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

    public static String sendMusicMessage(OutMusicMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>")
                .append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>")
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

        if (!StringUtils.isEmpty(message.getMusic().getHQMusicUrl())) {
            sb.append("<HQMusicUrl><![CDATA[" + message.getMusic().getHQMusicUrl() + "]]></HQMusicUrl>");
        }
        if (!StringUtils.isEmpty(message.getMusic().getThumbMediaId())) {
            sb.append("<ThumbMediaId><![CDATA[" + message.getMusic().getThumbMediaId() + "]]></ThumbMediaId>");
        }
        sb.append("</Music>")
                .append("</xml>");
        return sb.toString();
    }

/**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[video]]></MsgType>
     *   <Video>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *     <Title><![CDATA[title]]></Title>
     *     <Description><![CDATA[description]]></Description>
     *   </Video>
     * </xml>
     * 回复视频消息
     * @param message
     * @return
     */

    public static String sendVideoMessage(OutVideoMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA["+message.getToUserName()+"]]></ToUserName>")
                .append("<FromUserName><![CDATA["+message.getFromUserName()+"]]></FromUserName>")
                .append("<CreateTime>"+message.getCreateTime()+"</CreateTime>")
                .append("<MsgType><![CDATA["+message.getMsgType()+"]]></MsgType>")
                .append("<Video>");
        if (!StringUtils.isEmpty(message.getVideo().getMediaId())) {
            sb.append("<MediaId><![CDATA[" + message.getVideo().getMediaId() + "]]></MediaId>");
        }
        if (!StringUtils.isEmpty(message.getVideo().getTitle())) {
            sb.append("<Title><![CDATA[" + message.getVideo().getTitle() + "]]></Title>");
        }
        if (!StringUtils.isEmpty(message.getVideo().getDescription())) {
            sb.append("<Description><![CDATA[" + message.getVideo().getDescription() + "]]></Description>");
        }

        sb.append("</Video>")
                .append("</xml>");
        return sb.toString();
    }


/**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[voice]]></MsgType>
     *   <Voice>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *   </Voice>
     * </xml>
     * 回复语音消息
     * @param message
     * @return
     */

    public static String sendVoiceMessage(OutVoiceMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>")
                .append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>")
                .append("<CreateTime>" + message.getCreateTime() + "</CreateTime>")
                .append("<MsgType><![CDATA[" + message.getMsgType() + "]]></MsgType>")
                .append("<Voice>");
        if (!StringUtils.isEmpty(message.getVoice().getMediaId())) {
            sb.append("<MediaId><![CDATA[" + message.getVoice().getMediaId() + "]]></MediaId>");
        }
        sb.append("</Voice>")
                .append("</xml>");
        return sb.toString();
    }

/**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[image]]></MsgType>
     *   <Image>
     *     <MediaId><![CDATA[media_id]]></MediaId>
     *   </Image>
     * </xml>
     * 回复图片消息
     * @param message
     * @return
     */

    public static String sendImageMessage(OutImageMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>")
                .append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>")
                .append("<CreateTime>" + message.getCreateTime() + "</CreateTime>")
                .append("<MsgType><![CDATA[" + message.getMsgType() + "]]></MsgType>")
                .append("<Image>");
        if (!StringUtils.isEmpty(message.getImage().getMediaId())) {
            sb.append("<MediaId><![CDATA[" + message.getImage().getMediaId() + "]]></MediaId>");
        }
        sb.append("</Image>")
                .append("</xml>");
        return sb.toString();
    }


/**
     * <xml>
     *   <ToUserName><![CDATA[toUser]]></ToUserName>
     *   <FromUserName><![CDATA[fromUser]]></FromUserName>
     *   <CreateTime>12345678</CreateTime>
     *   <MsgType><![CDATA[text]]></MsgType>
     *   <Content><![CDATA[你好]]></Content>
     * </xml>
     * 回复文本消息
     * @param message
     * @return
     */

    public static String sendTextMessage(InTextMessage message) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>")
                .append("<ToUserName><![CDATA[" + message.getToUserName() + "]]></ToUserName>")
                .append("<FromUserName><![CDATA[" + message.getFromUserName() + "]]></FromUserName>")
                .append("<CreateTime>" + message.getCreateTime() + "</CreateTime>")
                .append("<MsgType><![CDATA[" + message.getMsgType() + "]]></MsgType>")
                .append("<Content><![CDATA[" + message.getContent() + "]]></Content>")
                .append("</xml>");
        return sb.toString();
    }
}

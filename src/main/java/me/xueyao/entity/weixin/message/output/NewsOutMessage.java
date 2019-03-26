package me.xueyao.entity.weixin.message.output;

import java.util.List;

/**
 * 获取多条图文消息信息
 * @author: Simon.Xue
 * @date: 2019/3/26 19:52
 */
public class NewsOutMessage extends BaseOutMessage {
    //图文消息个数 ，限制为10条以内
    private Integer articleCount;
    //多条图文消息信息，默认第一个Item为大图
    private List<Articles> articles;

    public Integer getArticleCount() {
        return articleCount;
    }

    public void setArticleCount(Integer articleCount) {
        this.articleCount = articleCount;
    }

    public List<Articles> getArticles() {
        return articles;
    }

    public void setArticles(List<Articles> articles) {
        this.articles = articles;
    }

    @Override
    public String getMsgType() {
        return null;
    }
}

package me.xueyao.util;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: Simon.Xue
 * @date: 2019/3/25 10:29
 */
public class HttpClientUtil {

    /**
     * post请求传输map数据
     * @param url URL
     * @param map  map数据
     * @param encoding  编码
     * @return
     */
    public static String sendPostDataByMap(String url, Map<String, String> map, String encoding) {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        List<NameValuePair> nameValuePairs = new ArrayList<>();

        if (null != map) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nameValuePairs.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }

        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, encoding));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //设置header信息
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        return executeGetOrPost(httpClient, httpPost);
    }

    /**
     * POST请求传输JSON数据
     * @param url
     * @param json
     * @return
     */
    public static String sendPostDataByJson(String url, String json) {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //设置参数到请求对象中
        StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
        stringEntity.setContentEncoding("utf-8");
        httpPost.setEntity(stringEntity);

        return executeGetOrPost(httpClient, httpPost);

    }

    /**
     * Get请求
     * @param url
     * @return
     */
    public static String sendGetData(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建get方式请求对象
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Content-Type", "application/json");
        return executeGetOrPost(httpClient, httpGet);
    }

    /**
     * 执行GET/POST方法
     * @param httpClient
     * @param httpMethod
     * @return
     */
    private static String executeGetOrPost(CloseableHttpClient httpClient, HttpRequestBase httpMethod) {
        String result = StringUtils.EMPTY;
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(httpMethod);
            if (HttpStatus.SC_OK == response.getStatusLine().getStatusCode()) {
                result = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }
}

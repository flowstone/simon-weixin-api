package me.xueyao.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: Simon.Xue
 * @date: 2019/3/26 16:33
 */
public class WXMessageUtil {

    /**
     * 将用户的xml消息提取成map key value 类型
     * @param request
     * @param response
     * @return
     */
    public static Map<String, String> parseXML(HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, String> map = new HashMap<>();
        InputStream inputStream = null;
        try {
            inputStream = request.getInputStream();
            SAXReader reader = new SAXReader();
            Document document = reader.read(inputStream);
            Element root = document.getRootElement();
            List<Element> elements = root.elements();
            for (Element element : elements) {
                map.put(element.getName(), element.getText());
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
}

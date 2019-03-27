package me.xueyao.util;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Simon.Xue
 * @date: 2019/3/27 9:38
 */
public class XmlUtil {
    private static final String PREFIX_XML = "<xml>";
    private static final String SUFFIX_XML = "</xml>";
    private static final String PREFIX_CDATA = "<![CDATA[";
    private static final String SUFFIX_CDATA = "]]>";

    /**
     * 转化成xml，单层无嵌套
     * @param param
     * @param isAddCDATA
     * @return
     */
    public static String xmlFormat(Map<String, String> param, boolean isAddCDATA) {
        StringBuffer sb = new StringBuffer(PREFIX_XML);
        if (!CollectionUtils.isEmpty(param)) {
            for (Map.Entry<String, String> entry : param.entrySet()) {
                sb.append("<" + entry.getKey() + ">");
                if (isAddCDATA) {
                    sb.append(PREFIX_CDATA);
                    if (!StringUtils.isEmpty(entry.getValue())) {
                        sb.append(entry.getValue());
                    }
                    sb.append(SUFFIX_CDATA);
                } else {
                    if (!StringUtils.isEmpty(entry.getValue())) {
                        sb.append(entry.getValue());
                    }
                }
                sb.append("</"+entry.getKey()+">");
            }
        }
        return sb.append(SUFFIX_XML).toString();
    }

    /**
     * 解析xml
     * @param xml
     * @return
     */
    public static Map<String, String> xmlParse(String xml) {
        Map<String, String> map = null;

        if (!StringUtils.isEmpty(xml)) {
            InputStream inputStream = new ByteArrayInputStream(xml.getBytes());
            try {
                XmlPullParser xmlPullParser = XmlPullParserFactory.newInstance().newPullParser();
                xmlPullParser.setInput(inputStream, "UTF-8");

                int eventType = xmlPullParser.getEventType();
                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {
                        case XmlPullParser.START_DOCUMENT:
                            map = new HashMap<String, String>();
                            break;
                        case XmlPullParser.START_TAG:
                            String key = xmlPullParser.getName();
                            if ("xml".equals(key)) {
                                break;
                            }
                            String value = xmlPullParser.nextText().trim();
                            map.put(key, value);
                            break;
                        case XmlPullParser.END_TAG:
                            break;
                    }
                    eventType = xmlPullParser.next();
                }
            } catch (XmlPullParserException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return map;
    }
}

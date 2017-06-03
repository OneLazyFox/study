package guava.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import guava.util.RandomUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/31.
 * 封装http请求的相关方法
 * @author 张小虎
 * @version 1.0
 */
public class HttpHelper {

    public static Map<String, String> defaultHeaders = new HashMap<>();

    static {
        defaultHeaders.put("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
        defaultHeaders.put("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36");
        defaultHeaders.put("Accept-Language", "zh-CN,zh;q=0.8");
        defaultHeaders.put("Connection", "keep-alive");
    }

    public final static String[] userAgents = {"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.153 Safari/537.36 SE 2.X MetaSr 1.0",
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.116 Safari/537.36",
            "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.122 Safari/537.36 SE 2.X MetaSr 1.0"};

    public static final String[] ipPrefixes = {"14.125.63.", "42.199.58.", "59.37.23.", "14.28.36.", "14.149.159.", "116.16.48.",
            "219.129.99.", "223.73.60.", "116.27.32.", "125.92.119.", "123.133.53.", "113.92.146.", "180.99.62.", "183.51.159.",
            "119.190.61.", "14.124.102.", "113.245.100."};

    /**
     * 使用随机的 头信息发送GET请求
     */
    public static HttpResult doGetWithRandoms(String url) {
        HttpResult result = new HttpResult();
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        request.setHeader("Accept",defaultHeaders.get("Accept"));
        request.setHeader("Connection", defaultHeaders.get("Connection"));
        request.setHeader("Accept-Language", defaultHeaders.get("Accept-Language"));
        //request.setHeader("User-Agent", userAgents[RandomUtils.getRandomInt(userAgents.length)]);
        request.setHeader("User-Agent", RandomUtils.getRandomElement(userAgents));
        //String ip = ipPrefixes[RandomUtils.getRandomInt(ipPrefixes.length)]+RandomUtils.getRandomInt(2,254);
        String ip = RandomUtils.getRandomElement(ipPrefixes)+RandomUtils.getRandomInt(2,254);
        request.setHeader("X-Forwarded-For", ip);
        request.setHeader("CLIENT-IP", ip);
        System.out.println("User-Agent: " + request.getHeaders("User-Agent")[0].getValue());
        System.out.println("ip: " + ip);

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            result.setCode(response.getStatusLine().getStatusCode());
            if (entity != null) {
                result.setMsg(EntityUtils.toString(entity,"UTF-8"));
                if (result.getCode() != 200) {
                    request.abort();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 使用缺省的headers发送GET请求
     */
    public static HttpResult doGet(String url) {
        HttpResult result = new HttpResult();
        HttpClient client = HttpClientBuilder.create().build();

        try {
            //HttpGet request = new HttpGet(URLEncoder.encode(url, "utf-8"));
            HttpGet request = new HttpGet(url);
            request.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
            request.setHeader("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/43.0.2357.124 Safari/537.36");
            request.setHeader("Accept-Language", "zh-CN,zh;q=0.8");
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            result.setCode(response.getStatusLine().getStatusCode());
            if (entity != null) {
                result.setMsg(EntityUtils.toString(entity, "UTF-8")); //解决中文乱码问题
                if(result.getCode()!=200){
                    request.abort();
                }
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 使用指定的headers发送GET请求
     */
    public static HttpResult doGet(String url, Map<String, String> headers) {
        HttpResult result = new HttpResult();
        HttpClient client = HttpClientBuilder.create().build();

        try {
            //HttpGet request = new HttpGet(URLEncoder.encode(url, "utf-8"));
            HttpGet request = new HttpGet(url);
            for(String key : headers.keySet()){
                request.setHeader(key, headers.get(key));
            }
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            result.setCode(response.getStatusLine().getStatusCode());
            if (entity != null) {
                result.setMsg(EntityUtils.toString(entity, "UTF-8")); //解决中文乱码问题
                //System.out.println(EntityUtils.getContentCharSet(entity));
                //result.setMsg(EntityUtils.toString(entity));
                if(result.getCode()!=200){
                    request.abort();
                }
            }
        } catch (IOException e ) {
            e.printStackTrace();
        }

        return result;
    }

    public static void main(String[] args) {
        Map<String, String> defaultHeaders = new HashMap<>();
        defaultHeaders.put("apikey","da47545cf2bf34e59a445eda060ee62b");
        HttpResult result = doGet("http://apis.baidu.com/apistore/stockservice/stock?stockid=sz000002", defaultHeaders);
        ObjectMapper jsonMapper = new ObjectMapper();
        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> r = jsonMapper.readValue(result.getMsg(),Map.class);
            System.out.println(r);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

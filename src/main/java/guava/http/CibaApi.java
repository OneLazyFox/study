package guava.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2016</p>
 * <p>Company: Company of NECO's Technology</p>
 * <p>CompanyShortName: CNT </p>
 * Created by neco on 2017/5/28.
 *
 * @author 张小虎
 * @version 1.0
 */
public class CibaApi {
    private String url = "http://open.iciba.com/dsapi";

    @Test
    public void HttpRequest() {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String str = EntityUtils.toString(entity, "UTF-8");
                System.out.println("Do something");
                System.out.println(str);
                request.abort();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void UrlRequest() {
        try {
            URL requestUrl = new URL(url);
            URLConnection connection = requestUrl.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder sb = new StringBuilder();
            int cp;

            while ((cp = in.read()) != -1) {
                sb.append((char)cp);
            }
            String json = sb.toString();

            ObjectMapper objectMapper = new ObjectMapper();
            CibaPojo cibaPojo = objectMapper.readValue(json, CibaPojo.class);
            System.out.println(cibaPojo.getNote() + cibaPojo.getCaption());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

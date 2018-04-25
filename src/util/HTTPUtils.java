package util;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicHttpResponse;
/**
 * 通过httpclient相关方法，获取解析的html文件或者json数据
 * @author lhc
 */
public abstract class HTTPUtils {
    public static HttpResponse getRawHtml(HttpClient client, String personalUrl) {
        //采用get方法获取响应数据
        HttpGet getMethod = new HttpGet(personalUrl);
        HttpResponse response = new BasicHttpResponse(HttpVersion.HTTP_1_1,
                HttpStatus.SC_OK, "OK");
        try {
            //执行get方法
            response = client.execute(getMethod);
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            // getMethod.abort();
        }
        return response;
    }

}
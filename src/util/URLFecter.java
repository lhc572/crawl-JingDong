package util;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import model.JdModel;
import parse.JdParse;
/*   
 *  抓取数据，封装到list集合中
 */
public class URLFecter {
	/**
	 * 
	 * @param client HttpClient对象
	 * @param url 要爬取的url
	 * @return List<JdModel> 抓取的数据集合
	 * @throws Exception
	 */
    public static List<JdModel> URLParser (HttpClient client, String url) throws Exception {
        //用来接收解析的数据
        List<JdModel> JingdongData = new ArrayList<JdModel>();
        //获取网站响应的html，这里调用了HTTPUtils类
        HttpResponse response = HTTPUtils.getRawHtml(client, url);      
        //获取响应状态码
        int StatusCode = response.getStatusLine().getStatusCode();
        //如果状态响应码为200，则获取html实体内容或者json数据
        if(StatusCode == 200){
        	//这里是html页面
            String entity = EntityUtils.toString (response.getEntity(),"utf-8");
            System.out.println("********************8"+entity);
            //解析数据
            JingdongData = JdParse.getData(entity);
            //消耗掉实体
            EntityUtils.consume(response.getEntity());
        }else {
            //否则，消耗掉实体
            EntityUtils.consume(response.getEntity());
        }
        return JingdongData;
    }
}
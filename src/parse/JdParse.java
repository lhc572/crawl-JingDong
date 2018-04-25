package parse;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import model.JdModel;
/*
 * 用于将上面传下来的html解析，获取我们需要的内容
 * 解析方式，采用Jsoup解析html
 * Jsoup是一款很简单的html解析器
 */
public class JdParse {
    public static List<JdModel> getData (String html) throws Exception{
        //获取的数据，存放在集合中
        List<JdModel> data = new ArrayList<JdModel>();
        //采用Jsoup解析
        Document doc = Jsoup.parse(html);
        //获取html标签中的内容
        Elements elements=doc.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        System.out.println("元素长度："+elements.size());
        for (Element ele:elements) {
        	//获取bookID
            String bookID=ele.attr("data-sku");
            //获取bookPrice
            String bookPrice=ele.select("div[class=p-price]").select("strong").select("i").text();
            //获取bookName
            String bookName=ele.select("div[class=p-name]").select("em").text();
            //将获取到的值封装到对象中
            JdModel jdModel=new JdModel();
            jdModel.setBookID(bookID);
            jdModel.setBookName(bookName);
            jdModel.setBookPrice(bookPrice);
            //将每一个对象的值，保存到List集合中
            data.add(jdModel);
        }
        //返回数据
        return data;
    }
}
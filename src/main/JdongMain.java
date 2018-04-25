package main;

import java.util.Iterator;
import java.util.List;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import db.MYSQLControl;
import model.JdModel;
import util.URLFecter;
/**
 * 爬虫入口
 * @author lhc
 *
 */
public class JdongMain {
    //log4j的是使用，不会的请看之前写的文章
    public static void main(String[] args) throws Exception {
        //初始化一个httpclient
        //HttpClient client = new DefaultHttpClient();
        HttpClient client = HttpClientBuilder.create().build();
        //我们要爬取的一个地址，这里可以从数据库中抽取数据，然后利用循环，可以爬取一个URL队列
//        for (int i = 1; i <= 100; i++) {
//        	int page=i*2-1;
//        	int page1=1+(i-1)*60;
//			//String everypageurl="http://search.jd.com/Search?keyword=Python&enc=utf-8&qrst=1&rt=1&stop=1&book=y&vt=2&wq=Python&page="+page+"&s="+page1+"&click=0";
//			String everypageurl="http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb&page="+page+"&s="+page1+"&click=0";
//			List<JdModel> bookdatas=URLFecter.URLParser(client, everypageurl);
//	        System.out.println("第"+i+"页抓取数据个数："+bookdatas.size());
//	        //循环输出抓取的数据
//	        for (JdModel jd:bookdatas) {
//	        	System.out.println(jd);
//	        }
//	        //将抓取的数据插入数据库
//	        MYSQLControl.executeInsert(bookdatas);
//        }
        
        //抓取单页数据
        String url="http://search.jd.com/Search?keyword=Python&enc=utf-8&book=y&wq=Python&pvid=33xo9lni.p4a1qb";
        List<JdModel> bookdatas=URLFecter.URLParser(client, url);
        for (JdModel jd : bookdatas) {
			System.out.println(jd);
		}
        MYSQLControl.executeInsert(bookdatas);
    }
}

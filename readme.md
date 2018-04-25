#### 爬虫--京东
* HttpClient + Jsoup + log4j + dbutils 
#### 使用httpclient步骤
1. 创建HttpClient实例
2. 通过HttpGet/HttpPost方法创建请求方法实例
3. 调用HttpClient的execute()方法请求访问具体的资源，返回HttpResponse实例
4. 对响应内容进行解析：响应状态码、响应内容、网页等内容进行解析，实现具体的操作
5. 释放连接

#### 具体实例
> 下面实现爬取京东书城上第一相页面关于Python书籍的ID、书名和价格，并将其存入到本地数据库的爬虫代码
1. 新建数据库: crawl_lhc 新建数据表: jd_book

```
CREATE TABLE `jd_book` (
  `bookid` varchar(255) NOT NULL DEFAULT '',
  `bookname` varchar(255) DEFAULT NULL,
  `bookprice` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```
2. 创建JdModel对象封装抓取的数据
3. 通过HttpClient获取页面内容(html|json)
4. 使用jsoup解析html,将抓取的数据封装到List<JdModel>中
5. 将数据保存数据库

#### 模块分析
* model(模型)：用于封装爬虫数据
* db(数据库)：处理与数据库相关的操作
* util(HttpClient): 处理HttpClient相关的操作
* parse(解析)：用来解析页面数据,将结果封装到对象模型中
* main(入口)：程序入口

#### 问题
1. 只能爬取指定uri响应的数据，对于页面中的动态uri如何处理，比如该页面每页显示60本书，通过该url每页只能爬取30本书的信息
2. 实际请求url中的参数如何快速确定具体含义，可能值是多少
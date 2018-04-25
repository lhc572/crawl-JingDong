####使用httpclient步骤
1. 创建HttpClient实例
2. 通过HttpGet/HttpPost方法创建请求方法实例
3. 调用HttpClient的execute()方法请求访问具体的资源，返回HttpResponse实例
4. 对响应内容进行解析：响应状态码、响应内容、网页等内容进行解析，实现具体的操作
5. 释放连接

####具体实例
> 下面实现爬取京东书城上第一相页面关于Python书籍的ID、书名和价格，并将其存入到本地数据库的爬虫代码
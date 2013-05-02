####一.HttpListener
HttpListener用来监听到达的Http请求。

它通过start()方法，创建一个守护进程。

#####(一).创建ServerSocket
该进程会创建一个ServerSocket，然后监听相应的端口。

ServerSocket.setSoTimeout(xxx)，可以设置通过accept()方法等待Socket的超时时间，如果达到指定时间，则抛出
`java.net.SocketTimeoutException` 。

否则一直等待，直到有连接进入。

#####（二).处理Socket
通过ServerSocket.accept()获得Socket，然后调用ObjectPool.handleRequest(socket,httplistener)处理。

这一步主要的目的是从连接处理池中获得RequestHandlerThread，来处理请求。

#####（三）.RequestHandlerThread处理

######a.分配Request和Response
首先调用HttpListener的allocateRequestResponse来分配WinstoneRequest和WinstoneResponese，这两部分都是从ObjectPool这个池中拿出来的。

WinstoneRequest继承了HttpServletRequest 。

WinstoneResponese继承了HttpServletResponse 。


设置RequestHandlerThread的WinstoneRequest和WinstoneResponese。

######b.解析HTTP协议
然后，通过解析Http协议，来获得请求的URI和初始化WinstoneRequest的相关信息，如IP地址等。

解析的同时，解析出HTTP协议头（第一行为method,uri和version，第二行开始，正常的header为用:分割的行）。

######c.分发Request
接着根据URI获得WebAppConfiguration，然后获得初始化的RequestDispatcher,并调用forward()方法。

`javax.servlet.RequestDispatcher`接口定义了容器分发Request的行为。

包括：forward()和include()两种。


forward()方法中会调用ServletConfiguration的excute()方法,excute()方法获得Servlet的实例，然后执行service()方法。从而完成请求。


其中ServletConfiguration是在Winstone启动的时候初始化的，保存了servlet的基本信息。

winstone初始化的时候，会指定winstone.StaticResourceServlet为默认的Servlet，如果URL映射不到任何servlet，则将此作为静态资源处理。

#####其它
HttpListener实现了接口Listener和Thread


ObjectPool里面有RequestHandlerThread的池，用于处理请求。

HttpListener实现：

1.	run()方法：初始化ServerSocket;接收Socket;调用ObjectPool的handleRequest方法处理Socket。
2.	boolean start:启动HttpListener线程。
3.	allocateRequestResponse()分配request请求
4.	deallocateRequestResponse()回收request请求
5.	parseURI()解析URI
6.	releaseSocket()释放socket
7.	processKeepAlive()处理长连接


WinstoneInputStream 继承了 javax.servlet.ServletInputStream 

其中 javax.servlet.ServletInputStream  定义了读取一行的方法：

 
 	public int readLine(byte[] b, int off, int len)



请求解析：
从socket.inputStream中按行读取，
第一行是GET /xx 协议。
之后都是header。
如果解析不到header后，进行下一步操作。



package Callables;

import java.util.concurrent.*;

/*
    实现Callable接口：（案例：多线程下载网图）
        1、实现Callable接口，需要返回值类型
        2、重写call方法，需要抛出异常
        3、创建目标对象
        4、创建执行服务：
        5、提交执行：
        6、获取结果：
        7、关闭服务：
 */
public class CallableDemo implements Callable<Boolean> {
    private String url;//网络图片地址
    private String path;//保存的文件名

    public CallableDemo(String url, String path){
        this.url = url;
        this.path = path;
    }
    //下载图片线程的执行体
    @Override
    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, path);
        System.out.println("下载了图片：" + path);
        return true;
    }

    //主函数
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CallableDemo c1 = new CallableDemo("","");
        CallableDemo c2 = new CallableDemo("","");
        CallableDemo c3 = new CallableDemo("","");
        //创建执行服务
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> r1 = service.submit(c1);
        Future<Boolean> r2 = service.submit(c2);
        Future<Boolean> r3 = service.submit(c3);
        //获取执行结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);
        //关闭服务
        service.shutdown();
    }
}

//图片下载器
class WebDownloader{

    public void downloader(String url, String path){
    }

}

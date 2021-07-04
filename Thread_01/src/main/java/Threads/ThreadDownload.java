package Threads;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

//多线程同步下载网络图片
public class ThreadDownload extends Thread {
    private String url;
    private String path;

    public ThreadDownload(String url, String path){
        this.url = url;
        this.path = path;
    }

    @Override
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.downloader(url, path);
        System.out.println("下载了文件名：" + path);
    }

    //主函数
    public static void main(String[] args) {
        ThreadDownload t1 = new ThreadDownload("https://img2.baidu.com/it/u=644069964,3935661324&fm=15&fmt=auto&gp=0.jpg","Thread_01/src/main/java/images/1.jpg");
        ThreadDownload t2 = new ThreadDownload("https://img1.baidu.com/it/u=2584696831,1864562584&fm=15&fmt=auto&gp=0.jpg","Thread_01/src/main/java/images/2.jpg");
        ThreadDownload t3 = new ThreadDownload("https://img2.baidu.com/it/u=3532676088,826791039&fm=26&fmt=auto&gp=0.jpg","Thread_01/src/main/java/images/3.jpg");
        t1.start();
        t2.start();
        t3.start();
    }

}

//下载器
class WebDownloader{
    //下载方法
    public void downloader(String url, String path){
        try {
            FileUtils.copyURLToFile(new URL(url), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

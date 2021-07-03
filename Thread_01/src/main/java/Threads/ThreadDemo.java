package Threads;

/*
    创建线程方式一：
        1、继承Thread类
        2、重写run()方法
        3、调用start()开启线程
 */
public class ThreadDemo extends Thread {

    @Override
    public void run() {
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看动漫" + i);
        }
    }

    //主线程
    public static void main(String[] args) {
        //创建一个线程对象
        ThreadDemo threadDemo = new ThreadDemo();
        threadDemo.start();//调用start()开启线程

        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习" + i);
        }
    }

}

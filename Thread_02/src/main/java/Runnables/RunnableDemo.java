package Runnables;

/*
    创建线程方式2：
        1、实现Runnable接口；
        2、重写run方法，编写线程执行体；
        3、创建线程对象，调用start()方法启动线程；
 */
public class RunnableDemo implements Runnable {

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
        RunnableDemo threadDemo = new RunnableDemo();
        //等价于：new Thread(threadDemo).start();
        Thread thread = new Thread(threadDemo);//创建线程对象，通过线程对象开启线程（代理）
        thread.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("我在学习" + i);
        }
    }

}

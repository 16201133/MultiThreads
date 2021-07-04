package Runnables;

/*
    初识并发问题（例子：火车抢票）
 */
public class ConcurrentProblem implements Runnable {
    private int ticket = 10;//票数

    @Override
    public void run() {
        while (true){
            if (ticket <= 0)
                break;
            //模拟延时
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第" + ticket-- + "号票");
        }
    }


    public static void main(String[] args) {
        ConcurrentProblem ticketThread = new ConcurrentProblem();
        //三个人并发抢票
        new Thread(ticketThread, "张三").start();
        new Thread(ticketThread, "李四").start();
        new Thread(ticketThread, "刘浩存").start();
    }
}

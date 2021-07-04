package Runnables;

/*
    龟兔赛跑案例
 */
public class RaceDemo implements Runnable {
    //胜利者
    private static String winner;
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {//龟兔百米赛跑
            //模拟兔子睡觉
            if (Thread.currentThread().getName().equals("兔子") && i%10==0) {//没十米休息10ms
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //判断比赛比赛是否结束
            boolean flag = gameOver(i);
            if (flag)
                break;
            System.out.println(Thread.currentThread().getName() + "跑了" + i + "米");
        }
    }

    //判断比赛是否结束
    public boolean gameOver(int steps){
        //判断是否有胜利者
        if (winner != null){
            return true;
        }{
            if (steps >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("Winner is " + winner);
                return true;
            }
        }
        return false;
    }

    //主函数
    public static void main(String[] args) {
        RaceDemo raceDemo = new RaceDemo();
        new Thread(raceDemo, "兔子").start();
        new Thread(raceDemo, "乌龟").start();
    }
}

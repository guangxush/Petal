package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class TwoTask implements Runnable{

    /**
     * 等待的线程
     */
    private Thread thread;

    /**
     * 等待第一个任务线程死亡再打印数字2
     */
    @Override
    public void run() {
        // 等待该线程死亡
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("2");
    }

    /**
     * 设置需要等待的线程
     * @param thread
     */
    public void setThread(Thread thread) {
        this.thread = thread;
    }
}

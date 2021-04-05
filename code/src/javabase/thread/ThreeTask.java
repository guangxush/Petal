package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class ThreeTask implements Runnable{

    /**
     * 等待的线程
     */
    private Thread thread;

    @Override
    public void run() {
        // 等待该线程死亡
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("3");
    }

    public void setThread(Thread thread) {
        this.thread = thread;
    }
}

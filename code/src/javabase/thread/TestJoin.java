package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class TestJoin {
    public static void main(String[] args) {
        // 创建三个任务
        OneTask oneTask = new OneTask();
        TwoTask twoTask = new TwoTask();
        ThreeTask threeTask = new ThreeTask();

        // 创建三个线程
        Thread oneThread = new Thread(oneTask);
        Thread twoThread = new Thread(twoTask);
        Thread threeThread = new Thread(threeTask);

        // 设置需要等待的线程
        twoTask.setThread(oneThread);
        threeTask.setThread(twoThread);

        // 启动线程
        oneThread.start();
        twoThread.start();
        threeThread.start();
    }
}

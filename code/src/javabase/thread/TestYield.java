package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class TestYield {
    public static void main(String[] args) {
        // 创建任务
        PrintTask printTask = new PrintTask();
        ValueTask valueTask = new ValueTask();

        // 创建线程
        Thread printThread = new Thread(printTask);
        Thread valueThread = new Thread(valueTask);

        // 启动线程
        printThread.start();
        valueThread.start();
    }
}

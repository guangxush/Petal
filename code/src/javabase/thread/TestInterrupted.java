package javabase.thread;

/**
 * @author: guangxush
 * @create: 2021/04/05
 */
public class TestInterrupted implements Runnable {

    @Override
    public void run() {
        while(true){
            Thread thread = Thread.currentThread();
            if(thread.isInterrupted()){
                break;
            }
            System.out.println("正在执行");
        }
    }
}

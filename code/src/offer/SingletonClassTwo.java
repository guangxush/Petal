package offer;

/**
 * @author: guangxush
 * @create: 2019/07/07
 * 懒汉式单例模式
 */
public class SingletonClassTwo {
    private static SingletonClassTwo instance = null;
    private SingletonClassTwo(){

    }
    public synchronized static SingletonClassTwo getInstance(){
        if(instance==null){
            instance = new SingletonClassTwo();
        }
        return instance;
    }
}

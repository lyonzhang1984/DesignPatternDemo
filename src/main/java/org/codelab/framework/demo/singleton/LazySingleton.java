package org.codelab.framework.demo.singleton;
/**
 * @author Admin
 * 懒汉式单例模式,也称为延迟加载法
 *   延迟加载法在适用于单线程环境，它不是线程安全的，引入多线程时，就必须通过同步来保护getInstance（）方法，
 * 否则可能会返回LazySingleton的两个不同实例。
 *   比如，一个线程在判断instance为null后，还没来得及创建新的instance，
 * 另一个线程此时也判断到instance为null，这样两个线程便会创建两个LazySingleton实例。
 * 
 * 优点：资源利用率高,不执行getInstance就不会被实例。
 * 缺点：第一次加载时反应不快，多线程使用不必要的同步开销大
 */
public class LazySingleton {
	private static LazySingleton instance;

	private LazySingleton() {
	}

	//The first one
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
	
    //the second one
    public static synchronized LazySingleton getSafetyInstance() {               
        if (instance == null) {                         
            instance = new LazySingleton();             
        }  
        return instance;                                        
    }  

	public static void main(String[] args) {
		System.out.println("The demo for LazySingleton.");
		LazySingleton instance = LazySingleton.getInstance();
		System.out.println("The instance: "+instance);
		LazySingleton safetyInstance = LazySingleton.getSafetyInstance();
		System.out.println("The safety safetyInstance: "+safetyInstance);
		System.out.println("OK.");
	}

}

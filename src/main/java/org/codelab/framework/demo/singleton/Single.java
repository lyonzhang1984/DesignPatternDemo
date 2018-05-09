package org.codelab.framework.demo.singleton;
/**
 * NO.1
 * @author Lyonzhang1984
 * 饿汉式单例模式
 * 优点：线程安全，调用时反应速度快，在类加载的同时已经创建好了一个静态对象（创建的唯一对象）
 * 缺点：资源利用效率不高，可能该实例并不需要，但也被系统加载了。
 *     另外，饿汉式在一些场景下是无法使用的，比如，如果Single实例的创建依赖参数或配置文件，
 *     则在getInstance()之前必须调用某个方法来设置这些参数，但在设置之前，
 *     可能已经new了Single实例，这种情况下，饿汉式的写法是无法使用的。
 */
public class Single {
	private Single() {
		System.out.println("Private structure method.");
	}

	private static Single instance = new Single();

	public static Single getInstance() {
		return instance;
	}

	public static void main(String[] args) {
		System.out.println("The demo for Single.");
		Single instance = Single.getInstance();
		System.out.println("The instance: "+instance);
		System.out.println("OK.");
	}

}

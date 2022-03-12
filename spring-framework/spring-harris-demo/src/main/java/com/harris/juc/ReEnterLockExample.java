package com.harris.juc;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: 可重入锁示例
 * @date 2022/2/17 15:42
 * <p>
 *     可重入锁：可重复可递归调用的锁，在外层使用锁之后，在内存仍然可以使用，并且不会发生死锁，这样的锁就叫做可重入锁。
 *     在一个synchronized修饰的方法或代码块的内部，调用本类的其他synchronized修饰的方法或代码块时，是永远可以得到锁的。
 * </p>
 */
public class ReEnterLockExample {

	static Object object1 = new Object();

	static Object object2 = new Object();

	public static void testSynchronized () {
	    new Thread(() -> {
			synchronized (object2) {
				System.out.println(Thread.currentThread().getName() + "\t 外层调用");
				synchronized (object1) {
					System.out.println(Thread.currentThread().getName() + "\t 中层调用");
					synchronized (object1) {
						System.out.println(Thread.currentThread().getName() + "\t 内层调用");
					}
				}
			}
		}, "testSynchronized").start();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 2; i++) {
			new Thread(() -> {
				testSynchronized();
			}).start();
		}

	}
}

package com.harris.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: AQS示例Demo
 * @date 2022/2/18 12:16
 */
public class AqsExample {
	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();

		new Thread(() -> {
			lock.lock();
			try {
				System.out.println(Thread.currentThread().getName() + " 执行....");
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}, "threadA").start();
	}
}

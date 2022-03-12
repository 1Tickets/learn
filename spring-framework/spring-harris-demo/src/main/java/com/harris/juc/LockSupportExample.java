package com.harris.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Harris
 * @version 1.0
 * @ClassName: spring
 * @Description: LockSupport测试
 * @date 2022/2/18 10:00
 */
public class LockSupportExample {
	public static void main(String[] args) {
		Thread one = new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "\t 线程进入....");
			LockSupport.park();
			System.out.println(Thread.currentThread().getName() + "\t 线程唤醒....");
		}, "one");
		one.start();

		try {
			Thread.sleep(3L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		Thread two = new Thread(() -> {
			LockSupport.unpark(one);
			System.out.println(Thread.currentThread().getName() + "\t 线程通知....");
		}, "two");
		two.start();
	}
}

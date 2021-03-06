package com.zcx.test.busi.Learn.JavaSenior.threads.threadsynchronize;

/**
 * <p>
 * 使用同步方法解决继承Thread线程安全问题
 * 创建三个窗口卖票，总票数为100（使用实现Runnable接口的方式实现）
 * </p>
 *
 * <p>
 * 问题：
 * 卖票过程中，出现了重票、错票 ——>出现了线程的安全问题
 * 问题出现的原因：
 * 当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 如何解决：
 * 当一个线程a在操作ticket的时候，其他线程不能参与进来，直到线程a操作完ticket时，其他线程才可以操作ticket。
 * 这种情况即使线程a出现了阻塞，也不能被改变。
 * 在Java中，我们通过同步机制，来解决线程安全问题
 * </p>
 *
 * @author : Yuki Judai 2022/3/9 13:35
 */
public class ThreadSynchronize4 {
    public static void main(String[] args) {
        MyWindow4 t1 = new MyWindow4();
        MyWindow4 t2 = new MyWindow4();
        MyWindow4 t3 = new MyWindow4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class MyWindow4 extends Thread {

    private static int ticket = 100;

    @Override
    public void run() {
        boolean flag = true;
        while (flag) {
            flag = show();
        }
    }

    //同步监视器：MyWindow4.class
    private static synchronized boolean show() {
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为" + ticket);
            ticket--;
            return true;
        }

        return false;
    }
}
package com.zcx.test.busi.Learn.DesignModel.template;

/**
 * 设计模式——模板方法
 *
 * @author : Yuki Judai 2022/3/3 10:01
 */
public class TemplateTest {
    public static void main(String[] args) {
        Template t = new SubTemplate();
        t.spendTime();
    }
}

abstract class Template {
    //计算某段代码执行所需要花费的时间
    public void spendTime() {
        long start = System.currentTimeMillis();
        code();
        long end = System.currentTimeMillis();

        System.out.println("花费的时间:" + (end - start));
    }

    public abstract void code();
}

class SubTemplate extends Template {

    @Override
    public void code() {
        for (int i = 2; i <= 1000; i++) {
            boolean isFlag = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isFlag = false;
                    break;
                }
            }

            if (isFlag) {
                System.out.println(i);
            }
        }
    }
}
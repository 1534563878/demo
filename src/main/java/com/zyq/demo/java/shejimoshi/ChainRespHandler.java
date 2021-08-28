package com.zyq.demo.java.shejimoshi;
/*
    责任链模式,
  根据等级处理事务
 */
public class ChainRespHandler {
    public static void main(String[] args) {
        Handler handler1 = new Leader();
        Handler handler2 = new Boss();
        handler1.setNextHandler(handler2);

        handler1.process(11);
    }
}
abstract class Handler{
    protected Handler nextHandler;

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
    public abstract void process(Integer info);
}
class Leader extends Handler{

    @Override
    public void process(Integer info) {
        if (info>0&&info<10){
            System.out.println("learder 处理");
        } else {
            nextHandler.process(info);
        }
    }
}
class Boss extends Handler{
    @Override
    public void process(Integer info) {
        System.out.println("boss ");
    }
}
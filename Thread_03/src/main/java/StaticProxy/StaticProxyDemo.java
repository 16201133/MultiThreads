package StaticProxy;

/*
    静态代理模式
 */
public class StaticProxyDemo {

    public static void main(String[] args) {
        //1、代理模式
        System.out.println("1、代理模式");
        new WeddingCompany(new Person()).HappyMarry();
        //2、Thread方式
        System.out.println("2、Thread方式");
        new Thread(() -> System.out.println("ZP_Coder进行婚礼")).start();//使用Lamda表达式
    }

}

interface Marry{
    void HappyMarry();
}

//真实对象
class Person implements Marry{

    @Override
    public void HappyMarry() {
        System.out.println("ZP_Coder进行婚礼");
    }
}

class WeddingCompany implements Marry{
    private Marry target;//真实对象
    public WeddingCompany(Marry target){
        this.target = target;
    }
    @Override
    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("收拾婚礼现场");
    }

    private void before() {
        System.out.println("布置婚礼现场");
    }
}

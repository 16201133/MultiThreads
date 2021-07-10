package Lambda;

/*
    Lambda表达式的演化过程
        1、函数式接口的实现
        2、静态内部类
        3、局部内部类
        4、匿名内部类，没有类名，必须借助接口或父类
        5、Lambda简化
 */
public class LambdaDemo {

    //2、静态内部类
    static class MyLike2 implements ILike{
        @Override
        public void lambda(String name, int num) {
            System.out.println("I Like " + name + num);
        }
    }

    public static void main(String[] args) {

        //1、函数式接口  调用
        ILike myLike = new MyLike1();
        myLike.lambda("Lambda", 1);
        //2、静态内部类  调用
        myLike = new MyLike2();
        myLike.lambda("Lambda",2);
        //3、局部内部类  调用
        class MyLike3 implements ILike{
            @Override
            public void lambda(String name, int num) {
                System.out.println("I Like " + name + num);
            }
        }
        myLike = new MyLike3();
        myLike.lambda("Lambda",3);
        //4、匿名内部类  调用（匿名内部类，没有类名，必须借助接口或父类）
        myLike = new ILike() {
            @Override
            public void lambda(String name, int num) {
                System.out.println("I Like " + name + num);
            }
        };
        myLike.lambda("Lambda",4);
        //5、Lambda简化  调用
        myLike = (name, num) -> {
            System.out.println("I Like " + name + num);
        };
        myLike.lambda("Lambda",5);
        //Lambda如果只有一行代码可以做到更加精简，多行必须使用代码块
        myLike = (name, num) -> System.out.println("I Like " + name + num);
        myLike.lambda("Lambda",6);
    }

}

//1、定义函数式接口（函数式接口的定义：任何接口，如果只包含唯一一个抽象方法，那么它就是一个函数式接口）
interface ILike{
    void lambda(String name, int num);
}
//函数式接口的实现
class MyLike1 implements ILike{

    @Override
    public void lambda(String name, int num) {
        System.out.println("I Like " + name + num);
    }
}
package cn.sxt.oo2;
public class TestSuper02 { 
    public static void main(String[] args) {
        System.out.println("��ʼ����һ��ChildClass����......");
        new ChildClass2();
    }
}
class FatherClass2 {
    public FatherClass2() {
        System.out.println("����FatherClass");
    }
}
class ChildClass2 extends FatherClass2 {
    public ChildClass2() {
        System.out.println("����ChildClass");
    }
}
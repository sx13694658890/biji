import src.pojiao.Test01;
import src.pojiao.Test02;

public class Test001 {
    public static void main(String[] args) {
        
        Test01 test02=new Test02();
        Test02 test03=(Test02)test02;
        test03.doSomethingNew();
        System.out.println(test03 instanceof Test01);
        test03.take();
    }
}

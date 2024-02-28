package src.pojiao;



interface OutlineFace{
    public void f();
    public void inf();
}
public class Test02 extends Test01 {
    private int num=10;
    OutlineFace in=new InnerClass("内部类");
    public void ouf(){
        in.inf();
    }    
    public class InnerClass implements OutlineFace{
        private int y=0;
        InnerClass(String str){
            System.out.println(str);
        }
        public void inf(){
            System.out.println(Test02.this.num);
        }

        @Override
        public void f() {
            // TODO
            System.out.println(this.y);
        }
    }
    public OutlineFace doit(){
        return new InnerClass("内部类");
    }
    public Test02(){
        super();
        super.doSomething();
    }
    public void doSomethingNew(){
        System.out.println("aaa"+getClass().getName());
       
    }
    public void  take(){
        try {
            String str="ie";
            System.out.println(str);
            int age=Integer.parseInt("20L");
            System.out.println(age);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    protected Test02 dolt(){
        return this;
    }
}

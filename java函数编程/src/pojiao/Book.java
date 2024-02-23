package src.pojiao;

public class Book {
    static {

    }
    final static double PI=3.1415;
    static int ids;
    private String name;
    private int id=0;
    public static void method1(){
        //
        System.out.println(Book.PI);

        // System.out.println("静态方法");
    }
    public String getName(){
       
        setName("java"+ id++);
       
        return id+this.name;
    }
    public Book(){
        // this("name");
        // System.out.println("无参数构造");
    }
    public Book(String name){
        System.out.println("有参数构造");
    }
    private void setName(String name){
        this.name=name;
    }
    public Book getBook(){
        return this;
    }
    public void  test(){
        String str[]={"89","12","10"};
        int sum=0;
        for(int i=0;i<str.length;i++){
            int myInt=Integer.parseInt(str[i]);
            sum+=myInt;
        }
        System.out.println(sum);
        
        
    }
    
}

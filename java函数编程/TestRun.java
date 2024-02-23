import src.pojiao.Book;
import src.pojiao.Price;

public class TestRun {
    public static void main(String[] args) {
        Book book1=new Book();
        Book book2=new Book();
        System.out.println(book1==book2);
        System.out.println(book1.equals(book2));
        book1.test();
        
        System.out.println("-------------");
        // System.out.println(book1.getName());
        // System.out.println(book1.getName());
        // System.out.println(book1.getBook());
        // Book.method1();
        Price price=new Price();
        price.simpleFormat("###.###",123456.789);
        price.math(Math.PI/6);
        System.out.println(Math.ceil(5.2));
        System.out.println(price.random(2, 10));
        price.big();
    }
}

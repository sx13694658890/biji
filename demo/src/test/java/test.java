import utils.FileInputAndOutput;

public class test {
    public static void main(String[] args) {
        FileInputAndOutput file=new  FileInputAndOutput("world.text");
      
        file.write("hello");
        file.read();
    }
}


import java.sql.Date;
import java.util.Arrays;

/**
 * byte 
 * short 
 * int 
 * long
 */
public class Hello{
    public static String say="hello world";
    static long num=134324123L;
    int num1=12388;
    short num2=488;
    static String str="hel,lo w,orld";
    public static void main(String[] args) {
        String a;
        String regex="\\w+@\\w+(\\.\\w{2,3})*\\.\\w{2,3}";
        String s1="aaa@11.cee";
        Date date=new Date(System.currentTimeMillis());
        char c[]={'g','o','d'};
        a=new String(c,0,3);
        System.out.println("作者："+say);
        System.out.println(a);
       
        // for(String s:str.split("\\,",3)){
        //     System.out.print(s);
        // }
        System.out.println(String.format("%tF", date));
        System.out.println(s1.matches(regex));
        String str="";
        long startTime=System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            str=str+i;
        }
        long endTime=System.currentTimeMillis();
        long time=startTime-endTime;
        System.out.println("耗时："+time);
        startTime=System.currentTimeMillis();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<10000;i++){
            sb.append(i);
        }
        endTime=System.currentTimeMillis();
        time=startTime-endTime;
        System.out.println("耗时stringBuilder："+time);
        StringBuilder bf=new StringBuilder("hello");
        // bf.delete(0, 3);
       
        int myArr[]={4,5,6,1};
        Arrays.sort(myArr);
        int newArr[]=Arrays.copyOfRange(myArr,0,5);
        System.out.println(newArr);
        for(int aa:newArr){
            System.out.println(aa);
        }
        System.out.println(Arrays.binarySearch(myArr, 2,3,4));
        Hello hello=new Hello();
        hello.selectSort(myArr);
    }
    public void selectSort(int[] array){
            int index;
            for(int i=1;i<array.length;i++){
                index=0;
                for(int j=1;j<array.length-i;j++){
                    if(array[index]<array[j]){
                        index=j;
                    }

                }
                int temp=array[array.length-i];
                array[array.length-i]=array[index];
                array[index]=temp;
            }
    }

}
    
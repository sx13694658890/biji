package src.pojiao;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Random;

public class Price {
        public void simpleFormat(String pattern,double value){
            DecimalFormat format=new DecimalFormat();
            format.setGroupingSize(3);
            format.setGroupingUsed(false);
            String output=format.format(value);
            System.out.println(output);
        }
        /**
         * 
         * @param angle 角度
         */
        public void math(double angle){
        //    1°等于π/180弧度
            System.out.println(Math.sin(angle));
            
        }
        public int random(double num1,double num2){
            int num=(int)(Math.random()*(num2-num1)+num1);
          
            Random r=new Random();



            return r.nextInt(10);
        }
       
        public void big(){
            BigDecimal bd1=new BigDecimal(Double.toString(100.0));
            BigInteger bi1=new BigInteger("2");
            BigInteger bi2=new BigInteger("5");
            BigInteger bi3=new BigInteger("6");
            // bi1.multiply(bi2);
            System.out.println(bi2.divideAndRemainder(bi1)[1]);;
        }
}

//随机产生验证码
package 面向对象电影;

import java.util.Random;

public class String案例2 {
    public static void main(String[] args) {
        System.out.println(code(5));
    }
    //设计一个方法，返回指定位数的验证码。
    public static String code(int n){
        String code = "";
        String data ="qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM123456789";
        Random r =new Random();
        for (int i = 0; i <n; i++) {
            int index = r.nextInt(data.length());
            code+= data.charAt(index);
        }
        return code;
    }
}

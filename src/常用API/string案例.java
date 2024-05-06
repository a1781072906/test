//用String模拟登陆界面
import java.util.Scanner;

import java.util.Scanner;

public class string案例 {
    public static void main(String[] args) {
        //三次循环，错误之后再填写。
        for (int i=0;i<3;i++) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入账号");
            String name=sc.next();
            System.out.println("请输入密码");
            String password = sc.next();
            boolean rs =login(name,password);
            if(rs){
                System.out.println("恭喜你登陆成功");
                break;
            }else{
                System.out.println("账号或者密码错误，请再试一次");
            }
        }
    }

    //验证账号密码，返回结果
    public static boolean login(String name,String password){
        String OKloginname ="user";
        String OKpassword ="pass";
        if(name.equals(OKloginname)&& password.equals(OKpassword)){
            return  true;
        }else{
            return false;
        }
    }
}

package 常用API.外卖系统;

import java.util.ArrayList;
import java.util.Scanner;

//菜品操作
public class FoodOperator {
    ArrayList<Food> foodlist = new ArrayList<>();

    public void addfood() {
        Food food = new Food();
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入菜品名称");
        String name = sc.next();
        food.setName(name);

        System.out.println("请输入菜品价格");
        Double price = sc.nextDouble();
        food.setPrice(price);

        System.out.println("请输入菜品名称");
        String desc = sc.next();
        food.setDesc(desc);
        foodlist.add(food);
        System.out.println("上传成功");
    }
    public void showAllFood(){
        for (int i = 0; i < foodlist.size(); i++) {
            Food food = foodlist.get(i);
            System.out.println(food.getName()+","+food.getPrice()+","+food.getDesc());
        }
    }
    //展示操作界面
    public void start(){
        while (true) {
            System.out.println("请选择您要进行的操作：");
            System.out.println("1.上架菜品");
            System.out.println("2.展示菜品");
            System.out.println("3.退出");
            Scanner sc =new Scanner(System.in);
            String command =sc.next();
            switch(command){
                case "2":
                    showAllFood();
                    break;
                case "1":
                    addfood();
                    break;
                case"3":
                    System.out.println("再见");
                    return;
                default:
                    System.out.println("输错了");
            }
        }
    }
}
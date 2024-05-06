package ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ATM {
    private ArrayList<Account> accounts = new ArrayList<>();
    private Account loginAcc;
    private Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("欢迎进入到ATM系统");
            System.out.println("1.用户登录");
            System.out.println("2.用户开户");
            System.out.println("请选择：");
            int command = sc.nextInt();
            switch (command) {
                case 1:
                    //登录
                    login();
                    break;
                case 2:
                    //开户
                    createAccount();
                    break;
                default:
                    System.out.println("您的输入有误");
            }
        }
    }
//登录功能
    private void login(){
        System.out.println("系统登录");
        //判断系统中是否有账户，存在才能登陆。
        if(accounts.size() == 0) {
            System.out.println("当前系统中无任何账户，请先开户再来登录");
           return;
        }
        while (true) {
            System.out.println("请您输入卡号");
            String cardID =sc.next();
            Account acc=getAccountByCardId(cardID);
            if(acc==null){
                System.out.println("您输入的卡号不存在，请检查后再次输入");
            }else{
                while (true) {
                    System.out.println("请您输入密码");
                    String passWord =sc.next();
                    if(acc.getPassWord().equals(passWord)){
                        //正确
                        loginAcc =acc;
                        System.out.println("恭喜您登陆成功。");
                        //展示登陆后的操作界面
                        showUserCommand();
                        return;

                    }else{
                        System.out.println("您输入的密码不正确，请重新输入。");
                    }
                }
            }
        }
    }
    //展示登录界面
    private void showUserCommand(){
        while (true) {
            System.out.println(loginAcc.getUserName()+"请选择如下功能");
            System.out.println("1.查询账户");
            System.out.println("2.存款");
            System.out.println("3.取款 ");
            System.out.println("4.转账 ");
            System.out.println("5.密码修改");
            System.out.println("6.退出 ");
            System.out.println("7.注销账号");
            int command = sc.nextInt();
            switch (command){
                case 1://查询
                    showloginAccount();
                    break;
                case 2://存款
                    saveMoney();
                    break;
                case 3://取款
                    drawMoney();
                    break;
                case 4://转账
                    transferMoney();
                    break;
                case 5://密码修改
                    updatePassWord();
                    return;
                case 6://退出
                    System.out.println(loginAcc.getUserName());
                    return;
                case 7://注销
                    deleteAccount();
                    if(deleteAccount()){
                        return;
                    }
                    break;
                default:
                    System.out.println("您的输入有误，请重新输入。");

            }
        }
    }

    private void updatePassWord() {
        while (true) {
            System.out.println("您当前正在修改密码");
            System.out.println("请输入当前账户密码");
            String PassWord=sc.next();
            if(loginAcc.getPassWord().equals(PassWord)){
                while (true) {
                    System.out.println("请您输入新密码");
                    String newPassWord =sc.next();
                    System.out.println("请您确认新密码");
                    String okPassWord =sc.next();
                    if(okPassWord.equals(newPassWord)){
                        loginAcc.setPassWord(okPassWord);
                        return;
                    }else{
                        System.out.println("您输入的两次密码不一致");
                    }
                }
            }else{
                System.out.println("您输入的密码不正确");
            }
        }

    }

    private boolean deleteAccount() {
        System.out.println("你正在操作销户，请注意!!");

        System.out.println("您确定要销户吗？y/n");
        String command =sc.next();
        switch (command){
            case"y":
                //销户
                if(loginAcc.getMoney()==0){
                    //销户
                    accounts.remove((loginAcc));
                    return true;
                }else{
                    System.out.println("您的帐户中还有余额");
                    return false;
        }
        }
        return false;
    }

    //转账
    private void transferMoney() {;
        System.out.println("您当前正在转账");
        if(accounts.size()<2){
            System.out.println("当前系统中账户数不足，无法转账");
            return;
        }
        if(loginAcc.getMoney()==0){
            System.out.println("您的余额不足");
            return;
        }
        while (true) {
            System.out.println("请输入对方的卡号");
            String cardId=sc.next();
            Account acc =getAccountByCardId(cardId);
            if(acc==null){
                System.out.println("您输入的卡号不正确，请重新输入");
            }else{
                //对方账户存在
                String name='*'+acc.getUserName().substring(1);
                System.out.println("请您输入对方的姓氏"+name);
                String preName =sc.next();
                if (acc.getUserName().startsWith(preName)){
                    while (true) {
                        System.out.println("请您输入转账金额");
                        double money = sc.nextDouble();
                        if(loginAcc.getMoney()>=money){
                            loginAcc.setMoney(loginAcc.getMoney()-money);
                            acc.setMoney(acc.getMoney()+money);
                            System.out.println("转账成功，您的当前余额为"+loginAcc.getMoney()+"元");
                            return;
                        }else{
                            System.out.println("您的余额不足，转账失败。您的当前余额为"+loginAcc.getMoney());
                        }
                    }
                }else{
                    System.out.println("对不起，您输入的姓名有误");
                }

            }
        }
    }

    private void drawMoney(){
        System.out.println("您当前正在取钱");
        if(loginAcc.getMoney()<100){
            System.out.println("您的账户余额不足100元，无法取款");
            return;
        }
        System.out.println("请输入取款金额");
        while (true) {
            Double money=sc.nextDouble();
            if(loginAcc.getMoney()>=money){
                if(money>loginAcc.getLimit()){
                    System.out.println("超出限额，限额为"+loginAcc.getLimit()+"元");
                }else{
                    loginAcc.setMoney(loginAcc.getMoney()-money);
                    System.out.println("您取款"+money+"元成功，当前余额为"+loginAcc.getMoney());
                }
            }else{
                System.out.println("余额不足,您的当前余额为"+loginAcc.getMoney());
            }
        }

    }

    //存钱
    private void saveMoney() {
        System.out.println("你正在进行存钱操作");
        System.out.println("请您输入存款金额");
        Double money =sc.nextDouble();
        loginAcc.setMoney(loginAcc.getMoney()+money);
        System.out.println("存款成功，本次您共存款"+money+"元，当前余额为"+loginAcc.getMoney()+"元");

    }

    //查询方法
    private void showloginAccount(){
        System.out.println("当前账户信息：");
        System.out.println("卡号"+loginAcc.getCardId());
        System.out.println("户主"+loginAcc.getUserName());
        System.out.println("性别"+loginAcc.getSex());
        System.out.println("余额"+loginAcc.getMoney());
        System.out.println("限额"+loginAcc.getLimit());
    }
    //开户功能
    private void createAccount() {
        Account acc = new Account();
        System.out.println("请输入您的账户名称");
        String name = sc.next();
        acc.setUserName(name);

        while (true) {
            System.out.println("请输入您的性别");
            char sex = sc.next().charAt(0);
            if (sex == '男' || sex == '女') {
                acc.setSex(sex);
                break;

            } else {
                System.out.println("您输入的性别有误");
            }
        }
        while (true) {
            System.out.println("请输入您的账户密码");
            String passWord = sc.next();
            System.out.println("请再次输入您的账户密码");
            String OkPassWord = sc.next();
            if (passWord.equals(OkPassWord)) {
                acc.setPassWord(passWord);
                break;
            } else {
                System.out.println("您两次输入的密码不一致");
            }
        }
        System.out.println("请输入您的取现额度");
        Double limit = sc.nextDouble();
        acc.setLimit(limit);
        String cardId =createCardId();
        acc.setCardId(cardId);

        accounts.add(acc);
        System.out.println("恭喜您，" + acc.getUserName() + "开户成功。您的卡号是:"+acc.getCardId());

    }

    //生成卡号(8位)不重复
    private String createCardId() {
        while (true) {
            String cardID = "";
            Random r = new Random();
            for (int i = 0; i < 8; i++) {
                int data = r.nextInt(10);
                cardID += data;
            }
            Account acc = getAccountByCardId(cardID);
            if (acc == null) {
                return cardID;
            }
        }

    }

    //查询生成的卡号是否重复
    private Account getAccountByCardId(String cardId) {
        for (int a = 0; a < accounts.size(); a++) {
            Account acc = accounts.get(a);
            if (acc.getCardId().equals(cardId)) {
                return acc;
            }
        }
        return null;
    }
}

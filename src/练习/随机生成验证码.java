import java.util.Random;

public class 随机生成验证码 {
    public 随机生成验证码() {
    }

    public static void main(String[] args) {
        System.out.println(createcode(5));
    }

    public static String createcode(int n) {
        Random r = new Random();
        String code = "";
        int i = 1;

        while(i < n) {
            int type = r.nextInt(3);
            switch (type) {
                case 0:
                    code = code + r.nextInt(10);
                case 1:
                    char ch = (char)(r.nextInt(26) + 65);
                    code = code + ch;
                case 2:
                    char cw = (char)(r.nextInt(26) + 97);
                    code = code + cw;
                default:
                    ++i;
            }
        }

        return code;
    }
}

//计算飞机票折扣
public class 计算飞机票折扣 {
    public static void main(String[] args) {
        double price = calcuate(100, 10, "经济舱");
        System.out.println(price);
    }

    public static double calcuate(double price, int month, String type) {
        if (month >= 5 && month <= 10) {
            switch (type) {
                case "头等舱" -> price *= 0.9;
                case "经济舱" -> price *= 0.85;
            }
        } else {
            switch (type) {
                case "头等舱" -> price *= 0.7;
                case "经济舱" -> price *= 0.65;
            }
        }

        return price;
    }
}


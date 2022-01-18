/*Thầy Ba muốn có s cây bút để tặng cho học sinh của mình.

Ở cửa hàng bán bút CODEGYM đang có khuyến mãi như sau: Khi mua x cây bút sẽ được tặng y cây bút nữa.

Hãy đưa ra số bút tối thiểu mà Thầy Ba phải mua để thầy có đủ s cây bút.

Ví dụ:

Với x = 2, y = 1, s = 6, thì promotion(x,y,s) = 4.
Giải thích: Thầy Ba sẽ mua 4 cây bút như sau:
Mua 2 cây bút được khuyến mãi 1 cây -> tổng cộng thầy có 3 cây bút.
Mua thêm 2 cây bút được khuyến mãi 1 cây -> tổng cộng thầy có 6 cây bút.
Với x = 3, y = 2, s = 11, thì promotion(x,y,s) = 7.
Giải thích: Thầy Ba sẽ mua 7 cây bút như sau:
Mua 3 cây bút được khuyến mãi 2 cây -> tổng cộng thầy có 5 cây bút.
Mua thêm 3 cây bút được khuyến mãi 2 cây -> tổng cộng thầy có 10 cây bút.
Mua thêm 1 cây bút không cần khuyến mãi -> tổng cộng thầy có 11 cây bút.*/
public class TimSoBut {
    public static void main(String[] args) {
        int x = 1, y = 3, s=2, a,b,c;
        a = s / (x+y);
        b = s % (x+y);
        c = a*x + b;
        System.out.println(c);
    }
}

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
//    public static void main(String[] args) {
//        int x = 1, y = 3, s=2, a,b,c;
//        a = s / (x+y);
//        b = s % (x+y);
//        c = a*x + b;
//        System.out.println(c);
//    }
//}

    /*Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one of the arrays.
    Given two arrays a and b, check whether they are similar.
    Example
    • For a = [1, 2, 3] and b = [1, 2, 3], the output should be
    areSimilar(a, b) = true.
    The arrays are equal, no need to swap any elements.
    • For a = [1, 2, 3] and b = [2, 1, 3], the output should be
    areSimilar(a, b) = true.
    We can obtain b from a by swapping 2 and 1 in b.
    • For a = [1, 2, 2] and b = [2, 1, 1], the output should be
    areSimilar(a, b) = false.
    Any swap of any two elements either in a or in b won't make a and b equal.*/
    public static void main(String[] args) {
        int[] a = {1, 1, 3};
        int[] b = {3, 1, 1};
        List<Integer> integerListA= new ArrayList<>();
        for (int i = 0; i < a.length; i++) {
            integerListA.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < integerListA.size(); j++) {
                if (b[i] == integerListA.get(j)){
                    System.out.println("true");
                }
            }
        }
        System.out.println(integerListA);

    }

//    public static boolean xyz(int[] a, int[] b) {
//        if (a.length != b.length) {
//            return false;
//        } else {
//            for (int i = 0; i < a.length; i++) {
//                for (int j = 0; j < b.length; j++) {
//                    if (a[i] ==)
//                }
//        }
//    }
}


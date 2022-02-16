import java.util.ArrayList;
import java.util.List;

/*Người ta định nghĩa số vòng là một số tự nhiên mà mà chữ số đầu trùng với chữ số cuối của nó. Ví dụ 303, 101, 8, 88 là những số vòng.
Cho 2 số nguyên dương L, R, hãy đếm số lượng số vòng trong đoạn [L; R]
Ví dụ:
Với L = 9, R = 13 thì circle(L,R) = 2. Trong đoạn [9; 13] có 2 số vòng là 9 và 11*/
public class TimSoVong {
    public static void main(String[] args) {
        int count = 0;
        int L = 9;
        int R = 13;
        for (int i = L; i <= R; i++) {
            while (i > 0) {
                List<Integer> integerList = new ArrayList<>();
                integerList.add(i % 10);
                i = i /10;
            }
            for (int j = 0; j < i; j++) {

            }
        }
    }
}

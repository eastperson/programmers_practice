import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제 설명
 * 피보나치 수는 F(0) = 0, F(1) = 1일 때, 1 이상의 n에 대하여 F(n) = F(n-1) + F(n-2) 가 적용되는 수 입니다.
 *
 * 예를들어
 *
 * F(2) = F(0) + F(1) = 0 + 1 = 1
 * F(3) = F(1) + F(2) = 1 + 1 = 2
 * F(4) = F(2) + F(3) = 1 + 2 = 3
 * F(5) = F(3) + F(4) = 2 + 3 = 5
 * 와 같이 이어집니다.
 *
 * 2 이상의 n이 입력되었을 때, n번째 피보나치 수를 1234567으로 나눈 나머지를 리턴하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * * n은 1이상, 100000이하인 자연수입니다.
 *
 * 입출력 예
 * n	return
 * 3	2
 * 5	5
 * 입출력 예 설명
 * 피보나치수는 0번째부터 0, 1, 1, 2, 3, 5, ... 와 같이 이어집니다.
 */



public class FibonacciNumbers {
    public static void main(String[] args) {
        FibonacciNumbersSolution solution = new FibonacciNumbersSolution();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

        System.out.println(solution.solution(5));
    }
}

class FibonacciNumbersSolution {
    public int solution(int n) {
        List<BigInteger> list = new ArrayList<>();
        list.add(BigInteger.valueOf(0));
        list.add(BigInteger.valueOf(1));
        for(int i = 2; i <= n; i++){
            list.add(list.get(i-2).add(list.get(i-1)));
        }
        return (list.get(n).mod(BigInteger.valueOf(1234567L))).intValue();
    }
}
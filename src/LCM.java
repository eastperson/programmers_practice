import kotlin.jvm.internal.CollectionToArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 예를 들어 2와 7의 최소공배수는 14가 됩니다. 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 *
 * 제한 사항
 * arr은 길이 1이상, 15이하인 배열입니다.
 * arr의 원소는 100 이하인 자연수입니다.
 * 입출력 예
 * arr	result
 * [2,6,8,14]	168
 * [1,2,3]
 */

public class LCM {
    public static void main(String[] args) {
        LCMSolution solution = new LCMSolution();
        int[] numbers = {100,1,23,4,4,2,3,2,21,4};

        System.out.println(solution.solution(numbers));
    }
}

class LCMSolution {
    public int solution(int[] arr) {
        List<Long> list = Arrays.stream(arr).mapToLong(Long::valueOf).boxed().collect(Collectors.toList());
        while(list.size() != 1) {
            listLcm(list);
        }
        return list.get(0).intValue();
    }
    long gcd(long a, long b) {
        while(b!=0) {
            long r = a%b;
            a=b;
            b=r;
        }
        return a;
    }

    long lcm(long a, long b){
        return a * b / gcd(a,b);
    }

    void listLcm(List<Long> list){
        list.add(lcm(list.get(0),list.get(1)));
        list.remove(1);
        if(list.size()!=1)list.remove(0);
    }
}
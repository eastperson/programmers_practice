import java.util.Arrays;

/**
 * 문제 설명
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 *
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
 * 이중 가장 큰 수는 6210입니다.
 *
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로
 * 바꾸어 return 하도록 solution 함수를 작성해주세요.
 *
 * 제한 사항
 * numbers의 길이는 1 이상 100,000 이하입니다.
 * numbers의 원소는 0 이상 1,000 이하입니다.
 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
 */

public class BigNumber {
    public static void main(String[] args) {
        BigNumberSolution bigNumberSolution = new BigNumberSolution();
        int[] arr = {6,10,2};
        System.out.println(bigNumberSolution.solution(arr));
    }
}


class BigNumberSolution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] arr = new String[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }
        String[] sorted = new String[arr.length];
        for(int i = 0; i < arr.length; i++){
            for(int j = i; j < arr.length; j++) {
                if(1==compare(arr[i],arr[j],0)){
                    sorted[i] = arr[i];
                    arr[i] = "0";
                } else {
                    sorted[j] = arr[j];
                    arr[j] = "0";
                }
            }
        }
        String result = "";
        for(String s : sorted){
            result += s;
        }
        return result;
    }

    int compare(String a, String b,int idx){
        if (idx == a.length() && a.length() == b.length()) return 0;
        if(idx == a.length()){
            compare(a.substring(1,a.length()),b.substring(idx),0);
        } else if (idx == b.length()) {
            compare(b.substring(1,a.length()),a.substring(idx),0);
        }

        if(a.charAt(idx) > b.charAt(idx)) return 1;

        if (a.charAt(idx) == b.charAt(idx)) {
            compare(a,b,idx+1);
        }
        return -1;
    }

}

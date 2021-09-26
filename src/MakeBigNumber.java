import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 문제 설명
 * 어떤 숫자에서 k개의 수를 제거했을 때 얻을 수 있는 가장 큰 숫자를 구하려 합니다.
 *
 * 예를 들어, 숫자 1924에서 수 두 개를 제거하면 [19, 12, 14, 92, 94, 24] 를 만들 수 있습니다.
 * 이 중 가장 큰 숫자는 94 입니다.
 *
 * 문자열 형식으로 숫자 number와 제거할 수의 개수 k가 solution 함수의 매개변수로 주어집니다.
 * number에서 k 개의 수를 제거했을 때 만들 수 있는 수 중 가장 큰 숫자를 문자열 형태로 return 하도록
 * solution 함수를 완성하세요.
 *
 * 제한 조건
 * number는 1자리 이상, 1,000,000자리 이하인 숫자입니다.
 * k는 1 이상 number의 자릿수 미만인 자연수입니다.
 * 입출력 예
 * number	k	return
 * "1924"	2	"94"
 * "1231234"	3	"3234"
 * "4177252841"
 */

public class MakeBigNumber {
    public static void main(String[] args) {
        MakeBigNumberSolution makeBigNumberSolution = new MakeBigNumberSolution();
        String solution = makeBigNumberSolution.solution("4177252841", 4);
        System.out.println(solution);

    }
}

class MakeBigNumberSolution {

    public String solution(String number, int k) {
        String answer = "";
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        List<Integer> list = new ArrayList<>();
        for(char ch : number.toCharArray()) {
            list.add(Integer.parseInt(String.valueOf(ch)));
        }


        int max = -1;
        boolean flag = false;
        for(int i : list){
            if(queue.size() < k || max > i) {
                queue.add(i);
                max = i;
                if(queue.size() > k){
                    queue.poll();
                }
            }
            if(flag) break;
            if(queue.size() == k) flag = true;
        }

        List<Integer> index = new ArrayList<>();
        for(int i = 0; i < list.size(); i++) {
            if(queue.contains(list.get(i))){
                queue.remove(list.get(i));
                index.add(i);
            }
        }
        index = index.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        for(int i : index){
            list.remove(i);
        }

        for(int i : list){
            answer += String.valueOf(i);
        }

        return answer;
    }

}
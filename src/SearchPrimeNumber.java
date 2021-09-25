import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.OptionalLong;
import java.util.Set;

/**
 * 문제 설명
 * 한자리 숫자가 적힌 종이 조각이 흩어져있습니다.
 * 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
 *
 * 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때,
 * 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * numbers는 길이 1 이상 7 이하인 문자열입니다.
 * numbers는 0~9까지 숫자만으로 이루어져 있습니다.
 * "013"은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
 * 입출력 예
 * numbers	return
 * "17"	3
 * "011"	2
 * 입출력 예 설명
 * 예제 #1
 * [1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.
 *
 * 예제 #2
 * [0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.
 *
 * 11과 011은 같은 숫자로 취급합니다.
 */

public class SearchPrimeNumber {
    public static void main(String[] args) {
        SearchPrimeNumberSolution searchPrimeNumberSolution = new SearchPrimeNumberSolution();
        int solution = searchPrimeNumberSolution.solution("7843");
        System.out.println(solution);
    }
}

class SearchPrimeNumberSolution {

    private Set<Integer> numbers = new HashSet<>();

    private List<String> list = new ArrayList<>();

    public int solution(String numbers) {
        for(char ch : numbers.toCharArray()) {
            list.add(String.valueOf(ch));
        }

        for(int i = 0; i < list.size(); i++){
            Set<Integer> visited = new HashSet<>();
            visited.add(i);
            dfs(list.get(i),1,visited);
        }

        int cnt = countPrimeNumber(this.numbers);

        return cnt;
    }


    private void dfs(String prev, int length,Set<Integer> visited){
        if(length > list.size()) return;
        if(prev.length() == length) numbers.add(Integer.parseInt(prev));
        for(int i = 0; i < list.size(); i++){
            Set<Integer> set = new HashSet<>(visited);
            if(visited.contains(i)) continue;
            set.add(i);
            dfs(prev + list.get(i),length+1,set);
        }

    }

    private int countPrimeNumber(Set<Integer> numbers){

        Long max = numbers.stream().mapToLong(Integer::longValue).max().getAsLong();

        boolean[] prime = new boolean[max.intValue() + 1];

        prime[0] = prime[1] = true;

        for(int i = 2; i <= Math.sqrt(max); i++){

            if(prime[i]) continue;

            for(int j = i*i; j <= max; j = j+i) prime[j] = true;

        }

        int count = 0;

        for(int i : numbers){
            if(!prime[i])
                count++;
        }
        return count;
    }
}

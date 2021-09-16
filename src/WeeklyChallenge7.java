import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * 사회적 거리두기를 위해 회의실에 출입할 때 명부에 이름을 적어야 합니다.
 * 입실과 퇴실이 동시에 이뤄지는 경우는 없으며, 입실 시각과 퇴실 시각은 따로 기록하지 않습니다.
 *
 * 오늘 회의실에는 총 n명이 입실 후 퇴실했습니다. 편의상 사람들은 1부터 n까지 번호가 하나씩 붙어있으며,
 * 두 번 이상 회의실에 들어온 사람은 없습니다. 이때, 각 사람별로 반드시 만난 사람은 몇 명인지 구하려 합니다.
 *
 * 예를 들어 입실 명부에 기재된 순서가 [1, 3, 2], 퇴실 명부에 기재된 순서가 [1, 2, 3]인 경우,
 *
 * 1번과 2번은 만났는지 알 수 없습니다.
 * 1번과 3번은 만났는지 알 수 없습니다.
 * 2번과 3번은 반드시 만났습니다.
 * 또 다른 예로 입실 순서가 [1, 4, 2, 3], 퇴실 순서가 [2, 1, 3, 4]인 경우,
 *
 * 1번과 2번은 반드시 만났습니다.
 * 1번과 3번은 만났는지 알 수 없습니다.
 * 1번과 4번은 반드시 만났습니다.
 * 2번과 3번은 만났는지 알 수 없습니다.
 * 2번과 4번은 반드시 만났습니다.
 * 3번과 4번은 반드시 만났습니다.
 * 회의실에 입실한 순서가 담긴 정수 배열 enter, 퇴실한 순서가 담긴 정수 배열 leave가 매개변수로 주어질 때,
 * 각 사람별로 반드시 만난 사람은 몇 명인지 번호 순서대로 배열에 담아 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 1 ≤ enter의 길이 ≤ 1,000
 * 1 ≤ enter의 원소 ≤ enter의 길이
 * 모든 사람의 번호가 중복없이 하나씩 들어있습니다.
 * leave의 길이 = enter의 길이
 * 1 ≤ leave의 원소 ≤ leave의 길이
 * 모든 사람의 번호가 중복없이 하나씩 들어있습니다.
 *
 *
 *
 */

public class WeeklyChallenge7 {
    public static void main(String[] args) {
        WeeklyChallenge7Solution weeklyChallenge7Solution = new WeeklyChallenge7Solution();
        int[] enter = {1,4,2,3};
        int[] leave = {2,1,4,3};

        System.out.println(Arrays.toString(weeklyChallenge7Solution.solution(enter, leave)));
    }
}

class WeeklyChallenge7Solution {
    public int[] solution(int[] enter, int[] leave) {
        int[] answer = new int[enter.length];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i< enter.length; i++){
            map.put(i+1,new HashSet<>());
        }
        List<Integer> enterList = new ArrayList<>();
        for(int i : enter){
            enterList.add(i);
        }
        for(int i = 0; i < leave.length; i++){
            List<Integer> list = new ArrayList<>();
            for(int j = 0; j < enterList.size();j++) {
                list.add(enterList.get(j));
                if(leave[i] == enterList.get(j)) break;
            }
            for(int k : list){
                map.get(k).addAll(list);
            }
            enterList.remove(Integer.valueOf(leave[i]));
        }

        for(int i = 0; i < enter.length; i++){
            answer[i] = map.get(i+1).size()-1;
        }
        return answer;
    }
}
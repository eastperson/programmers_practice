import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * 문제 설명
 * XX아파트에서는 공동현관 출입을 위해 다음과 같이 비밀번호를 입력합니다.
 *
 * 호수#비밀번호#
 * 즉 호수를 누르고 '#'을 누른 후 비밀번호를 누르고 다시 '#'을 누르면 공동현관문이 열리게 됩니다. 예를 들어 1201호에서 1234라는 비밀번호를 사용하고 있다면 다음과 같이 공동 현관문을 열 수 있습니다.
 *
 * 1201#1234#
 * 비밀번호 입력을 위해 사용하는 버튼은 다음과 같습니다.
 *
 * 0~9 버튼 : 숫자를 입력합니다.
 * '#' 버튼 : 확인 버튼에 해당합니다. 예를 들어 1201#1234#의 경우 1201(확인)1234(확인)과 동일합니다.
 * 올바르게 호수와 비밀번호를 입력한 경우 문이 열리고 초기 상태로 돌아갑니다.
 * '#' 버튼을 누른 경우 앞선 입력 내용에 오류가 있다면 지금까지의 입력 내용을 모두 취소 후 초기 상태로 돌아갑니다. 오류는 다음과 같습니다.
 * 잘못된 호수를 입력한 경우
 * 잘못된 비밀번호를 입력한 경우
 * 본 문제에서는 XX아파트에서 공동현관 출입을 위해 입력한 내용이 한 줄로 된 문자열 형태로 주어질 때, 올바르게 비밀번호를 입력하여 공동현관문을 연 횟수는 총 몇 번인지 구하면 됩니다. 문자열로 주어진 내용은 앞에서부터 순서대로 공동현관문에 입력되었다고 가정합니다.
 *
 * 다음은 XX아파트의 각 세대가 사용하는 비밀번호와 공동현관문에 입력된 내용을 나타낸 예시입니다.
 *
 * 호수	비밀번호
 * 101	1234
 * 102	54321
 * 201	202
 * 202	1
 * "101#1234#102#654321#51#203#201#202#1#"
 * 이때, 공동현관문에 입력된 내용을 분석하면 다음과 같습니다.
 *
 * 내용	설명
 * "101#1234#"	101호를 입력 후 비밀번호 1234를 입력해 문이 열렸습니다.
 * "102#654321#"	102호는 올바르게 입력했으나, 비밀번호가 틀렸습니다.
 * "51#"	51호는 없는 호수입니다.
 * "203#"	203호는 없는 호수입니다.
 * "201#202#"	201호를 입력 후 비밀번호 202를 입력해 문이 열렸습니다.
 * "1#"	1호는 없는 호수입니다.
 * 따라서 위 예시에서 공동현관문은 총 2번 열렸습니다.
 *
 * 각 세대에서 사용하는 비밀번호가 담긴 2차원 배열 passwords, 공동현관문에 입력된 내용이 담긴 문자열 s가 매개변수로 주어질 때, 공동현관문은 총 몇 번 열렸는지 return 하도록 solution 함수를 완성해주세요.
 *
 * 제한사항
 * 2 ≤ passwords의 세로(행) 길이 ≤ 40
 * passwords의 세로(행) 길이는 2의 배수입니다.
 * passwords의 각 행은 [호수, 비밀번호] 형태입니다.
 * 호수는 101호, 102호, 201호, 202호 ... 2001호, 2002호 순서이며 1층 ~ 20층까지 각 층별로 1호, 2호만 있는 형태입니다.
 * 비밀번호는 1부터 999,999까지의 자연수입니다.
 * 동일한 호수가 두 개 이상 주어지지 않습니다.
 * 2 ≤ s의 길이 ≤ 10,000
 * s는 숫자와 '#'으로만 이루어져 있습니다.
 * s에서 숫자는 연속해서 최대 6번까지 붙어있을 수 있습니다.
 * '#'과 '#' 사이에는 항상 하나 이상의 숫자가 있습니다. 즉, '#'이 서로 붙어있는 경우는 없습니다.
 * 따라서 호수나 비밀번호를 입력하지 않고 연속해서 '#'을 누르는 경우는 고려하지 않아도 됩니다.
 * s의 첫 번째 문자는 항상 숫자입니다.
 * s의 마지막 문자는 항상 '#'입니다.
 * s의 숫자는 0으로 시작하지 않습니다.
 * s의 첫 문자는 '0'이 아니며, 모든 '#' 뒤에는 '0'이 바로 오지 않습니다.
 * 즉, 101호는 0101호와 같이 입력받지 않으며, 모든 비밀번호는 0으로 시작하지 않습니다.
 * s의 마지막에 올바른 호수만 입력한 후 문자열이 끝나는 경우에는 공동현관문을 열지 못한 것으로 합니다. (입출력 예 2번 참조)
 * 입출력 예
 * passwords	s	result
 * [[101,1234],[102,54321],[201,202],[202,1]]	"101#1234#102#654321#51#203#201#202#1#"	2
 * [[101,9999],[102,1111]]	"201#9999#101#"	0
 * [[101,9999],[102,1111]]	"101#9999#102#1111#101#9999#101#9999#"	4
 * 입출력 예 설명
 * 입출력 예 #1
 *
 * 문제의 예시와 같습니다.
 *
 * 입출력 예 #2
 *
 * 호수	비밀번호
 * 101	9999
 * 102	1111
 * "201#9999#101#"
 * 공동현관문에 입력된 내용을 분석하면 다음과 같습니다.
 *
 * 내용	설명
 * "201#"	201호는 없는 호수입니다.
 * "9999#"	9999호는 없는 호수입니다.
 * "101#"	101호는 올바른 호수이나, 비밀번호를 입력하지 않고 문자열이 끝났으므로 공동현관문은 열리지 않았습니다.
 * 따라서 공동현관문은 한 번도 열리지 않았습니다.
 *
 * 입출력 예 #3
 *
 * 호수	비밀번호
 * 101	9999
 * 102	1111
 * "101#9999#102#1111#101#9999#101#9999#"
 * 공동현관문에 입력된 내용을 분석하면 다음과 같습니다.
 *
 * 내용	설명
 * "101#9999#"	101호를 입력 후 비밀번호 9999를 입력해 문이 열렸습니다.
 * "102#1111#"	102호를 입력 후 비밀번호 1111을 입력해 문이 열렸습니다.
 * "101#9999#"	101호를 입력 후 비밀번호 9999를 입력해 문이 열렸습니다.
 * "101#9999#"	101호를 입력 후 비밀번호 9999를 입력해 문이 열렸습니다.
 * 따라서 공동현관문은 총 네 번 열렸습니다.
 */
public class CodingTest2 {
    public static void main(String[] args) {
        CodingTestSolution2 solution = new CodingTestSolution2();
        int[][] passwords = {
                {101,9999},
                {102,1111}
        };
        String[] strArr = {
                "a=3",
                "..a=4",
                "..b=3",
                "..print a",
                ".......a=6",
                ".......print a",
                ".......print b",
                "..print a",
                "....a=7",
                "....print a",
                "print a",
                "print b",
                "a=4",
                "print a",
                "...print a"};

        System.out.println(Arrays.toString(solution.solution(strArr)));
    }
}

class CodingTestSolution2 {

    private List<String> result = new ArrayList<>();

    public String[] solution(String[] code) {
        String[] answer = {};
        int beforeCnt = 0;
        for(int i = 0; i < code.length; i++) {
            HashMap<String,Integer> map = new HashMap<>();
            recursion(code[i],beforeCnt,map);
        }

        return result.toArray(new String[result.size()]);
    }

    void recursion(String str, int beforeCnt, HashMap<String,Integer> map){
        HashMap<String,Integer> newMap = new HashMap<>();
        newMap.putAll(map);
        int cnt = 0;
        for(char ch : str.toCharArray()) {
            if(ch == '.') cnt++;
        }
        if(beforeCnt < cnt) {
            recursion(str,cnt,newMap);
            insert(newMap,str);
            print(newMap,str);
        }
        if(beforeCnt == cnt) {
            insert(map,str);
            print(map,str);
        }
    }

    void insert(HashMap<String,Integer> map, String str) {
        if(str.contains("=")) {
            String[] arr = str.split("=");
            map.put(arr[0],Integer.parseInt(arr[1]));
        }
    }

    void print(HashMap<String,Integer> map, String str){
        if(str.contains(" ") && str.contains("print")){
            String[] arr = str.split(" ");
            System.out.println("arr[1] : " + arr[1]);
            result.add(String.valueOf(map.get(arr[1])));
        }
    }
}

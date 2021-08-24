/**
 Caesar cipher
 문제 설명
 어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다. "z"는 1만큼 밀면 "a"가 됩니다.
 문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.

 제한 조건
 공백은 아무리 밀어도 공백입니다.
 s는 알파벳 소문자, 대문자, 공백으로만 이루어져 있습니다.
 s의 길이는 8000이하입니다.
 n은 1 이상, 25이하인 자연수입니다.
 입출력 예
 s	n	result
 "AB"	1	"BC"
 "z"	1	"a"
 "a B z"	4	"e F d"
 */

public class CaesarCipher {
    public static void main(String[] args) {
        CaesarCipherSolution solution = new CaesarCipherSolution();
        int[] numbers = {1,2,7,6,4};

        System.out.println(solution.solution("z",1));
    }
}

class CaesarCipherSolution {
    public String solution(String s, int n) {
        StringBuilder result = new StringBuilder();
        for(char ch : s.toCharArray()){
            char c = (char) (ch + n);
            if('a' <= ch && ch <= 'z'){
                if(c > 'z') c = (char) (c - 26);
                result.append(c);
            } else if ('A' <= ch && ch <= 'Z') {
                if(c > 'Z') c = (char) (c - 26);
                result.append(c);
            } else if (ch == ' ') {
                result.append(" ");
            }
        }
        return result.toString();
    }
}

/**
 카이사르 암호(Caesar cipher) 또는 시저 암호는 암호학에서 다루는 간단한 치환암호의 일종이다.
 실제로 로마의 황제 카이사르는 이 카이사르 암호를 사용하기도 했다. 카이사르 암호는 암호화하고자 하는 내용을 알파벳별로 일정한 거리만큼 밀어서 다른 알파벳으로 치환하는 방식이다.
 예를 들어 3글자씩 밀어내는 카이사르 암호로 'COME TO ROME'을 암호화하면 'FRPH WR URPH'가 된다.
 여기서 밀어내는 글자 수는 암호를 보내는 사람과 함께 정해 더 어려운 암호를 만들 수 있다.
 이런 카이사르 암호는 순환암호라고 한다. 예를 들어 위의 카이사르 암호로 'RUSQHUVKBVEHQIIQIYDQJEH' 라는 암호를 받았을 경우, 해독하면 BECAREFULFORASSASINATOR, 암살자를 조심하라는 뜻이 된다.

 카이사르 암호는 약 기원전 100년경에 만들어져 로마의 장군인 카이사르가 동맹군들과 소통하기 위해 만든 암호이다

 카이사르 암호는 단순하고 간단하여 일반인도 쉽게 사용할 수 있지만, 철자의 빈도와 자주 사용되는 단어와 형태를 이용하면 쉽게 풀 수 있다는 단점이 있다.
 **/
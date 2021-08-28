import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidBracket {
    public static void main(String[] args) {
        ValidBracketSolution solution = new ValidBracketSolution();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

        System.out.println(solution.solution("(())"));
    }
}

class ValidBracketSolution {
    boolean solution(String s) {
        Stack stack = new Stack();
        for(char ch : s.toCharArray()){
            if(ch == '(') {
                stack.push(ch);
            }
            else if(ch == ')') {
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

public class MathExpression {
    public static void main(String[] args) {
        MathExpressionSolution solution = new MathExpressionSolution();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

        System.out.println(solution.solution(15));
    }
}

class MathExpressionSolution {
    public int solution(int n) {
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            int j = i;
            while(true){
                sum += j;
                j++;
                if(n==sum) cnt++;
                if(n<=sum) break;
            }
        }
        return cnt;
    }
}
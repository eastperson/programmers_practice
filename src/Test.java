import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        TestSolution solution = new TestSolution();
        int[] arr = {1,2,3,4,6,7,8,0};
        System.out.println(solution.solution(arr));
    }
}


class TestSolution {
    public int solution(int[] numbers) {
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        Arrays.sort(numbers);
        for(int i =0; i<arr.length;i++){
            for(int b : numbers){
                if(arr[i] == b) arr[i] = 0;
            }
        }

        return Arrays.stream(arr).sum();
    }
}
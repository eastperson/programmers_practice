import java.util.Arrays;

public class MinimumNumber {
    public static void main(String[] args) {
        MinimumNumberSolution solution = new MinimumNumberSolution();
        int[] arr1 = {1, 2};
        int[] arr2 = {3,4};

        System.out.println(solution.solution(arr1,arr2));
    }
}

class MinimumNumberSolution
{
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int sum = 0;
        for(int i = 0; i < A.length;i++) sum += A[i]*B[B.length-i-1];
        return sum;
    }
}
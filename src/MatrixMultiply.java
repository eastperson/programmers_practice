import java.util.Arrays;

public class MatrixMultiply {
    public static void main(String[] args) {
        MatrixMultiplySolution solution = new MatrixMultiplySolution();
        int[][] arr1 = {
                {2,3,2},
                {4,2,4},
                {3,1,4}
        };
        int[][] arr2 = {
                {5,4,3},
                {2,4,1},
                {3,1,1}
        };
        System.out.println(Arrays.deepToString(solution.solution(arr1, arr2)));
    }
}

class MatrixMultiplySolution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[i].length; j++){
                int sum = 0;
                for(int k = 0; k < arr1[i].length; k++){
                    sum += arr1[i][k]*arr2[k][j];
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Optional;


public class MaximumAndMinimum {
    public static void main(String[] args) {
        MaximumAndMinimumSolution solution = new MaximumAndMinimumSolution();
        int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};

        System.out.println(solution.solution("-1 -2 -3 -4"));
    }
}

class MaximumAndMinimumSolution {
    public String solution(String s) {
        String[] strArr = s.split(" ");
        List<Integer> list = Arrays.stream(strArr).map(Integer::valueOf).collect(Collectors.toList());
        return list.stream().min(Integer::compareTo).get().toString() + " " + list.stream().max(Integer::compareTo).get().toString();
    }
}
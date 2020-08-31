package level2;

import java.util.Arrays;

public class 기능개발1 {
    public static void main(String[] args) {

        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        //[93,30,55]	[1,30,5]	[2,1]

        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
}

package level2;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class 기능개발2 {
    public static void main(String[] args) {

        int[] progresses = new int[]{93,30,55};
        int[] speeds = new int[]{1,30,5};

        System.out.println(Arrays.toString(solution(progresses, speeds)));
    }
    public static int[] solution(int[] progresses, int[] speeds) {
        //[93,30,55]	[1,30,5]	[2,1]

        Queue<Integer> q = new ConcurrentLinkedDeque<>();
        for(int i=0; i<progresses.length; i++){
            q.add((100-progresses[i]) % speeds[i] == 0?
                            (100-progresses[i]) / speeds[i] : (100-progresses[i]) / speeds[i]+1
                    );
        }
        List<Integer> result = new ArrayList<>();
        int standard = q.poll();
        int cnt = 1;
        while(!q.isEmpty()){
            int num = q.poll();
            if(standard >= num){
                cnt++;
            }else{
                result.add(cnt);
                cnt = 1;
                standard = num;
            }
        }
        result.add(cnt);
        int[] answer = new int[result.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }
}

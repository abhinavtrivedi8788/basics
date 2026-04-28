package com.engineering.dsa.arraypkg;

import java.util.HashMap;
import java.util.Map;

public class MinDayTaskScheduler {

    public static long taskSchedulerII(int[] tasks, int space) {
        Map<Integer,Long> lastDay = new HashMap<>();
        long day=0;
        for(int task : tasks){
            if(lastDay.containsKey(task)){
                long previousDay = lastDay.get(task);
                if(day <= previousDay + space ){
                    day = previousDay + space + 1;
                }else{
                    day++;
                }
            }else{
                day++;
            }
            lastDay.put(task,day);
        }
        return day;
    }

    static void main() {
        int [] tasks = {1,2,1,2,3,1};
        int space = 3;
        System.out.println("Minimum required day to complete the task is : "+taskSchedulerII(tasks, space));
    }
}

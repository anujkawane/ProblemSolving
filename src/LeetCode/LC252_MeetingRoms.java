package LeetCode;

import java.util.*;

public class LC252_MeetingRoms {
    class Point implements Comparable<Point>{
        int time;
        boolean isStart;

        public Point(int time, boolean isStart){
            this.time = time;
            this.isStart = isStart;
        }

        @Override
        public int compareTo(Point p2){
            if(p2.time == this.time){
                if(this.isStart == p2.isStart){
                    return 0;
                }else{
                    return this.isStart ? 1 : -1;
                }
            }
            return this.time < p2.time ? -1 : 1;
        }
    }
    public boolean canAttendMeetings(int[][] intervals) {

        List<Point> list = new ArrayList();
        for(int[] arr : intervals){
            list.add(new Point(arr[0], true));
            list.add(new Point(arr[1], false));
        }

        Collections.sort(list);
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).isStart){
                count ++;
            }else{
                count--;
            }
            if(count > 1)
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        LC252_MeetingRoms o = new LC252_MeetingRoms();
        int[][] intervals = {{13,15},{1,13}};
        System.out.println(o.canAttendMeetings(intervals));
    }
}


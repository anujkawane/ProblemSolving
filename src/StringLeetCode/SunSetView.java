package StringLeetCode;

import java.util.ArrayList;

public class SunSetView {

    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {

        ArrayList<Integer> result = new ArrayList<>();
        int maxHeight = Integer.MIN_VALUE;
        if(direction.equals("EAST")){
            for(int i = buildings.length-1; i>=0;i--){
                if(buildings[i]>maxHeight){
                    maxHeight = buildings[i];
                    result.add(i);
                }
            }
        }else{
            for(int i = 0; i < buildings.length;i++){
                if(buildings[i]>maxHeight){
                    maxHeight = buildings[i];
                    result.add(i);
                }
            }
        }
        return result;
    }
}

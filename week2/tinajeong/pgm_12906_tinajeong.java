package week2.tinajeong;
import java.util.*;

public class pgm_12906_tinajeong {
    public int[] solution(int [] arr) {
        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]==arr[j]) arr[j]= -1; else break;
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int num:arr) { if(num!=-1) arrayList.add(num); }
        return arrayList.stream().mapToInt(i -> i).toArray();
    }
}

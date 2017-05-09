package demo.hackeerearth.implmentation;

import java.util.*;

/**
 * Created by anya on 5/5/17.
 */
public class Minmax {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int arraySize=Integer.parseInt(sc.nextLine());
        String array[]=sc.nextLine().split(" ");
        SortedSet<Integer> arList=new TreeSet<>(Comparator.reverseOrder());
        for(int i=0; i<arraySize; i++){
            int inInt = Integer.parseInt(array[i]);
            arList.add(inInt);
        }
        Integer[] sortedAr=(Integer[]) arList.toArray();
        boolean flag=true;
//        Integer prev=0;
//        for(Iterator<Integer> inIterator=arList.iterator(); inIterator.hasNext();){
//            if(inIterator.next()!=(inIterator.next())){
//                flag=false;
//                break;
//            }
//
//        }
        for(int i=sortedAr.length-1; i>0; i--){
            if(i!=0 && (sortedAr[i]!=(sortedAr[i-1]+1))){
                flag=false;
            }
        }
        if(flag==true){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}

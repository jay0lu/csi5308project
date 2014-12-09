/**
 * Created by Jaylu
 * Generating N unique random numbers in a ring
 */

import java.util.HashSet;
import java.util.Random;


public class makeRing {

    // use hashset to generating unique array
    public static void random(String[] args) {
        Random rand = new Random();
        int e;
        int i;
        int g = 10;  // nodes number
        HashSet<Integer> randomNumbers = new HashSet<Integer>();

        for (i = 0; i < g; i++) {
            e = rand.nextInt(100);  //number range
            randomNumbers.add(e);
            if (randomNumbers.size() <= 10) {
                if (randomNumbers.size() == 10) {
                    g = 10;
                }
                g++;
                randomNumbers.add(e);
            }
        }
        System.out.println("Ten Unique random numbers from 1 to 10 are  : " + randomNumbers);
    }

/**
 * @ use treeSet to sort

 import java.util.TreeSet;

 public class TreeSetTest {
 public static void main(String[] args) {
 TreeSet<Integer>treeSet = new TreeSet<Integer>();
 while(treeSet.size()<200){
 int num =(int)(Math.random()*1000);
 treeSet.add(num);
 }
 for(Integer i : treeSet){
 System.out.println(i);
 }
 }
 }
 */

    /**
     * use mergesort
     *
     public class Mergesort
     {
         public static void merge(int a[],int pl,int mid,int pr)
         {
             int temp[]=new int[pr-pl+1];
             int i=0,left=pl,right=mid+1;
             while(left<=mid && right<=pr)
             {
                 temp[i++]=a[left]<a[right] ? a[left++]:a[right++];
             }
             while(left<=mid)
             {
                 temp[i++]=a[left++];
             }
             while(right<=pr)
             {
                 temp[i++]=a[right++];
             }
             for(int j=0,k=pl;k<=pr;j++,k++)
             {
                 a[k]=temp[j];
             }
      
         }
         public static void sort(int a[],int left,int right)
         {
             int mid;
             if(left<right)
             {
                 mid=(left+right)/2;
                 sort(a,left,mid);
                 sort(a,mid+1,right);
                 merge(a,left,mid,right);
             }
         }
         public static void main(String args[])
         {
             int a[]=new int[]{35,123,5,95,56,242,43,44,65,24};
             Mergesort.sort(a, 0, a.length-1);
             for(int i=0;i<a.length;i++)
             {
                 System.out.printf("%-5d",a[i]);
             }
         }
     }
     */

}

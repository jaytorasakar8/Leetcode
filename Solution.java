import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
Q1. 
Implement uniqueSubstrings in the editor below. This takes a string and a substring length as inputs and returns the list of unique substrings of this length in ascending order (you should use built-in sort functions for this).   Input Format An input string and substring length entered as  string length   Output Format Your function must return a sorted list of unique substrings.   Sample Input 0 aaabbc 2   Sample Output 0 [ "aa", "ab", "bb", "bc" ]   Explanation 0 Though "aa" appears twice as a substring in the input string, it is only included once as the resulting list only contains unique elements.   Sample Input 1 zacaabc 3   Sample Output 1 [ "aab", "abc", "aca", "caa", "zac" ]   Explanation 1 The output list contains all 5 substrings of length 3 in ascending sorted order.


*/

/* public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = sc.nextInt();
        
        String[] result;
        result = uniqueSubstrings(s, len);
        
        for(int i=0;i<result.length;i++)
            System.out.println(result[i]);
        
    }
   
   static String[] uniqueSubstrings(String inputString, int substringLength) 
   {
       Set<String> hs = new HashSet<String>();
       
       for(int i=0;i<=inputString.length()-substringLength;i++)
       {
           hs.add(inputString.substring(i, i+substringLength));
       }
       
       
       
       ArrayList<String> al = new ArrayList<String>(hs);
       Collections.sort(al);
       
       
       
       String[] s = new String[al.size()]; //Convert the given array list to string array
        s = al.toArray(s);

        return s;
       
    }*/



public class Solution
{
    
    /* 
    Given a list of student test scores, find the best average grade. Each student may have more than one test score in the list.Complete the bestAverageGrade function in the editor below.It has one parameter, scores, which is an array of student test scores. Each element in the array is a two-element array of the form [student name, test score] e.g. [ "Bobby", "87"].More points will be awarded for solutions that can handle larger inputs within a set period of time i.e. code with a faster run-time complexity. Input FormatThe input parameter scores is an array of arrays, where each sub-array contains two strings: the student name followed by a test score as a string. You must also include the number of entries and the size of each entry (this will always be 2). See below for specific examples. Test scores may be positive or negative integers. Output FormatYour function must return a single integer representing the best average grade. If you end up with an average grade that is not an integer, you should use a floor function to return the largest integer less than or equal to the average.Return 0 for an empty input. Sample Input 0[ [ "Bobby", "87" ], [ "Charles", "100" ], [ "Eric", "64" ], [ "Charles", "22" ] ].entered as42Bobby 87Charles 100Eric 64Charles 22 Sample Output 087 Explanation 0The average scores are 87, 61, and 64 for Bobby, Charles, and Eric, respectively. 87 is the highest. Sample Input 1[ [ "Sarah", "99" ], [ "Elaine", "99" ], [ "Jordan", "99" ] ]entered as32Sarah 99Elaine 99Jordan 99 Sample Output 199 Explanation 1Each student has one score of 99, so the highest average is 99.
    */
     public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        
         String[][] s = {{"B", "87"},{"C","100"},{"E","64"},{"C","22"}};
         
         System.out.println( bestAverageGrade(s));
    }
     
     static double bestAverageGrade(String[][] scores) 
     {
         for(int i =0;i<scores.length;i++)
         {
             for(int j=i+1;j<scores.length;j++)
             {
                 if(scores[i][0].equals(scores[j][0]))
                 {
                     double temp1=Double.parseDouble(scores[i][1]);
                     double temp2=Double.parseDouble(scores[j][1]);
                     double temp3= (temp1+temp2)/2;
                     scores[i][1] = Double.toString(temp3);
                    double temp4 = Double.parseDouble(scores[j][1]);
                     scores[j][1] = Double.toString(0);
                     System.out.println(temp1+" "+temp2+" "+temp3);
                 }
                 
             }
         }//end of all for loops
          String s[]=new String[scores.length];
          Double temp[]=new Double [scores.length];
         for(int i=0;i<scores.length;i++)
         {
             s[i]= scores[i][1];
             temp[i] = Double.parseDouble(s[i]);
         }
         
         Arrays.sort(temp);
         
         return temp[scores.length-1];
         
     }
    
 
}



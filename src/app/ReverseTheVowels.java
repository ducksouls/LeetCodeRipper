package app;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import javax.sound.sampled.SourceDataLine;

public class ReverseTheVowels {

    /**
     * leetcode 左右两个指针,指向一前一后 交换后,两个指针往前一步
     * 
     * 
     */
    public String reverseVowels(String s) {
        String letter = "aeiouAEIOU";
        char[] str = s.toCharArray();
        int i = 0;
        int j = str.length - 1;
        while (i < j) {
            if (letter.indexOf(str[i]) >= 0 && letter.indexOf(str[j]) >= 0) {
                char temp = str[i];
                str[i] = str[j];
                str[j] = temp;
                i++;
                j--;
            } else if (letter.indexOf(str[i]) <= -1) {
                i++;
            } else if (letter.indexOf(str[j]) <= -1) {
                j--;
            }
        }

        return new String(str);
    }

    // public boolean contains(char c){
    // if(c=='a' || c=='e' || c=='i'|| c=='o' || c=='u' || c=='A' || c=='E' ||
    // c=='I'|| c=='O' || c=='U' ) return true;
    // else return false;

    // }
    // public String reverseVowels2(String s) {
    // char arr[] = s.toCharArray();
    // char tmp;
    // int i = 0 , j = arr.length-1;
    // while(i < j){
    // while(!this.contains(arr[i]) && i < j) i ++ ;
    // while(!this.contains(arr[j]) && i < j) j -- ;
    // if(i < j ){
    // tmp = arr[i];
    // arr[i] = arr[j];
    // arr[j] = tmp ;
    // }
    // else{
    // break;
    // }
    // i ++;
    // j --;
    // }
    // return String.valueOf(arr);
    // }

    public static void main(String[] args) {
        ReverseTheVowels so = new ReverseTheVowels();
        String result = so.reverseVowels("hello");
        System.out.println(result);
    }

}
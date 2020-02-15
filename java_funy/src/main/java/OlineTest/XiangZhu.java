package OlineTest;

import java.util.ArrayList;
import java.util.Scanner;

public class XiangZhu {
    public static void main(String[] args){
        int[] nums=new int[10005];
        Scanner sc = new Scanner(System.in);
        String line;
        line=sc.nextLine();
//        ArrayList<String> list=new ArrayList<>();

        String[] strs=new String[10005];
        strs=line.split(" ");

        int[] zh=new int[1000005];
        int[] fu=new int[1000005];

        int length=strs.length;
        int j=0;
        for(int i=0;i<length;i++){
            int num;
            if(strs[i].charAt(0)=='-')
            {
                strs[i]=strs[i].replace("-","");
                System.out.println(strs[i]);
                num=-Integer.valueOf(strs[i]);
            }else {
                num = Integer.valueOf(strs[i]);
            }

//            int num=Integer.valueOf(strs[i]);
            if(num>=0){
                zh[num]+=1;
            }
            else {
                fu[-num]+=1;
            }
            nums[j]=num;
            j++;
        }
        j=0;
        for(int i=0;i<length;i++){
            if(nums[i]>=0){
                if(zh[nums[i]]==1){
                    if(j!=0){
                        System.out.print(" ");
                    }
                    System.out.print(nums[i]);
                    j++;
                }
            }else {
                if(fu[-nums[i]]==1){
                    if(j!=0){
                        System.out.print(" ");
                    }
                    System.out.print(nums[i]);
                    j++;
                }
            }
        }
        if(j==0){
            System.out.println("empty");
        }
    }
}

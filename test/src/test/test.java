package test;


import java.util.LinkedList;
import java.util.Scanner;
public class test{
    public static LinkedList<Integer> func(int n){
        LinkedList<Integer> help=new LinkedList<Integer>();
        for(int i=n;i>=1;i--){
            help.addFirst(i);
            help.addFirst(help.removeLast());
        }
        return help;
    }
    public static void main(String[] args){
        int t;
        Scanner scan = new Scanner(System.in);
        t=scan.nextInt();
        int n;
        LinkedList<Integer> res;
        while(t-->0){
            n=scan.nextInt();
            res=func(n);
            for(int i=0;i<n-1;i++){
                System.out.print(res.removeFirst()+" ");
            }
            System.out.println(res.removeFirst());
        }
    }
}
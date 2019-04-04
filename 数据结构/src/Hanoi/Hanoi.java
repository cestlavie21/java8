package Hanoi;

public class Hanoi {
    /**
     *
     * @param n         总数量
     * @param from      A盘子
     * @param in        B盘子
     * @param to        C盘子
     */

public static void hanoi(int n, char from , char in ,char to){

        if(n==1){
            System.out.println("将第"+n+"圆环从" +from+"移至"+to);

        }else{
            hanoi(n-1,from,to,in);
            System.out.println("将第"+n+"圆环从" +from+"移至"+to);
            hanoi(n-1,in,from,to);

        }


}

    public static void main(String[] args) {

        hanoi(3,'A','B','C');

    }

}

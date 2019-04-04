package Sort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {

        int [] arr = {1,13,12,5,7,4,8,0};

        quickSort(arr,0,arr.length-1);

        System.out.println(Arrays.toString(arr));

    }


    public static  void quickSort(int[] arr,int start,int end){

        if (start<end){
            //先找出第一个元素的位置
            int pos = findPos(arr,start,end);
            quickSort(arr,0,pos-1);
            quickSort(arr,pos+1,end);
        }
    }

    public static int findPos(int[] arr,int start,int end)
    {
        //取第一个值
        int val = arr[start];
        //取头坐标
        int low = start;
        //取尾坐标
        int high = end;
        //先将第一个值与尾坐标元素对比，如果val的值小于尾元素，那么将high坐标向左移动， 不然将high坐标元素给low坐标元素
        //然后开始比较 low坐标元素，如果val的值大于头元素，那么将low坐标向右移动， 不然将low坐标元素给high坐标元素
        //最终low 将会等于 high , 这个坐标位置是 val元素的位置，将val的值赋给 arr[high]
        while (low<high){
            while(low<high && arr[high]>=val){
                high--;
            }
            arr[low] = arr[high];
            while (low<high && arr[low]<=val){
                low++;
            }
            arr[high] = arr[low];
        }

        arr[low] = val;

        return  low;
    }

}

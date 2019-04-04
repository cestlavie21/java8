package Queue;

import java.util.Arrays;
//队列
public class MyQueue {

    private  int[] elements ;

    public MyQueue(){

        elements = new int[0];
    }

    //入列方法
    public void add(int element){
        //  复制一个新数组
        int [] newArr  = new int[elements.length+1];

        for (int i = 0; i <newArr.length ; i++) {
            newArr[i] = elements[i];
        }
        //将元素加入数组最后
        newArr[newArr.length-1] = element;
        //将原数组替换
        elements = newArr;
    }

    //出列方法
    public int poll(){
        //取出数组的第一个元素
        int  element = elements[0];

        int [] newArr  = new int[elements.length-1];
        //将原数组之后的元素给新数组
        for (int i = 0; i <newArr.length ; i++) {
            newArr[i] = elements[i+1];
        }
        elements = newArr;
        return  element;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();

        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.poll());
        System.out.println(Arrays.toString(queue.elements));

    }

}

package Stack;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 栈的实现
 */
public class MyStack {
   //底层用数组保存数据
    private int[] elements;

    public  MyStack(){

        elements = new int[0];
    }


    public  MyStack(int size){

        elements = new int[size];
    }

    /**
     * 压栈
     * @param element
     */
    public void push(int element){
        int [] elements = new int[this.elements.length+1];
        for (int i = 0; i <this.elements.length ; i++) {
            elements[i] = this.elements[i];
        }
        elements[elements.length-1] = element;

        this.elements = elements;
    }

    /**
     * 出栈
     * @return
     */
    public  int pop() {
        if (this.elements.length==0){

            System.out.println("栈为空！");
            return 0 ;
        }

        int element = this.elements[this.elements.length-1];

        int [] elements = new int[this.elements.length-1];
        for (int i = 0; i <elements.length ; i++) {

            elements[i] = this.elements[i];
        }

        this.elements = elements;

        return element;
    }

    /**
     * 返回栈顶元素
     * @return
     */
    public int peek(){
        return elements[elements.length-1];
    }



    public static void main(String[] args) {

        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        System.out.println(stack.peek());
        System.out.println(Arrays.toString(stack.elements));

    }





}

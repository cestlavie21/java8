package Node;
//双链表
public class DoubleNode {
    //数据
    private  int data;
    //上一个节点地址
    private  DoubleNode  pre;
    //下一个节点地址
    private  DoubleNode  next;


    //添加节点方法
    public void  after(DoubleNode node){

        DoubleNode  currentNextNode = next;

        next = node;
        node.pre = this;
        node.next = currentNextNode;
        currentNextNode.pre = node ;
    }
}

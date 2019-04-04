package Node;
//单链表
public class Node {
    //数据
    private  int data;
    //下一个节点地址
    private Node next;

    public Node(int data){
        this.data = data ;
    }

    //向节点添加数据
    public  void add(int data){

        this.data = data;
    }

    //向节点添加下一个节点地址
    public void append (Node next){
      //先获取当前节点，如果下个节点为空，那么取出下个节点作为当前节点
        Node node = this;

      while (node.next!=null){
          node = node.getNode();
      }
         node.next = next;
    }

    //取出节点数据
    public int getData(){
        return data;
    }

    //取出下一个节点地址
    public Node getNode(){
        return  next;
    }

    //判断是否为最后一个节点
    public boolean isLastNode(){

        return next==null;
    }

    //删除下一个节点
    public void removeNext(){

        next = next.next;
    }

    //插入节点
    public void insertNode(Node node){

        Node nextNode = next;
        next = node;
        node.next = nextNode;

    }

    //打印所有节点信息
    public void showAllNodes(){

        Node  node = this;
        while (node!=null){
            System.out.println(node.getData());
            node = node.next;
        }
    }

    public static void main(String[] args) {


        Node  node1 = new Node(1);
        Node  node2 = new Node(2);
        Node  node3 = new Node(3);

        node1.append(node2);
        node1.append(node3);
        node1.removeNext();
        node1.insertNode(node2);


        node1.showAllNodes();


    }


}

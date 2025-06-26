public class AVLTrre{
  private Node root;

  public AVLTrre(){
    this.root= null;
  }
  

  public int height(Node node){
    if (node==null){
      return 0;
    }
    return node.getHeight();
  }

  public int getBalance(Node node){
    if (node == null){
      return 0;
    }
    return height(node.getLeft())-height(node.getRight());
  
  }

  public void insert(int value){
    System.out.println("Nodo a insertar");
    root = insertRec(root, value);
  }
  
  private Node insertRec(Node node, int value){
    if (node==null) {
      Node newNode = new Node(value);
      newNode.setHeight(1);
      System.out.println("Nodo insertado: "+ newNode.getValue()+ "balance al insertar ="+ getBalance(newNode));
      return newNode;
    }

    if(value < node.getValue()){
    node.setLeft(insertRec(node.getLeft(), value));
    }else if (value> node.getValue()){
    node.setRight(insertRec(node.getRight(), value));
    }else{
      return node;
    }

    System.out.println("Node actual: "+ node.getValue());

     //actualizar la altura de este ancestro node

    int altura= 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    node.setHeight(altura);
    System.out.println("\tAltura =" + node.getHeight());

    int balance = getBalance(node);
    System.out.println("\tBalance = "+ balance);

    // Caso Izquierda-Izquierda
    if(balance > 1 && value < node.getLeft().getValue()){
      System.out.println("Rotacion Derecha");
    }
    //Caso Derecha-Derecha
    if(balance < -1 && value > node.getRight().getValue()){
      System.out.println("Rotacuon Izquierda");
    }
    // Caso Izquierda - Derecha
    if (balance > 1 && value > node.getLeft().getValue()){
      System.out.println("Cambio");
      System.out.println("Rotacion Derecha");
    }
    //Caso Derecha -Izquierda{
    if (balance < -1 && value < node.getRight().getValue()){
      System.out.println("Cambio");
      System.out.print("Rotacion Izquierda ");
    }

    return node;


  }



}
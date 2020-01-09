package ExpressionTree;


import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class Expression extends ExpressionTree {
    //Expression expr;


    public String fullyParenthesised(){

        return fullyParenthesised((BNode<String>) root());
    }

    public String fullyParenthesised(BNode<String> n) { //infix notation
        //using recursion, need an auxiliary recursive method to call on
        // add implementation here
        //BNode<String> root = (BNode<String>) this.root();
        //recursive call to generate full Parent
        if(isLeaf(n)) return n.getData();//base case if its a leaf just return the data
        //if n is not a leaf
        String rootStr = n.getData(); //get the root or operator
        String leftStr = fullyParenthesised(n.getLeft());
        String rightStr = fullyParenthesised(n.getRight());
        return "(" + leftStr + rootStr + rightStr + ")";// concate a String with a parent in the begining and end
    }

    //https://www.programmingassignmenthelper.com/expression-trees/
    //https://runestone.academy/runestone/books/published/pythonds/Trees/ParseTree.html
    // with root and size from 'Tree class'
    //think about which operation is the last to be performed in the expression
    //A rule to identity these operation, deal with the easier case when there are no parentheses first
    //the use recusion
    //add implementation here
    // turn an input expression into the content of a binary(expression tree)

    /*public Expression(String s) {
     BinaryTree bt = new BinaryTree();
     bt.root = build(s);
    } */

    public Expression(String s){
        super();
        root = generateTree(s);
    }

    public BNode<String> generateTree(String s) {
        //super();
        BinaryTree<String> bt = new BinaryTree();
        bt.root = new BNode<String>(" ", null, null, null);
        Stack<BNode<String>>  st = new Stack();
        //BNode<Character> root = (BNode<Character>) bt.root();
        //Stack<BNode> st = new Stack<BNode>();
        //BinaryTree<Character> biTree = new BinaryTree<>();
        //BNode<Character> currentNode = (BNode<Character>) biTree.root();
        BNode<String> curNode =(BNode<String>) bt.root;
        st.push(curNode);
        //s = s.replaceAll("\\s","");
        char[] arrayExpr = s.toCharArray();
        for(int i=0; i<arrayExpr.length; i++){
            if(arrayExpr[i]==' ') continue;
            if(arrayExpr[i]=='('){
                //System.out.println("( test1");
                BNode<String> newNode = new BNode<String>(" ", curNode, null, null );
                //curNode.setLeft(newNode);
                curNode.setLeft(newNode);
                //System.out.println("( test2");
                newNode.setParent(curNode);
                //System.out.println("( test3");
                st.push(curNode);
                BNode<String> testNode = st.peek();//
                treePrint(testNode);//
                curNode = curNode.left;
                //System.out.println("( test4");

            }
            else if(arrayExpr[i]=='+' || arrayExpr[i]=='-' || arrayExpr[i]=='*' || arrayExpr[i]=='/' )
            {
                //System.out.println("+ test 1");
                if(curNode.getData().equals(" ")){
                    curNode.setData(String.valueOf(arrayExpr[i]));
                    //System.out.println(curNode.getData()); //
                }
                else{
                    BNode<String> parNode = new BNode<String>(" ", null, curNode, null);
                    parNode.setData(String.valueOf(arrayExpr[i]));
                    curNode.setParent(parNode);
                    parNode.setLeft(curNode);
                    curNode = parNode;
                }
                BNode<String> newNode = new BNode<String>(" ", curNode, null, null);
                //curNode.setRight(newNode);
                curNode.setRight(newNode);
                newNode.setParent(curNode);
                System.out.println(curNode.getData()); //
//                BNode<String> testNode = st.peek();//
//                treePrint(testNode);//
                st.push(curNode);
                curNode = newNode; //curNode = newNode????

            }else if(arrayExpr[i]==')'){
//                System.out.println(curNode.getData().toString()); //
//                if(curNode.parent == null)
//                    return;
                //curNode = (BNode<Character>) curNode.parent;
                curNode = st.pop();
                if(i<s.length()-1){
                    BNode<String> newNode = new BNode<String>(" ", null, curNode, null);
                    newNode.setLeft(curNode);
                    curNode.setParent(newNode);
                    curNode = newNode;
//                    BNode<String> testNode = st.peek();//
//                    treePrint(testNode);//
                }

////        ArrayList<BNode<String>> ls = new ArrayList<>();
////        ls = this.inOrder();
////        for(int i=0; i<ls.size();i++){

    }else if(arrayExpr[i] >='0' && arrayExpr[i] <= '9'){
        StringBuffer strBuff = new StringBuffer();
        while (i < arrayExpr.length && arrayExpr[i] >= '0' && arrayExpr[i] <= '9' || arrayExpr[i] == '.')
            strBuff.append(arrayExpr[i++]);

//                newNode.setData(arrayExpr[i]);
//                curNode.left = newNode;
//                newNode.parent = st.pop();
//                curNode = (BNode<Character>) curNode.parent;
        //System.out.println(b.toString());
        //curNode.left;
        curNode.setData(strBuff.toString());
        System.out.println(curNode.getData()); //
        BNode<String> testNode = st.peek();//
        treePrint(testNode);//
        if(st.empty()){  //Do I need to change this as: st.isEmpty();???
            BNode<String> parNode = new BNode<String>(" ", null, curNode, null);
            parNode.setLeft(curNode);
            curNode.setParent(parNode);

            st.push(parNode);
        }else{
            curNode.parent = st.pop();
        }
        curNode = (BNode<String>)  curNode.parent;

        //curNode = (BNode<Character>) curNode.getParent();
    }else{
        System.out.println("the character is unvalid!!!");
    }
}
//            System.out.println(ls.get(i).getData()+" "); //
//        }
        return (BNode<String> ) bt.root;

    }





    public boolean isOperator(char c){
        if(c=='+' || c=='-'){
            return true;
        }
        return false;
    }

    public double evaluate(){
        BNode<String> root = (BNode<String>) this.root();
        return evaluate(root);
    }

    public double evaluate(BNode<String> n){
        double result = 0.0;
        if(n==null) return result;
        if(isLeaf(n)) return Double.parseDouble(n.getData());//base case if its a leaf just return the data
        else{
            double left = evaluate(n.getLeft());
            double right = evaluate(n.getRight());
            if(n.getData().equals("+")) result =  left + right;
            if(n.getData().equals("-")) result =  left - right;
            if(n.getData().equals("*")) result =  left * right;
            if(n.getData().equals("/")) result = left / right;

        }
        return result;
    }


   /* public int findRootIndex(String s){
        s = s.replaceAll("\\s","");
        char[] arrayExpr = s.toCharArray();
        for(int i=arrayExpr.length-1; i>0 ; i--){
            if(isOperator(arrayExpr[i]))
                return i;
        }
        return -1;
    }

    public BNode<Character> build(String s) {
        int rootIndex = findRootIndex(s);
        char rootChar = s.charAt(rootIndex);
        BNode root = new BNode<Character>(rootChar, null, null, null);
        root.left = build(s.substring(0,rootIndex));
        root.right = build(s.substring(rootIndex+1, s.length()-1));

        return root;
    }



    public double evaluate() throws EmptyStackException {
        String expr = this.fullyParenthesised();
        //Add code below
        char[] tokens = expr.toCharArray();
        Stack<Double> values = new Stack<Double>(); //when I define it double, it can work on both integer and double number
        Stack<Character> operator = new Stack<Character>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ')
                continue;
            if (tokens[i] >= '0' && tokens[i] <= '9') { //there are more than one number, for example: 34
                StringBuffer strBuff = new StringBuffer();
                //for more than digits in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9' || tokens[i] == '.')
                    strBuff.append(tokens[i++]);
                //System.out.println(Double.parseDouble(strBuff.toString()));
                values.push(Double.parseDouble(strBuff.toString()));
            } else if (tokens[i] == '(') {
                operator.push(tokens[i]);
            }
            //Closing brace encountered, solve entire brace
            else if (tokens[i] == ')') {

                while (operator.peek() != '(' && !operator.empty())  //&& values.size() >= 2)

                    values.push(applyOp(operator.pop(), values.pop(), values.pop()));
                operator.pop();

                //throw new EmptyStackException();
            }
            //Current token is an operator
            else if (tokens[i] == '+' || tokens[i] == '-' ||
                    tokens[i] == '*' || tokens[i] == '/') {

                //while (!operator.empty() && values.size() >= 2 )
                //values.push(applyOp(operator.pop(), values.pop(), values.pop()));
                // catch(EmptyStackException e) {return 0.0; }
                //System.out.println(tokens[i]);
                operator.push(tokens[i]);
            }
        }

        while (!operator.empty()  && values.size() >= 2) {
            //System.out.println(applyOp(operator.pop(), values.pop(), values.pop()));
            values.push(applyOp(operator.pop(), values.pop(), values.pop()));


        }

        return values.pop();

    }

    //Additional helper methods
    public static double applyOp(char op,double a, double b){
        switch(op){
            case '+':
                return a + b;
            case '-':
                return b - a;//order
            case '*':
                return a * b;
            case '/':
                if(b==0)
                    throw new UnsupportedOperationException("Cannot divide by zero");
                return b / a;

        }
        return 0;
    }

    */
}







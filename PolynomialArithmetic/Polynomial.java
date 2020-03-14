package PolynomialArithmetic;
import java.util.*;


public class Polynomial extends PolynomialInterface {

    private String parts[];
    DNode<Term> header;

    public Polynomial(String s) {
         // complete this code
       this();
       parts = s.replace(" ","").split("(?=\\+|\\-)");
       if(parts.length==0) return;
       Term newTerm;
       for(int i=0; i<parts.length; i++){
           newTerm = parse(parts[i]);
           this.data.addLast(newTerm);
       }
    }

    public  Term parse(String s){

        double coefficient = 0.0;
        int power = 0;
        boolean isNegative=false;
        String delimeter = "^xX";
        StringTokenizer strToken = new StringTokenizer(s,delimeter,true);
        String  newToken = strToken.nextToken();
        if(newToken.equals("+")) { isNegative = false;  newToken = strToken.nextToken(); }//skip +
        if(newToken.equals("-")) {  isNegative = true; newToken = strToken.nextToken();}//skip -

        if(newToken.equals("x")|| newToken.equals("X")){
            if(isNegative) coefficient = -1.0;
            else coefficient = 1.0;
            if(!strToken.hasMoreTokens())  power = 1;
            else{
                strToken.nextToken();//skip X
                power = Integer.parseInt(strToken.nextToken());
                //System.out.println("power: "+power);
            }
        }
        else{
            coefficient = Double.parseDouble(newToken);
            if(isNegative==true){
                coefficient =-coefficient;
                //System.out.println("coefficient: "+ coefficient);
            }
            if(!strToken.hasMoreElements()){
                power = 0;
            }
            else{
                strToken.nextToken(); //skip X
                if(!strToken.hasMoreTokens()){
                    power =1;
                }
                else{
                    strToken.nextToken();
                    power = Integer.parseInt(strToken.nextToken());
                }
            }
        }
        Term term = new Term(coefficient, power);
        return term;
    }

    public Polynomial() {
        super();
    }

    public PolynomialInterface add(PolynomialInterface p)  {
        PolynomialInterface ans = new Polynomial();
        try{
            // complete this code
            DList<Term> pPoly = p.data;
            DList<Term> thisPoly = this.data;
            DList<Term> resPoly = ans.data;
            DNode<Term> current1 = thisPoly.getFirst();
            DNode<Term> current2 = pPoly.getFirst();
            while(current1.getData() !=null && current2.getData() !=null){//!!remember to check the the data is not null, but not the node
                if(current1.getData().getDegree()==current2.getData().getDegree()){
                    Term  newTerm = new Term(current1.getData().getCoefficient()+current2.getData().getCoefficient(),current1.getData().getDegree());
                    ans.data.addLast(newTerm);
                    current1 = current1.getNext();
                    current2 = current2.getNext();
                    continue;
                }
                if(current1.getData().getDegree()>current2.getData().getDegree()){
                    ans.data.addLast(current1.getData());
                    current1 = current1.getNext();
                    continue;
                }
                if(current1.getData().getDegree()<current2.getData().getDegree()){
                    ans.data.addLast(current2.getData());
                    current2 = current2.getNext();
                    continue;
                }
            }
            if(current1.getData() != null && current2.getData()==null){
                while(current1.getData() != null){
                    ans.data.addLast(current1.getData());
                    current1 = current1.getNext();
                }
            }
            if(current2.getData() !=null &&  current1.getData()==null ){
                while(current2.getData() != null){
                    ans.data.addLast(current2.getData());
                    current2 = current2.getNext();
                }
            }
        }catch(Exception e) {}
        return ans;
    }

//    public PolynomialInterface remove (PolynomialInterface p) {
//        PolynomialInterface ans = new Polynomial();
//
//        try {
//            DNode<Term> temp1 = p.data.getFirst();
//            while (temp1.getData() != null) {
//                if (temp1.getData().getCoefficient() != 0.0	) {
//                    ans.data.addLast(temp1.getData());
//                }
//                temp1 = temp1.getNext();
//
//            }
//        } catch (Exception e) {}
//        return ans;
//    }

    public PolynomialInterface subtract(PolynomialInterface p)  {
        PolynomialInterface ans = new Polynomial();
        try{
            DNode<Term> current1 =this.data.getFirst();
            DNode<Term> current2 = p.data.getFirst();
            while(current1.getData() !=null && current2.getData() !=null){//!!remember to check the the data is not null, but not the node
                if(current1.getData().getDegree()>current2.getData().getDegree()){
                    ans.data.addLast(current1.getData());
                    current1 = current1.getNext();
                    continue;
                }
                if(current1.getData().getDegree()==current2.getData().getDegree()){
                    double coeff1 = current1.getData().getCoefficient();
                    double coeff2 = current2.getData().getCoefficient();
                    double newCoeff = coeff1-coeff2;
                    int newDegree = current1.getData().getDegree();
                    Term  newTerm = new Term(newCoeff,newDegree);
                    //System.out.println("coeff1: "+ coeff1 +" " + "coeff2: "+ coeff2);
                    //System.out.println("newTerm Coefficient: " + newCoeff+" " +"newTerm degree: "+ newDegree);
                    ans.data.addLast(newTerm);
                    current1 = current1.getNext();
                    current2 = current2.getNext();
                    continue;
                }
                if(current1.getData().getDegree()<current2.getData().getDegree()){
                    Term newTerm =new Term(-current2.getData().getCoefficient(),current2.getData().getDegree());
                    ans.data.addLast(newTerm);
                    current2 = current2.getNext();
                    continue;
                }
            }
            if(current1.getData() != null && current2.getData()==null){
                while(current1.getData() != null){
                    ans.data.addLast(current1.getData());
                    current1 = current1.getNext();
                }
            }
            if(current2.getData() !=null &&  current1.getData()==null ){
                while(current2.getData() != null){
                    Term newTerm = new Term((-1.0)*current2.getData().getCoefficient(),current2.getData().getDegree());
                    ans.data.addLast(newTerm);
                    current2 = current2.getNext();
                }
            }
            if(ans.data.getFirst().getData()==null){
                ans.data.addLast(new Term(0.0,0));
            }
        }catch(Exception e) {}
        //ans = remove(ans);
        return ans;
    }
        // complete this code
        /*PolynomialInterface negativePoly = new Polynomial();
        DList<Term> pPoly = p.data;
        DNode<Term> current = pPoly.getFirst();
        while(current.getData()!=null){
            Term newTerm = new Term(0.0-current.getData().getCoefficient(), current.getData().getDegree());
            negativePoly.data.addLast(newTerm);
            current = current.getNext();
        }
        ans =this.add(p);*/

    /*public PolynomialInterface multiply(PolynomialInterface p) throws Exception {
        PolynomialInterface ans = new Polynomial();
        // complete this code
        DNode<Term> current1 = this.data.getFirst();
        DNode<Term> current2 = p.data.getFirst();
        ArrayList<PolynomialInterface> polyArray = new ArrayList<PolynomialInterface>();
        while(current1 != null){
            Term term1 = current1.getData();
            double coeff1 = term1.getCoefficient();
            int power1 = term1.getDegree();
            DList<Term> newDList = new DList<Term>();
            PolynomialInterface newPoly = new Polynomial();
            while(current2 !=null){
                Term term2 = current2.getData();
                double coeff2 = term2.getCoefficient();
                int power2 = term2.getDegree();
                Term newTerm = new Term(coeff1*coeff2, power1+power2);
                newDList.addLast(newTerm);  //???How can transfer the newDList to the PolynomialInterface, and store it into arrayList
                current2 = current2.getNext();
            }
            newPoly.data = newDList;
            polyArray.add(newPoly);

            current1 = current1.getNext();
            current2 = p.data.getFirst();
        }

        for(PolynomialInterface poly : polyArray){
            ans = ans.add(poly);
        }
        return ans;
    }*/
    public PolynomialInterface multiply(PolynomialInterface p)  {
        PolynomialInterface ans = new Polynomial();
        // complete this code
        Term term = new Term(0.0, 0);
        ans.data.addLast(term);
        try{
            DNode<Term> current1 = this.data.getFirst();
            DNode<Term> current2 = p.data.getFirst();
            while(current1.getData()!=null){
                PolynomialInterface res = new Polynomial();
                while(current2.getData()!=null){
                    double newCoefficient = current1.getData().getCoefficient()*current2.getData().getCoefficient();
                    int power = current1.getData().getDegree()+current2.getData().getDegree();
                    Term newTerm = new Term(newCoefficient, power);
                    res.data.addLast(newTerm);
                    current2 = current2.getNext();
                }
                ans = ans.add(res);
                current1 = current1.getNext();
                current2 = p.data.getFirst();
            }
        }catch(Exception e) {}
        return ans;
    }

    /*public PolynomialInterface divide(PolynomialInterface p) throws Exception {
        PolynomialInterface ans = new Polynomial();
        // complete this code
        try{
            PolynomialInterface newThis = this;
            DNode<Term> current1 = this.data.getFirst();
            DNode<Term> current2 = p.data.getFirst();
            while(current1.getData().getDegree()>=current2.getData().getDegree()){
                double newCoeff= Math.round((current1.getData().getCoefficient()/current2.getData().getCoefficient())*100)/100.0;
                int newPower = current1.getData().getDegree()-current2.getData().getDegree();
                Term newTerm = new Term(newCoeff, newPower);
                ans.data.addLast(newTerm);
                newThis = this.subtract(p.multiply(ans));
                current1 = newThis.data.getFirst();
        }
     }catch (Exception e) {}
        return ans;
    }*/
    public PolynomialInterface divide(PolynomialInterface p) throws Exception {
        PolynomialInterface ans = new Polynomial();
        // complete this code
        try {
            PolynomialInterface t = this;
            DNode<Term> temp1 = t.data.getFirst();
            DNode<Term> temp2 = p.data.getFirst();
            while (temp1.getData().getDegree() >= temp2.getData().getDegree()) {
                double cof = Math.round((temp1.getData().getCoefficient()/temp2.getData().getCoefficient())*100)/100.0;
                int power = temp1.getData().getDegree()-temp2.getData().getDegree();
                ans.data.addLast(new Term(cof,power));
                t = this.subtract(p.multiply(ans));
                temp1 = t.data.getFirst();
            }
        }catch (Exception e) {}
        return ans;
    }

    public PolynomialInterface remainder(PolynomialInterface p) throws Exception {
        PolynomialInterface ans = new Polynomial();
        // complete this code
        ans = this.subtract(p.multiply(this.divide(p)));
        return ans;
    }

    /****************
     * MAIN FUNCTION
     ****************/

   public static void main(String args[]) throws Exception {
        //Variables
        Scanner scnr = new Scanner(System.in);
        PolynomialInterface p, q;
        PolynomialInterface ans1,ans2,ans3, ans4 ,ans5 = null;
        String testInput = "";
       // String testInput="6X^5 + 7X^2 -8X + 1.0";
       // Polynomial testPoly = new Polynomial(testInput);
//        System.out.println(testPoly.data);
//        System.out.println(testPoly.toString());

//        //Custom test case
//       String testInput1;
//       String testInput2;
       String testInput1 = "X^4 + 2.0 X^2 + 3.0";
       String testInput2 = "X^2 + X + 1.0";
       p = new Polynomial(testInput1);
       q = new Polynomial(testInput2);
       ans1 = p.add(q);
       ans2 = p.subtract(q);
       ans3 = p.multiply(q);
       ans4 = p.divide(q);
       //ans5 = p.remainder(q);
       System.out.println("This poly: " + p);
       System.out.println("P Poly: " + q);
       System.out.println("Result of add: " + ans1);
       System.out.println("Result of substract: " + ans2);
       System.out.println("Result of multiply: " + ans3);
       System.out.println("Result of divide: " + ans4);
       //System.out.println("Result of reminder: "+ ans5);
//        if(scnr.hasNext()){
//            testInput1 = scnr.nextLine();
//            p = new Polynomial(testInput1);
//            testInput2 = scnr.nextLine();
//            q = new Polynomial(testInput2);
//            System.out.println("User Input\n***************************");
//            Utility.run(p, q);
//        }
//        //Default test case
//        else{
//            p = new Polynomial(" X^5");
//            q = new Polynomial("X^2 - X + 1");
//            System.out.println("Default Input\n***************************");
//            Utility.run(p, q);
//        }
     }


    /*public static void main(String args[]) throws Exception {
        //Variables
        Scanner scnr = new Scanner(System.in);
        PolynomialInterface p, q;
        String testInput = "";
        //Custom test case
        if(scnr.hasNext()){
            testInput = scnr.nextLine();
            p = new Polynomial(testInput);
            testInput = scnr.nextLine();
            q = new Polynomial(testInput);
            System.out.println("User Input\n***************************");
            Utility.run(p, q);
        }
        //Default test case
        else{
            p = new Polynomial(" X^5");
            q = new Polynomial("X^2 - X + 1");
            System.out.println("Default Input\n***************************");
            Utility.run(p, q);
        }
    }*/
}

       /*
       User Input
      ***************************

         Polynomials
        p =  X^4 + 2.0 X^2 + 3.0
        q =  X^2 + X + 1.0
        Sum  X^4 + 3.0 X^2 + X + 4.0
        Difference  X^4 + X^2 -X + 2.0
        Product  X^6 + X^5 + 3.0 X^4 + 2.0 X^3 + 5.0 X^2 + 3.0 X + 3.0
        Quotient  X^2 -X + 2.0
        Remainder  -X + 1.0
        */
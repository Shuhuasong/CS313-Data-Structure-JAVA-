package PolynomialArithmetic;

class Term {

    Double coefficient;
    int degree;

    public Term() {
        this(null, 0);
    }
    public Term( double coeff, int power){
        this.coefficient = coeff;
        this.degree = power;
    }
    public boolean isPositive() {
        return coefficient > 0;
    }
    public Term(Double coefficient, int degree) {
        this.coefficient = coefficient;
        this.degree = degree;
    }
    public Double getCoefficient() {
        return coefficient;
    }
    public void setCoefficient(Double coefficient) {
        this.coefficient = coefficient;
    }
    public int getDegree() {
        return degree;
    }
    public void setDegree(int degree) {
        this.degree = degree;
    }

    //return a term based on the coefficient and degree
    public String toString() {
        String ans = "";
        if (coefficient.doubleValue() == 0) return ""; //convert the value of the given Integer to a Double type after a widening primitive conversion and returns it.
        if (degree == 0) return coefficient.toString();
        if (coefficient != 1) {
            if (coefficient == -1) ans += "-";
            else ans += coefficient + " ";
        }
        ans = ans + "X";
        if (degree == 1) return ans;
        return ans + "^" + degree;
    }
}
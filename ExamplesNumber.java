import tester.*;
interface Number {
    int numerator();
    int denominator();
    Number add(Number other);
    Number multiply(Number other);
    String toString();
    double toDouble();
}
class WholeNumber implements Number{
    int n;
    WholeNumber(int n)
    {
        this.n = n;
    }
    @Override
    public int numerator() {
        return n;
    }
    @Override
    public int denominator() {
        return 1;
    }
    @Override
    public Number add(Number other) {
        if(other.denominator()==1)
        {
            return new WholeNumber(this.n + other.numerator());
        }
        int num = n*other.denominator()+other.numerator();
        return new Fraction(num, other.denominator());
    }
    @Override
    public Number multiply(Number other) {
        if(other.denominator()==1)
        {
            return new WholeNumber(this.n * other.numerator());
        }
        int num = n*other.numerator();
        return new Fraction(num, other.denominator());
    }
    @Override
    public String toString()
    {
        String num = String.valueOf(n);
        return num;
    }
    @Override
    public double toDouble() {
        double num = (double)n;
        return num;
    }
    
}
class Fraction implements Number{
    int n;
    int d;
    Fraction(int n,int d)
    {
        this.n = n;
        this.d = d;
    }
    @Override
    public int numerator() {
        return this.n;
    }

    @Override
    public int denominator() {
        return this.d;
    }

    @Override
    public Number add(Number other) {
        //add a whole number
        if(other.denominator()==1)
        {
            int num = other.numerator()*this.d+this.n;
            return new Fraction(num, this.d);
        }
        //add another fraction number
        int den = this.d*other.denominator();
        int numer = this.n*other.denominator()+other.numerator()*this.d;
        return new Fraction(numer, den);
    }

    @Override
    public Number multiply(Number other) {
        int numer = this.n*other.numerator();
        int den = this.d*other.denominator();
        return new Fraction(numer, den);
    }
    @Override
    public String toString(){
        String num = String.valueOf(n)+"/"+String.valueOf(d);
        return num;
    }
    @Override
    public double toDouble() {
        double num = (double)n;
        double den = (double)d;
        return num/den;
    }
}
class ExamplesNumber{
    WholeNumber two = new WholeNumber(2);
    WholeNumber Three = new WholeNumber(3);
    Fraction pointFive = new Fraction(1, 2);
    Fraction TwoOverSeven = new Fraction(2, 7);
    //Method Test on WholeNumber
    //test case 1:
    int numTest1 = two.numerator();//expect 2
    int numTest2 = Three.numerator();//expect 3;

    //test case 2:
    int denTest1 = two.denominator();//expect 1;
    int denTest2 = Three.denominator();//expect 1;

    //test case3:
    Number Five = two.add(Three);//expect 5 or numerator 5 and denominator 1
    Number TwoPointFive = two.add(pointFive);//expect 2.5 or numerator 2 and denominator 5

    //test case 4:
    Number Six = two.multiply(Three);//expect 6;
    Number ThreeOverTwo = Three.multiply(pointFive);//expect:3/2 numerator 3 and denominator 3

    //toString method
    String numTwoTest = two.toString();//expect "2";
    String numThreeTest = Three.toString();//expect "3";
    //test case 5:
    double Two = two.toDouble();//expect 2.0;
    double three = Three.toDouble();//expect 3.0

    //Method Test on Fraction
    //test case 6:
    int numTest3  = pointFive.numerator();//expect 1;
    int numTest4 = TwoOverSeven.numerator();//expect 2;

    //test case 7
    int denTest3 = pointFive.denominator();//expect 2
    int denTest4 = TwoOverSeven.denominator();//expect 7;

    //test case 8 
    Number ElevenOverFourteen = pointFive.add(TwoOverSeven);//Expect 11/14
    Number TwentyThreeOverSeven = TwoOverSeven.add(Three);//expect 23/7

    //test case 9:
    Number TwoOverFourteen = pointFive.multiply(TwoOverSeven);//Expect 2/14
    Number SixOverSeven = TwoOverSeven.multiply(Three);//expect 6/7;

    //test toString:
    String stringTest3 = pointFive.toString();//expect "1/2";
    String stringTest4 = TwoOverSeven.toString();//expect "2/7"

    //test toDouble
    double doubleTest = pointFive.toDouble();//expect 0.5
    double doubleTest2 = TwoOverSeven.toDouble();//expect 0.28571429

    //Exploration:
    double explore1 = 0.1+0.2+0.3;//expect 0.6;
    double explore2 = 0.1+(0.2+0.3);//expect 0.6;
    Fraction pointOne = new Fraction(1,10);
    Fraction pointTwo = new Fraction(1,5);
    Fraction pointThree = new Fraction(3,10);
    String explore3 = pointOne.add(pointTwo).add(pointThree).toString();//expect "0.6"
    String explore4 = pointOne.add(pointTwo.add(pointThree)).toString();//expect "0.6"
}

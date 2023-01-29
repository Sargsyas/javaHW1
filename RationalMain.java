import java.util.Scanner;

class Rational {
    private int num;
    private int den;

    public Rational(int numerator, int denominator) {
        this.num = numerator;
        this.den = denominator;
        reduce();
    }

    public void increaseBy(Rational other) {
        num = (int) num * other.den + den * other.num;
        den *= other.den;
        reduce();
    }

    public void multiplyBy(Rational other) {
        num *= other.num;
        den *= other.den;
        reduce();
    }

    public void negate() {
        num = -num;
    }

    public void invert() {
        int placeHolder = num;
        num = den;
        den = placeHolder;
    }

    public String toString() {
        if (den < 0) {
            num = -num;
            den = den * -1;
        }
        return num + "/" + den;
    }

    private void reduce() {
        int commonden = commfunc(num, den);
        num /= commonden;
        den /= commonden;
    }

    private int commfunc(int top, int bottom) {
        if (bottom == 0) {
            return top;
        }
        return commfunc(bottom, top % bottom);
    }
}

public class RationalMain {
    public static void main(String[] args) {
        Scanner rationalInput = new Scanner(System.in);
        int A1 = rationalInput.nextInt();
        int A2 = rationalInput.nextInt();
        Rational A = new Rational(A1, A2);
        char connector = rationalInput.next().charAt(0);
        int B1 = rationalInput.nextInt();
        int B2 = rationalInput.nextInt();
        Rational B = new Rational(B1, B2);

        if (connector == '+') {
            A.increaseBy(B);

        } else if (connector == '-') {
            B.negate();
            A.increaseBy(B);
        } else if (connector == '*') {
            A.multiplyBy(B);
        } else if (connector == '/') {
            B.invert();
            A.multiplyBy(B);
        }

        System.out.println(A);

    }
}

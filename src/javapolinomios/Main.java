package javapolinomios;

/**
 *
 * @author benjag
 */
public class Main {

    public static void main(String[] args) {

        int[] a = new int[3];
        a[0] = 1;
        a[1] = 2;
        a[2] = 3;

        int[] b = new int[3];
        b[0] = 3;
        b[1] = 6;
        b[2] = 1;

        Polynomial pol1 = new Polynomial(a);
        Polynomial pol2 = new Polynomial(b);

        System.out.println(pol1);
        System.out.println("+");
        System.out.println(pol2);
        System.out.println("=");
        pol2.add(pol1);
        System.out.println(pol2);
    }
}

package kr.hs.dgsw.webclass01.calculator;

public interface CalculatorService {
    int calculator(String num1, String num2, String sign);
    boolean haveNull(String num);
    boolean zeroDivide(String num, String sign);

}
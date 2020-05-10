package kr.hs.dgsw.webclass01.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetController {
    @Autowired
    private CalculatorService cs;

    @GetMapping("/calculator/{num1}/{num2}/{sign}")
    public String calculator(@PathVariable String num1, @PathVariable String num2, @PathVariable String sign){
        if(cs.haveNull(num1) || cs.haveNull(num2))
            return "빈 칸을 채워주십시오.";
        else if(cs.zeroDivide(num2,sign))
            return "0으로 나눌 수 없습니다.";
        else
            return Integer.toString(cs.calculator(num1, num2, sign));
    }
}
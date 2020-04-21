package kr.hs.dgsw.webclass01;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
public class HelloController {
    @GetMapping("/calculate")
    public String calculate(@RequestParam final int num1, @RequestParam final int num2, @RequestParam final int operator) {
        return Integer.toString(calculParam(num1,num2,operator));
    }
    @GetMapping("/calculate2/{num1}/{num2}/{operator}")
    public String calculate2(@PathVariable final int num1, @PathVariable final int num2,@PathVariable final int operator){
         return Integer.toString(calculParam(num1,num2,operator));
    }
    public int calculParam(int num1, int num2, int operator){
        int result = 0;
        if(operator == 0) result = num1 + num2;
        else if(operator == 1) result = num1 -= num2;
        else if(operator == 2) result = num1 *= num2;
        else if(operator == 3) result = num1 /= num2;

        return result;
    }

    }


package kr.hs.dgsw.weblog.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kr.hs.dgsw.weblog.Domain.User;
import kr.hs.dgsw.weblog.Protocol.ResponseFormat;
import kr.hs.dgsw.weblog.Protocol.ResponseType;
import kr.hs.dgsw.weblog.Service.UserService;

@RestController
//기존의 특정한 JSP와 같은 뷰를 만들어 내는 것이 아닌 REST방식의 데이터 자체를 서비스 하는 것.
public class UserController {
    @Autowired
    //생성자나 세터 등을 사용하여 의존성 주입을 하려고 할 때, 해당 빈을 찾아서 주입해주는 annotation.
    private UserService userService;

    @PostMapping("/user/create")
    //기존에 사용하였던 @RequestMapping 속성을 지정해 주기보다 간단히 사용할 수 있도록 스프링 4.3버전부터 출시된 annotation.
    public ResponseFormat create(@RequestBody User user){
        User newUser = userService.create(user);
        if(newUser != null){
            return new ResponseFormat(
                ResponseType.USER_ADD,
                newUser,
                newUser.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @PutMapping("/user/update/{id}")
    //기존에 사용하였던 @RequestMapping 속성을 지정해 주기보다 간단히 사용할 수 있도록 스프링 4.3버전부터 출시된 annotation.
    public ResponseFormat update(@PathVariable Long id, @RequestBody User user){
        if(userService.update(id, user) != null){
            return new ResponseFormat(
                ResponseType.USER_UPDATE,
                userService.update(id, user),
                user.getId()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @DeleteMapping("/user/delete/{id}")
    //기존에 사용하였던 @RequestMapping 속성을 지정해 주기보다 간단히 사용할 수 있도록 스프링 4.3버전부터 출시된 annotation.
    public ResponseFormat delete(@PathVariable Long id) {
        if(userService.delete(id)){
            return new ResponseFormat(
                ResponseType.USER_DELETE,
                userService.delete(id),
                id
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/user/read/{id}")
    // 기본적인 작동원리로는 GET의 HTTP(S) request를 처리
    public ResponseFormat read(@PathVariable Long id){
        if(userService.read(id) != null){
            return new ResponseFormat(
                ResponseType.USER_GET,
                userService.read(id),
                id
            );

        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }

    @GetMapping("/user/read")    
    // 기본적인 작동원리로는 GET의 HTTP(S) request를 처리
    public ResponseFormat readAll(){
        if(userService.readAll() != null){
            return new ResponseFormat(
                ResponseType.USER_GET_ALL,
                userService.readAll()
            );
        } else {
            return new ResponseFormat(
                ResponseType.FAIL,
                null
            );
        }
    }
}
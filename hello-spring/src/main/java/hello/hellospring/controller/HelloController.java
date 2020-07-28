package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("hello") //get메서드
    public String hello(Model model){
        model.addAttribute("data","hello!");
        return "hello"; //templates의 hello파일을 찾아서 렌더링
    }

}

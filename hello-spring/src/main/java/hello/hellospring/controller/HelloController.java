package hello.hellospring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController<name, hello> {

    @GetMapping("hello") //get메서드 hello 호출시 이 메서드가 호출
    public String hello(Model model){
        model.addAttribute("data","hello!"); //key는 data 값은 hello
        return "hello"; //templates의 hello파일을 찾아서 렌더링
    }
    //컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리한다.
    //resources : templates/ + {viweName(hello)} + .html

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(value = "na") String name, Model model){
        model.addAttribute("name",name); //name 파라미터가 주소 입력한 값으로 바뀐다.
        return "hello-template";
    }
    //@RequestParam 어노테이션은 단일 매개변수를 전달 받을 때 사용한다.
    //vlaue 속성은 HTTP요청 파라미터의 이름을 지정한다. URL을 처리할 때 사용한다.
    //value =  location:8080/hello-mvc?name =*** 에서 name을 의미

    @GetMapping("hello-string")
    @ResponseBody //http에서 바디부에 이 데이터를 직접 넣어주겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello" + name; // hello spring
        //내가 요청한 클라이언트에 그대로 내려감

    }
    @GetMapping("hello-api")
    @ResponseBody  //객체가오면 기본 디폴트가 그냥 제이슨 방식으로 데이터를 만들어서 http에 반환하겠다.
    public  Hello helloApi(@RequestParam("name") String name) {     //객체를 만듬
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }
    static class Hello{ //HelloController.Hello 같은 느낌
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}
//alt + insert 누르고 getter setter
//객체는 대부분 json만 쓴다.





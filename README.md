# Springboot Study

2020 8/9

1. **MVC (Model View Controller)**
   - model : 필요한 view만 담아서 화면에 전달한다.
   - view : 화면의 보이는 내용을 담당한다.
   - controller : 서버 뒷단에 관련된 것을 처리한다.

2. **처음보는 어노테이션 사용의 대해 찾아보느라 시간이 많이 소요되었다.**

- GetMapping(" ") 

- RequestParam

  ```java
  @GetMapping("hello-mvc") get메서드 hello-mvc 호출시 이 메서드가 호출
  public String helloMvc(@RequestParam(value = "name") String name, Model model){
      model.addAttribute("name",name); //name 파라미터가 주소 입력한 값으로 바뀐다.
      return "hello-template";
      //templates 디렉터리에 hello-template파일을 찾아서 렌더링
  }
  ```

  1) . 단일 매개변수를 전달 받을 때 사용한다.

  2 ). value 속성을 HTTP요청 파라미터 이름을 지정한다. URL을 처리할 때 사용한다.

  3) .  model.addAttribute("name",name); 첫 번째 매개변수는 key이고 두 번 째 매개변수는 key에 할당될 값이다. 

  4). location:8080/hello-mvc?name= (검색한 값이 key값에 전달되어서 페이지에 호출) 에서 name이 value 값
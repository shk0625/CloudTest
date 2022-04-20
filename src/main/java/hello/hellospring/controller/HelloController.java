package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "Spring!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    // 조작해서 html 에 넣는다는 느낌(jsp)
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    // 그냥 쌩으로다가 때려박는다는 느낌
    public String helloString(@RequestParam("name") String name){
        //응답 바디부에 아래있는 'hello' + name 을 직접 넣어주겠다는 뜻.
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    // Json 방식으로 출력됨.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }
}

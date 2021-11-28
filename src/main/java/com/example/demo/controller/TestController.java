package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/*
@GetMapping 어노테이션은 스프링 4.3부터 지원. 이전에는
@RequestMapping(value="/경로", method = RequestMethod.GET)으로 사용함.
 */

@RestController
@RequestMapping("test") // 리소스
public class TestController {

    @GetMapping
    public String testController() {
        return "Hello, World";
    }

    // GetMapping에 경로 지정
    @GetMapping("/testGetMapping")
    public String testControllerWithPath() {
        return "Hello, World testGetMapping";
    }

    // 매개변수를 넘겨받기
    @GetMapping("/{id}")
    public String testControllerWithPathVariables(@PathVariable(required = false) int id) {
        return "Hello, World! ID " + id;
    }

    // @RequestParam 사용 시 ?id={id} 와 같이 요청 매개변수로 넘어오는 값을 변수로 받을 수 있다.
    @GetMapping("/testRequestParam")
    public String testControllerRequestParam(@RequestParam(required = false) int id) {
        return "Hello, World! ID " + id;
    }

    // 복잡한 자료형을 통째로 요청에 보내고 싶은 경우
    @GetMapping("/testRequestBody")
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO) {
        return "Hello World! ID " + testRequestBodyDTO.getId() + " Message : "
            + testRequestBodyDTO.getMessage();
    }

    // 응답으로 오브젝트 리턴 가능
    @GetMapping("/testResponseBody")
    public ResponseDTO<String> testControllerResponseBody() {
        List<String> list = new ArrayList<>();
        list.add("Hello World! ResponseBody Test");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    // ResponseEntity는 HTTP 응답의 Body뿐만 아니라 여러 다른 매개변수들(status, Header) 를 조작하고 싶을 때 사용
    @GetMapping("/testResponseEntity")
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("ResponseEntity, 400");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        // http status를 400으로 설정
        return ResponseEntity.badRequest().body(response);
    }
}

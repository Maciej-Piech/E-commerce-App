package pl.mpiech.credit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.System.out;

@RestController
public class HelloController {

    @GetMapping("/hello")
    String hello() {
        return "Hello";
    }

    ;
}


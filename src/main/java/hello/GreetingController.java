package hello;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/longs")
    public long getLongs(@RequestParam(value = "longs")long longs){
        System.out.println(longs);
        return longs;
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(){
        return "hello";
    }


    @RequestMapping("/employees")
    public String handleEmployeeRequestByDept(@RequestParam("dept") String deptName,
                                              @RequestParam("state") String stateCode,
                                              Model map) {
        map.addAttribute("msg", "employees request by dept and state code : " +
                deptName + ", " + stateCode);
        return map.toString();
    }

}

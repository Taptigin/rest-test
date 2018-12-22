package hello;

import org.springframework.web.bind.annotation.*;

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


    @RequestMapping("/employees/{id}/paystubsByMonths")
    public String handleRequest4 (@PathVariable("id") String employeeId,
                                  @RequestParam("months") int previousMonths) {
        return "empId = " + employeeId + " " + "epmMonths " + previousMonths;
    }

    @RequestMapping(value = "/ex/foos", method = RequestMethod.POST)
    @ResponseBody
    public String postFoos() {
        return "Post some Foos";
    }

}

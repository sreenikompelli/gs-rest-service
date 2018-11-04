package hello;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping({"/api/greeting", "/greeting"})
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                            String.format(template, name));
    }



    @RequestMapping("/api/uuid")
    public String getUUID(@RequestParam(value="key") String key) {
            // Creating a random UUID (Universally unique identifier).
            UUID uuid = UUID.randomUUID();
            String randomUUIDString = uuid.toString();
            if(StringUtils.isEmpty(key)) {
                key="NOT SENT";
            }
            System.out.println("key: " + key + "  Random UUID generated: " + randomUUIDString);
           // System.out.println("UUID version       = " + uuid.version());
            //System.out.println("UUID variant       = " + uuid.variant());
            return randomUUIDString;
        }


}

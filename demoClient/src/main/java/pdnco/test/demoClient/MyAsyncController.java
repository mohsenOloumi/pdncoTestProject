package pdnco.test.demoClient;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

@RestController
public class MyAsyncController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private DirectExchange exchange;
    @Bean
    public DirectExchange exchange() {
        return new DirectExchange("spring-boot-exchange");
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String taskExecutor(@RequestParam("from") int from, @RequestParam("to") int to) throws InterruptedException,
            ExecutionException {

        String number = "";
        rabbitTemplate.setReplyTimeout(100000);
        HashMap<String,Integer> hashMap = new HashMap();
        hashMap.put("from",from);
        hashMap.put("to",to);
        number = (String) rabbitTemplate.convertSendAndReceive(exchange.getName(), "pdnco-message-queue", hashMap);

        System.out.println(number);
        return "the number is " + hashMap;
    }

}

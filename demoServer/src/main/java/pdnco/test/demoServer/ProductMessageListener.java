package pdnco.test.demoServer;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ProductMessageListener {
    public String receiveMessage(HashMap<String,Integer> hashMap) throws InterruptedException {
        int from = hashMap.get("from");
        int to = hashMap.get("to");
        while (from<to){
            from+=1;
            Thread.sleep(1);
        }
        System.out.println("Message processed..."  );
        return "Message processed...";
    }
}

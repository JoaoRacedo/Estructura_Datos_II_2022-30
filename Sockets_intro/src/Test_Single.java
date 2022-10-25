import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test_Single {
    
    @Test
    public void Test1(){
        Client_Class client = new Client_Class();
        client.Connect_to_Server("127.0.0.1",5555);
        String response = client.sendMessage("hello server");
        assertEquals("hello client", response);
    }
}
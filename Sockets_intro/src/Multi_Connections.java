import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Multi_Connections {
    private Client_Class client;

    // estable conex con cliente
    @Before
    public void setup(){
        client = new Client_Class();
        client.Connect_to_Server("127.0.0.1", 4444);
    }

    @After
    public void tearDown(){
        client.stop();
    }

    @Test
    public void Test1(){

        String response1 = client.sendMessage("holaaaaaa");
        assertEquals("holaaaaaa", response1);
        String response2 = client.sendMessage("hello");
        assertEquals("hello", response2);
        String response3 = client.sendMessage("server");
        assertEquals("server", response3);
        String response4 = client.sendMessage("bye");
        assertEquals("good bye", response4);

    }

}
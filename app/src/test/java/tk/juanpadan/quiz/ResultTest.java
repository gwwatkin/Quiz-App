package tk.juanpadan.quiz;

import org.junit.Test;

import static org.junit.Assert.*;

public class ResultTest {

    @Test
    public void show() {
        Result r = new Result("test","some string");
        assertEquals(r.show(),"some string");
    }
}
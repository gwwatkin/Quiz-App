package tk.juanpadan.quiz;

import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class AnswerTest {

    @Test
    public void getResultScores() {


        Answer a = new Answer("a","answer");
        a.bindResult(new Result("r1","r1"),100);


        HashMap<String,Integer> res = a.getResultScores();

        assertEquals((int)res.get("r1"),100);

    }

    @Test
    public void bindResult() {

        Answer a = new Answer("a","answer");
        a.bindResult(new Result("r1","r1"),100);
        a.bindResult(new Result("r2","r1"),200);

        HashMap<String,Integer> res = a.getResultScores();

        assertEquals((int)res.get("r1"),100);
        assertEquals((int)res.get("r2"),200);

        assertEquals(res.size(),2);
    }

    @Test
    public void show() {
        Answer a = new Answer("a","answer");

        assertEquals(a.show(),"answer");
    }

}
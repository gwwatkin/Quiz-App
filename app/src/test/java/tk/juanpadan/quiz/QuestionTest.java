package tk.juanpadan.quiz;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class QuestionTest {


    @Test
    public void getQuestionText() {
        Question q = new Question("q","question");

        assertEquals(q.getQuestionText(),"question");
    }


    @Test
    public void bind() {
        Question q = new Question("q","question");
        q.bind(new Answer("a","answer"),new Result("r","result"),100);

        assertEquals(q.getNumOfAnswers(),1);

        HashMap<String,Integer> ress = q.getResultsByAnswerNumber(0);
        assertEquals((long)ress.get("r"),100);
    }



    @Test
    public void getNumOfAnswers() {
        Question q = new Question("q","question");
        q.bind(new Answer("a","answer"),new Result("r","result"),100);

        assertEquals(q.getNumOfAnswers(),1);

    }

    @Test
    public void getResultsByAnswerNumber() {

        Question q = new Question("q","question");
        q.bind(new Answer("a1","answer1"),new Result("r0","result"),100);
        q.bind(new Answer("a2","answer2"),new Result("r1","result"),101);
        q.bind(new Answer("a2","answer2"),new Result("r2","result"),102);


        HashMap<String,Integer> ress1 = q.getResultsByAnswerNumber(0);
        assertEquals(ress1.size(),1);
        assertEquals((long)ress1.get("r0"),100);


        HashMap<String,Integer> ress2 = q.getResultsByAnswerNumber(1);
        assertEquals(ress2.size(),2);
        assertEquals((long)ress2.get("r1"),101);
        assertEquals((long)ress2.get("r2"),102);


    }


    @Test
    public void getPossibleAnswers() {
        Question q = new Question("q","question");
        q.bind(new Answer("a1","answer1"),new Result("r0","result"),100);
        q.bind(new Answer("a2","answer2"),new Result("r1","result"),101);
        q.bind(new Answer("a2","answer2"),new Result("r2","result"),102);


        ArrayList<Answer> answers = q.getPossibleAnswers();
        assertEquals(answers.size(),2);
        assertEquals(answers.get(0).id,"a1");
        assertEquals(answers.get(1).id,"a2");


    }



    @Test
    public void getPossibleAnswersText() {

        Question q = new Question("q","question");
        q.bind(new Answer("a1","answer1"),new Result("r0","result"),100);
        q.bind(new Answer("a2","answer2"),new Result("r1","result"),101);
        q.bind(new Answer("a2","answer2"),new Result("r2","result"),102);


        ArrayList<String> answersText = q.getPossibleAnswersText();
        assertEquals(answersText.size(),2);
        assertEquals(answersText.get(0),"answer1");
        assertEquals(answersText.get(1),"answer2");
    }
}
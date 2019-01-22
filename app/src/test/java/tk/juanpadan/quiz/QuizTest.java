package tk.juanpadan.quiz;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuizTest {


    @Test
    public void getName() {
        Quiz q = new Quiz("quiz","desc");
        assertEquals(q.getName(),"quiz");
    }

    @Test
    public void getDescription() {
        Quiz q = new Quiz("quiz","desc");
        assertEquals(q.getDescription(),"desc");
    }



    @Test
    public void addQuestion() {
        Quiz q = new Quiz("quiz","desc");
        q.addQuestion(new Question("q","question"));

        assertEquals(q.numberOfQuestions(),1);
    }

    @Test
    public void addResult() {
        Quiz q = new Quiz("quiz","desc");
        Result r = new Result("r","result");
        q.addResult(r);

        assertEquals(q.getResult("r"),r);
    }

    @Test
    public void numberOfQuestions() {
        Quiz q = new Quiz("quiz","desc");
        Question quest = new Question("q","question");
        Question quest1 = new Question("q1","question");
        q.addQuestion(quest);
        q.addQuestion(quest1);

        assertEquals(q.numberOfQuestions(),2);
    }

    @Test
    public void getQuestion() {

        Quiz q = new Quiz("quiz","desc");
        Question quest = new Question("q","question");
        Question quest1 = new Question("q1","question");
        q.addQuestion(quest);
        q.addQuestion(quest1);

        assertEquals(q.getQuestion(1),quest1);

    }

    @Test
    public void getResult() {
        Quiz q = new Quiz("quiz","desc");
        Result r = new Result("r","result");
        q.addResult(r);

        assertEquals(q.getResult("r"),r);
    }



}
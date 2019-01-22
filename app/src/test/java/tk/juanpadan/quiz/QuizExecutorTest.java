package tk.juanpadan.quiz;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuizExecutorTest {

    @Test
    public void getCurrentQuestion() {

        QuizExecutor qe = new QuizExecutor(DefaultQuizes.doYouLikeThisApp());

        Question q = qe.getCurrentQuestion();
        assertEquals(q.id,"q");
    }

    @Test
    public void answerCurrentQuestion() {

        QuizExecutor qe = new QuizExecutor(DefaultQuizes.doYouLikeThisApp());
        qe.answerCurrentQuestion(1);

        assertEquals(qe.getResultText(),
                "May the TA have mercy upon the student's soul.\n ._.");

    }

    @Test
    public void quizDone() {
        QuizExecutor qe = new QuizExecutor(DefaultQuizes.doYouLikeThisApp());
        qe.answerCurrentQuestion(1);

        assertTrue(qe.quizDone());

    }

    @Test
    public void getResultText() {

        QuizExecutor qe = new QuizExecutor(DefaultQuizes.doYouLikeThisApp());
        qe.answerCurrentQuestion(1);

        assertEquals(qe.getResultText(),
                "May the TA have mercy upon the student's soul.\n ._.");
    }
}
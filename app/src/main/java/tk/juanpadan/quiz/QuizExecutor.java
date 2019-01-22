package tk.juanpadan.quiz;

import java.util.HashMap;
import java.util.Map;

public class QuizExecutor {

    private Quiz quiz;

    private int questionCounter;

    private HashMap<String,Integer> partialResults;

    QuizExecutor(Quiz quiz_)
    {
        quiz = quiz_;
        questionCounter = 0;
        partialResults = new HashMap<>();
    }


    Question getCurrentQuestion()
    {
        return quiz.getQuestion(questionCounter);
    }


    /*
     * Apply the scores to the current question with the given answer and move on to the next
     * question
     */
    void answerCurrentQuestion(int answerNumber)
    {
        Question q = this.getCurrentQuestion();

        this.applyScores(q.getResultsByAnswerNumber(answerNumber));

        questionCounter++;
    }



    boolean quizDone()
    {
        return this.questionCounter >= quiz.numberOfQuestions();
    }



    String getResultText()
    {
        return quiz.getResult(getResultId()).show();
    }



    private void applyScores(HashMap<String,Integer> scores)
    {
        for (Map.Entry<String,Integer> score: scores.entrySet())
            this.keepScore(score.getKey(),score.getValue());

    }


    private void keepScore(String result_id, int score)
    {
        if(!partialResults.containsKey(result_id))
        {
            partialResults.put(result_id, score);
        }
        else
        {
            int prev = partialResults.get(result_id);
            partialResults.put(result_id,prev+score);
        }
    }




    private String getResultId()
    {
        if(partialResults.size()==0)
            return null;

        //find the max and then return the string
        String best = partialResults.keySet().iterator().next();

        for(Map.Entry<String,Integer> entry: partialResults.entrySet())
            if(entry.getValue()>partialResults.get(best))
                best=entry.getKey();

        return best;

    }




}

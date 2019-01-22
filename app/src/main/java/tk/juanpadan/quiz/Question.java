package tk.juanpadan.quiz;

import android.os.Build;
import android.support.annotation.RequiresApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;

public class Question
{
    public String id;



    private String question;
    private ArrayList<Answer> possibleAnswers;


    Question(String id_,String question_)
    {
        id = id_;
        question = question_;
        possibleAnswers = new ArrayList<Answer>();
    }


    public void bind(Answer the_answer, Result result, int score)
    {
        Answer newAnswer = new Answer(the_answer);

        int oldAnswerIndex = this.getAnswerIndexById(newAnswer.id);

        if(oldAnswerIndex == -1)
        {
            newAnswer.bindResult(result,score);
            possibleAnswers.add(newAnswer);
        }
        else
        {
            Answer old_answer = possibleAnswers.get(oldAnswerIndex);
            old_answer.bindResult(result, score);
        }
    }


    public int getNumOfAnswers()
    {
        return possibleAnswers.size();
    }



    public HashMap<String,Integer> getResultsByAnswerNumber(int answer_number)
    {
        return possibleAnswers.get(answer_number).getResultScores();
    }

    public String getQuestionText() {
        return question;
    }

    public ArrayList<Answer> getPossibleAnswers() {
        return possibleAnswers;
    }


    public ArrayList<String> getPossibleAnswersText() {
        ArrayList<String> out = new ArrayList<>();
        for (Answer answer: getPossibleAnswers())
            out.add(answer.show());
        return out;
    }


    /**
     * @param a_id
     * @return -1 on fail otherwise the index
     */
    private int getAnswerIndexById(String a_id)
    {
        int i = 0;
        for (Answer answer:possibleAnswers)
        {
            if(answer.id.equals(a_id))
                return i;
            i++;
        }
        return -1;
    }



}

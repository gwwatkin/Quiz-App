package tk.juanpadan.quiz;

import java.util.HashMap;
import java.util.Map.Entry;

public class Answer
{
    String id;
    private String answer;
    private HashMap<String,Integer> resultValues; // result_id => score

    Answer(String id_, String answer_)
    {
        id = id_;
        answer = answer_;
        resultValues = new HashMap<String,Integer>();
    }

    Answer(Answer a)
    {
        id = a.id;
        answer = a.answer;
        resultValues = new HashMap<>(a.resultValues);
    }


    public HashMap<String,Integer> getResultScores()
    {
        return resultValues;
    }

    public void bindResult(Result result, Integer score)
    {
        resultValues.put(result.id,score);
    }

    public String show()
    {
        return answer;
    }

}




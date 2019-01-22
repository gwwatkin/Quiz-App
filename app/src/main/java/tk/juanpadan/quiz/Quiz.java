package tk.juanpadan.quiz;



import java.util.ArrayList;


public class Quiz
{


    private String name;
    private String description;

    private ArrayList<Question> questions;

    private ArrayList<Result> results;


    Quiz(String name_, String description_)
    {
        name = name_;
        description = description_;

        questions = new ArrayList<Question>();

        results = new ArrayList<Result>();

    }



    public void addQuestion(Question q)
    {
        questions.add(q);
    }


    public void addResult(Result r)
    {
        results.add(r);
    }



    public int numberOfQuestions()
    {
        return questions.size();
    }

    public Question getQuestion(int index)
    {
        return questions.get(index);
    }



    public Result getResult(String r_id)
    {
        // match the string with the result
        for(Result r : this.results)
            if(r.id.equals(r_id))
                return r;

        return null;
    }


    public String getName()
    {
        return name;
    }

    public String getDescription()
    {
        return description;
    }
}

package tk.juanpadan.quiz;


public class Result
{
    public String id;
    public String name;

    Result(String id_, String name_)
    {
        id = id_;
        name = name_;
    }

    public String show()
    {
        return name;
    }


}

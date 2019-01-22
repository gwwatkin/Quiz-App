package tk.juanpadan.quiz;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class DefaultQuizes{


    // have to use a regular c style array because that's what the adapters's constructor accepts
    public static LinkedHashMap<String,Quiz> getSome()
    {
        LinkedHashMap<String,Quiz> map = new LinkedHashMap<>();

        map.put("pet",petForYou());
        map.put("liking",doYouLikeThisApp());

        return map;
    }


     static Quiz petForYou()
    {
        //make a quiz
        Quiz qz = new Quiz(
                "Choose your pet!",
                "Complete this quiz to find out what kind of pet you should have"
        );

        // define results
            Result r_dog = new Result("dog","Your pet should be: A Dog");
            Result r_cat = new Result("cat","Your pet should be: A Cat");
            Result r_fish = new Result("fish","Your pet should be: A Fish");

        // add them to the quiz
            qz.addResult(r_dog);
            qz.addResult(r_cat);
            qz.addResult(r_fish);


        // define answers
            Answer a_yes = new Answer("yes","Yes");
            Answer a_no = new Answer("no","No");
            Answer a_a_bit = new Answer("a_bit","A little bit");
            Answer a_sometimes = new Answer("sometimes","Some times");
            Answer a_indoor = new Answer("indoor","Indoor");
            Answer a_outdoor = new Answer("outdoor","Outdoor");
            Answer a_jazz = new Answer("jazz","Jazz/Classical");
            Answer a_rock = new Answer("rock","Rock/Metal");
            Answer a_country = new Answer("country","Country/Folk");
            Answer a_rap = new Answer("rap","R&B/Rap/Pop");
            Answer a_morning = new Answer("morning","A Morning Person?");
            Answer a_night = new Answer("night","A Night Person?");




        // define questions
            Question q_water = new Question("water","Do you like water?");
            Question q_walks = new Question("walks","Do you like walks?");
            Question q_door = new Question("door","Indoor or Outdoor?");
            Question q_music = new Question("music","what do you prefer?");
            Question q_day = new Question("day","Are you...");



        // answers can be combined with results and questions in any way
            q_water.bind(a_yes,r_fish,100);
            q_water.bind(a_yes,r_dog,25);
            q_water.bind(a_no,r_cat,100);
            q_water.bind(a_sometimes,r_dog,50);
            q_water.bind(a_sometimes,r_fish,25);

            q_walks.bind(a_yes,r_dog,100);
            q_walks.bind(a_yes,r_cat,20);
            q_walks.bind(a_no,r_fish, 100);
            q_walks.bind(a_a_bit,r_cat, 40);
            q_walks.bind(a_a_bit,r_dog,25);

            q_door.bind(a_indoor,r_fish,100);
            q_door.bind(a_indoor,r_cat,75);
            q_door.bind(a_outdoor,r_dog,100);
            q_door.bind(a_outdoor,r_cat,25);

            q_music.bind( a_jazz, r_cat, 1000);
            q_music.bind(a_jazz, r_fish, 50);
            q_music.bind(a_rock, r_dog, 100);
            q_music.bind(a_rock, r_cat, 25);
            q_music.bind(a_country, r_dog, 100);
            q_music.bind(a_country, r_cat, 50);
            q_music.bind(a_rap, r_cat, 100);
            q_music.bind(a_rap, r_fish, 25);

            q_day.bind(a_morning, r_dog, 100);
            q_day.bind(a_morning, r_cat, 75);
            q_day.bind(a_night, r_cat, 100);
            q_day.bind(a_night, r_fish, 75);




        // now we can add the questions to the quiz

            qz.addQuestion(q_water);
            qz.addQuestion(q_walks);
            qz.addQuestion(q_door);
            qz.addQuestion(q_music);
            qz.addQuestion(q_day);


        return qz;

    }



     static Quiz doYouLikeThisApp(){
        Quiz qz = new Quiz(
                "Do you like this app?",
                "I know you do"
        );

        Result r_good= new Result("good","> Fv11 m4rk5 plz < \nUwU");
        Result r_bad= new Result("bad","May the TA have mercy upon the student's soul.\n ._.");

        qz.addResult(r_good);
        qz.addResult(r_bad);

        Answer a_yes = new Answer("yes","YESSSS");
        Answer a_no = new Answer("no","well...");

        Question q = new Question("q","Do you like this app?");

        q.bind(a_yes,r_good,1);
        q.bind(a_no,r_bad,1);

        qz.addQuestion(q);

        return qz;
    }

}
package tk.juanpadan.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class QuizPage extends AppCompatActivity {

    public static QuizExecutor quizExecutor;
    public TextView questionViewer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //BEGIN Android studio
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final Activity parentActivity = this;
        //END Android studio


        if(getIntent().getBooleanExtra("newQuiz",false))
        {   // i.e. we came here from main activity
            // we need to initialize the quiz
            String quizId = getIntent().getStringExtra("quiz");
            initNewQuiz(quizId);
        }
        assert quizExecutor != null;


        if(quizExecutor.quizDone())
            launchResultPage();
        else
            drawQuestion(quizExecutor.getCurrentQuestion());

    }




    void initNewQuiz(String quizId)
    {
        quizExecutor = new QuizExecutor(MainActivity.mainQuizes().get(quizId));
    }




    void drawQuestion(Question q)
    {

        questionViewer = findViewById(R.id.quiz_question);
        questionViewer.setText(q.getQuestionText());


        ArrayList<String> answers = q.getPossibleAnswersText();

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,R.layout.answer_text_view,answers);

        ListView answer_list = (ListView) findViewById(R.id.answer_list_view);
        answer_list.setAdapter(adapter);
        answer_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                quizExecutor.answerCurrentQuestion(position);

                //restart the activity
                Intent intent = getIntent();
                finish();
                intent.putExtra("newQuiz",false);
                startActivity(intent);
            }
        });

    }


    void launchResultPage()
    {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("result", quizExecutor.getResultText() );
        finish();
        startActivity(intent);
    }


}

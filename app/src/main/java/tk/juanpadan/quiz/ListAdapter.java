package tk.juanpadan.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.LinkedHashMap;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.Holder>
{


    private LinkedHashMap<String,Quiz> quizes;

    private Activity parentActivity;

    ListAdapter(LinkedHashMap<String,Quiz> quizes_, Activity parentActivity_)
    {
        quizes = new LinkedHashMap<>(quizes_);

        parentActivity = parentActivity_;
    }


    public static class Holder extends RecyclerView.ViewHolder
    {
        public TextView name;
        public TextView description;
        public Button link;


        Holder(View itemView, final Activity parentActivity)
        {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.quiz_name);
            description = (TextView) itemView.findViewById(R.id.quiz_description);
            link = (Button) itemView.findViewById(R.id.quiz_link);

        }
    }


    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View quiz_row_view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.quiz_chooser_row,viewGroup,false);

        return new Holder(quiz_row_view,parentActivity);
    }

    @Override
    public void onBindViewHolder(Holder holder,int position)
    {
        final String quizId = (String) quizes.keySet().toArray()[position] ;

        holder.name.setText( quizes.get(quizId).getName() );
        holder.description.setText( quizes.get(quizId).getDescription() );

        holder.link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(parentActivity, QuizPage.class);
                intent.putExtra("newQuiz",true );
                intent.putExtra("quiz", quizId);
                parentActivity.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount()
    {
        return quizes.size();
    }




}

package com.amazonaws.demo.s3_transfer_manager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.demo.s3_transfer_manager.models.Comment;
import com.amazonaws.demo.s3_transfer_manager.models.Genie;
import com.amazonaws.demo.s3_transfer_manager.models.UserProfile;

import java.util.List;
import java.util.Map;


public class CommentActivity extends Activity {

    public static Genie genie;
    public static List<Comment> commentList;

    TextView welcomeTxt;
    TextView detailsTxt;
    LinearLayout comments;

    public static void setGenie(Genie genie) {
        CommentActivity.genie = genie;
    }

    public static void setGenieList(List<Comment> commentList) {
        CommentActivity.commentList = commentList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        welcomeTxt = (TextView)findViewById(R.id.welcome);
        detailsTxt = (TextView)findViewById(R.id.descrip);
        genie=HttpUtil.getTickets().get(0);
        commentList=HttpUtil.getComments((int)genie.getId());
        ((RatingBar)findViewById(R.id.rating)).setRating(Float.parseFloat(genie.getRating()));
        UserProfile profile=HttpUtil.getProfile();
        String welcomeMsg="Welcome Mr."+ profile.getFirstName()+" ,"+profile.getLastName();
        String desc=profile.getAddress1()+","+profile.getAddress2()+" "+profile.getCity()+", "+profile.getState()
                +" \n "+profile.getEmailId()+" \n "+profile.getPhoneNo();

        welcomeTxt.setText(welcomeMsg);
        detailsTxt.setText(desc);
        comments=(LinearLayout)findViewById(R.id.comment);
        TextView btn;RatingBar ratingBar; LinearLayout layout;
        int count=0;
        for(Comment comment:commentList){
             layout=new LinearLayout(this);
             ratingBar=new RatingBar(this);


            btn=new TextView(this);
            btn.setText(comment.getDescription());
            if("closed".equalsIgnoreCase(genie.getGenieStatusType().getType()))
                btn.setBackgroundColor(Color.GREEN);
            else
                btn.setBackgroundColor(Color.RED);

            btn.setId(1000+count );
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(getApplicationContext(), "Open genie " + view.getId(), Toast.LENGTH_SHORT)
                            .show();
                    CommentActivity.setGenie(genie);
                    CommentActivity.setGenieList( HttpUtil.getComments(view.getId()) );
                   /* Intent intent = new Intent(commentActivity.class,HomeActivity.class);
                    startActivity(intent);*/
                }
            });
            layout.addView(btn);

            comments.addView(layout);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_comment, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

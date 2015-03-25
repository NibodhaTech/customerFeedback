package com.amazonaws.demo.s3_transfer_manager;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.amazonaws.demo.s3_transfer_manager.models.Comment;
import com.amazonaws.demo.s3_transfer_manager.models.Genie;
import com.amazonaws.demo.s3_transfer_manager.models.UserProfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DashboardActivity extends Activity {

    TextView welcomeTxt;
    TextView detailsTxt;
    LinearLayout genies;
    public static Map<Integer, Genie> idMap;
    public static Genie genie;
    public static List<Comment> commentList;


    public static void setGenie(Genie genie) {
        CommentActivity.genie = genie;
    }

    public static void setGenieList(List<Comment> commentList) {
        CommentActivity.commentList = commentList;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_welcome);

        welcomeTxt = (TextView)findViewById(R.id.welcome);
        detailsTxt = (TextView)findViewById(R.id.particular);
        UserProfile profile=HttpUtil.getProfile();
        String welcomeMsg="Welcome Mr."+ profile.getFirstName()+" ,"+profile.getLastName();
        String desc=profile.getAddress1()+","+profile.getAddress2()+" "+profile.getCity()+", "+profile.getState()
                +" \n "+profile.getEmailId()+" \n "+profile.getPhoneNo();

        welcomeTxt.setText(welcomeMsg);
        detailsTxt.setText(desc);
        genies=(LinearLayout)findViewById(R.id.genies);
        List<Genie> allTickets=new ArrayList<Genie>();

        allTickets=HttpUtil.getTickets();
        Button btn;
        genies.removeAllViews();
        idMap=new HashMap<Integer, Genie>();
        int count=1000;
        Toast.makeText(getApplicationContext(), "No of genie raised by you is " + allTickets.size(), Toast.LENGTH_SHORT)
                .show();
        for (Genie genie:allTickets){
            btn=new Button(this);
            btn.setText(genie.getId()+"  :  " + genie.getDescription());
            if("closed".equalsIgnoreCase(genie.getGenieStatusType().getType()))
            btn.setBackgroundColor(Color.GREEN);
            else
            btn.setBackgroundColor(Color.RED);
            btn.setTag(genie.getId());
            idMap.put((int)genie.getId(), genie);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    long id=Long.parseLong(view.getTag().toString());
                    Toast.makeText(getApplicationContext(), "Open genie " +id, Toast.LENGTH_SHORT)
                            .show();
                    setGenie(idMap.get( id));
                    setGenieList(HttpUtil.getComments((int)id));
                    CommentActivity.setGenie(idMap.get( id));
                    CommentActivity.setGenieList( HttpUtil.getComments((int)id) );
                    Intent intent = new Intent(DashboardActivity.this,  CommentActivity.class);
                    startActivity(intent);
                }
            });
            genies.addView(btn);
        }
        findViewById(R.id.new_genie).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "New genie " , Toast.LENGTH_SHORT)
                        .show();
                Genie genie=HttpUtil.newGenie();
               MainActivity.setGenieId(""+genie.getId());
                Intent intent = new Intent(DashboardActivity.this,  MainActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome, menu);
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

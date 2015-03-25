package com.amazonaws.demo.s3_transfer_manager;

import com.amazonaws.com.google.gson.Gson;
import com.amazonaws.demo.s3_transfer_manager.models.Comment;
import com.amazonaws.demo.s3_transfer_manager.models.Genie;
import com.amazonaws.demo.s3_transfer_manager.models.GenieStatusType;
import com.amazonaws.demo.s3_transfer_manager.models.UserProfile;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by manikandan15785 on 14-03-2015.
 */
public class HttpUtil {
    static String code;
    static String userId;
    static Gson gson=new Gson();
    private String baseUrl="http://337a6bb5.ngrok.com/feedbackController";

    private static String endPointUrlValidCode="/valid?code=";
    public static boolean isValidCode(String code){

        HttpUtil.code=code;
//        return true;
        try {
            if ("true".equalsIgnoreCase(getHTTPCall(endPointUrlValidCode + code))) return true;
            else return false;
        }catch(Exception e) {
            return true;
        }
    }

    private static String endPointUrlProfile="/profile?code=";
    public static UserProfile getProfile(){

        // TODO:Test data
//        UserProfile userProfile=new UserProfile();
//        userProfile.setId(1);
//        userProfile.setFirstName("Mani");
//        userProfile.setLastName("kandan");
//        userProfile.setAddress1("asdasd");
//        userProfile.setAddress2("asdasd");
//        userProfile.setCity("Chennai");
//        userProfile.setState("tamilnadu");
//        userProfile.setEmailId("email@email.com");
//        userProfile.setPhoneNo("9876543210");
        //Test data end
        UserProfile userProfile= gson.fromJson(getHTTPCall(endPointUrlProfile + code),UserProfile.class);
        userId=""+userProfile.getId();
        return userProfile;
    }

    private static String endPointUrlTicket="/ticket?code=";
    public static List<Genie> getTickets(){
//        List<Genie> genies=new ArrayList<Genie>();

        // TODO:Test data
//        Genie genie=new Genie();
//        genie.setId(1);
//        genie.setDescription("room is not clean");
//        genie.setCreatedDate(new Date());
//        genie.setGenieStatusType(GenieStatusType.OPEN);
//        genie.setDocumentpath("path");
//        genie.setRating("1.5");
//        genie.setCreatedDate(new Date());
//        genies.add(genie);
//
//        genie=new Genie();
//        genie.setId(2);
//        genie.setRating("4.5");
//        genie.setDescription("food is very good");
//        genie.setCreatedDate(new Date());
//        genie.setGenieStatusType(GenieStatusType.CLOSED);
//        genie.setDocumentpath("path");
//        genie.setCreatedDate(new Date());
//        genies.add(genie);
        // Test data :end

        ListObject temp= gson.fromJson(getHTTPCall(endPointUrlTicket + code),ListObject.class);
        return temp.getGenies();
        }

    private static String endPointUrlnewgenie="/genie?code=";
    public static Genie newGenie(){
        // TODO:Test data
        long newGenieid=3;
        String newDocumentPath="path";
        // Test data :end
//
//        Genie genie=new Genie();
//        genie.setId(newGenieid);
//        genie.setDescription("");
//        genie.setCreatedDate(new Date());
//        genie.setGenieStatusType(GenieStatusType.OPEN);
//        genie.setDocumentpath(newDocumentPath);
        Genie genie= gson.fromJson(getHTTPCall(endPointUrlnewgenie + code),Genie.class);
        return genie;
    }

    private static String endPointUrlgenie="/genie?id=";
    public static Genie getGenie(long genieId){
        // TODO:Test data
//        Genie genie=new Genie();
//        genie.setId(genieId);
//        genie.setDescription("room is not clean");
//        genie.setCreatedDate(new Date());
//        genie.setGenieStatusType(GenieStatusType.OPEN);
//        genie.setDocumentpath("path");
//        genie.setCreatedDate(new Date());
        // Test data end
        Genie genie= gson.fromJson(getHTTPCall(endPointUrlgenie + code),Genie.class);
        return genie;
    }

    private static String endPointUrlComment="/comment?=";
    public static List<Comment> getComments(int genieId){
        // TODO:Test data
//       List<Comment> comments=new ArrayList<Comment>();
//        Comment comment=new Comment();
//        comment.setId(1);
//        comment.setDescription("reply");
//        comment.setCreatedDate(new Date());
//        comment.setGenieStatusType(GenieStatusType.OPEN);
//        comment.setIsUser(false);
//        comments.add(comment);
//        comment=new Comment();
//        comment.setId(2);
//        comment.setDescription("thanks of the feedback");
//        comment.setCreatedDate(new Date());
//        comment.setGenieStatusType(GenieStatusType.PROGRESS);
//        comment.setIsUser(false);
//        comments.add(comment);

        ListObject temp= gson.fromJson(getHTTPCall(endPointUrlComment + code),ListObject.class);
        return temp.getComments();
//        return comments;
    }


    private static String getHTTPCall(String url){
        DownloadTask task=new DownloadTask();
        task.execute(url);
        while(task.isRunning()){}
        return  task.getResult();
//        return "";
    }
}
class ListObject{
    List<Genie> genies;
    List<Comment> comments;

    public List<Comment> getComments() {
        return comments;
    }

    public List<Genie> getGenies() {
        return genies;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setGenies(List<Genie> genies) {
        this.genies = genies;
    }
}

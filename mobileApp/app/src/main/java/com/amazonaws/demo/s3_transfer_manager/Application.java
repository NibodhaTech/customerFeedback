package com.amazonaws.demo.s3_transfer_manager;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParsePush;
import com.parse.PushService;

public class Application extends android.app.Application {

  public Application() {
  }

  @Override
  public void onCreate() {
    super.onCreate();

	// Initialize the Parse SDK.
	Parse.initialize(this, "GDJFCv89aMLD5TfOSpu8MJlE1rHjgwl6e1Du1Pwb", "8tFzuJBJvww2Tzsi6crtDzJIarbzqSbJTZYQtu4A");
      ParseInstallation installation = ParseInstallation.getCurrentInstallation();
      installation.put("mobileNumber","9940483172");
      installation.saveInBackground();
	// Specify an Activity to handle all pushes by default.
   PushService.setDefaultPushCallback(this, DashboardActivity.class);
  }
}
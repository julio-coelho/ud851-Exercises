package com.example.android.background.sync;

// COMPLETED (9) Create WaterReminderIntentService and extend it from IntentService
//  COMPLETED (10) Create a default constructor that calls super with the name of this class
//  COMPLETED (11) Override onHandleIntent
//      COMPLETED (12) Get the action from the Intent that started this Service
//      COMPLETED (13) Call ReminderTasks.executeTaskForTag and pass in the action to be performed

import android.app.IntentService;
import android.content.Intent;

public class WaterReminderIntentService extends IntentService {

    public WaterReminderIntentService() {
        super(WaterReminderIntentService.class.getSimpleName());
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String action = intent.getAction();
        ReminderTasks.executeTask(this, action);
    }
}
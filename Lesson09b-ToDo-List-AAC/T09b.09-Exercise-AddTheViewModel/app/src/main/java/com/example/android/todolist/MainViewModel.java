package com.example.android.todolist;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.todolist.database.AppDatabase;
import com.example.android.todolist.database.TaskEntry;

import java.util.List;

// COMPLETED (1) make this class extend AndroidViewModel and implement its default constructor
public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private LiveData<List<TaskEntry>> tasks;

    public MainViewModel(@NonNull Application application) {
        super(application);
        AppDatabase database = AppDatabase.getInstance(this.getApplication());
        Log.d(TAG, "Actively retrieving the tasks from the Database");
        tasks = database.taskDao().loadAllTasks();
    }

    public LiveData<List<TaskEntry>> getTasks() {
        return tasks;
    }

    public void setTasks(LiveData<List<TaskEntry>> tasks) {
        this.tasks = tasks;
    }

    // COMPLETED (2) Add a tasks member variable for a list of TaskEntry objects wrapped in a LiveData

    // COMPLETED (4) In the constructor use the loadAllTasks of the taskDao to initialize the tasks variable

    // COMPLETED (3) Create a getter for the tasks variable
}

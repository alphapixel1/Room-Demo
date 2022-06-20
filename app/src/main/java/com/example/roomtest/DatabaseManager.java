package com.example.roomtest;

import android.content.Context;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.RoomMasterTable;
import androidx.room.migration.Migration;

import java.io.File;
import java.util.List;

public class DatabaseManager {
    public static UserDAO userDAO;
    public static  void Init(Context c){

        AppDatabase db = Room.databaseBuilder(c,
                AppDatabase.class, "newdb.db").allowMainThreadQueries().build();
        System.out.println(c.getDatabasePath("database-name2").getAbsolutePath());
        userDAO=db.userDao();

    }
}

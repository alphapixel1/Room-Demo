package com.example.roomtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private LinearLayout userList;
    private UserDAO userDAO;
    public static int updateCount=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseManager.Init(getApplicationContext());
        userDAO=DatabaseManager.userDAO;
        userList=findViewById(R.id.userList);

        findViewById(R.id.button).setOnClickListener(v->{
            ShowAddUserDialog();
        });
        UpdateList();
    }
    private void ShowAddUserDialog(){
        Dialog d=new Dialog(MainActivity.this);
        d.setContentView(R.layout.add_user_layout);
        d.findViewById(R.id.AddUserButton).setOnClickListener(v->{
            EditText f=d.findViewById(R.id.firstNameInput);
            EditText l=d.findViewById(R.id.lastNameInput);
            User u=new User();
            u.firstName=f.getText().toString();
            u.lastName=l.getText().toString();
            userDAO.insertAll(u);
            UpdateList();
            d.cancel();
        });
        d.show();
    }
    private void UpdateList(){
        System.out.println(updateCount++);
        userList.removeAllViews();
        for (User u:userDAO.getAll()) {
            System.out.println(u);
            userList.addView(u.getView(MainActivity.this));
          //  userList.addView(ud);
        }
    }
}
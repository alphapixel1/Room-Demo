package com.example.roomtest;

import android.app.Application;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.lifecycle.ViewModel;

public class UserViewModel extends ViewModel {
    private User user;
    public View view;
    TextView fNameView,lNameView;

    public UserViewModel(User u,Context c){
        user=u;
        view=LayoutInflater.from(c).inflate(R.layout.user_display,null);
        fNameView=view.findViewById(R.id.f_display);
        lNameView=view.findViewById(R.id.l_display);
        view.findViewById(R.id.delete_button).setOnClickListener(v->{
            DatabaseManager.userDAO.delete(user);
            ((LinearLayout)view.getParent()).removeView(view);
            fNameView=null;
            lNameView=null;
            view=null;
            user=null;
        });
        Update();
    }
    public void Update(){
        fNameView.setText(user.firstName);
        lNameView.setText(user.lastName);
    }

}

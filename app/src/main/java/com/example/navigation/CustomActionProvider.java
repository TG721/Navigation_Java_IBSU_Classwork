package com.example.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.view.ActionProvider;

import com.example.navigation_classwork.R;


public class CustomActionProvider extends ActionProvider {
    private Context context;

    public CustomActionProvider(Context context) {
        super(context);
        this.context = context;
    }

    @Override
    public View onCreateActionView() {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_notikasi_layout, new LinearLayout(context), false);



        return view;
    }
}

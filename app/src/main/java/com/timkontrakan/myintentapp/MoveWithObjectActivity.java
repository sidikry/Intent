package com.timkontrakan.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.timkontrakan.myintentapp.databinding.ActivityMainBinding;
import com.timkontrakan.myintentapp.databinding.ActivityMoveWithObjectBinding;

public class MoveWithObjectActivity extends AppCompatActivity {

    ActivityMoveWithObjectBinding binding;
    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoveWithObjectBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Person person = getIntent().getParcelableExtra(EXTRA_PERSON);
        String text = "Name : "
                + person.getName() + "\nEmail : "
                + person.getEmail() + "\nAge : "
                + person.getAge() + "\nLocation : "
                + person.getCity();
        binding.objectReceived.setText(text);
    }
}

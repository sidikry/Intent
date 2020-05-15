package com.timkontrakan.myintentapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.timkontrakan.myintentapp.databinding.ActivityMoveForResultBinding;

public class MoveForResultActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMoveForResultBinding binding;
    public static final String EXTRA_SELECTED_VALUE = "extra_selected_value";
    public static final int RESULT_CODE = 110;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMoveForResultBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        binding.btnChoose.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_choose) {
            if (binding.rgNumber.getCheckedRadioButtonId() != 0) {
                int value = 0;
                switch (binding.rgNumber.getCheckedRadioButtonId()) {
                    case R.id.rb_50:
                        value = 50;
                        break;
                    case R.id.rb_100:
                        value = 100;
                        break;
                    case R.id.rb_150:
                        value = 150;
                        break;
                    case R.id.rb_200:
                        value = 200;
                        break;
                }

                Intent resultIntent = new Intent();
                resultIntent.putExtra(EXTRA_SELECTED_VALUE, value);
                setResult(RESULT_CODE, resultIntent);
                finish();
            }
        }
    }
}

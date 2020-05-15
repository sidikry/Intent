package com.timkontrakan.myintentapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.timkontrakan.myintentapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    private int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        getContent();
    }

    private void getContent() {
        binding.btnMoveActivity.setOnClickListener(this);
        binding.btnMoveActivityData.setOnClickListener(this);
        binding.btnDialNumber.setOnClickListener(this);
        binding.btnMoveActivityObject.setOnClickListener(this);
        binding.btnMoveForResult.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_move_activity:
                startActivity(new Intent(MainActivity.this, MoveActivity.class));
                break;
            case R.id.btn_move_activity_data:
                Intent moveActivityData = new Intent(MainActivity.this, MoveWithDataActivity.class);
                moveActivityData.putExtra(MoveWithDataActivity.EXTRA_NAME, "DicodingAcademy Boy");
                moveActivityData.putExtra(MoveWithDataActivity.EXTRA_AGE, 5);
                startActivity(moveActivityData);
                break;
            case R.id.btn_dial_number:
                String phoneNumber = "085877650467";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
                startActivity(dialPhoneIntent);
                break;
            case R.id.btn_move_activity_object:
                Person person = new Person();
                person.setName("Sidik Ristiawan Yusuf");
                person.setEmail("sidik.14@students.amikom.ac.id");
                person.setCity("Yogyakarta");
                person.setAge(20);

                Intent intent = new Intent(MainActivity.this, MoveWithObjectActivity.class);
                intent.putExtra(MoveWithObjectActivity.EXTRA_PERSON, person);
                startActivity(intent);
                break;
            case R.id.btn_move_for_result:
                Intent moveForResults = new Intent(MainActivity.this, MoveForResultActivity.class);
                startActivityForResult(moveForResults, REQUEST_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE){
            if (resultCode == MoveForResultActivity.RESULT_CODE){
                int selectedValue = data.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0);
                binding.tvResults.setText(String.format("Hasil : %s", selectedValue));
            }
        }
    }
}

package com.example.dialogfragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements DialogFragment.OnPositiveClickListner, DialogFragment.OnNegativeClickListner, DialogFragment.OnNeutralClickListner {
Button btn_show;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btn_show=findViewById(R.id.btn_showDialog);
        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           DialogFragment fragment= DialogFragment.newInstance("Confirmation","Are You Sure?",R.drawable.check);
           fragment.show(getSupportFragmentManager(),null);
            }
        });

    }

    @Override
    public void OnNegativeButtonClicked() {
        Toast.makeText(this, "No clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnNeutralButtonClicked() {
        Toast.makeText(this, "No clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnPositiveButtonClicked() {
        Toast.makeText(this, "Yes clicked", Toast.LENGTH_SHORT).show();
    }
}
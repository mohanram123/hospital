package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class next extends AppCompatActivity {

    TextView name;
    TextView address;
    TextView contact;
    TextView gender;
    TextView dob;
    TextView age;
    TextView status;
    TextView addiction;
    TextView time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        contact=findViewById(R.id.contact);
        gender=findViewById(R.id.gender);
        dob=findViewById(R.id.dob);
        age=findViewById(R.id.age);
        status=findViewById(R.id.status);
        addiction=findViewById(R.id.addiction);
        time=findViewById(R.id.time);

        name.setText(getIntent().getStringExtra("NAME"));
        address.setText(getIntent().getStringExtra("ADDRESS"));
        contact.setText(getIntent().getStringExtra("CONTACT"));
        gender.setText(getIntent().getStringExtra("GENDER"));
        dob.setText(getIntent().getStringExtra("DOB"));
        age.setText(getIntent().getStringExtra("AGE"));
        status.setText(getIntent().getStringExtra("STATUS"));
        addiction.setText(getIntent().getStringExtra("ADDICTION"));
        time.setText(getIntent().getStringExtra("TIME"));
    }
}

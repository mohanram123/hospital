package com.example.hospital;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.mbms.MbmsErrors;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Button cancel;
    EditText name,contact,address,age;
    DatePicker dob;
    RadioGroup gender;
    Spinner status;
    CheckBox smoking,alcohol;
    TimePicker time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cancel=(Button)findViewById(R.id.cancel);
        name=findViewById(R.id.name);
        contact=findViewById(R.id.contact);
        dob=findViewById(R.id.dob);
        gender=findViewById(R.id.gender);
        status=findViewById(R.id.status);
        smoking=findViewById(R.id.smoking);
        alcohol=findViewById(R.id.alcohol);
        address=findViewById(R.id.address);
        age=findViewById(R.id.age);
        time=findViewById(R.id.time);
    }

    public void cancel_func(View view){
        name.setText("");
        contact.setText("");
        dob.updateDate(2000,0,01);
        gender.clearCheck();
        status.setSelection(0);
        smoking.setChecked(false);
        alcohol.setChecked(false);
        address.setText("");
        age.setText("");
    }

    public void submit(View view){
        Intent intent=new Intent(this,next.class);
        intent.putExtra("NAME",name.getText().toString());
        intent.putExtra("ADDRESS",address.getText().toString());
        intent.putExtra("AGE",age.getText().toString());
        intent.putExtra("CONTACT",contact.getText().toString());
        String birthday=dob.getDayOfMonth()+"/"+dob.getMonth()+"/"+dob.getYear();
        intent.putExtra("DOB",birthday);
        if(gender.getCheckedRadioButtonId()==R.id.male)
            intent.putExtra("GENDER","male");
        else if(gender.getCheckedRadioButtonId()==R.id.female)
            intent.putExtra("GENDER","female");
        intent.putExtra("STATUS",status.getSelectedItem().toString());
        if(smoking.isChecked() && !(alcohol.isChecked()))
            intent.putExtra("ADDICTION","smoking");
        else if(!(smoking.isChecked()) && alcohol.isChecked())
            intent.putExtra("ADDICTION","alcohol");
        else if(smoking.isChecked() && alcohol.isChecked())
            intent.putExtra("ADDICTION","alcohol and smoking");
        else if(!(smoking.isChecked()) && !(alcohol.isChecked()))
            intent.putExtra("ADDICTION","None");
        String timeset=time.getHour()+":"+time.getMinute();
        intent.putExtra("TIME",timeset);
        startActivity(intent);
    }
}

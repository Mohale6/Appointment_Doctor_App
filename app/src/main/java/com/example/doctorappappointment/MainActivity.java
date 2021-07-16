
package com.example.doctorappappointment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity<EditText> extends AppCompatActivity {

    private EditText fname, lname, age, gender, date, email;

    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference root = database.getReference().child("Users");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = (EditText) findViewById(R.id.editTextTextPersonName);
        lname = (EditText) findViewById(R.id.editTextTextPersonName2);
        age = (EditText) findViewById(R.id.editTextTextPersonName3);
        gender = (EditText) findViewById(R.id.editTextTextPersonName4);
        date = (EditText) findViewById(R.id.editTextDate);
        email = (EditText) findViewById(R.id.editTextTextEmailAddress);
        Button button = findViewById(R.id.button);
        Button button2 = findViewById(R.id.button2);

        button.setOnClickListener(v ->{
            String editTextTextPersonName = fname.toString();
            String editTextTextPersonName2 = lname.toString();
            String editTextTextPersonName3 = age.toString();
            String editTextTextPersonName4 = gender.toString();
            String editTextDate = date.toString();
            String editTextTextEmailAddress = email.toString();

            HashMap<String, String> userMap = new HashMap<>();

            userMap.put("First name", editTextTextPersonName);
            userMap.put("Last name", editTextTextPersonName2);
            userMap.put("Age", editTextTextPersonName3);
            userMap.put("Gender", editTextTextPersonName4);
            userMap.put("Date", editTextDate);
            userMap.put("Email", editTextTextEmailAddress);

            root.push().setValue(userMap).addOnCompleteListener(task -> Toast.makeText(MainActivity.this, "Data saved to database", Toast.LENGTH_SHORT).show());
        });

        button2.setOnClickListener(v -> startActivity(new Intent(MainActivity.this, DataActivity.class)));
    }
}
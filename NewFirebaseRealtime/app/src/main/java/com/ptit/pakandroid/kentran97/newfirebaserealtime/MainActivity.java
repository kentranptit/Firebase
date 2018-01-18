package com.ptit.pakandroid.kentran97.newfirebaserealtime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mData;
    TextView txtKhoaHoc;
    Button btnAndroid, btnIOS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKhoaHoc = findViewById(R.id.textViewKhoaHoc);
        btnAndroid = findViewById(R.id.buttonAndroid);
        btnIOS = findViewById(R.id.buttonIOS);

        mData = FirebaseDatabase.getInstance().getReference();

        mData.child("KhoaHoc").setValue("Lap trinh Android");

        mData.child("KhoaHoc").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                txtKhoaHoc.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        btnAndroid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.child("KhoaHoc").setValue("Android");
            }
        });

        btnIOS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mData.child("KhoaHoc").setValue("iOS");
            }
        });
    }
}

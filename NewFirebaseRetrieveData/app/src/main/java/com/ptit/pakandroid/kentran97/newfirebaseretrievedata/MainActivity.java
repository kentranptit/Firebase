package com.ptit.pakandroid.kentran97.newfirebaseretrievedata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mData;
    TextView txtKhoaHoc;
    ListView lvXe;
    ArrayList<String> mangPhuongTien;
    ArrayAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtKhoaHoc = findViewById(R.id.textViewKhoaHoc);
        lvXe = findViewById(R.id.listViewXe);
        mangPhuongTien = new ArrayList<String>();
        adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mangPhuongTien);
        lvXe.setAdapter(adapter);

        mData = FirebaseDatabase.getInstance().getReference();

//        mData.child("PhuongTien").push().setValue(new PhuongTien("Xe khach", 8));

        mData.child("PhuongTien").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                PhuongTien vehicle = dataSnapshot.getValue(PhuongTien.class);
                mangPhuongTien.add(vehicle.Ten + " - " + vehicle.Banh + " banh");
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//        mData.child("KhoaHoc").push().setValue("Lap trinh Unity");

        mData.child("KhoaHoc").addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                txtKhoaHoc.append(dataSnapshot.getValue().toString() + "\n");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}

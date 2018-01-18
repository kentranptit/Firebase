package com.ptit.pakandroid.kentran97.newfirebasedatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    DatabaseReference mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mData = FirebaseDatabase.getInstance().getReference();

        //truong hop 1
        mData.child("HoTen").setValue("Ken Tran PTIT");

        //truong hop 2
        SinhVien sv = new SinhVien("Ken", "Ha Noi", 1997);
        mData.child("SinhVien").setValue(sv);

        //truong hop 3
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        myMap.put("XeMay", 2);
        mData.child("PhuongTien").setValue(myMap);

        //truong hop 4
        SinhVien sinhVien = new SinhVien("Tran Quang Khai", "Tp. Hanoi", 1990);
        mData.child("HocVien").push().setValue(sinhVien);

        //bat su kien hoan thanh khi setValue()
        mData.child("PTIT").setValue("Lap trinh Android voi Firebase", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
                if (databaseError == null) {
                    Toast.makeText(MainActivity.this, "Luu thanh cong", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Luu that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

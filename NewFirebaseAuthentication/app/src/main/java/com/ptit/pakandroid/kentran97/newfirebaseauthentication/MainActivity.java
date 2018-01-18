package com.ptit.pakandroid.kentran97.newfirebaseauthentication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    Button btnDangKy, btnDangNhap;
    EditText edtEmail, edtPassword, edtTaiKhoan, edtMatKhau;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuth = FirebaseAuth.getInstance();

        mapping();

        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangKy();
            }
        });

        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DangNhap();
            }
        });
    }

    private void mapping() {
        btnDangKy = findViewById(R.id.buttonDangKy);
        btnDangNhap = findViewById(R.id.buttonDangNhap);
        edtEmail = findViewById(R.id.editTextEmail);
        edtTaiKhoan = findViewById(R.id.editTextTaiKhoan);
        edtPassword = findViewById(R.id.editTextPassword);
        edtMatKhau = findViewById(R.id.editTextMatKhau);
    }

    private void DangKy() {
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Dang ky thanh cong", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Loi dang ky!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }

    private void DangNhap() {
        String taikhoan = edtTaiKhoan.getText().toString();
        String matkhau = edtMatKhau.getText().toString();
        mAuth.signInWithEmailAndPassword(taikhoan, matkhau)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(MainActivity.this, "Dang nhap thanh cong", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(MainActivity.this, "Loi dang nhap!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}

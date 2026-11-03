package com.example.praktekcodemenu;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Button btnForm = findViewById(R.id.btnForm);
        Button btnEmail = findViewById(R.id.button2);
        Button btnTelp = findViewById(R.id.button3);
        Button btnAbout = findViewById(R.id.button);

        // 1. Tombol Form Siswa
        btnForm.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, FormSiswa.class);
            startActivity(intent);
        });

        // 2. Tombol Email (Membuka aplikasi Gmail / Email)
        btnEmail.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:rizkyadjiess44@gmail.com"));
            intent.putExtra(Intent.EXTRA_SUBJECT, "Pesan dari Aplikasi Praktek Code Menu");
            try {
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Tidak ada aplikasi email terinstall", Toast.LENGTH_SHORT).show();
            }
        });

        // 3. Tombol No Telp (Membuka aplikasi telepon bawaan)
        btnTelp.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:082122387470"));
            try {
                startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(MainActivity.this, "Tidak dapat membuka aplikasi telepon", Toast.LENGTH_SHORT).show();
            }
        });

        // 4. Tombol About Me (Membuka halaman About)
        btnAbout.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}

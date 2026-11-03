package com.example.praktekcodemenu;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        TextView tvResultData = findViewById(R.id.tvResultData);

        // Ambil data dari Intent
        String nis = getIntent().getStringExtra("EXTRA_NIS");
        String nama = getIntent().getStringExtra("EXTRA_NAMA");
        String alamat = getIntent().getStringExtra("EXTRA_ALAMAT");
        String gender = getIntent().getStringExtra("EXTRA_GENDER");
        String kota = getIntent().getStringExtra("EXTRA_KOTA");

        if (nis != null && nama != null) {
            String resultText = "NIS : " + nis + "\n" +
                    "Nama : " + nama + "\n" +
                    "Alamat : " + alamat + "\n" +
                    "Jenis Kelamin : " + gender + "\n" +
                    "Kota : " + kota;
            tvResultData.setText(resultText);
        } else {
            tvResultData.setText("Belum ada data yang diisi. Silakan isi form siswa terlebih dahulu.");
        }
    }
}

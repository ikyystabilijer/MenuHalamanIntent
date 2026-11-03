package com.example.praktekcodemenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormSiswa extends AppCompatActivity {

    private EditText etNis, etNama, etAlamat, etKota;
    private RadioGroup rgGender;
    private Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etNis = findViewById(R.id.etNis);
        etNama = findViewById(R.id.etNama);
        etAlamat = findViewById(R.id.etAlamat);
        etKota = findViewById(R.id.etKota);
        rgGender = findViewById(R.id.rgGender);
        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String nis = etNis.getText().toString().trim();
            String nama = etNama.getText().toString().trim();
            String alamat = etAlamat.getText().toString().trim();
            String kota = etKota.getText().toString().trim();

            int selectedId = rgGender.getCheckedRadioButtonId();
            String gender = "";
            if (selectedId != -1) {
                RadioButton rbSelected = findViewById(selectedId);
                gender = rbSelected.getText().toString();
            }

            if (nis.isEmpty() || nama.isEmpty() || alamat.isEmpty() || kota.isEmpty() || gender.isEmpty()) {
                Toast.makeText(FormSiswa.this, "Semua data harus diisi!", Toast.LENGTH_SHORT).show();
                return;
            }

            // Kirim data ke AboutActivity
            Intent intent = new Intent(FormSiswa.this, AboutActivity.class);
            intent.putExtra("EXTRA_NIS", nis);
            intent.putExtra("EXTRA_NAMA", nama);
            intent.putExtra("EXTRA_ALAMAT", alamat);
            intent.putExtra("EXTRA_GENDER", gender);
            intent.putExtra("EXTRA_KOTA", kota);
            startActivity(intent);
        });
    }
}

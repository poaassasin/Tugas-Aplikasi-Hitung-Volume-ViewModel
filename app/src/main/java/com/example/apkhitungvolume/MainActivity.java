package com.example.apkhitungvolume;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private EditText panjangEditText, lebarEditText, tinggiEditText;
    private TextView hasilTextView;
    private MainVM viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        panjangEditText = findViewById(R.id.panjangEditText);
        lebarEditText = findViewById(R.id.lebarEditText);
        tinggiEditText = findViewById(R.id.tinggiEditText);
        hasilTextView = findViewById(R.id.hasilTextView);
        Button hitungButton = findViewById(R.id.hitungButton);

        viewModel = new ViewModelProvider(this).get(MainVM.class);

        hasilTextView.setText("Hasil: " + viewModel.getHasil());

        hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungVolume();
            }
        });
    }

    private void hitungVolume() {
        double panjang = Double.parseDouble(panjangEditText.getText().toString());
        double lebar = Double.parseDouble(lebarEditText.getText().toString());
        double tinggi = Double.parseDouble(tinggiEditText.getText().toString());

        viewModel.hitungVolume(panjang, lebar, tinggi);
        hasilTextView.setText("Hasil: " + viewModel.getHasil());
    }
}
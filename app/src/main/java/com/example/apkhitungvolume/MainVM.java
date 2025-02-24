package com.example.apkhitungvolume;
import androidx.lifecycle.ViewModel;

public class MainVM extends ViewModel {

    private double hasil = 0;

    public double getHasil() {
        return hasil;
    }

    public void hitungVolume(double panjang, double lebar, double tinggi) {
        hasil = panjang * lebar * tinggi;
    }
}
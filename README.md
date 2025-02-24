# Tugas-Aplikasi-Hitung-Volume-ViewModel
Tugas 1 Pemrograman Aplikasi Mobile Lanjut
Muhammad Azka Ayubi
225150407111008
PAML

Dependencies: implementation "androidx.lifecycle:lifecycle-viewmodel:2.6.2"
Dependensi ini digunakan untuk import library view model.

Layout:

...

<TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:textSize="16sp"
        android:text="Panjang"
        android:textStyle="bold"
        />

    <EditText
        android:id="@+id/panjangEditText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="Masukkan panjang"
        android:inputType="numberDecimal"
        android:layout_marginBottom="5dp"/>
        
...

TextView disini digunakan sebagai judul kolom, EditText disini digunakan untuk mengisi isian angka dengan tipe inputnya adalah angka desimal. Begitupun dengan kolom isian lainnya. Width menggunakan match_parent supaya menyesuaikan dengan lebar layar, sedangkan tingginya sesuai dengan size teks.

...
<Button
        android:id="@+id/hitungButton"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hitung"
        android:layout_gravity="center"
        />       
...

Button disini digunakan untuk digunakan di event listener yaitu setOnClickListener.

...

panjangEditText = findViewById(R.id.panjangEditText);
lebarEditText = findViewById(R.id.lebarEditText);
tinggiEditText = findViewById(R.id.tinggiEditText);
Button hitungButton = findViewById(R.id.hitungButton);
hitungButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitungVolume();
            }
        });
        
...

Disini button dipanggil dengan findViewById dengan menarik id yang telah diassign di layout (activity_main.xml). Lalu dibuat event OnClickListener yang dimana apabila diklik akan memanggil method hitungVolume.

...

private void hitungVolume() {
        double panjang = Double.parseDouble(panjangEditText.getText().toString());
        double lebar = Double.parseDouble(lebarEditText.getText().toString());
        double tinggi = Double.parseDouble(tinggiEditText.getText().toString());

        viewModel.hitungVolume(panjang, lebar, tinggi);
        hasilTextView.setText("Hasil: " + viewModel.getHasil());
    }
    
...

di method tersebut, var panjang lebar tinggi diambil dari var yang sudah diassign menggunakan findViewById yang angkanya berupa text string diparse-ing menjadi double. Lalu memanggil object class viewModel [viewModel = new ViewModelProvider(this).get(MainVM.class)] untuk dikirimkan data panjang, lebar, dan tinggi ke class viewModel. 

...

public class MainVM extends ViewModel {
public double getHasil() {
        return hasil;
    }

    public void hitungVolume(double panjang, double lebar, double tinggi) {
        hasil = panjang * lebar * tinggi;
    }
}

...

hasil dari perhitungan di class viewModel akan diambil dan dijadikan text di dalam tampilan TextView dengan id hasilTextView.

di luar method hitungVolume juga terdapat setText untuk Tv hasil [hasilTextView.setText("Hasil: " + viewModel.getHasil());] supaya tetap sama hasilnya walau view diputar.



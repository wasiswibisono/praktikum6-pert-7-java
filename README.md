# Tugas Praktikum 6 (Pertemuan ke 7) 

|Nama|NIM|Kelas|Mata Kuliah|
|----|---|-----|------|
|**Wasis Wibisono**|**312310661**|**TI.23.A6**|**Pemrograman Orientasi Objek**|

#  • Soal 1
![gambar](Tugas-Pemrograman-Orientasi-Objek-Pert-7/ss1.png)

#  • Dari modul praktikum 3, tambahkan constructor pada masing-masing class dan tambahkan overload dan override constructor tersebut.
#  • Contoh:
```
Programer ("Andi Herlambang")
Programer ("Riko", 6000000")
Programer ("Dina", 5000000, 3000000)
```

##  • Kelas Pegawai
```java
class Pegawai {
    private String nama;
    private double gajiPokok;

    public Pegawai(String nama, double gajiPokok) {
        this.nama = nama;
        this.gajiPokok = gajiPokok;
    }

    public Pegawai(String nama) {
        this.nama = nama;
        this.gajiPokok = 0; 
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setGajiPokok(double gajiPokok) {
        this.gajiPokok = gajiPokok;
    }

    public double getGajiPokok() {
        return gajiPokok;
    }

    public void cetakInfo() {
        System.out.printf("Nama: %s, Gaji Pokok: %.0f%n", nama, gajiPokok);
    }
}
```

###  • Penjelasan:
```
- Atribut:
  - private String nama: Menyimpan nama pegawai. Atribut ini bersifat private, yang berarti hanya dapat diakses melalui metode dalam kelas ini.
  - private double gajiPokok: Menyimpan gaji pokok pegawai.

- Konstruktor:
  - public Pegawai(String nama, double gajiPokok): Konstruktor ini digunakan untuk menginisialisasi objek Pegawai dengan nama dan gaji pokok yang diberikan.
  - public Pegawai(String nama): Konstruktor ini hanya menginisialisasi nama pegawai dan menetapkan gaji pokok menjadi 0.

- Metode Set dan Get:
  - public void setNama(String nama): Metode ini digunakan untuk mengubah nama pegawai.
  - public String getNama(): Metode ini mengembalikan nama pegawai.
  - public void setGajiPokok(double gajiPokok): Metode ini digunakan untuk mengubah gaji pokok pegawai.
  - public double getGajiPokok(): Metode ini mengembalikan gaji pokok pegawai.

- Metode cetakInfo():
  - Metode ini mencetak informasi pegawai (nama dan gaji pokok) ke layar dengan format tertentu.
```

##  • Kelas  Manager
```java
class Manager extends Pegawai {
    private double tunjangan;

    public Manager(String nama, double gajiPokok, double tunjangan) {
        super(nama, gajiPokok);
        this.tunjangan = tunjangan;
    }

    public Manager(String nama, double gajiPokok) {
        super(nama, gajiPokok);
        this.tunjangan = 0; 
    }

    public void setTunjangan(double tunjangan) {
        this.tunjangan = tunjangan;
    }

    public double getTunjangan() {
        return tunjangan;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.printf("Tunjangan: %.0f%n", tunjangan);
    }
}
```
###  • Penjelasan:
```
- Kelas Manager: Kelas ini merupakan subclass dari Pegawai dan menambahkan informasi spesifik untuk manajer.

- Atribut:
  - double tunjangan: Menyimpan tunjangan yang diterima oleh manajer.

- Konstruktor:
  - public Manager(String nama, double gajiPokok, double tunjangan): Menginisialisasi semua atribut (nama, gaji pokok, dan tunjangan).
  - public Manager(String nama, double gajiPokok): Menginisialisasi nama dan gaji pokok, tunjangan diatur ke 0.

- Metode:
  - setTunjangan dan getTunjangan: Untuk mengatur dan mendapatkan tunjangan manajer.
  - @Override cetakInfo: Mengoverride metode dari Pegawai untuk menampilkan informasi tambahan mengenai tunjangan setelah informasi dasar (nama dan gaji pokok).
```

##  • Kelas Programer 
```java
class Programmer extends Pegawai {
    private double bonus;

    public Programmer(String nama, double gajiPokok, double bonus) {
        super(nama, gajiPokok);
        this.bonus = bonus;
    }

    public Programmer(String nama, double gajiPokok) {
        super(nama, gajiPokok);
        this.bonus = 0; 
    }

    public Programmer(String nama) {
        super(nama);
        this.bonus = 0; 
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    @Override
    public void cetakInfo() {
        super.cetakInfo();
        System.out.printf("Bonus: %.0f%n", bonus);
    }
}
```
###  • Penjelasan:
```
- Kelas Programmer: Kelas ini juga merupakan subclass dari Pegawai, ditujukan untuk merepresentasikan programmer.

- Atribut:
  - double bonus: Menyimpan bonus yang diterima oleh programmer.

- Konstruktor:
  - public Programmer(String nama, double gajiPokok, double bonus): Menginisialisasi nama, gaji pokok, dan bonus.
  - public Programmer(String nama, double gajiPokok): Menginisialisasi nama dan gaji pokok, bonus diatur ke 0.
  - public Programmer(String nama): Menginisialisasi hanya nama, gaji pokok dan bonus diatur ke 0.

Metode:
  - setBonus dan getBonus: Untuk mengatur dan mendapatkan bonus programmer.
  - @Override cetakInfo: Mengoverride metode dari Pegawai untuk menampilkan informasi mengenai bonus setelah informasi dasar.
```

##  • Kelas Main
```java
public class main {
    public static void main(String[] args) {
        Programmer programmer1 = new Programmer("Andi Herlambang");
        Programmer programmer2 = new Programmer("Riko", 6000000);
        Programmer programmer3 = new Programmer("Dina", 5000000, 3000000);

        System.out.println("Info Programmer 1:");
        programmer1.cetakInfo();
        System.out.println("\nInfo Programmer 2:");
        programmer2.cetakInfo();
        System.out.println("\nInfo Programmer 3:");
        programmer3.cetakInfo();
    }
}
```
###  • Penjelasan:
```
- Kelas Main: Kelas ini berfungsi sebagai titik masuk untuk program. Di sinilah semua objek diciptakan dan informasi mereka dicetak.

- Metode main:
  - Membuat tiga objek Programmer dengan berbagai parameter (nama, gaji pokok, bonus) dan mencetak informasi mereka menggunakan metode cetakInfo().
  - Juga menciptakan satu objek Manager dan mencetak informasinya untuk menunjukkan cara penggunaan kelas Manager.
```

#  • Output
![gambar](Tugas-Pemrograman-Orientasi-Objek-Pert-7/ss2.png)

#  • Soal 2 
![gambar](Tugas-Pemrograman-Orientasi-Objek-Pert-7/ss3.png)

#  • Studi kasus: Sistem Pembelian Online dengan Keranjang Belanja

##  • Kelas Produk
```java
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

class Produk {
    protected String namaProduk;
    protected double harga;
    protected int jumlahStok;

    public Produk(String namaProduk, double harga, int jumlahStok) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        this.jumlahStok = jumlahStok;
    }

    public void displayInfo() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Nama Produk: " + namaProduk);
        System.out.println("Harga: " + df.format(harga));
        System.out.println("Jumlah Stok: " + jumlahStok);
    }
}
```

### • Penjelasan:
```
- Kelas Produk: Kelas dasar untuk semua produk yang memiliki atribut dasar seperti nama, harga, dan jumlah stok.

- Atribut:
  - String namaProduk: Nama produk.
  - double harga: Harga produk.
  - int jumlahStok: Jumlah stok produk yang tersedia.

- Konstruktor: Untuk menginisialisasi nama produk, harga, dan jumlah stok saat objek Produk dibuat.

- Metode displayInfo(): Menampilkan informasi produk dengan format harga yang ditentukan menggunakan DecimalFormat.
```

##  • Kelas Elektronik
```java
class Elektronik extends Produk {
    @SuppressWarnings("FieldMayBeFinal")
    private int garansi;

    public Elektronik(String namaProduk, double harga, int jumlahStok, int garansi) {
        super(namaProduk, harga, jumlahStok);
        this.garansi = garansi;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Garansi: " + garansi + " tahun");
    }
}
```

### • Penjelasan:
```
- Kelas Elektronik: Subclass dari Produk untuk kategori produk elektronik.
- Atribut:
  - int garansi: Menyimpan lama garansi produk elektronik dalam tahun.

- Konstruktor: Menginisialisasi atribut produk elektronik, termasuk garansi.

- Metode displayInfo(): Mengoverride metode dari Produk untuk menampilkan informasi tambahan yaitu garansi.
```

##  • Kelas Pakaian
```java
class Pakaian extends Produk {
    @SuppressWarnings("FieldMayBeFinal")
    private String ukuran;
    @SuppressWarnings("FieldMayBeFinal")
    private String warna;

    public Pakaian(String namaProduk, double harga, int jumlahStok, String ukuran, String warna) {
        super(namaProduk, harga, jumlahStok);
        this.ukuran = ukuran;
        this.warna = warna;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Ukuran: " + ukuran);
        System.out.println("Warna: " + warna);
    }
}
```

### • Penjelasan:
```
- Kelas Pakaian: Subclass dari Produk untuk kategori pakaian.

- Atribut:
  - String ukuran: Ukuran pakaian.
  - String warna: Warna pakaian.

- Konstruktor: Menginisialisasi atribut pakaian, termasuk ukuran dan warna.

- Metode displayInfo(): Mengoverride untuk menampilkan informasi tambahan tentang ukuran dan warna.
```

##  • Kelas Makanan
```java
class Makanan extends Produk {
    private Date tanggalKadaluarsa;

    public Makanan(String namaProduk, double harga, int jumlahStok, Date tanggalKadaluarsa) {
        super(namaProduk, harga, jumlahStok);
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    public void setTanggalKadaluarsa(Date tanggalKadaluarsa) {
        this.tanggalKadaluarsa = tanggalKadaluarsa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        System.out.println("Tanggal Kadaluarsa: " + dateFormat.format(tanggalKadaluarsa));
    }
}
```

### • Penjelasan:
```
- Kelas Makanan: Subclass dari Produk untuk kategori makanan.

- Atribut:
  - Date tanggalKadaluarsa: Menyimpan tanggal kedaluwarsa produk makanan.

- Konstruktor: Menginisialisasi semua atribut makanan, termasuk tanggal kedaluwarsa.

- Metode setTanggalKadaluarsa(): Setter untuk mengubah tanggal kedaluwarsa.

- Metode displayInfo(): Mengoverride untuk menampilkan informasi tentang tanggal kedaluwarsa dalam format yang ditentukan.
```

##  • Kelas KeranjangBelanja
```java
class KeranjangBelanja {
    @SuppressWarnings("FieldMayBeFinal")
    private List<Produk> daftarProduk;
    private List<Integer> jumlahProduk;

    public KeranjangBelanja() {
        daftarProduk = new ArrayList<>();
        jumlahProduk = new ArrayList<>();
    }

    public void tambahProduk(Produk p, int jumlah) {
        if (p.jumlahStok >= jumlah) {
            daftarProduk.add(p);
            jumlahProduk.add(jumlah);
            p.jumlahStok -= jumlah;
            System.out.println(jumlah + " " + p.namaProduk + " ditambahkan ke keranjang.");
        } else {
            System.out.println("Stok tidak mencukupi untuk " + p.namaProduk);
        }
    }

    public double hitungTotalBelanja() {
        double total = 0;
        for (int i = 0; i < daftarProduk.size(); i++) {
            total += daftarProduk.get(i).harga * jumlahProduk.get(i);
        }
        return total;
    }

    public void displayKeranjang() {
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Isi Keranjang Belanja:");
        for (int i = 0; i < daftarProduk.size(); i++) {
            Produk p = daftarProduk.get(i);
            int jumlah = jumlahProduk.get(i);
            p.displayInfo();
            System.out.println("Jumlah: " + jumlah);
            System.out.println("Subtotal: " + df.format(p.harga * jumlah));
            System.out.println();
        }
        System.out.println("Total Harga Semua Produk di Keranjang: " + df.format(hitungTotalBelanja()));
    }

    public List<Integer> getJumlahProduk() {
        return jumlahProduk;
    }

    public void setJumlahProduk(List<Integer> jumlahProduk) {
        this.jumlahProduk = jumlahProduk;
    }
}
```

### • Penjelasan:
```
- Kelas KeranjangBelanja: Kelas ini mengelola daftar produk yang ditambahkan ke
keranjang.

- Atribut:
  - List<Produk> daftarProduk: Daftar produk yang ada di keranjang.
  - List<Integer> jumlahProduk: Jumlah masing-masing produk dalam keranjang.

- Konstruktor: Inisialisasi dua list kosong.

- Metode tambahProduk(Produk p, int jumlah): Menambahkan produk ke keranjang jika stok cukup, mengurangi jumlah stok produk yang ada.

- Metode hitungTotalBelanja(): Menghitung total biaya semua produk di keranjang.

- Metode displayKeranjang(): Menampilkan semua produk dalam keranjang beserta subtotal untuk masing-masing produk dan total keseluruhan.
```
##  • Kelas ShopingCart
```java
public class ShopingCart {
    public static void main(String[] args) {
        Elektronik laptop = new Elektronik("Laptop", 8000000, 10, 2);
        Pakaian sepatu = new Pakaian("Sepatu", 100000, 50, "L", "Hitam");

        Calendar cal = Calendar.getInstance();
        cal.set(2024, Calendar.NOVEMBER, 7); 
        Date tanggalKadaluarsa = cal.getTime();
        
        Makanan roti = new Makanan("Roti", 50000, 30, tanggalKadaluarsa);

        KeranjangBelanja keranjang = new KeranjangBelanja();

        keranjang.tambahProduk(laptop, 1);
        keranjang.tambahProduk(sepatu, 3);
        keranjang.tambahProduk(roti, 5);

        keranjang.displayKeranjang();
    }
}
```

### • Penjelasan:
```
- Kelas ShopingCart: Kelas ini berfungsi sebagai titik masuk untuk program.

- Metode main:
  - Membuat objek dari kelas Elektronik, Pakaian, dan Makanan, serta mengatur tanggal kadaluarsa menggunakan Calendar.
  - Membuat objek KeranjangBelanja dan menambahkan produk ke dalam keranjang.
  - Memanggil displayKeranjang() untuk menampilkan informasi semua produk di keranjang.
```

#  • Output
![gambar](Tugas-Pemrograman-Orientasi-Objek-Pert-7/ss4.png)

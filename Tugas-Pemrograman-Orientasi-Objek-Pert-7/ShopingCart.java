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

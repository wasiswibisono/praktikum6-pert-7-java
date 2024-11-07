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

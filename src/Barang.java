public class Barang {
    private String nama;
    private int harga;
    private int kuantitas;

    public Barang(String nama, int harga) {
        this.nama = nama;
        this.harga = harga;
        this.kuantitas = 1; // Default kuantitas saat ditambahkan
    }

    // --- Getter dan Setter bisa ditambahkan di sini jika perlu ---
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }
}
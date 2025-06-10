public class Barang {
    // Pastikan field ini ada
    private String idBarang;
    private String nama;
    private int harga;
    private int kuantitas;

    // Pastikan constructor Anda menerima idBarang
    public Barang(String idBarang, String nama, int harga) {
        this.idBarang = idBarang;
        this.nama = nama;
        this.harga = harga;
        this.kuantitas = 1; 
    }

    // --- PASTIKAN METHOD INI ADA ---
    public String getIdBarang() {
        return idBarang;
    }
    
    // --- Method getter lainnya ---
    public String getNama() {
        return nama;
    }

    public int getHarga() {
        return harga;
    }

    public int getKuantitas() {
        return kuantitas;
    }

    // --- Method untuk mengubah kuantitas ---
    public void tambahKuantitas(int jumlah) {
        this.kuantitas += jumlah;
    }
    
    public int getSubtotal() {
        return this.harga * this.kuantitas;
    }
}
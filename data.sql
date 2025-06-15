-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 12 Jun 2025 pada 15.51
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `barang`
--

CREATE TABLE `barang` (
  `ID_Barang` varchar(50) NOT NULL,
  `Nama_Barang` varchar(100) DEFAULT NULL,
  `ID_Supplier` varchar(50) DEFAULT NULL,
  `tanggal_pembelian` date DEFAULT NULL,
  `Harga_Beli` int(11) DEFAULT NULL,
  `Harga_Jual` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `barang`
--

INSERT INTO `barang` (`ID_Barang`, `Nama_Barang`, `ID_Supplier`, `tanggal_pembelian`, `Harga_Beli`, `Harga_Jual`) VALUES
('BRG011', 'Helm Keselamatan', 'SUP001', '2025-06-03', 75000, 120000),
('BRG012', 'Sarung Tangan Safety', 'SUP002', '2025-06-03', 30000, 50000),
('BRG013', 'Sepatu Safety', 'SUP003', '2025-06-04', 250000, 380000),
('BRG014', 'Masker Respirator N95', 'SUP005', '2025-06-04', 45000, 70000),
('BRG015', 'Kacamata Safety', 'SUP001', '2025-06-05', 20000, 35000),
('BRG016', 'Rompi Reflektif', 'SUP002', '2025-06-10', 60000, 95000),
('BRG017', 'Alat Pemadam Api Ringan (APAR)', 'SUP006', '2025-06-10', 500000, 750000),
('BRG018', 'Kotak P3K Lengkap', 'SUP007', '2025-06-11', 150000, 220000),
('BRG019', 'Tali Pengaman', 'SUP008', '2025-06-11', 300000, 450000),
('BRG020', 'Earplug Pelindung Telinga', 'SUP009', '2025-06-11', 15000, 25000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `customer`
--

CREATE TABLE `customer` (
  `ID_Pelanggan` varchar(50) NOT NULL,
  `Nama_Perusahaan` varchar(100) DEFAULT NULL,
  `Nama_PIC` varchar(100) DEFAULT NULL,
  `Jabatan` varchar(50) DEFAULT NULL,
  `No_Telepon` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Alamat` varchar(255) DEFAULT NULL,
  `Bidang_Proyek` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `customer`
--

INSERT INTO `customer` (`ID_Pelanggan`, `Nama_Perusahaan`, `Nama_PIC`, `Jabatan`, `No_Telepon`, `Email`, `Alamat`, `Bidang_Proyek`) VALUES
('CUST001', 'PT. Bangun Rumah', 'Andi Wijaya', 'Manajer Proyek', '081211223344', 'andi.w@bangunrumah.com', 'Jl. Proklamasi No. 1, Jakarta', 'Konstruksi'),
('CUST002', 'CV. Desain Interior', 'Citra Kirana', 'Desainer Senior', '081322334455', 'citra.k@desaininterior.id', 'Jl. Anggrek No. 2, Bandung', 'Desain Interior'),
('CUST003', 'Yayasan Pendidikan', 'Joko Susilo', 'Kepala Sekolah', '081433445566', 'joko.s@yayasanpendidikan.org', 'Jl. Pendidikan No. 3, Surabaya', 'Pendidikan'),
('CUST004', 'PT. Solusi Teknologi', 'Rina Amelia', 'IT Manager', '081544556677', 'rina.a@solusiteknologi.com', 'Jl. Teknologi No. 4, Jakarta', 'Teknologi Informasi'),
('CUST005', 'Toko Buku Cerdas', 'Bayu Pratama', 'Pemilik', '081655667788', 'bayu.p@tokobukucerdas.net', 'Jl. Buku No. 5, Semarang', 'Retail Buku'),
('CUST006', 'PT. Kuliner Nusantara', 'Putri Indah', 'Chef Utama', '081766778899', 'putri.i@kulinernusantara.com', 'Jl. Kuliner No. 6, Medan', 'Restoran'),
('CUST007', 'Koperasi Petani', 'Bambang Setiawan', 'Ketua Koperasi', '081877889900', 'bambang.s@koperasi.id', 'Jl. Pertanian No. 7, Yogyakarta', 'Agribisnis'),
('CUST008', 'PT. Media Kreatif', 'Siska Nurani', 'Art Director', '081988990011', 'siska.n@mediakreatif.com', 'Jl. Media No. 8, Jakarta', 'Media & Periklanan'),
('CUST009', 'Puskesmas Sehat', 'Dr. Tania', 'Kepala Puskesmas', '082099001122', 'dr.tania@puskesmassehat.org', 'Jl. Kesehatan No. 9, Bandung', 'Kesehatan'),
('CUST010', 'PT. Logistik Cepat', 'Faisal Akbar', 'Supervisor Logistik', '082100112233', 'faisal.a@logistikcepat.com', 'Jl. Logistik No. 10, Surabaya', 'Logistik');

-- --------------------------------------------------------

--
-- Struktur dari tabel `detail_penjualan`
--

CREATE TABLE `detail_penjualan` (
  `ID_Detail` int(11) NOT NULL,
  `ID_Transaksi` int(11) NOT NULL,
  `ID_Barang` varchar(50) NOT NULL,
  `Jumlah` int(11) NOT NULL,
  `Harga_Saat_Transaksi` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `detail_penjualan`
--

INSERT INTO `detail_penjualan` (`ID_Detail`, `ID_Transaksi`, `ID_Barang`, `Jumlah`, `Harga_Saat_Transaksi`) VALUES
(1, 1, 'BRG011', 1, 120000),
(2, 1, 'BRG015', 1, 35000),
(3, 2, 'BRG011', 1, 120000),
(4, 2, 'BRG019', 1, 450000);

-- --------------------------------------------------------

--
-- Struktur dari tabel `supplier`
--

CREATE TABLE `supplier` (
  `ID_Supplier` varchar(50) NOT NULL,
  `Nama_Perusahaan` varchar(100) DEFAULT NULL,
  `Kontak_PIC` varchar(100) DEFAULT NULL,
  `No_Telepon` varchar(20) DEFAULT NULL,
  `Email` varchar(100) DEFAULT NULL,
  `Alamat` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `supplier`
--

INSERT INTO `supplier` (`ID_Supplier`, `Nama_Perusahaan`, `Kontak_PIC`, `No_Telepon`, `Email`, `Alamat`) VALUES
('SUP001', 'PT. Maju Bersama', 'Budi Santoso', '081234567890', 'budi.s@majubersama.com', 'Jl. Merdeka No. 10, Jakarta'),
('SUP002', 'CV. Jaya Abadi', 'Siti Aminah', '082345678901', 'siti.a@jayaabadi.co.id', 'Jl. Kebon Jeruk No. 25, Bandung'),
('SUP003', 'UD. Sejahtera', 'Agus Salim', '083456789012', 'agus.s@sejahtera.net', 'Jl. Diponegoro No. 5, Surabaya'),
('SUP004', 'PT. Global Solusi', 'Dewi Lestari', '081122334455', 'dewi.l@globalsolusi.com', 'Jl. Sudirman No. 100, Jakarta'),
('SUP005', 'CV. Cahaya Indah', 'Rudi Hartono', '085678901234', 'rudi.h@cahayaindah.id', 'Jl. Pahlawan No. 7, Semarang'),
('SUP006', 'PT. Sentosa Jaya', 'Fitriani', '087890123456', 'fitriani@sentosajaya.com', 'Jl. Gatot Subroto No. 12, Medan'),
('SUP007', 'UD. Makmur Sentosa', 'Hadi Wijaya', '089012345678', 'hadi.w@makmursentosa.co.id', 'Jl. Ahmad Yani No. 30, Yogyakarta'),
('SUP008', 'PT. Mitra Unggul', 'Lina Marlina', '081345678901', 'lina.m@mitraunggul.net', 'Jl. Thamrin No. 8, Jakarta'),
('SUP009', 'CV. Berkah Rezeki', 'Dian Permata', '082123456789', 'dian.p@berkahrezeki.com', 'Jl. Asia Afrika No. 15, Bandung'),
('SUP010', 'PT. Prima Karya', 'Eko Susanto', '085123456789', 'eko.s@primakarya.id', 'Jl. Veteran No. 20, Surabaya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `transaksi_penjualan`
--

CREATE TABLE `transaksi_penjualan` (
  `ID_Transaksi` int(11) NOT NULL,
  `ID_Pelanggan` int(11) NOT NULL,
  `Total_Transaksi` int(11) NOT NULL,
  `tanggal_transaksi` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `transaksi_penjualan`
--

INSERT INTO `transaksi_penjualan` (`ID_Transaksi`, `ID_Pelanggan`, `Total_Transaksi`, `tanggal_transaksi`) VALUES
(1, 1, 155000, '2025-06-11 19:17:55'),
(2, 14, 570000, '2025-06-11 19:24:15');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`ID_Barang`),
  ADD KEY `ID_Supplier` (`ID_Supplier`);

--
-- Indeks untuk tabel `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`ID_Pelanggan`);

--
-- Indeks untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD PRIMARY KEY (`ID_Detail`),
  ADD KEY `ID_Transaksi` (`ID_Transaksi`),
  ADD KEY `ID_Barang` (`ID_Barang`);

--
-- Indeks untuk tabel `supplier`
--
ALTER TABLE `supplier`
  ADD PRIMARY KEY (`ID_Supplier`);

--
-- Indeks untuk tabel `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD PRIMARY KEY (`ID_Transaksi`),
  ADD KEY `ID_Pelanggan` (`ID_Pelanggan`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  MODIFY `ID_Detail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT untuk tabel `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  MODIFY `ID_Transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_ibfk_1` FOREIGN KEY (`ID_Supplier`) REFERENCES `supplier` (`ID_Supplier`);

--
-- Ketidakleluasaan untuk tabel `detail_penjualan`
--
ALTER TABLE `detail_penjualan`
  ADD CONSTRAINT `detail_penjualan_ibfk_1` FOREIGN KEY (`ID_Transaksi`) REFERENCES `transaksi_penjualan` (`ID_Transaksi`),
  ADD CONSTRAINT `detail_penjualan_ibfk_2` FOREIGN KEY (`ID_Barang`) REFERENCES `barang` (`ID_Barang`);

--
-- Ketidakleluasaan untuk tabel `transaksi_penjualan`
--
ALTER TABLE `transaksi_penjualan`
  ADD CONSTRAINT `transaksi_penjualan_ibfk_1` FOREIGN KEY (`ID_Pelanggan`) REFERENCES `user`.`konsumen` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

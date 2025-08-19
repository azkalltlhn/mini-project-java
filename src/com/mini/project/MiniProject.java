package com.mini.project;

import java.util.ArrayList;
import java.util.Scanner;

public class MiniProject {

    // Class Mahasiswa
    static class Mahasiswa {
        String nim;
        String nama;
        double tugas;
        double uts;
        double uas;

        // Hitung nilai akhir
        double hitungNilaiAkhir() {
            return (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);
        }

        // Tentukan grade
        String getGrade() {
            double nilaiAkhir = hitungNilaiAkhir();
            if (nilaiAkhir >= 85) return "A";
            else if (nilaiAkhir >= 70) return "B";
            else if (nilaiAkhir >= 55) return "C";
            else if (nilaiAkhir >= 40) return "D";
            else return "E";
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Mahasiswa> daftarMahasiswa = new ArrayList<>();
        int pilihan;

        do {
            // Menu Utama
            System.out.println("\n=== MENU APLIKASI NILAI MAHASISWA ===");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Semua Data");
            System.out.println("3. Cari Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = input.nextInt();
            input.nextLine(); // buang newline

            switch (pilihan) {
                case 1 -> { // Tambah Mahasiswa
                    Mahasiswa mhs = new Mahasiswa();
                    System.out.print("Masukkan NIM   : ");
                    mhs.nim = input.nextLine();
                    System.out.print("Masukkan Nama  : ");
                    mhs.nama = input.nextLine();
                    System.out.print("Masukkan Nilai Tugas : ");
                    mhs.tugas = input.nextDouble();
                    System.out.print("Masukkan Nilai UTS   : ");
                    mhs.uts = input.nextDouble();
                    System.out.print("Masukkan Nilai UAS   : ");
                    mhs.uas = input.nextDouble();
                    input.nextLine(); // buang newline

                    daftarMahasiswa.add(mhs);
                    System.out.println("✅ Data mahasiswa berhasil ditambahkan!");
                }
                case 2 -> { // Tampilkan Semua Data
                    if (daftarMahasiswa.isEmpty()) {
                        System.out.println("⚠️ Belum ada data mahasiswa.");
                    } else {
                        System.out.println("\n=== DAFTAR MAHASISWA ===");
                        for (Mahasiswa m : daftarMahasiswa) {
                            System.out.println("NIM   : " + m.nim);
                            System.out.println("Nama  : " + m.nama);
                            System.out.println("Tugas : " + m.tugas);
                            System.out.println("UTS   : " + m.uts);
                            System.out.println("UAS   : " + m.uas);
                            System.out.println("Nilai Akhir : " + m.hitungNilaiAkhir());
                            System.out.println("Grade       : " + m.getGrade());
                            System.out.println("----------------------------");
                        }
                    }
                }
                case 3 -> { // Cari Mahasiswa
                    System.out.print("Masukkan NIM yang dicari: ");
                    String cariNim = input.nextLine();
                    boolean ditemukan = false;
                    for (Mahasiswa m : daftarMahasiswa) {
                        if (m.nim.equalsIgnoreCase(cariNim)) {
                            System.out.println("\n=== DATA DITEMUKAN ===");
                            System.out.println("NIM   : " + m.nim);
                            System.out.println("Nama  : " + m.nama);
                            System.out.println("Nilai Akhir : " + m.hitungNilaiAkhir());
                            System.out.println("Grade       : " + m.getGrade());
                            ditemukan = true;
                            break;
                        }
                    }
                    if (!ditemukan) {
                        System.out.println("⚠️ Mahasiswa dengan NIM " + cariNim + " tidak ditemukan.");
                    }
                }
                case 4 -> { // Hapus Mahasiswa
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    String hapusNim = input.nextLine();
                    boolean terhapus = daftarMahasiswa.removeIf(m -> m.nim.equalsIgnoreCase(hapusNim));
                    if (terhapus) {
                        System.out.println("✅ Data mahasiswa berhasil dihapus!");
                    } else {
                        System.out.println("⚠️ Mahasiswa dengan NIM " + hapusNim + " tidak ditemukan.");
                    }
                }
                case 5 -> System.out.println("👋 Keluar dari program...");
                default -> System.out.println("⚠️ Pilihan tidak valid!");
            }
        } while (pilihan != 5);

        input.close();
    }
}

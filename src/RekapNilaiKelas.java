import java.util.Scanner; 

public class RekapNilaiKelas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jumlahNilaiSah = 0;
        double totalNilai = 0;
        int nomorInput = 1;

        System.out.println("===== REKAP NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.\n");

        while (true) {
            System.out.print("Nilai ke-" + nomorInput + " : ");
            double nilai = scanner.nextDouble();

            // Cek kondisi untuk berhenti
            if (nilai == -1) {
                break;
            }

            // Validasi rentang nilai (0 - 100)
            if (nilai < 0 || nilai > 100) {
                System.out.println("  ditolak — nilai harus 0..100");
                continue; // Lanjut ke iterasi berikutnya tanpa menambah hitungan
            }

            // Tentukan Grade
            String grade;
            if (nilai >= 85) {
                grade = "Grade A — Sangat Baik";
            } else if (nilai >= 75) {
                grade = "Grade B — Baik";
            } else if (nilai >= 60) {
                grade = "Grade C — Cukup";
            } else if (nilai >= 50) {
                grade = "Grade D — Kurang";
            } else {
                grade = "Grade E — Tidak Lulus";
            }

            System.out.println("  " + grade);

            // Akumulasi data untuk perhitungan akhir
            totalNilai += nilai;
            jumlahNilaiSah++;
            nomorInput++;
        }

        System.out.println("\n------------------------------");
        if (jumlahNilaiSah > 0) {
            double rataRata = totalNilai / jumlahNilaiSah;
            // Menentukan status kelulusan (contoh batas lulus rata-rata adalah 60)
            String status = (rataRata >= 60) ? "LULUS" : "TIDAK LULUS";

            System.out.println("Nilai sah   : " + jumlahNilaiSah);
            System.out.printf("Rata-rata   : %.2f\n", rataRata);
            System.out.println("Status      : " + status);
        } else {
            System.out.println("Tidak ada nilai sah yang dimasukkan.");
        }

        scanner.close();
    }
}

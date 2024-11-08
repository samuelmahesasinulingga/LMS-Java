import java.util.Random; // Mengimpor kelas Random untuk membuat angka acak
import java.util.Scanner; // Mengimpor kelas Scanner untuk input dari pengguna
import java.util.HashMap; // Mengimpor kelas HashMap untuk menyimpan jadwal
import java.util.ArrayList; // Mengimpor kelas ArrayList untuk menyimpan to-do list

// Kelas Grades untuk mengelola nilai mata kuliah mahasiswa
class Grades {
    private String[] courses; // Array untuk menyimpan nama mata kuliah
    private int[] scores; // Array untuk menyimpan nilai mata kuliah

    // Konstruktor untuk menginisialisasi data mata kuliah dan nilai
    public Grades() {
        courses = new String[] {
                "Sistem Operasi", "Basis Data", "Desain dan Analisa Algoritma",
                "Kecerdasan Artifisial", "Kalkulus 2", "Pemrograman Beriorentasi Objek",
                "Rekayasa Perangkat Lunak", "Kewirausahaan 1"
        };
        scores = new int[] { 85, 90, 80, 88, 75, 92, 87, 78 }; // Inisialisasi nilai masing-masing mata kuliah
    }

    // Method untuk menampilkan daftar nilai mahasiswa
    public void displayGrades() {
        System.out.println("Daftar Nilai Mahasiswa:");
        for (int i = 0; i < courses.length; i++) {
            System.out.println((i + 1) + ". " + courses[i] + " : " + scores[i]);
        }
    }
}

// Kelas Schedule untuk mengelola jadwal kelas
class Schedule {
    private HashMap<String, String[]> schedule; // HashMap untuk menyimpan jadwal kelas per hari

    // Konstruktor untuk menginisialisasi jadwal kelas
    public Schedule() {
        schedule = new HashMap<>();
        // Memasukkan jadwal ke dalam HashMap
        schedule.put("senin", new String[] { "07.30-12.30 Sistem Operasi", "13.00-15.30 Basis Data" });
        schedule.put("selasa",
                new String[] { "07.30-10.00 Desain dan Analisa Algoritma", "13.00-15.30 Kecerdasan Artifisial" });
        schedule.put("rabu", new String[] { "07.30-10.00 Kalkulus 2" });
        schedule.put("kamis",
                new String[] { "07.30-12.30 Pemrograman Beriorentasi Objek", "13.00-15.30 Rekayasa Perangkat Lunak" });
        schedule.put("jumat", new String[] { "07.30-10.00 Kewirausahaan 1" });
    }

    // Method untuk menampilkan jadwal berdasarkan hari yang dimasukkan
    public void displaySchedule(String day) {
        if (schedule.containsKey(day)) { // Kondisi untuk memeriksa apakah hari ada dalam jadwal
            System.out.println("Jadwal Hari " + day + ":");
            for (String time : schedule.get(day)) { // Looping untuk menampilkan jadwal kelas pada hari tersebut
                System.out.println(time);
            }
        } else {
            System.out.println("Hari yang dimasukkan tidak valid atau tidak ada kelas.");
        }
    }
}

// Kelas ToDoList untuk mengelola daftar tugas mahasiswa
class ToDoList {
    private ArrayList<String> tasks; // ArrayList untuk menyimpan tugas
    private ArrayList<String> deadlines; // ArrayList untuk menyimpan deadline tugas

    // Konstruktor untuk menginisialisasi ArrayList tasks dan deadlines
    public ToDoList() {
        tasks = new ArrayList<>();
        deadlines = new ArrayList<>();
    }

    // Method untuk menampilkan semua tugas dan deadlinenya
    public void displayTasks() {
        if (tasks.isEmpty()) { // Kondisi jika tidak ada tugas dalam daftar
            System.out.println("Tidak ada tugas dalam to-do list.");
        } else {
            System.out.println("Daftar Tugas:");
            for (int i = 0; i < tasks.size(); i++) { // Loop untuk menampilkan setiap tugas
                System.out.println((i + 1) + ". " + tasks.get(i) + " (Deadline: " + deadlines.get(i) + ")");
            }
        }
    }

    // Method untuk menambahkan tugas baru ke to-do list
    public void addTask(String task, String deadline) {
        tasks.add(task); // Menambahkan tugas ke ArrayList tasks
        deadlines.add(deadline); // Menambahkan deadline ke ArrayList deadlines
        System.out.println("Tugas berhasil ditambahkan!");
    }

    // Method untuk menghapus tugas berdasarkan indeks
    public void removeTask(int taskIndex) {
        if (taskIndex > 0 && taskIndex <= tasks.size()) { // Kondisi untuk memeriksa apakah indeks valid
            tasks.remove(taskIndex - 1); // Menghapus tugas berdasarkan indeks
            deadlines.remove(taskIndex - 1); // Menghapus deadline tugas tersebut
            System.out.println("Tugas berhasil dihapus!");
        } else {
            System.out.println("Indeks tugas tidak valid.");
        }
    }
}

// Kelas utama lms untuk sistem manajemen mahasiswa
public class lms {
    private static long nim; // Variabel untuk menyimpan NIM
    private static String password; // Variabel untuk menyimpan password
    private static String namaDepan; // Variabel untuk menyimpan nama depan
    private static String namaBelakang; // Variabel untuk menyimpan nama belakang

    // Konstruktor untuk mengatur NIM
    public lms(long nim) {
        nim = nim;
    }

    // Method getter untuk mengambil nilai NIM
    public static long getNim() {
        return nim;
    }

    // Konstruktor untuk mengatur password
    public lms(String pw) {
        password = pw;
    }

    // Method getter untuk mengambil password
    public static String getPassword() {
        return password;
    }

    // Method setter untuk mengubah password
    public static void setPassword(String newPassword) {
        password = newPassword;
        System.out.println("Password berhasil diubah! Silakan login ulang dengan password baru.");
    }

    // Method setter untuk mengatur nama depan
    public static void setNamaDepan(String depan) {
        namaDepan = depan;
    }

    // Method setter untuk mengatur nama belakang
    public static void setNamaBelakang(String belakang) {
        namaBelakang = belakang;
    }

    // Method untuk menampilkan profil pengguna
    public static void displayProfile() {
        System.out.println("User Profile:");
        System.out.println("Nama     : " + namaDepan + " " + namaBelakang);
        System.out.println("NIM      : " + nim);
        System.out.println("Password : " + password);
    }

    // Method untuk memverifikasi captcha acak
    public static boolean verifyCaptcha(Scanner scanner) {
        Random rand = new Random(); // Membuat objek Random untuk angka acak
        int num1 = rand.nextInt(10); // Angka pertama antara 0 dan 9
        int num2 = rand.nextInt(10); // Angka kedua antara 0 dan 9

        System.out.println("Captcha: Berapakah " + num1 + " + " + num2 + " ?");
        System.out.print("Jawaban: ");
        int answer = scanner.nextInt(); // Membaca jawaban pengguna

        return answer == (num1 + num2); // Mengembalikan hasil apakah jawaban benar
    }

    // Method main untuk menjalankan aplikasi
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Membuat objek Scanner untuk input
        Grades grades = new Grades(); // Membuat objek Grades
        Schedule schedule = new Schedule(); // Membuat objek Schedule
        ToDoList toDoList = new ToDoList(); // Membuat objek ToDoList

        lms userLMS = new lms("1234"); // Inisialisasi Password Pertama Kali Login

        while (true) { // Loop utama untuk login
            System.out.println("Login");

            int attempts = 0; // Menghitung percobaan login
            boolean isAuthenticated = false; // Status login

            while (attempts < 3) { // Membatasi percobaan login maksimal 3 kali
                System.out.print("Username (NIM): ");
                nim = scanner.nextLong();
                System.out.print("Password: ");
                String pw = scanner.next();

                if (pw.equals(getPassword()) && verifyCaptcha(scanner)) { // Memverifikasi password dan captcha
                    System.out.println("Login berhasil!");
                    isAuthenticated = true;
                    break;
                } else {
                    System.out.println("Password atau captcha salah. Silakan coba lagi.");
                    attempts++; // Menambah jumlah percobaan login
                }
            }

            if (!isAuthenticated) { // Kondisi jika 3 kali gagal login
                System.out.println("Anda telah salah memasukkan password atau captcha 3 kali. Program dihentikan.");
                return;
            }

            boolean isLoggedIn = true; // Status login setelah berhasil login

            while (isLoggedIn) {
                // Menu utama setelah login
                System.out.println("\nProgram LMS Esa Unggul University");
                System.out.println("1. Jadwal Kelas");
                System.out.println("2. Courses");
                System.out.println("3. Nilai Mahasiswa");
                System.out.println("4. To-Do List");
                System.out.println("5. User Profile");
                System.out.println("6. Settings");
                System.out.println("7. Logout");

                System.out.print("Pilihan anda: ");
                int pilihan = scanner.nextInt();

                switch (pilihan) { // Menjalankan menu berdasarkan pilihan
                    case 1:
                        System.out.print("Masukkan Hari: ");
                        String hari = scanner.next();
                        schedule.displaySchedule(hari); // Menampilkan jadwal berdasarkan hari
                        break;
                    case 2:
                        // Menammpilkan daftar courses yang ada
                        System.out.println("Daftar Courses:");
                        System.out.println("1. KH001 Sistem Operasi");
                        System.out.println("2. KH002 Basis Data");
                        System.out.println("3. KH003 Desain dan Analisa Algoritma");
                        System.out.println("4. KH004 Kecerdasan Artifisial");
                        System.out.println("5. KH005 Kalkulus 2");
                        System.out.println("6. KH006 Pemrograman Beriorentasi Objek");
                        System.out.println("7. KH007 Rekayasa Perangkat Lunak");
                        System.out.println("8. KH008 Kewirausahaan 1");
                        break;
                    case 3:
                        grades.displayGrades(); // Menampilkan nilai mahasiswa
                        break;
                    case 4:
                        // Menampilkan menu to-do list
                        System.out.println("\nTo-Do List:");
                        System.out.println("1. Lihat Semua Tugas");
                        System.out.println("2. Tambah Tugas Baru");
                        System.out.println("3. Hapus Tugas");
                        System.out.print("Pilih opsi: ");

                        int todoOption = scanner.nextInt();
                        scanner.nextLine();

                        switch (todoOption) {
                            case 1:
                                toDoList.displayTasks(); // Menampilkan daftar tugas
                                break;
                            case 2:
                                System.out.print("Masukkan deskripsi tugas baru: ");
                                String newTask = scanner.nextLine();
                                System.out.print("Masukkan deadline tugas (misalnya: 2024-11-30): ");
                                String deadline = scanner.nextLine();
                                toDoList.addTask(newTask, deadline); // Menambah tugas baru
                                break;
                            case 3:
                                System.out.print("Masukkan nomor tugas yang ingin dihapus: ");
                                int taskIndex = scanner.nextInt();
                                toDoList.removeTask(taskIndex); // Menghapus tugas berdasarkan indeks
                                break;
                            default:
                                System.out.println("Pilihan tidak valid.");
                                break;
                        }
                        break;
                    case 5:
                        displayProfile(); // Menampilkan profil pengguna
                        break;
                    case 6:
                        // Menampilkan menu setting
                        System.out.println("\nMenu Settings");
                        System.out.println("1. Tambahkan Nama");
                        System.out.println("2. Ubah Password");
                        System.out.print("Pilih opsi: ");
                        int settingMenu = scanner.nextInt();
                        scanner.nextLine();

                        if (settingMenu == 1) { // Pengaturan nama pengguna
                            System.out.print("Masukkan nama depan: ");
                            String depan = scanner.nextLine();
                            System.out.print("Masukkan nama belakang: ");
                            String belakang = scanner.nextLine();
                            setNamaDepan(depan);
                            setNamaBelakang(belakang);
                            System.out.println("Nama berhasil diubah!");
                        } else if (settingMenu == 2) { // Pengaturan password
                            System.out.print("Masukkan password lama: ");
                            String oldPassword = scanner.next();

                            if (oldPassword.equals(getPassword())) { // Verifikasi password lama
                                System.out.print("Masukkan password baru: ");
                                String newPassword = scanner.next();
                                setPassword(newPassword);
                                isLoggedIn = false; // Logout setelah mengganti password
                            } else {
                                System.out.println("Password lama salah, silakan coba lagi.");
                            }
                        } else {
                            System.out.println("Pilihan tidak valid.");
                        }
                        break;
                    case 7:
                        System.out.println("Logout berhasil. Terima kasih!"); // Logout dari sistem
                        isLoggedIn = false;
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                        break;
                }

                if (isLoggedIn) { // Konfirmasi apakah ingin melanjutkan atau tidak
                    System.out.print("\nApakah anda ingin mengulang? (Y/N): ");
                    char ulang = scanner.next().charAt(0);
                    if (ulang != 'y' && ulang != 'Y') {
                        isLoggedIn = false;
                    }
                }
            }
        }
    }
}

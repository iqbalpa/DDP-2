import java.util.Scanner;
import java.util.Arrays;

public class Lab03 {
    static int pointer = 0;
    static String[][] playlist = new String[1][4];
    static Scanner in = new Scanner(System.in);
    static int jumlahMusik = 0;

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Pacilfy!");

        // TODO:
        // loop inisialisasi playlist minimal 1 lagu dimasukkan
        int perintah = 1;

        // jika perintah != 0, maka akan tetap di dalam loop
        while (perintah != 0) {
            System.out.println("Silahkan masukkan lagu Anda");
            System.out.print("Judul : ");
            String judul = in.nextLine();
            System.out.print("Artist: ");
            String artist = in.nextLine();
            System.out.print("Album : ");
            String album = in.nextLine();
            System.out.print("Tahun : ");
            String tahun = in.nextLine();

            // menyimpan judul,artist,album,tahun ke dalam playlist
            playlist[jumlahMusik][0] = judul;
            playlist[jumlahMusik][1] = artist;
            playlist[jumlahMusik][2] = album;
            playlist[jumlahMusik][3] = tahun;

            System.out.println("Lanjut menambahkan lagu?");
            System.out.println("[1] Lanjut");
            System.out.println("[0] Berhenti");
            System.out.print("Perintah: ");
            perintah = in.nextInt();
            in.nextLine();

            // jika perintah = 1
            if (perintah == 1) {
                jumlahMusik++;

                // menambah panjang playlist sebanyak 1
                playlist = Arrays.copyOf(playlist, jumlahMusik+1);
                playlist[jumlahMusik] = Arrays.copyOf(playlist[0], 4);
            }
        }


        System.out.println("Pacilfy siap dimulai");
               
        System.out.println("\nSELAMAT DATANG DI\n");
        System.out.println(" /$$$$$$$                     /$$ /$$  /$$$$$$");
        System.out.println("| $$__  $$                   |__/| $$ /$$__  $$");
        System.out.println("| $$  \\ $$ /$$$$$$   /$$$$$$$ /$$| $$| $$  \\__//$$   /$$");
        System.out.println("| $$$$$$$/|____  $$ /$$_____/| $$| $$| $$$$   | $$  | $$");
        System.out.println("| $$____/  /$$$$$$$| $$      | $$| $$| $$_/   | $$  | $$");
        System.out.println("| $$      /$$__  $$| $$      | $$| $$| $$     | $$  | $$");
        System.out.println("| $$     |  $$$$$$$|  $$$$$$$| $$| $$| $$     |  $$$$$$$");
        System.out.println("|__/      \\_______/ \\_______/|__/|__/|__/      \\____  $$");
        System.out.println("                                               /$$  | $$");
        System.out.println("                                              |  $$$$$$/");
        System.out.println("                                               \\______/");


        int command = 1;
        while (true){
            display();
            System.out.print("Command (0 untuk exit) : ");
            command = Integer.parseInt(in.nextLine());
            if (command == 1){
                prevMusic();
            }
            else if (command == 2){
                addMusic();
            }
            else if (command == 3){
                detailsMusic();
            }
            else if (command == 4){
                deleteMusic();
            }
            else if (command == 5){
                nextMusic();
            }
            else if (command == 0){
                break;
            }
            else {
                System.out.println("Maaf, command yang anda masukan salah");
            }
        }

        System.out.println("Terima kasih sudah menggunakan Pacilfy!");
    }

    private static void nextMusic() {
        //TODO:

        // jika yg di play adalah lagu terakhir, maka nextMusic
        // akan play lagu pertama
        if (pointer == jumlahMusik) {
            pointer = 0;

        // jika bukan lagu terakhir, maka play lagu selanjutnya
        } else {
            pointer += 1;
        }
    }

    private static void deleteMusic() {
        //TODO:

        // jika jumlah musik cuma ada 1
        if (jumlahMusik == 0) {
            System.out.println("Minimal ada satu musiik dalam sistem");

        // jika jumlah musik > 1
        } else {
            String[][] newPlaylist = new String[jumlahMusik][];
            for (int i=0,j=0; j<jumlahMusik && i<jumlahMusik+1; i++) {

                // jika i = indeks lagu yg dihapus, maka lagu tsb tidak dimasukkan ke dalam newPlaylist
                if (i == pointer) {
                    continue;

                // memasukkan lagu yg tidak dihapus ke newPlaylist
                } else {
                    newPlaylist[j] = playlist[i];
                    j++;
                }
            }

            // mengcopy newPlaylist ke dalam playlist
            playlist = Arrays.copyOf(newPlaylist, jumlahMusik);

            // jika lagu yg dihapus adalah lagu terakhir, maka akan di play lagu pertama
            if (pointer == jumlahMusik) {
                pointer = 0;
            }

            // jumlah musik berkurang 1 tiap ada yg dihapus
            jumlahMusik--;
        }
    }

    private static void detailsMusic() {
        //TODO:
        boolean flag = false;
        System.out.print("Judul yang ingin dicari: ");
        String judul = in.nextLine();

        // membuat judul menjadi lowercase
        judul = judul.toLowerCase();

        // iterasi ke dalam playlist
        for (int i=0; i <= jumlahMusik; i++) {

            // jika judul yg dicari = judul lagu yg ada di playlist,
            // maka akan ditampilkan detail
            if (judul.equals(playlist[i][0].toLowerCase())) {
                System.out.println("Judul : " + playlist[i][0]);
                System.out.println("Artist: " + playlist[i][1]);
                System.out.println("Album : " + playlist[i][2]);
                System.out.println("Tahun : " + playlist[i][3]);
                flag = true;
            }
        }
        
        // jika lagu yg dicari tidak ada di dalam playlist
        if (!flag) {
            System.out.println("Lagu tidak ditemukan");
        }
        
    }

    private static void prevMusic() {
        //TODO:

        // jika lagu yg di play lagu pertama, maka akan di play lagu terakhir
        if (pointer == 0) {
            pointer = jumlahMusik;

        // jika bukan lagu pertama, maka akan di play lagu sebelumnya
        } else {
            pointer -= 1;
        }
    }

    private static void addMusic() {
        //TODO:

        // jumlah musik bertambah 1 tiap ada penambahan
        jumlahMusik++;
        System.out.println("Silahkan masukkan lagu Anda");
        System.out.print("Judul : ");
        String judul = in.nextLine();
        System.out.print("Artist: ");
        String artist = in.nextLine();
        System.out.print("Album : ");
        String album = in.nextLine();
        System.out.print("Tahun : ");
        String tahun = in.nextLine();

        // menambah panjang playlist sebanyak 1
        playlist = Arrays.copyOf(playlist, jumlahMusik + 1);
        playlist[jumlahMusik] = Arrays.copyOf(playlist[0], 4);

        // menyimpan judul,artist,album,tahun ke dalam playlist
        playlist[jumlahMusik][0] = judul;
        playlist[jumlahMusik][1] = artist;
        playlist[jumlahMusik][2] = album;
        playlist[jumlahMusik][3] = tahun;
    }


    private static void display() {
        System.out.println();
        System.out.println("Currently Playing");

        String displayedMusic = " " + playlist[pointer][1] + " - " + playlist[pointer][0] + " ";
        String command = "|[1] prev |[2] add music |[3] details |[4] delete music |[5] next|";

        if (displayedMusic.length() < command.length()){
            int width = 62;
            String s = displayedMusic;

            int padSize = width - s.length();
            int padStart = s.length() + padSize / 2;

            s = String.format("%" + padStart + "s", s);
            s = String.format("%-" + width  + "s", s);


            System.out.println(new String(new char[66]).replace("\0", "="));
            System.out.println("= "+ s +" =");
            System.out.println(new String(new char[66]).replace("\0", "="));
            System.out.println(command);

            return;
        }

        System.out.println("=" + new String(new char[displayedMusic.length()]).replace("\0", "=") + "=");
        System.out.println("=" + displayedMusic + "=");
        System.out.println("=" + new String(new char[displayedMusic.length()]).replace("\0", "=") + "=");
        System.out.println(command);
    }
    
}
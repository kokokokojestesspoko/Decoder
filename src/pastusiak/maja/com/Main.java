package pastusiak.maja.com;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {




    public static void main(String[] args) throws IOException {


        FileDialog dialog = new FileDialog((Frame)null, "Select File to Open");
        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);
        String file2 = dialog.getFile();
        System.out.println(file2 + " chosen.");
        File f = new File(file2);
        String absolute = dialog.getDirectory();

        int shift;

        Scanner load = new Scanner(System.in);
        System.out.println("Running a Decoder. \n Set the shift: "); // User can set the shift
        shift = load.nextInt();

        File file = new File(absolute + file2);
        System.out.println("Absolute  path: "
                + absolute + file2);
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                System.out.println(decode(sc.nextLine(), shift));
            }
        }

    }

    public static String decode(String text, int shift) {
        shift %= 26;
        if (shift == 0) return text;
        StringBuilder sb = new StringBuilder(text.length());
        for (int i = 0; i < text.length(); i++) {
            int c = text.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                c += shift;
                if (c > 'Z') c -= 26;
            } else if (c >= 'a' && c <= 'z') {
                c += shift;
                if (c > 'z') c -= 26;
            }

            sb.append((char) c);
        }
        return sb.toString();
    }
}



package sg.edu.nus.iss;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args )
    {
     
        String dirPath = "";
        if (args.length == 1) {
            dirPath = args[0];
        }
        
        File folder = new File(dirPath);

        if (!folder.exists()) {
            System.out.println("Please check directory again");
            System.exit(0);
        }

        File directory = folder;

        while (folder.isDirectory()) {
            directory = new File(folder.toString());
            folder = new File(folder.listFiles()[0].toString());
        }

        List<File> fileList = Arrays.asList(directory.listFiles());

        for (File file : fileList) {
            try {
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);

                StringBuilder sb = new StringBuilder();
                String input = "";
                while ((input = br.readLine()) != null) {
                    sb.append(input + " ");
                }

                String fileText = sb.toString().replace("\\s+", " ");
                fileAnalyst fileAnalyst = new fileAnalyst();
                fileAnalyst.analyse(fileText);
                fileAnalyst.printAnalysis();

                br.close();
                fr.close();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


        
        
    }

}

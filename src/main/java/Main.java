//        4. Написать программу, которая создаст текстовый файл и запишет в него
//        список файлов (путь, имя, дата создания) из заданного каталога.
//

import java.io.*;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;


public class Main {
        public static void main(String[] args) throws Exception {
            createTxtFile("G:\\1.txt", "C:\\Users\\User\\Downloads");
        }

        public static void createTxtFile(String myTextFile, String dirNameFrom) throws Exception {
            PrintWriter printWriter = new PrintWriter(myTextFile);
            File file1 = new File(dirNameFrom);
            // загоняем список всех фалов в массив
            File[] allFiles = file1.listFiles();

            StringBuilder stringBuilder = new StringBuilder();
            // для всех файлов достаем атрибуты и добавляем их в файл
            for(File curFile: allFiles){
                BasicFileAttributes attrs = Files.readAttributes(file1.toPath(), BasicFileAttributes.class);
                // вібираем только файлы - каталоги отбрасываем
                if(curFile.isFile()) {
                    stringBuilder.append(curFile + " ")                //путь и имя
                                 .append(attrs.creationTime() + " ") // дата создания
                                 .append("\n");
                }
            }
            printWriter.write(String.valueOf(stringBuilder));
            printWriter.close();
        }
}

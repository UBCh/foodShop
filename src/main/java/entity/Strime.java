package entity;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Strime {


    static String namefilePath;
    private static final String filePath = "src/main/java/artifact/";

    public Strime() {
    }

    public Strime(String namefilePath) {
        Strime.namefilePath = filePath + namefilePath;
    }

    public static String getNamefilePath() {
        return namefilePath;
    }

    public static void setNamefilePath(String namefile) {
        namefilePath = filePath + namefile;
    }

    public static void outputFile(String namefilePath, String infoForRecord, boolean replacingAnEntry) throws IOException {
        try (FileWriter fileWriter = new FileWriter(namefilePath, replacingAnEntry))  // tru- дозаписываем в файл, fals- перезаписываем)
        {
            fileWriter.write(new StringBuilder( ).append(infoForRecord).append("\n").toString( ));

        }
    }


    public static String inputFiles(String namefilePath) {
        String result = "";
        try (RandomAccessFile randomAccessFile = new RandomAccessFile(namefilePath, "rw");
             FileChannel channel = randomAccessFile.getChannel( )) {
// создаем буфер необходимого размера на основании размера нашего канала
            ByteBuffer byteBuffer = ByteBuffer.allocate((int) channel.size( ));
            StringBuilder builder = new StringBuilder( );
            channel.read(byteBuffer);
            // переключаем буфер с режима записи на режим чтения
            byteBuffer.flip( );
            // в цикле записываем данные из буфера в StringBuilder""
            while (byteBuffer.hasRemaining( )) {
                builder.append((char) byteBuffer.get( ));
            }

            result = builder.toString( );
        } catch (FileNotFoundException e) {
            e.printStackTrace( );
        } catch (IOException e) {
            e.printStackTrace( );
        }

        return result;
    }


    public static void cleanFile(String namefilePath) throws IOException {
        try (FileWriter fileWriter = new FileWriter(namefilePath, false)) {
            fileWriter.write("");
        }
    }

    public static void createFile(String namefile) throws IOException {
        setNamefilePath(namefile);
        File f = new File(getNamefilePath( ));
        f.createNewFile( );
    }

}

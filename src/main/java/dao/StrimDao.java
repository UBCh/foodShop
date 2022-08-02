package dao;

import entity.Good;
import entity.Strime;

import java.io.File;
import java.io.IOException;

public class StrimDao {

//    CRUD: create, read, update, delete

    static Strime strime;

    public StrimDao(Strime strime) {
        StrimDao.strime = strime;
    }

    public static Strime getStrime() {
        return strime;
    }

    public static void setStrime(Strime newStrime) {
        strime = newStrime;
    }

    public static void createFile() throws IOException {
        Strime.createFile(Strime.getNamefilePath( ));
    }

    public static void createFile(String nameFile) throws IOException {
        Strime.createFile(nameFile);
    }

    public static void clearFile(String newNameFile) throws IOException {
        Strime strime = new Strime(newNameFile);
        Strime.cleanFile(strime.getNamefilePath( ));
    }

    public static void deleteFile(String patch) {
        File file = new File(patch);
        file.delete( );
    }

    public static boolean existingFile(String patch) {
        return new File(patch).isFile( );
    }



    public static boolean checkingStockAvailability(String nameFilePath, Good good) throws IOException {

        setStrime(new Strime(nameFilePath));
        String tmp = Strime.inputFiles(nameFilePath);
        if (tmp.equals("") | tmp.equals("\n")) {
            return false;
        }
        String[] result = reformatContents(tmp);
        for (int i = 0; i < result.length; i++) {
            if (result[i].equals(good.getName( ))) {
                return true;
            }

        }
        return false;
    }

    public static String[] reformatContents(String source) {
        String tmp = source;
        tmp = tmp.replace("\n", ",");
        tmp = tmp.trim( );
        String[] result = tmp.split(",");
        return result;
    }

}



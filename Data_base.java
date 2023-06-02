import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Data_base {

    final static int  SIZAOFSRING = 20;
    final static String  TEMP = "remove";

    static Scanner reader = new Scanner(System.in);


//------------------------------------------  Write file -----------------------------------------

    protected void  Write_file(RandomAccessFile rfile, String object,long seek) throws IOException
    {
        String str = fix_string(object);
        rfile.seek(seek);
        rfile.writeChars(str);

    }
//------------------------------------------  fix string -----------------------------------------

    private String fix_string(String object)
    {
        while(object.length() < SIZAOFSRING)
        {
            object += " ";
        }
        return object.substring(0,SIZAOFSRING);
    }
//------------------------------------------  read file -----------------------------------------

    protected  String read_file (RandomAccessFile rfile , long seek) throws IOException
    {
        String temp = "";
        rfile.seek(seek);
        for (long i = 0; i < (SIZAOFSRING); i++)
        {
            temp += rfile.readChar();
        }
        return temp.trim();
    }

    //------------------------------------------ system clear -----------------------------------------
    public void clear()
    {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

}

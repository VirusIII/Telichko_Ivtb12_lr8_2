import java.io.*;
public class IOFile{ //Функции ввода-вывода
   public static boolean outBooleanRAFile(File file, boolean[] arr, int pos) 
                                                                                    throws IOException {
   //Выводит числа boolean (4 байт каждое) из массива arr в файл file,
   //начиная с позиции pos в файле, возвращает true, 
   // если вывод закончился успешно
   RandomAccessFile OutpFile=null; 
   boolean f=true; //для возврата
     try { //контролируем исключения при выводе данных
        //открываем файл для чтения и записи:
        OutpFile= new RandomAccessFile(file,"rw");
        OutpFile.seek (pos); // устанавливаем указатель файла 
                                            // на заданную  позицию
        for (int i=0;i<arr.length;i++)
           OutpFile.writeBoolean(arr[i]); // выводим очередное число (8 байт)
     }
     catch (Exception e) {f=false;}
     finally{ if(OutpFile!=null) OutpFile.close();} //закрываем файл
     return f;
 }
 

public static boolean[][] inpBooleanMatrRAFile(File file, int m, int pos) 
                                                                                throws IOException {
   // Возвращает ссылку на матрицу с элементами double 
   // размером m x m, введенную  из файла file, начиная
   // с позиции pos; при ошибке ввода-вывода возвращает null
   RandomAccessFile inpFile = null; 
   long toRead; //счетчик байтов в файле
   boolean [ ][ ] matr=new boolean[m][m]; // создаем матрицу m x m
   try { //контролируем исключения при вводе данных
        //открываем файл для чтения:
        inpFile = new RandomAccessFile(file,"r");
        inpFile.seek (pos); //устанавливаем указатель файла в
                                         //заданную позицию
        toRead=inpFile.length()-pos+1; //число байтов в файле, начиная 
                                                              //с позиции pos
                                                              //System.out.println(inpFile.length()+" "+pos);
        //Вводим числа из файла в матрицу:
        M1:{for (int i=0; i<m; i++) // блок помечен меткой M1
             for (int j=0; j<m; j++){
                    matr[i][j]=inpFile.readBoolean(); //введено очередное число
                    toRead-=4; // уменьшаем число оставшихся байт на 4
                    if (toRead<=0) break M1; //если данные в файле закончились,
                    //переход на конец блока, отмеченного меткой M1
             }
        } //Конец блока, отмеченного меткой M1    
    } //try
    catch (Exception e) {matr=null;} //если исключение, вернем null
    finally{ if(inpFile!=null) inpFile.close();} // закрываем файл
    return matr; //возвращаем ссылку на матрицу или null
  }
  public static boolean[ ] inpBooleanArrRAFile(File file) throws IOException {
     //Вводит все данные из файла в одномерный boolean-массив,
     //возвращает ссылку на массив или null (если было исключение)
     //Число байтов в файле должно быть кратно 4, 
     //иначе метод вернет null (объясните, почему)  
     RandomAccessFile inpFile = null; 
     long toRead; // счетчик байтов в файле
     boolean [ ]arr=null;
     try {inpFile= new RandomAccessFile(file,"r");
        toRead=inpFile.length(); //длина файла в байтах
        arr=new boolean[(int)toRead/4]; // создаем boolean-массив 
        int i=0;
        while (toRead>0){ //пока в файле есть числа
            arr[i]=inpFile.readBoolean(); //прочли очередное число (4 байт)
            i=i+1;
            toRead-=4; // уменьшаем число оставшихся байт на 4

        }    
    }
    catch (Exception e) {arr=null;} //если исключение, вернем null
    finally{ if(inpFile!=null) inpFile.close();}// закрываем файл
    return arr; //возвращаем ссылку на массив или null

  }
} // IOFile

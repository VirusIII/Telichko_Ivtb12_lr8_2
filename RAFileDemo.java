import java.io.*;
import java.util.Random;
public class RAFileDemo{
  public static void main (String args[]) {
      int n=7, m=5; String t="boolean"; //9 матриц 3 x 3, тип boolean
      File f1=new File("Matr/matr_"+n+"_"+m+"_"+t+".bin"); //файл
      System.out.println ("В файл выводятся "+n+" матриц "+m+"x"+m+
                    " c элементами типа "+t);
      //Формирование элементов матриц 
      Random r = new Random(); //генератор псевдо-случайных чисел
      boolean [ ] arr = new boolean[n*m*m]; //всего чисел для вывода в файл
      for (int i=0; i<arr.length; i++)
           arr[i]=r.nextBoolean(); //получаем очередное число
           //MatrProc.putArr(arr,m*m); //выводим массив arr в окно терминала
      try{
        //-------------------вывод--------------------------------------------------------------------
        IOFile.outBooleanRAFile(f1,arr,0);
        //----------------ввод всего файла и контроль-----------------------------------
        //очистка arr:
        for (int i=0; i<arr.length; i++) arr[i]=false;
        //ввод в одномерный массив всех чисел из файла
        System.out.println ("Содержимое файла "+f1.getName()+
                            ", интерпретированное как boolean-значения:"); 
        arr =IOFile.inpBooleanArrRAFile(f1);
        System.out.println(arr);
        MatrProc.putArr(arr,m*m); //выводим массив arr в окно терминала
        //--------ввод из файла третьей и седьмой матрицы--------------------
        boolean[ ][ ] matr1=IOFile.inpBooleanMatrRAFile(f1,m,m*m*(4-1));
        System.out.println ("Введена матрица номер 4:");
        MatrProc.putMatr(matr1); //выводим матрицу в окно терминала
        boolean[ ][ ] matr2=IOFile.inpBooleanMatrRAFile(f1,m,m*m*(6-1));
        System.out.println ("Введена матрица номер 6:");
        MatrProc.putMatr(matr2); //выводим матрицу в окно терминала
        //вычисление суммы матриц
        matr1=MatrProc.sumTwoMatr(matr1,matr2);
        System.out.println ("Сумма матриц:");
        MatrProc.putMatr(matr1);
        //--------------Вывод результирующей матрицы в файл------------------- 
        //-------------------------на место третьей матрицы-----------------------------
        boolean[ ] arr1=MatrProc.matrToArr(matr1); //преобразуем матрицу
                                                                                  // в массив
        System.out.println ("После преобразования матрицы в массив:");
        MatrProc.putArr(arr1,m*m); //выводим на терминал
        IOFile.outBooleanRAFile(f1,arr1,m*m*8*(3-1)); //выводим в файл
        //----------------ввод всего файла и контроль------------------------------------
        //очистка arr:
        for (int i=0; i<arr.length; i++) arr[i]=false;
        //ввод в одномерный массив всех чисел из файла
        System.out.println ("Новое содержимое файла "+f1.getName()+
                            ", интерпретированное как boolean-значения:"); 
        arr=IOFile.inpBooleanArrRAFile(f1); 
        MatrProc.putArr(arr,m*m); //вывод на терминал
    } catch (Exception e) {} finally{}
 } //main 
      } // RAFileDemo 

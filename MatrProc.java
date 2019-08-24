public class MatrProc{ //Работа с матрицами и массивами
 //Содержит статические методы для работы с матрицами 
 //и одномерными массивами
   public static void putMatr (boolean [ ][ ]matr){
   //выводит матрицу matr в окно терминала    
      if (matr==null) return;
      for (int i=0; i<matr.length; i++) {
         for (int j=0; j<matr[0].length; j++)
             System.out.printf (matr[i][j]+"  ");
         System.out.println();
      } //for i 
   } //putMatr 
   public static void putArr (boolean X[ ], int n){
   //выводит массив X в окно терминала по n элементов в строке
         if (X==null) return;
         for (int i=0; i<X.length; i++){
            if ((i!=0)&&(i%n==0)) System.out.println();  
            System.out.printf (X[i]+"  ");
         }   
         System.out.println();  
   } //putArr 
   public static boolean[ ] matrToArr (boolean matr[ ][ ]){
   //преобразует матрицу в одномерный массив:
   //данные первой строки, за ними данные второй строки и т.д.
        boolean[] arr=new boolean[matr.length*matr[0].length];
        int k=0;
        for (int i=0; i<matr.length; i++)
          for (int j=0; j<matr[0].length; j++){
              arr[k]=matr[i][j];
              k=k+1;
          }
         return arr;
   }       
   public static double sumElMatr(double[][] matr){
   //вычисляет сумму элементов матрицы    
      if (matr==null) return 0;
      int sum=0;
      for (int i=0; i<matr.length; i++) 
         for (int j=0; j<matr[0].length; j++) 
              sum+=matr[i][j];
      return sum;
  }  
  public static boolean[ ][ ] sumTwoMatr(boolean[ ][ ] m1, boolean [ ][ ] m2){
  //возвращает матрицу, являющуюся  суммой двух матриц 
  //m1 и m2, или null, если у матриц m1 и m2 разная размерность  
      if ((m1==null)||(m2==null)||(m1.length!=m2.length)||
          (m1[0].length!=m2[0].length)) return null;
     boolean [ ][ ]m=new boolean[m1.length][m1[0].length];   
      for (int i=0; i<m.length; i++) 
         for (int j=0; j<m[0].length; j++) 
              m[i][j]=m1[i][j]&&m2[i][j];
      return m;
   }    
} // MatrProc

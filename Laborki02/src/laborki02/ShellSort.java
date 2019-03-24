/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki02;

/**
 *
 * @author Lenovo
 */
class ShellSort {
    int tablica[];
    int przestawiam = 0;
    public ShellSort(int _tablica[])
    {
        tablica = _tablica;
    }
    
    // Wyznaczamy wartość początkowego przesunięcia
public void shellsort()
{
   int h,i,j,x;
   int N = tablica.length;
  for(h = 1; h < N; h = 3 * h + 1);
  h /= 9;

// start sortowania

  while(h>0)
  {
    for(j = N - h - 1; j >= 0; j--)
    {
      x = tablica[j];
      i = j + h;
      while((i < N) && (x > tablica[i]))
      {
        tablica[i - h] = tablica[i];
        
        i += h;
      }
      tablica[i - h] = x; 
      przestawiam++;
    }
    h /= 3;
  }
}
    public void get() // wyświetl tablice
    {
        System.out.println("");
        System.out.println("Tablica po posortowaniu:");
        for(int i=0; i<tablica.length; i++)
        System.out.print(tablica[i]+" "); 
        System.out.println("");
        System.out.println("Przestawienia " + przestawiam);
    }
}

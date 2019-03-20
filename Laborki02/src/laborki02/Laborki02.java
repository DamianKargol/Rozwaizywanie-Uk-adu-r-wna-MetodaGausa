/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki02;

import java.util.Random;
import static laborki02.MergeSort.N;
import static laborki02.MergeSort.mergesort;
import static laborki02.MergeSort.tab;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author Lenovo
 */
public class Laborki02 {



/**
* @param args
*/
public static void main(String[] args) {
int i;
System.out.println("Zbior przed sortowaniem:");
for (i=0; i<N; i++)
System.out.print(tab[i] + " ");
 
mergesort(0,N-1);
 
System.out.println("\nZbior po sortowaniu:");
for (i=0; i<N; i++)
System.out.print(tab[i] + " ");
    System.out.println("");

    System.out.println("");
    QuickSort quicksort = new QuickSort();
quicksort.quicksort(100,0, 99);
quicksort.get();
quicksort.save();
 
    MakeTab lista = new MakeTab();
lista.makeTab(100);
quicksort.quicksort(lista.tablica,0, lista.tablica.length -1);
//int y =1;
//int x=2;
//int temp = y;
//y = x;
//x = temp; 
//    System.out.println(x);
//    System.out.println(y);
}
 
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki02;

import java.io.FileNotFoundException;
import java.util.Random;
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
public static void main(String[] args) throws FileNotFoundException {
    System.out.println("");
    MakeTab lista = new MakeTab(100);
    MergeSort sort = new MergeSort(lista.tablica);
    sort.mergesort(0, lista.tablica.length - 1);
    lista.save();
    lista.reset();
    QuickSort quicksort = new QuickSort(lista.tablica);
    quicksort.quicksort(0, lista.tablica.length -1);
    quicksort.get();
    quicksort.save();
    quicksort.time();
   lista.reset();
   ShellSort shellsort = new ShellSort(lista.tablica);
   shellsort.shellsort();
   shellsort.get();
   lista.save();
   Wykres1 wykres = new Wykres1();
   wykres.Wykres1("QuickSort");
  
 
  



}
 
}
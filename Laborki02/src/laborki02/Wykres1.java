/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki02;

import java.awt.FileDialog;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Lenovo
 */
public class Wykres1 {
    
        public void Wykres1(String metoda) throws FileNotFoundException
                
    {
        
        
     
 
////        File plik = new File("Czas_QuickSort");
////        Scanner odczyt = new Scanner(plik);
//        ArrayList<Integer> tabTime = new ArrayList<Integer>();
//        
//        while (odczyt.hasNextInt()) // petla while bedzie sie wykonywac do konca pliku
//        {
//            
////            dane = odczyt.nextInt(); // zapisanie wiersza do zmiennej dane
////            tab[i] = dane;           /// zapisanie zmiennej danej do tablicy
////            i++;                     /// zmiana indeksu tablicy
//            tabTime.add(odczyt.nextInt());
//        }
//        
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        for(int i =1; i< tabTime.size(); i++)
//        dataset.setValue(tabTime.get(i), metoda, "czas");
//        
//        JFreeChart chart = ChartFactory.createBarChart3D( "Wykres typu Bar 3D",
//        "X - Lable", "Y - Lable", dataset, PlotOrientation.VERTICAL, true, true, false );
//        ChartFrame frame1=new ChartFrame("XYArea Chart",chart);
//        frame1.setVisible(true);
//        frame1.setSize(500,400);
    }
    public void Wykres1(int wartosci, String rodzaj, String nazwa )
    {
        
        
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        dataset.setValue(6, rodzaj, nazwa);
        
        JFreeChart chart = ChartFactory.createBarChart3D( "Wykres typu Bar 3D",
        "X - Lable", "Y - Lable", dataset, PlotOrientation.VERTICAL, true, true, false );
        ChartFrame frame1=new ChartFrame("XYArea Chart",chart);
        frame1.setVisible(true);
        frame1.setSize(500,400);
    }


  
    

}


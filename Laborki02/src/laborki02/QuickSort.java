/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laborki02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Random;


/**
 *
 * @author Lenovo
 */
public class QuickSort {

int przestawiam=0;
int przesuwam=0; 
int tablica[];

    public void quicksort(int n, int x, int y) { // przeciązenie metody wstępnej ktora tworzy nam tablicę 
    if(n<=1)
        System.out.println("Za mała tablica sproboj jeszcze raz");
        tablica = new int[n];
        Random random = new Random();
        for(int i = 0; i < tablica.length; i++)
        tablica[i] = (int) random.nextInt(1000000);
        System.out.println("Tablica przed posortowaniem:");
        for(int i=0; i<tablica.length; i++)
        System.out.print(tablica[i] +" ");
         File file = new File("Tablice.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst = ".\r\n" + "Tablica o dlugości =  " + n + ".\r\n"
                            + "tablica przed posortowaniem " + ".\r\n";
                    zapis.write(tekst);
                    String tekst1 = "";
                    for(int i=0; i<tablica.length; i++)
                    {
                    tekst1 = " " + tablica[i];
                    zapis.write(tekst1);
                    }
                    String tekst2;
                    tekst2 = ".\r\n";
//                        String wynik1 = "Wyniki z przebiegu doświadczenia.\r\n" + wynik + ".\r\n";
                    
                  
                    zapis.write(tekst2);
                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
    int i,j,v,temp;

    i=x;
    j=y;
    v=tablica[(x+y) / 2];
    do {
    while (tablica[i]<v)
    {
        i++;
        this.przesuwam ++;
    }
    while (v<tablica[j])
    {
    j--;
    this.przesuwam++;
    }
    if (i<=j) {
    temp=tablica[i];
    tablica[i]=tablica[j];
    tablica[j]=temp;
    this.przestawiam++;
    i++;
    j--;
    }
    }
    while (i<=j);
    if (x<j)
    quicksort(tablica,x,j);
    if (i<y)
    quicksort(tablica,i,y);
    }
    
    public void quicksort(int tablica[], int x, int y) { // metoda głowna która wykona sie w przypadku rekurencji 
    if(tablica.length<=1)
            System.out.println("Za mała tablica sproboj jeszcze raz");
    int i,j,v,temp;

    i=x;
    j=y;
    v=tablica[(x+y) / 2];
    do {
    while (tablica[i]<v)
    {
        i++;
        this.przesuwam ++;
    }
    while (v<tablica[j])
    {
    j--;
    this.przesuwam++;
    }
    if (i<=j) {
    temp=tablica[i];
    tablica[i]=tablica[j];
    tablica[j]=temp;
    this.przestawiam++;
    i++;
    j--;
    }
    }
    while (i<=j);
    if (x<j)
    quicksort(tablica,x,j);
    if (i<y)
    quicksort(tablica,i,y);
    }

    public void get() // wyświetl tablice
    {
        System.out.println("");
        System.out.println("Tablica po posortowaniu:");
        for(int i=0; i<tablica.length; i++)
        System.out.print(tablica[i]+" "); 
        System.out.println("");
    }
    public void save()
    {
        int suma = przesuwam + przestawiam;
           File file = new File("Tablice.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst ="tablica po posortowaniu " + "przesunieć = " + przesuwam +  " " +"Przestawień = " + przestawiam + " " + "Suma = " + suma + ".\r\n";
                    zapis.write(tekst);
                    String tekst1 = "";
                    for(int i=0; i<tablica.length; i++)
                    {
                    tekst1 = " " + tablica[i];
                    zapis.write(tekst1);
                    }
                    String tekst2;
                    tekst2 = ".\r\n";
//                        String wynik1 = "Wyniki z przebiegu doświadczenia.\r\n" + wynik + ".\r\n";
                    
                  
                    zapis.write(tekst2);
                    zapis.close();

            } catch (IOException e) {
                    e.printStackTrace();
            }
    }
    }

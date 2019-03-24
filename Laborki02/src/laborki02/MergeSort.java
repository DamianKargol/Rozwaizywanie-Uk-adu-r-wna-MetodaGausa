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

/**
 *
 * @author Lenovo
 */
public class MergeSort {
        

int  tab[];
int t[];
 // Tablica pomocnicza
public MergeSort()
{
    
}
 public MergeSort(int _tablica[])
    {
            tab = _tablica;
            t = new int[_tablica.length];
    }
 
/* Scalanie dwoch posortowanych ciagow
tab[pocz...sr] i tab[sr+1...kon] i
wynik zapisuje w tab[pocz...kon] */
public void merge(int pocz, int sr, int kon)
{
int i,j,q;
for (i=pocz; i<=kon; i++) t[i]=tab[i];  // Skopiowanie danych do tablicy pomocniczej
i=pocz; j=sr+1; q=pocz;                 // Ustawienie wskaźników tablic
while (i<=sr && j<=kon) {         // Przenoszenie danych z sortowaniem ze zbiorów pomocniczych do tablicy głównej
if (t[i]<t[j])
tab[q++]=t[i++];
else
tab[q++]=t[j++];
}
while (i<=sr) tab[q++]=t[i++]; // Przeniesienie nie skopiowanych danych ze zbioru pierwszego w przypadku, gdy drugi zbiór się skończył
}
 /* Procedura sortowania tab[pocz...kon] */
public void mergesort(int pocz, int kon)
{
int sr;
if (pocz<kon) {
sr=(pocz+kon)/2;
mergesort(pocz, sr);    // Dzielenie lewej części
mergesort(sr+1, kon);   // Dzielenie prawej części
merge(pocz, sr, kon);   // Łączenie części lewej i prawej
}
}  
    public void get() // wyświetl tablice
    {
        System.out.println("");
        System.out.println("Tablica po posortowaniu:");
        for(int i=0; i<tab.length; i++)
        System.out.print(tab[i]+" "); 
        System.out.println("");
    }
    public void save()
    {
        
           File file = new File("Tablice.txt");
         
            try {
                    Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), "UTF8"));
                    PrintWriter zapis = new PrintWriter(out);

                    String tekst ="tablica po posortowaniu MergeSort " + ".\r\n";
                    zapis.write(tekst);
                    String tekst1 = "";
                    for(int i=0; i<tab.length; i++)
                    {
                    tekst1 = " " + tab[i];
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

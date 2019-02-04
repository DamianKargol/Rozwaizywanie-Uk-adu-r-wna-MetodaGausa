/* 
 *Program przygotowany przez Damian Kargol
 *Program ten oblicza uklad rownań linoiwych, i pokazuje rozkład LU
 *W razie napotkania 0 na przękotnej skaluje wybór wiersza głownego na opowiedni i podaje wielomian do rozwiazania
 */
import java.io.IOException;
 
public class ElimGausa {
 
public static void main(String[] args) throws IOException {
 
//rozmiar tablicy

 
//macierz do rozwiazania A
double macierz [][] = 
{{0, 1, -1,0},
{1, 1, 2,0},
{2, -1, 1,1},
{1, 1, 1,1}};

//wektor w wynikami
double wynik [] = {1, 0, 0,0};
//{1, 2, 3, 1}};
 
//macierz wynikowa w ktorej będziemy przechowywac tymczasowe elementy macierzy głownej
double macWyn [][] = new double [macierz.length][macierz.length];
 
//kopiuj macierz do rozwiazania do macierzy wynikowej
for (int i = 0; i<macierz.length; i++)
for (int j = 0; j<macierz.length; j++)
macWyn[i][j]=macierz[i][j];
 
//wektor w wynikami
//kopiuj wektor z wynikami do wyktora ktora przechowywuje tymczasowe wyniki
double wCopy [] = new double [wynik.length];
for (int i=0; i<wynik.length; i++){
wCopy[i]=wynik[i];
}
 if(macierz[0][0] == 0)
 {
     System.out.println("Podano 0 w puknice [0][0] Metoda Gaussa zawiodłąby do tak napisanej macierzy");
     System.out.println("Nastąpiła zamiana wierszy");
 }
        
 
// Pętla zmieniająca wiersze gdy 0 wystapuje w punkcie [0][0] 
while(macierz[0][0] == 0)
{
for (int i = 0; i<macierz.length-1; i++){
            wynik[i] = wCopy[i+1];
        wynik[i+1] = wCopy[i];
    
for (int j = 0; j<macierz.length; j++){
 
        macierz[i][j] = macWyn[i+1][j];
        macierz[i+1][j] = macWyn[i][j];


        for (int ii = 0; ii<macWyn.length; ii++){
for (int jj = 0; jj<macWyn.length; jj++){
macWyn[ii][jj] = macierz[ii][jj]; 
 
}
        wCopy[ii]=wynik[ii];
        }}}}

//wyswietl  macierz do rozwiazania
System.out.println("Macierz do rozwiązania A");
for (int j = 0; j<macierz.length; j++){    
for (int k=0; k<macierz.length; k++){
System.out.print(macierz[j][k]+"\t");
}
System.out.println("\t |"+wynik[j]);
}
System.out.println("");
 //##############################################
 // Macierz U rozpoęczie i implementacja
 //##############################################
double u[][] = new double [macierz.length][macierz.length];
// Wypełnij U jedynkami po Przękątnej
for (int i = 0; i<macierz.length; i++)
{

    for (int j = 0; j<macierz.length; j++)
    {
        if(i ==j)
            u[i][j] = 1;
    }
}


//###############################
//   Metoda Eliminacji Gaussa
//###############################

for (int i = 0; i<macierz.length-1; i++){
for (int j = i+1; j<=macierz.length-1; j++){
for (int k = 0; k<macierz.length; k++)
{
    u[j][i]= macierz[j][i]/macierz[i][i];
    macWyn[j][k]=macierz[j][k]-(macierz[i][k]*(macierz[j][i]/macierz[i][i]));
}

wCopy[j]=wynik[j]-(wynik[i]*(macierz[j][i]/macierz[i][i]));               

for (int ii = 0; ii<macWyn.length; ii++){
for (int jj = 0; jj<macWyn.length; jj++){
macierz[ii][jj]=macWyn[ii][jj]; 
 
}
wynik[ii]=wCopy[ii];
}               
}           
}


////Wypisanie wyniku = macierzy U  
System.out.println("");       
System.out.println("Macierz U");
for (int j = 0; j<macierz.length; j++){    
for (int k=0; k<macierz.length; k++){
System.out.print(macierz[j][k]+"\t");
}
System.out.println("\t"+wynik[j]);
}
  
// Wypisanie macierzy L 
//wyswietl  macierz do rozwiazania
System.out.println("");
System.out.println("Macierz L");
for (int j = 0; j<macierz.length; j++){    
for (int k=0; k<macierz.length; k++){
System.out.print(u[j][k]+"\t");
}
System.out.println("");
}

  double s ;
  int j;
    /// Pętla obliczająca rozwiażania macierzy
  for(int i = macierz.length -1; i >= 0; i--)
  {
      if(i == macierz.length -1)
          s = 0;
          
    s = wynik[i];
    
    for(j = macierz.length - 1; j >= i + 1; j--)
      s -= macierz[i][j] * wynik[j];
    wynik[i] = s / macierz[i][i];
   
  }
  /// wypisanie wyników 
    System.out.println("");
    System.out.println("Wyniki");
  for(int i =wynik.length - 1; i>=0; i--)
        System.out.println("x" + (i+1) + "= " + wynik[i]);

}
}
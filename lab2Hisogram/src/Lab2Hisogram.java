import static com.sun.javafx.geom.Curve.next;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.sort;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import static org.apache.commons.math3.stat.inference.TestUtils.kolmogorovSmirnovTest;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.statistics.SimpleHistogramBin;
import org.jfree.data.statistics.SimpleHistogramDataset;
// statystyka na recepte 
/**
 * 
 * Przypuszczalny rozkład 
 * uzupełnienie braku danych
 * statystyka analiza danych z wykorzystaniem R redakcja naukowa marek walesiak eugeniusz gantar 
 */
public class Lab2Hisogram extends JFrame implements ActionListener {
    private static int c =0;
    private static int n;
    private static double odchylenie, srednia;
    private SimpleHistogramDataset dataset;
    
    public Lab2Hisogram(String title) {
         
        super(title);
        
      
//        Random x = new Random();
        Scanner odczyt = new Scanner(System.in);
        System.out.println("Podaj odchylenie od wartości średniej");
        odchylenie = odczyt.nextDouble();
        System.out.println("Podaj wartość średnią");
        srednia = odczyt.nextDouble();
        System.out.println("Podaj wielkość 1 wektora");
        n = odczyt.nextInt();
        
        
        double tabGausa[] =  new double[n];
        for(int i = 0; i<tabGausa.length; i++)
        {
            tabGausa[i] = nextGaussian(odchylenie,srednia);
//              tabGausa[i] = nextGaussian(10.0, 10.0);
        }
            sort(tabGausa);
            statystyki(tabGausa);
            
            System.out.println("Dominanta = " + dominanta(tabGausa));
            System.out.println("Mediana = " + mediana(tabGausa));
        
        // create the dataset with appropriate bins and some initial data
        this.dataset = new SimpleHistogramDataset("Wykres");
        
        
        for(double i = StatUtils.min(tabGausa) -5; i<=StatUtils.max(tabGausa) +5; i = i +0.1)
            
        {
            dataset.addBin(new SimpleHistogramBin(i,i+0.1 , true, false));
        }
       
//        dataset.addBin(new SimpleHistogramBin((int)StatUtils.max(tabGausa), (int)StatUtils.max(tabGausa) +1 , true, false));
//        dataset.addBin(new SimpleHistogramBin(-0.5, 0.5, true, false));
//        dataset.addBin(new SimpleHistogramBin(0.5, 1.5, true, false));
//        dataset.addBin(new SimpleHistogramBin(1.5, 3.5, true, false));
//        dataset.addBin(new SimpleHistogramBin(StatUtils.max(tabGausa),StatUtils.max(tabGausa) +1 , true, false));
            dataset.addObservations(tabGausa);
//       
        // create the chart with integer axis labels
        JFreeChart chart = ChartFactory.createHistogram(" Histogram liczby pseudolosowe z rozkładu Gaussa", 
                "Przedziały", "Liczba wystąpieńt", dataset, PlotOrientation.VERTICAL, 
                false, false, false);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.setDomainZeroBaselineVisible(false);
        plot.getDomainAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        plot.getRangeAxis().setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        
        // set up the UI
        ChartPanel panel = new ChartPanel(chart);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel);
        JButton button = new JButton("Dodaj wektor 50 liczb z rozkładem double z odchyleniem 1 i srednia 0");
        button.addActionListener(this);
        getContentPane().add(button, BorderLayout.SOUTH);
         Random x = new Random();
//        Scanner odczyt = new Scanner(System.in);
//        System.out.println("Podaj odchylenie od wartości średniej");
//        odchylenie = odczyt.nextDouble();
//        System.out.println("Podaj wartość średnią");
//        double srednia = odczyt.nextDouble();
//        System.out.println("Podaj wielkość 1 wektora");
////        double n = odczyt.nextInt();
        
        
// ##########################################################
// ######          kolmogorovSmirnovTest
//###########################################################
//                   double tabGausa[] =  new double[1000];
//        for(int i = 0; i<tabGausa.length; i++)
//        {
//            tabGausa[i] = nextGaussian(odchylenie,srednia);
////              tabGausa[i] = nextGaussian(10.0, 10.0);
//        } 
        double p =1;
        int zlicza = 1;
        while(p>0.05)
        {
                     List rMieszany = new ArrayList();
            for(int i = 0; i<n; i++)
            {
                rMieszany.add(nextGaussian(odchylenie,srednia));
            } 
            for(int i = 0; i<zlicza; i++)
            {
                rMieszany.add(x.nextDouble()*odchylenie + srednia);
            } 
            double tabMieszana[] = new double [rMieszany.size()];
            for(int i = 0; i< tabMieszana.length; i++)
            {
                tabMieszana[i] = (double) rMieszany.get(i);
            }
            p = kolmogorovSmirnovTest( tabGausa, tabMieszana);
            
            System.out.println("p = " + p);
            System.out.println("mtabMieszana rozmiar" + tabMieszana.length);
            if(p<0.05)
                break;
            zlicza++;
        }
        System.out.println("");
        System.out.println("RAPORT");
        System.out.println("Dla wektora z rozkladu Gaussa o sredniej = " + srednia + " i odchyleniu = " +odchylenie);
        System.out.println("Test Kolmogorova Smirnova wykazał"); 
        System.out.println("Zaburzenie rozkladu po dodaniu " + zlicza + "  liczb z rozkladu nextDouble");
        System.out.println("Dodanie " + (zlicza - 1) +" nie zaburzyło rozkladu");
        System.out.println("Koniec raportu");
        System.out.println("");
        // koniec testu 
        //##################################################################
    }
    
    @Override
    
    public void actionPerformed(ActionEvent e) {
        // add a random observation in the range 0 to 3
        Random x = new Random();
        
        
        
        for(int i = 0; i<50; i++)
        {
        this.dataset.addObservation( x.nextDouble() * odchylenie + srednia );
    
        }
        c += 50;
        System.out.println("Dodałeś " + c + " liczb z rozkładu double");
    }

    
      public double nextDouble() {
   return (((long)next(26) << 27) + next(27))
     / (double)(1L << 53);
 }
           private double nextNextGaussian;
 private boolean haveNextNextGaussian = false;
     public double nextGaussian() {
   if (haveNextNextGaussian) {
     haveNextNextGaussian = false;
     return nextNextGaussian;
   } else {
     double v1, v2, s;
     do {
       v1 = 2 * nextDouble() - 1;   // between -1.0 and 1.0
       v2 = 2 * nextDouble() - 1;   // between -1.0 and 1.0
       s = v1 * v1 + v2 * v2;
     } while (s >= 1 || s == 0);
     double multiplier = StrictMath.sqrt(-2 * StrictMath.log(s)/s);
     nextNextGaussian = v2 * multiplier;
     haveNextNextGaussian = true;
     return v1 * multiplier;
   }
 }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Lab2Hisogram demo = new Lab2Hisogram(
                        "HISTOGRAM");
                demo.pack();
                demo.setVisible(true);
                demo.setSize(800,800);
                demo.setDefaultCloseOperation(3);
            }
            
        }
        );
       
    }
    
                public static double nextGaussian(double odchylenie, double srednia){
            Random random = new Random();
            return random.nextGaussian() * odchylenie + srednia;
    }
                        private void statystyki(double tabGausa[])
        {
                    DescriptiveStatistics stats = new DescriptiveStatistics();
        for (int i = 0; i < tabGausa.length; i++) 
           {
                   stats.addValue(tabGausa[i]);
           }
        
        System.out.println("Średnia: "+stats.getMean());
        System.out.println("W. najwięsza: "+stats.getMax());
        System.out.println("W. najmniejsza: "+stats.getMin());
        System.out.println("Odch. standardowe: "+stats.getStandardDeviation());
        System.out.println("Suma: "+stats.getSum());
        System.out.println("Wariancja: "+stats.getVariance());
        }
                        
         private static double podajSumeLiczb(double[] liczby) {

        double sum = 0;

        for (double l : liczby) {

            sum=sum+l;

        }

        return sum;

    }

    
     private static double podajSredniaArytmetyczna(double[] liczby) {

        double srednia = podajSumeLiczb(liczby)/liczby.length;

        return srednia;

    }
     
          //##########################################################
     // funkcja licząca WARIANCJE
     //#####################################################
    private static double podajWariancje(double[] liczby) {

        double wariancja;

        double srednia = podajSredniaArytmetyczna(liczby);

        double sum=0.0;

        for (double x : liczby) {

            sum=sum+(x-srednia)*(x-srednia);

        }

        wariancja = sum/(liczby.length-1);

        return wariancja;
    }
     
             private static double dominanta(double[] liczby) {
		double dominanta = 0;
		int maks = 0;
		int licznik = 0;
 
		for (int i = 0; i < liczby.length; i++) {
			licznik = 0;
			for (int k = 0; k < liczby.length; k++) {
				if (liczby[i] == liczby[k]) {
					licznik++;
					if (licznik > maks) {
						dominanta = liczby[i];
						maks = licznik;
					}
				}
 
			}
		}
		return dominanta;
	}  
             
                         private static double mediana(double [] liczby) {
		double mediana = 0;
		Arrays.sort(liczby);
		if (liczby.length % 2 == 0) {
			mediana = (liczby[liczby.length / 2] + liczby[(liczby.length / 2) + 1]) / 2.0;
		} else {
			mediana = liczby[liczby.length / 2];
		}
 
		return mediana;
	}                     
}

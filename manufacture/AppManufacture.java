package cz.vsb.fei.manufacture;

public class AppManufacture {

    /**
     - Vytvořte výčtový typ (enumeration) Operation s konstantami: CUTTING -
     - "Řezání", délka trvání 2 minuty, SANDING - "Broušení", délka 20min, PAINTING
     - "Natírání" délka 30min), DRILLING - "Vrtání" délka 5)
     -
     - Každá konstanda bude mít proměnnou name (český název) a duration (délka
     - výrobní operace v minutách) a také metody getName a getDuration.
     -
     - Dále vytvořte třídu ManufacturingProcess, která bude mít proměnné:
     -
     - productName - typu String
     -
     - operations - list operací (Operation)
     -
     - Třída ManufacturingProcess bude mít také:
     -
     - překrytou metodu toString
     -
     - Konstruktor s parametrem productName a proměnným počtem parametrů typu Operation.
     -
     - @param args
     */
    public static void mainApp(String[] args) {
        createManufacturingProcess();
        calculateCircleArea(10);
    }

    /**
     - Metoda vytvoří a vrátí objekt třídy ManufacturingProcess, který obsahuje
     - alesppoň dvě výrobní operace
     -
     - @return new object of type ManufacturingProcess
     */
    public static Object createManufacturingProcess() {
        return  new ManufacturingProcess("Stul", Operation.CUTTING, Operation.DRILLING);

    }

    /**
     - Metoda spočítá poloměr kruhu π*r²
     -
     - Použijte konstantu π definovanou v jazyce Java
     -
     - @param r - poloměr kruhu.
     - @return obsah kruhu s daným poloměrem
     */
    public static double calculateCircleArea(double r) {
        return Math.PI*r*r;
    }
}
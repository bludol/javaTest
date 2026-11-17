package cz.vsb.fei.batteries;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class AppBattery {

    public static void mainApp(String[] args) {

        List<Battery> batteries = generateBatteries(10);
        sortByPrice(batteries);
        Battery.print(batteries);
        sortByTypeAndCapacity(batteries);
        Battery.print(batteries);
        logDischargedBatteries();
        logShopPriceBatteries();
        uniqueHeapForStrings(new String[] { "a", "a", "b", "a", "c", "d", "d", "a" });
        uniqueHeapForInt(new int[] { 1, 2, 1, 1, 3, 3, 2, 1, 2, 4 });

    }

    /**
     - Metoda vytvoří kolekci a do ní vygeneruje zadaný počet baterií (Battery)
     -
     - Vytvořte statickou třídní proměnnou třídy AppBatteries ve které, bude uložena
     - instance náhodného generátoru čísel.
     -
     - @param count - počet baterií, které se mají vygenerovat do kolekce
     - @return vytvořená kolekce baterií.
     */
    static Random r= new Random();
    public static List<Battery> generateBatteries(int count) {
        List<Battery> batteries = new ArrayList<>();
        for(int i= 0; i < count; i++){
            batteries.add(new Battery(Battery.types.get(Math.abs(r.nextInt())%6), Math.abs(r.nextInt())%101, Math.abs(r.nextInt()) ));
        }
        return batteries;
    }

    /**
     - Metoda setřídí kolekci baterií podle ceny od nejlevnější po nejdražší.
     - Využijte k setřídění lambda výraz nebo refrenci na metodu (method referenc)
     -
     - @param batteries - kolekce batterií k setřídění
     */
    public static void sortByPrice(List<Battery> batteries) {
        batteries.sort(
                (b1,b2) -> Double.compare(b1.getPrice(), b2.getPrice())
        );
    }

    /**
     - Metoda setřídí kolekci baterií podle typu (abecedně od A po Z) a pokud je typ
     - stejný tak podle počáteční kapacity (initialCapacity) od nejnižší po
     - nejvyšší. Využijte k setřídění lambda výraz nebo refrenci na metodu (method
     - referenc)
     -
     - @param batteries - kolekce batterií k setřídění
     */
    public static void sortByTypeAndCapacity(List<Battery> batteries) {
        batteries.sort(Comparator.comparing(Battery::getType).thenComparingInt(Battery::getInitialCapacity));
    }

    /**
     - Ve třídě AppBattery vytvořte vnořenou pojmenovanou třídu DischargeEvaluator,
     - která implementuje rozhraní BatteryShop.BatteryEvaluator.
     -
     -
     - Vytvořte instanci třídy BatteryShop a pomocí její metody iterateBatteries a
     - instance třídy DischargeEvaluator:
     -
     - vypište do souboru discharged.txt a do konzole typ, počáteční kapacitu
     - (initialCapacity) a aktuální kapacitu (actualCapacity) pro baterie, jejichž
     - aktuální kapacita je nižší než polovina výchozí kapacity. Pokud metoda
     - proběhne úspěšně vrací TRUE, pokud dojde při zápisu do souboru k výjimce,
     - metoda vypíše messge vyjímky do konzole a vrátí FALSE
     -
     - Metoda log se zavolá jen pro baterie, pro které metoda check vrátí true.
     */

    public static class DischargeEvaluator implements BatteryShop.BatteryEvaluator{

        private  List<String> lines = new ArrayList<>();
        @Override
        public void log(Battery battery) {
            String text = battery.getType() + " " + battery.getInitialCapacity() + " " + battery.getActualCapacity();
            System.out.println(text);
            lines.add(text);
        }

        @Override
        public boolean check(Battery battery) {
            return battery.getActualCapacity() < (battery.getInitialCapacity() /2.0);
        }
    }
    public static boolean logDischargedBatteries()  {
        BatteryShop shop = new BatteryShop();
        DischargeEvaluator evaluator = new DischargeEvaluator();

        shop.iterateBatteries(evaluator);

        try{
            Files.write(Path.of("discharged.txt"), evaluator.lines);
            return true;
        } catch (IOException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     - Vytvořte instanci třídy BatteryShop a pomocí její metody iterateBatteries a
     - vnořené anonymní třídy, která implementuje rozhraní
     - BatteryShop.BatteryEvaluator, vypište pro všechny baterie jejich cenu.
     -
     - Metoda log se zavolá jen pro baterie, pro které metoda check vrátí true.
     - Metoda check musí tedy v tomto případě vždy vracet true.
     */
    public static void logShopPriceBatteries() {
        BatteryShop batteryShop = new BatteryShop();
        batteryShop.iterateBatteries(new BatteryShop.BatteryEvaluator() {
            @Override
            public void log(Battery battery) {
                System.out.println(battery.getPrice());
            }

            @Override
            public boolean check(Battery battery) {
                return true;
            }
        });

    }

    /**
     - Vytvořte generickou třídu UniqueHeap, která budemít instanční proměnnou typu
     - množina a instanční proměnnou počítadlo (count).
     -
     - Třída bude mít:
     -
     - metodu add, pro přidání elementu do množiny. Metoda bude počíta počet volání
     - metody add.
     -
     - metodu getCount, která vrátí hodnotu počítadla
     -
     - metodu grabAll, která vrátí množinu unikátních vložených prvků a zároveň ve
     - třídě UniqueHeap, vymaže množinu a počítadlo nastaví na nulu.
     -
     - @param words- slova pro vložení do UniqueHeap
     - @return objekt typu UniqueHeap
     */



    public static Object uniqueHeapForStrings(String[] words) {
        UniqueHeap<String> uniqueHeap = new UniqueHeap<>();
        for (String word : words){
            uniqueHeap.add(word);
        }
        return uniqueHeap;
    }

    /**
     - Stejnou generickou třídu UniqueHeap, popsanou u předchozí metody, použijte
     - pro uložeí celých čísel.
     -
     - @param numbers - čísla pro vložení do UniqueHeap
     - @return objekt tzpu UniqueHeap
     */
    public static Object uniqueHeapForInt(int[] numbers) {
        UniqueHeap<Integer> uniqueHeap = new UniqueHeap<>();
        for (int number : numbers){
            uniqueHeap.add(number);
        }
        return uniqueHeap;
    }

}
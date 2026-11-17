package cz.vsb.fei.geom3d;

import java.util.LinkedList;
import java.util.List;

public class AppGeom3D {





    /**
     - Vytvořte rozhraní Body3D (3D těleso) s metodou getVolume, která vrací double
     -
     -
     - Vytvořte třídu Sphere, která implementuje rozhraní Body3D a má jako instanční
     - proměnnou poloměr r typu double. Má kostruktor s jedním parametrem a
     - implementuje potřebné metody. Objem koule se spočítá 4/3*π*r³
     -
     *
     - Vytvořte rozhraní BodyWithBase (těleso s podstavou), které je potomkem
     - prozhraní Body3D. Navíc má metody:
     -
     - double getHeight() - vrací výšku tělesa
     -
     - double getSurfaceOfBase() - vrací obsah podstavy
     -
     - double getVolume() - která vrací objem tělesa a má defaultní impemntaci,
     - která vynásobí výšku a obje podstavy.
     -
     *
     - Vytvořte třídu Cylinder (válec), která implementuje rozhraní BodyWithBase a
     - má jako instanční proměnnou poloměr r a height (výšku) obojí typu double. Má
     - kostruktor s dvěmi parametry a implementuje potřebné metody. Objem kruhu se
     - spočá π*r²
     -
     -
     - Vytvořte třídu Block (kvádr), která implementuje rozhraní BodyWithBase a má
     - jako instanční proměnnou poloměr width (šířku), depth (hloubku) a height
     - (výšku) vše typu double. Má kostruktor se třemi parametry a implementuje
     - potřebné metody. Objem podstavy se spočítá width*depth
     -
     -
     */
    public static void mainApp(String[] args) {
        createBodies();
        System.out.println(calculateVolume(createBodies()));
    }

    /**
     - Vytvořte kolekci (vázaný seznam) objektů implementujících rozhraní Body3D. Do
     - kolekce vložte jednu kouli (Sphere), jeden válec (Cylinder) a jeden kvádr
     - (Block). Kolekci vraťte jako návratovou hodnotu.
     -
     - @return - kolekce 3D těles
     */
    public static List<?> createBodies() {
        LinkedList<Body3D> bodies = new LinkedList<>();
        bodies.add(new Sphere(1));
        bodies.add(new Cylinder(1,2));
        bodies.add(new Block(1,2,3));
        return bodies;
    }

    /**
     - Metoda pro všechyn objekty typu Body3D spočítá obsah a vrátí součet všech
     - obsahů.
     -
     - Projděte kolekci a pokud je prvek kolekce typu Body3D spočítejte jeho obsah a
     - všechny obsahy všech těles sečtěte.
     -
     - @param bodies - koelkce objektů
     - @return součet všech obsahů 3D těles.
     */
    public static double calculateVolume(List<?> bodies) {
        double volume = 0;
        for (Object body : bodies) {
            if (body instanceof Body3D) {
                volume += ((Body3D) body).getVolume();
            }
        }
        return volume;
    }

}
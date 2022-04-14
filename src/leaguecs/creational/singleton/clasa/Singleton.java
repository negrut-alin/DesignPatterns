package leaguecs.creational.singleton.clasa;

public class Singleton {

    // IMPORTANT CA SINGLETONUL SA FIE NOTAT CU VOLATILE PENTRU A PREVENI ERORI IN MEMORIE
    // DEOARECE FOLOSIM DOUBLE CHECKING LOCKING (LA Synchronized)
    private static volatile Singleton instance; // Definire Instanta Privata

    static
    {
        instance = null; // Initializare Instanta cu NULL
    }

    private Singleton() // NU PERMITEM INITIALIZAREA CONSTRUCTORULUI
    { }

    // Syncronized pentru evitarea dificultatilor aparute in operatii multi thread
    public static  Singleton getInstance() {
        // Daca instanta e nula
           if(instance == null) {
               synchronized (Singleton.class) { // Permitem DOAR UN THREAD SA ACCESEZE METODA IN ACEL MOMENT
                   if (instance == null) {
                       instance = new Singleton(); // Vom construi una
                   }
               }
           }

        // Daca e creata deja , se returneaza doar valoarea atasata de instanta .
        return instance;
    }
}

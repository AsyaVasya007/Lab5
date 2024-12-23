package reflection;
/**
 * Реализация интерфейса SOInterface.
 */
public class SODoer implements SOInterface {

    /**
     * Выводит "C" в консоль.
     */
    @Override
    public void doSome() {
        System.out.println("C");
    }
}
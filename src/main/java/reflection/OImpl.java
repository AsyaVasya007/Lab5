package reflection;
/**
 * Реализация интерфейса SInterface.
 */
public class OImpl implements SInterface {

    /**
     * Выводит "B" в консоль.
     */
    @Override
    public void doSome() {
        System.out.println("B");
    }
}
package reflection;
/**
 * Реализация интерфейса SInterface.
 */
public class SImpl implements SInterface {

    /**
     * Выводит "A" в консоль.
     */
    @Override
    public void doSome() {
        System.out.println("A");
    }
}
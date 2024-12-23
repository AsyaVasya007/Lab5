package com.company;
import java.io.IOException;
/**
 * Главный класс для демонстрации функциональности внедрения зависимостей.
 */
public class Main {
    /**
     * Точка входа в приложение.
     *
     * @param args Аргументы командной строки (не используются).
     * @throws IOException              если произошла ошибка при чтении файла конфигурации.
     * @throws InstantiationException   если не удалось создать экземпляр класса.
     * @throws IllegalAccessException   если доступ к полю запрещен.
     */
    public static void main(String[] args) throws IOException, InstantiationException, IllegalAccessException {
        SomeBean sb = (new Injector<SomeBean>("src/config/inj.properties").inject(new SomeBean()));
        sb.go();
    }
}
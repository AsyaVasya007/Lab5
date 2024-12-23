/**
 * Универсальный класс для внедрения зависимостей в аннотированные поля.
 *
 * @param <T> Тип объекта, в который будут внедрены зависимости.
 */
package com.company;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector<T> {

    /**
     * Свойства, загруженные из файла конфигурации.
     */
    private final Properties properties;

    /**
     * Конструктор для загрузки свойств из указанного файла.
     *
     * @param pathToPropertiesFile Путь к файлу свойств.
     * @throws IOException если файл не может быть прочитан.
     */
    Injector(String pathToPropertiesFile) throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream(new File(pathToPropertiesFile)));
    }

    /**
     * Внедряет зависимости в поля переданного объекта.
     *
     * @param obj Объект, в который будут внедрены зависимости.
     * @return Объект с внедренными зависимостями.
     * @throws IOException            если произошла ошибка доступа к файлу свойств.
     * @throws IllegalAccessException если доступ к полю запрещен.
     * @throws InstantiationException если не удалось создать экземпляр класса.
     */
    T inject(T obj) throws IOException, IllegalAccessException, InstantiationException {
        Class<?> cl = obj.getClass();
        Field[] fields = cl.getDeclaredFields();

        for (Field field : fields) {
            Annotation a = field.getAnnotation(AutoInjectable.class);
            if (a != null) {
                String[] fieldType = field.getType().toString().split(" ");
                String equalsClassName = properties.getProperty(fieldType[1], null);

                if (equalsClassName != null) {
                    try {
                        Class<?> dependency = Class.forName(equalsClassName);
                        field.setAccessible(true);
                        field.set(obj, dependency.newInstance());
                    } catch (ClassNotFoundException e) {
                        System.out.println("Класс " + equalsClassName + " не найден");
                    }
                } else {
                    System.out.println("Свойства для типа поля " + fieldType[1] + " не найдены");
                }
            }
        }
        return obj;
    }
}

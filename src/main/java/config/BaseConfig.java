package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с основной конфигурацией проекта
 */
@Config.Sources({"classpath:config.properties"})
public interface BaseConfig extends Config{

    /**
     * Метод возвращает параметр url из config.properties
     *
     * @return параметр начальной страницы приложения
     */
    String url();

    /**
     * Метод возвращает параметр driverPath из config.properties
     *
     * @return параметр расположения chromedriver.exe в проекте
     */
    String driverPath();

    /**
     * Метод возвращает параметр driverProperty из config.properties
     *
     * @return параметр webdriver используемого для тестов
     */
    String driverProperty();
}
package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов Practice-automation/form-fields страницы
 */
@Config.Sources({"classpath:practice_automation_tests_config.properties"})
public interface PracticeAutomationTestsConfig extends Config{

    /**
     * Метод возвращает параметр inputName из practice_automation_tests_config.properties
     *
     * @return параметр строки для поля Name
     */
    String inputName();

    /**
     * Метод возвращает параметр inputPassword из practice_automation_tests_config.properties
     *
     * @return параметр строки для поля Password
     */
    String inputPassword();

    /**
     * Метод возвращает параметр inputEmail из practice_automation_tests_config.properties
     *
     * @return параметр строки для поля Email
     */
    String inputEmail();
}
package config;

import org.aeonbits.owner.Config;

/**
 * Интерфейс с конфигурацией проекта для тестов Practice-automation/form-fields страницы
 */
@Config.Sources({"classpath:practice_automation_tests_config.properties"})
public interface PracticeAutomationTestsConfig extends Config{


    String inputName();

    String inputPassword();

    String inputEmail();

}

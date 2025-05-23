package controller;

/**
 * Интерфейс, представляющий команду, которая может быть выполнена в программе.
 * Определяет методы для получения описания, имени команды и ее выполнения.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public interface CommandInterface {

    /**
     * Возвращает краткое описание команды.
     *
     * @return Строка, описывающая назначение команды.
     */
     String getDescription();

    /**
     * Возвращает имя команды.
     *
     * @return Строка, представляющая имя команды.
     */
     String getName();

    /**
     * Выполняет команду.
     */
     void execute();
}

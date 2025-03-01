package controller;

import exceptions.IncorrectArgumentException;

/**
 * Интерфейс для обработки команд и управления их выполнением.
 * Определяет методы для обработки аргументов, получения текущей команды и создания новой команды.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public interface HandlerInterface {

    /**
     * Обрабатывает переданные аргументы и выполняет соответствующую команду.
     *
     * @param arguments Аргументы, переданные для обработки.
     * @throws IncorrectArgumentException Если аргументы некорректны или не могут быть обработаны.
     */
     void handle(String arguments) throws IncorrectArgumentException;

    /**
     * Возвращает текущую команду, которая обрабатывается.
     *
     * @return Объект {@link CommandInterface}, связанный с текущей операцией обработки.
     */
    CommandInterface getCommand();

    /**
     * Создает новую команду на основе текущего состояния или требований.
     */
     void createCommand();
}

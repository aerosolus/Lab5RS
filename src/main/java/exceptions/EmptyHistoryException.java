package exceptions;

/**
 * Исключение, выбрасываемое при попытке доступа к пустой или недостаточно заполненной истории команд.
 * Это исключение указывает на то, что история команд содержит менее 5 записей.
 *
 * @author Aerosolus
 * @version 1.0
 * @since 2.0
 */
public class EmptyHistoryException extends Exception {
}

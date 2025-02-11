package exceptions;

/**
 * Исключение, выбрасываемое при попытке передать значение null
 * где требуется ненулевое значение.
 *
 * <p> Оно возникает в ситуациях, когда метод или функция ожидает ненулевой аргумент,
 * но вместо этого получает нулевую ссылку. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 */
public class NotNullException extends Exception{
}
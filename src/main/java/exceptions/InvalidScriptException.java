package exceptions;


/**
 * Исключение, выбрасываемое при обнаружении неверных данных в скрипте.
 *
 * <p> Оно указывает на то, что скрипт содержит некорректные команды, аргументы или синтаксические ошибки,
 * которые делают его выполнение невозможным. </p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.0
 */
public class InvalidScriptException extends IllegalArgumentException {
}

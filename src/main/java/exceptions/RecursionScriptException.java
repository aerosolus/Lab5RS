package exceptions;

/**
 * Исключение, выбрасываемое при обнаружении рекурсии в скрипте.
 *
 * <p> Это исключение указывает на то, что скрипт содержит рекурсию,
 * что может привести к бесконечному выполнению и переполнению стека. </p>
 *
 * @author Aerosolus
 * @version 1.1
 * @since 1.0
 */
public class RecursionScriptException extends IllegalStateException {
}

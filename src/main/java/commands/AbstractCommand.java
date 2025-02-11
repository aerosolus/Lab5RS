package commands;

/**
 * Абстрактный класс, реализующий базовую функциональность для команд.
 *
 * <p> Этот класс предоставляет общую реализацию методов {@link CommandInterface#getName()} и
 * {@link CommandInterface#getDescription()}, которые используются всеми командами.
 * Конкретные команды должны наследовать этот класс и по-своему реализовывать метод {@link CommandInterface#execute(String)}. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.0
 *
 * @see commands.CommandInterface
 */
public abstract class AbstractCommand implements CommandInterface {

    /**
     * Имя команды
     */
    private final String name;

    /**
     * Описание команды
     */
    private final String description;

    /**
     * Конструктор для создания команды с указанным именем и описанием.
     *
     * @param name        имя команды, которое будет использоваться для её идентификации.
     * @param description описание команды, объясняющее её назначение.
     */
    public AbstractCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Возвращает имя команды.
     *
     * @return строку с именем команды.
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает описание команды.
     *
     * @return строку с описанием команды.
     */
    public String getDescription() {
        return description;
    }
}

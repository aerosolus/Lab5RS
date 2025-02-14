package data;

/**
 * Перечисление, представляющее различные позиции.
 * Каждая константа перечисления соответствует определённой позиции.
 *
 * <p> Это перечисление может использоваться для представления позиций в различных контекстах, например,
 * выбор позиции пользователем. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.1
 */
public enum Position {

    /**
     * Инженер
     */
    ENGINEER,

    /**
     * Начальник отдела
     */
    HEAD_OF_DEPARTMENT,

    /**
     * Разработчик
     */
    DEVELOPER;

    /**
     * Преобразует все значения перечисления в строку, разделённую запятыми.
     * Используется для отображения или логирования всех доступных позиций.
     *
     * @return строка, содержащая все значения перечисления, разделённые запятыми.
     */
    public static String nameToString() {
        StringBuilder nameToString = new StringBuilder();
        for (Position position : values()) {
            nameToString.append(position.name()).append(", ");
        }
        return nameToString.substring(0, nameToString.length()-2);
    }
}

package data;

/**
 * Перечисление, представляющее различные цвета.
 * Каждая константа перечисления соответствует определённому цвету.
 *
 * <p> Это перечисление может использоваться для представления стран в различных контекстах, например,
 * выбор цвета пользователем. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.1
 */
public enum Color {

    /**
     * Красный
     */
    RED,

    /**
     * Черный
     */
    BLACK,

    /**
     * Желтый
     */
    YELLOW,

    /**
     * Зеленый
     */
    GREEN,

    /**
     * Синий
     */
    BLUE,

    /**
     * Белый
     */
    WHITE;

    /**
     * Преобразует все значения перечисления в строку, разделённую запятыми.
     * Используется для отображения или логирования всех доступных цветов.
     *
     * @return строка, содержащая все значения перечисления, разделённые запятыми.
     */
    public static String nameToString() {
        StringBuilder nameToString = new StringBuilder();
        for (Color color : values()) {
            nameToString.append(color.name()).append(", ");
        }
        return nameToString.substring(0, nameToString.length()-2);
    }
}

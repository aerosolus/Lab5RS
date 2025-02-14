package data;

/**
 * Перечисление, представляющее различные страны.
 * Каждая константа перечисления соответствует определённой стране.
 *
 * <p> Это перечисление может использоваться для представления стран в различных контекстах, например,
 * выбор страны пользователем. </p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.1
 */
public enum Country {

    /**
     * Италия
     */
    ITALY,

    /**
     * Таиланд
     */
    THAILAND,

    /**
     * Северная Корея
     */
    NORTH_KOREA;

    /**
     * Преобразует все значения перечисления в строку, разделённую запятыми.
     * Используется для отображения или логирования всех доступных стран.
     *
     * @return строка, содержащая все значения перечисления, разделённые запятыми.
     */
    public static String nameToString() {
        StringBuilder nameToString = new StringBuilder();
        for (Country country : values()) {
            nameToString.append(country.name()).append(", ");
        }
        return nameToString.substring(0, nameToString.length()-2);
    }
}

package data;

import java.util.Objects;

/**
 * Класс, представляющий координаты в двумерном пространстве.
 * Координаты имеют два параметра: x типа {@code Long} и y типа {@code long}.
 *
 * <p>Этот класс реализует создание объектов при помощи паттерна строитель (Builder).
 * Он также предоставляет методы для получения и установки значений координат,
 * для сравнения объектов данного класса, представления их в виде строк.</p>
 *
 * @author aerosolus
 * @version 1.0
 * @since 1.1
 */
public class Coordinates {

    /**
     * Координата y
     */
    private Long x;

    /**
     * Координата y
     */
    private long y;

    /**
     * Конструктор, использующий строитель (Builder) для инициализации координат.
     *
     * @param coordinatesBuilder Объект строителя, содержащий значения x и y.
     */
    public Coordinates(CoordinatesBuilder coordinatesBuilder) {
        x = coordinatesBuilder.x;
        y = coordinatesBuilder.y;
    }

    /**
     * Конструктор по умолчанию. Создает объект с неинициализированными координатами.
     */
    public Coordinates() {

    }

    /**
     * Вложенный класс, реализующий паттерн строитель (Builder) для создания объектов Coordinates.
     */
    public static class CoordinatesBuilder {

        /**
         * Координата x
         */
        private Long x;

        /**
         * Координата y
         */
        private long y;

        /**
         * Конструктор строителя, принимающий значения координат.
         *
         * @param x Начальное значение координаты x.
         * @param y Начальное значение координаты y.
         */
        public CoordinatesBuilder(Long x, long y) {
            this.x = x;
            this.y = y;
        }

        /**
         * Создает объект Coordinates на основе текущих параметров строителя.
         *
         * @return Новый объект Coordinates.
         */
        public Coordinates build() {
            return new Coordinates(this);
        }
    }

    /**
     * Возвращает значение координаты x.
     *
     * @return Значение координаты x.
     */
    public Long getX() {
        return x;
    }

    /**
     * Устанавливает значение координаты x.
     *
     * @param x Новое значение координаты x.
     */
    public void setX(Long x) {
        this.x = x;
    }

    /**
     * Возвращает значение координаты y.
     *
     * @return Значение координаты y.
     */
    public long getY() {
        return y;
    }

    /**
     * Устанавливает значение координаты y.
     *
     * @param y Новое значение координаты y.
     */
    public void setY(long y) {
        this.y = y;
    }

    /**
     * Возвращает строковое представление объекта Coordinates.
     *
     * @return Строка в формате "Coordinates{x=..., y=...}".
     *
     * @see Coordinates
     */
    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x
                + ", y="
                + y + '}';
    }

    /**
     * Проверяет текущий объект Coordinates с другим объектом на равенство.
     *
     * @param o Объект для сравнения.
     * @return true, если объекты равны по значениям x и y, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(x, that.x) && Objects.equals(y, that.y);
    }

    /**
     * Определяет хэш-код объекта Coordinates.
     *
     * @return Хэш-код, вычисленный на основе значений x и y.
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

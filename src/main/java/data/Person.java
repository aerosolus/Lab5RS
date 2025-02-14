package data;

import java.util.Objects;

/**
 * Класс, представляющий человека с такими характеристиками, как рост, цвет глаз, цвет волос и национальность.
 * У человека приводятся следующие параметры: {@code height} типа {@code Float}, {@code eyeColor} типа {@code Color},
 * {@code hairColor} типа {@code Color} и {@code nationality} типа {@code Country}.
 *
 * <p>Этот класс поддерживает создание объектов при помощи паттерна строитель (Builder).
 * Он также предоставляет методы для получения и установки значений его параметров,
 * для сравнения объектов данного класса, представления их в виде строк.</p>
 *
 * @author aerosolus
 * @version 1.0
 * @since 1.1
 */
public class Person implements Comparable<Person> {

    /**
     * Рост человека. Поле не может быть null, значение должно быть больше 0.
     */
    private Float height;

    /**
     * Цвет глаз человека. Поле может быть null.
     */
    private Color eyeColor;

    /**
     * Цвет волос человека. Поле может быть null.
     */
    private Color hairColor;

    /**
     * Национальность человека. Поле не может быть null.
     */
    private Country nationality;

    /**
     * Конструктор, использующий строитель (Builder) для инициализации объекта Person.
     *
     * @param personBuilder Объект строителя, содержащий значения height, eyeColor, hairColor, nationality.
     */
    public Person(PersonBuilder personBuilder) {
        height = personBuilder.height;
        eyeColor = personBuilder.eyeColor;
        hairColor = personBuilder.hairColor;
        nationality = personBuilder.nationality;
    }

    /**
     * Конструктор по умолчанию. Создает объект с неинициализированными параметрами.
     */
    public Person() {

    }

    /**
     * Вложенный класс, реализующий паттерн строитель (Builder) для создания объектов Person.
     */
    public static class PersonBuilder {

        /**
         * Рост человека.
         */
        private Float height;

        /**
         * Цвет глаз человека.
         */
        private Color eyeColor;

        /**
         * Цвет глаз человека.
         */
        private Color hairColor;

        /**
         * Цвет глаз человека.
         */
        private Country nationality;

        /**
         * Конструктор строителя, принимающий значения объекта Person.
         *
         * @param height Рост человека.
         * @param eyeColor Цвет глаз человека.
         * @param hairColor Цвет волос человека.
         * @param nationality Национальность человека.
         */
        public PersonBuilder(Float height, Color eyeColor, Color hairColor, Country nationality) {
            this.height = height;
            this.eyeColor = eyeColor;
            this.hairColor = hairColor;
            this.nationality = nationality;
        }

        /**
         * Создает объект Person на основе текущих параметров строителя.
         *
         * @return Новый объект Person.
         */
        public Person build() {
            return new Person(this);
        }
    }

    /**
     * Возвращает рост человека.
     *
     * @return Значение роста.
     */
    public Float getHeight() {
        return height;
    }

    /**
     * Устанавливает рост человека.
     *
     * @param height Новое значение роста.
     */
    public void setHeight(Float height) {
        this.height = height;
    }

    /**
     * Возвращает цвет глаз человека.
     *
     * @return Значение цвета глаз.
     */
    public Color getEyeColor() {
        return eyeColor;
    }

    /**
     * Устанавливает цвет глаз человека.
     *
     * @param eyeColor Новое значение цвета глаз.
     */
    public void setEyeColor(Color eyeColor) {
        this.eyeColor = eyeColor;
    }

    /**
     * Возвращает цвет волос человека.
     *
     * @return Значение цвета волос.
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * Устанавливает цвет волос человека.
     *
     * @param hairColor Новое значение цвета волос.
     */
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Возвращает национальность человека.
     *
     * @return Значение национальности.
     */
    public Country getNationality() {
        return nationality;
    }

    /**
     * Устанавливает национальность человека.
     *
     * @param nationality Новое значение национальности.
     */
    public void setNationality(Country nationality) {
        this.nationality = nationality;
    }

    /**
     * Возвращает строковое представление объекта Person.
     *
     * @return Строка в формате "Person{height=..., eyeColor=..., hairColor=..., nationality=...}".
     *
     * @see Person
     */
    @Override
    public String toString() {
        return "Person{" +
                "height=" + height +
                ", eyeColor=" + eyeColor +
                ", hairColor=" + hairColor +
                ", nationality=" + nationality +
                '}';
    }

    /**
     * Сравнивает текущий объект Person с другим объектом Person.
     * Сравнение выполняется с использованием значений всех полей объекта.
     * Первоначально для сравнения используется рост объектов класса Person.
     *
     * @param o Объект Person для сравнения.
     * @return Отрицательное целое число, ноль или положительное целое число,
     * если первый аргумент меньше, равен или больше второго соответственно.
     */
    @Override
    public int compareTo(Person o) {
        int heightComparison = this.height.compareTo(o.height);
        if (heightComparison != 0) {
            return heightComparison; // Если рост разный, возвращаем результат сравнения по росту
        }

        // Если рост одинаковый, сравниваем по цвету глаз
        int eyeColorComparison = this.eyeColor.compareTo(o.eyeColor);
        if (eyeColorComparison != 0) {
            return eyeColorComparison; // Если цвет глаз разный, возвращаем результат сравнения по цвету глаз
        }

        // Если цвет глаз одинаковый, сравниваем по цвету волос
        int hairColorComparison = this.hairColor.compareTo(o.hairColor);
        if (hairColorComparison != 0) {
            return eyeColorComparison; // Если цвет волос разный, возвращаем результат сравнения по цвету волос
        }

        // Если цвет волос одинаковый, сравниваем по национальности
        return this.nationality.compareTo(o.nationality); // Если национальность разная, возвращаем результат сравнения по национальности

        // Если все поля одинаковые, объекты считаются равными
    }

    /**
     * Проверяет текущий объект Person с другим объектом на равенство.
     *
     * @param o Объект для сравнения.
     * @return true, если объекты равны по значениям height, eyeColor, hairColor, nationality, иначе false.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(height, person.height) && eyeColor == person.eyeColor && hairColor == person.hairColor && nationality == person.nationality;
    }

    /**
     * Определяет хэш-код объекта Person.
     *
     * @return Хэш-код, вычисленный на основе значений height, eyeColor, hairColor, nationality.
     */
    @Override
    public int hashCode() {
        return Objects.hash(height, eyeColor, hairColor, nationality);
    }
}

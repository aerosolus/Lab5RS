package data;

import java.util.Date;

/**
 * Класс, представляющий работника с такими характеристиками, как идентификатор, имя, координаты,
 * дата создания, зарплата, должность, статус и персональные параметры.
 *
 * <p>Этот класс поддерживает создание объектов при помощи паттерна строитель (Builder).
 * Он также предоставляет методы для получения и установки значений его параметров,
 * для сравнения объектов данного класса, представления их в виде строк.</p>
 *
 * @author aerosolus
 * @version 1.0
 * @since 1.1
 */
public class Worker implements Comparable<Worker> {

    /**
     * Идентификатор работника. Поле не может быть null, значение должно быть больше 0,
     * должно быть уникальным и генерироваться автоматически.
     */
    private Long id;

    /**
     * Имя работника. Поле не может быть null, строка не может быть пустой.
     */
    private String name;

    /**
     * Координаты работника. Поле не может быть null.
     */
    private Coordinates coordinates;

    /**
     * Дата создания записи о работнике. Поле не может быть null,
     * значение должно генерироваться автоматически.
     */
    private java.util.Date creationDate;

    /**
     * Зарплата работника. Значение поля должно быть больше 0.
     */
    private long salary;

    /**
     * Должность работника. Поле не может быть null.
     */
    private Position position;

    /**
     * Статус работника. Поле может быть null.
     */
    private Status status;

    /**
     * Личные данные работника. Поле не может быть null.
     */
    private Person person;

    /**
     * Конструктор, использующий строитель (Builder) для инициализации объекта Worker.
     *
     * @param workerBuilder Объект строителя, содержащий значения id, name, coordinates,
     *                      creationDate, salary, position, status, person.
     */
    public Worker(WorkerBuilder workerBuilder) {
        id = workerBuilder.id;
        name = workerBuilder.name;
        coordinates = workerBuilder.coordinates;
        creationDate = workerBuilder.creationDate;
        salary = workerBuilder.salary;
        position = workerBuilder.position;
        status = workerBuilder.status;
        person = workerBuilder.person;
    }

    /**
     * Конструктор по умолчанию. Создает объект с неинициализированными параметрами.
     */
    public Worker() {

    }

    /**
     * Вложенный класс, реализующий паттерн строитель (Builder) для создания объектов Worker.
     */
    public static class WorkerBuilder {

        private Long id;

        private String name;

        private Coordinates coordinates;

        private java.util.Date creationDate;

        private long salary;

        private Position position;

        private Status status;

        private Person person;

        /**
         * Конструктор строителя, принимающий обязательные параметры объекта Worker.
         *
         * @param id Идентификатор работника.
         * @param name Имя работника.
         * @param coordinates Координаты работника.
         * @param creationDate Дата создания записи.
         * @param salary Зарплата работника.
         * @param position Должность работника.
         */
        public WorkerBuilder(
                Long id,
                String name,
                Coordinates coordinates,
                Date creationDate,
                long salary,
                Position position) {
            this.id = id;
            this.name = name;
            this.coordinates = coordinates ;
            this.creationDate = creationDate;
            this.salary = salary;
            this.position = position;
        }

        /**
         * Устанавливает статус работника.
         *
         * @param status Статус работника.
         * @return Текущий объект строителя.
         */
        public WorkerBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        /**
         * Устанавливает персональные параметры работника.
         *
         * @param person Персональные параметры работника.
         * @return Текущий объект строителя.
         */
        public WorkerBuilder setPerson(Person person) {
            this.person = person;
            return this;
        }

        /**
         * Создает объект Worker на основе текущих параметров строителя.
         *
         * @return Новый объект Worker.
         */
        public Worker build() {
            return new Worker(this);
        }
    }

    /**
     * Возвращает идентификатор работника.
     *
     * @return Значение идентификатора.
     */
    public Long getId() {
        return id;
    }

    /**
     * Устанавливает идентификатор работника.
     *
     * @param id Новое значение идентификатора.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Возвращает имя работника.
     *
     * @return Значение имени.
     */
    public String getName() {
        return name;
    }

    /**
     * Устанавливает имя работника.
     *
     * @param name Новое значение имени.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Возвращает координаты работника.
     *
     * @return Объект координат.
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Устанавливает координаты работника.
     *
     * @param coordinates Новое значение координат.
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Возвращает дату создания записи о работнике.
     *
     * @return Значение даты создания.
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * Устанавливает дату создания записи о работнике.
     *
     * @param creationDate Новое значение даты создания.
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Возвращает зарплату работника.
     *
     * @return Значение зарплаты.
     */
    public long getSalary() {
        return salary;
    }

    /**
     * Устанавливает зарплату работника.
     *
     * @param salary Новое значение зарплаты.
     */
    public void setSalary(long salary) {
        this.salary = salary;
    }

    /**
     * Возвращает должность работника.
     *
     * @return Значение должности.
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Устанавливает должность работника.
     *
     * @param position Новое значение должности.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Возвращает статус работника.
     *
     * @return Значение статуса.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Устанавливает статус работника.
     *
     * @param status Новое значение статуса.
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Возвращает персональные параметры работника.
     *
     * @return Объект с персональными параметрами.
     */
    public Person getPerson() {
        return person;
    }

    /**
     * Устанавливает персональные параметры работника.
     *
     * @param person Новое значение персональных параметров.
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * Сравнивает этот объект Worker с другим объектом для сортировки.
     * Сравнение основано на имени работника.
     *
     * @param o Объект для сравнения.
     * @return Отрицательное целое число, ноль или положительное целое число,
     * если первый аргумент меньше, равен или больше второго соответственно.
     */
    public int compareTo(Worker o) {
        return this.name.toLowerCase().compareTo(o.name.toLowerCase());
    }

    /**
     * Возвращает строковое представление объекта Worker.
     * Этот метод предоставляет подробное описание объекта,
     * включая все поля и их значения.
     *
     * @return Строковое представление объекта Worker.
     *
     * @see Worker
     */
    @Override
    public String toString() {
        return "Worker{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates=" + coordinates +
                ", creationDate=" + creationDate +
                ", salary=" + salary +
                ", position=" + position +
                ", status=" + status +
                ", person=" + person +
                '}';
    }
}

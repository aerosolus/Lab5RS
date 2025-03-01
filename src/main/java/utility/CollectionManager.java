package utility;

import data.Person;
import data.Worker;

import java.io.IOException;
import java.time.Instant;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Класс, управляющий коллекцией объектов {@link Worker}.
 * Предоставляет различные методы для работы с коллекцией, например, добавление, удаление, обновление,
 * сортировка, фильтрация, сохранение данных и др.
 *
 * <p>Используется потокобезопасная коллекция {@link Vector}.
 * Класс реализует генерацию уникальных идентификаторов для новых элементов коллекции.</p>
 *
 * @author Aerosolus
 * @version 1.0
 * @since 1.3
 */
public class CollectionManager {

    /**
     * Используемая конфигурация коллекции
     */
    private Vector<Worker> workersCollection;

    /**
     * Дата инициализации коллекции
     */
    private final Date initializationDate = new Date();

    /**
     * Путь к файлу, в котором сохраняется коллекция
     */
    private String filePath;

    /**
     * Конструктор по умолчанию. Создает пустую коллекцию.
     */
    public CollectionManager() {
    }

    /**
     * Конструктор, инициализирующий коллекцию и путь к файлу.
     *
     * @param workersCollection Коллекция объектов {@link Worker}.
     * @param filePath Путь к файлу для сохранения коллекции.
     */
    public CollectionManager(Vector<Worker> workersCollection, String filePath) {
        this.workersCollection = workersCollection;
        this.filePath = filePath;
    }

    /**
     * Возвращает текущую коллекцию объектов {@link Worker}.
     *
     * @return Коллекция объектов {@link Worker}.
     */
    public Vector<Worker> getCollection() {
        return workersCollection;
    }

    /**
     * Устанавливает коллекцию объектов {@link Worker}.
     *
     * @param workersCollection Новая коллекция объектов {@link Worker}.
     */
    public void setCollection(Vector<Worker> workersCollection) {
        this.workersCollection = workersCollection;
    }

    /**
     * Устанавливает путь к файлу для сохранения коллекции.
     *
     * @param filePath Путь к файлу.
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * Возвращает дату инициализации коллекции.
     *
     * @return Дата инициализации коллекции.
     */
    public Date getInitializationDate() {
        return initializationDate;
    }

    /**
     * Возвращает объект {@link Worker} по его идентификатору.
     *
     * @param id Идентификатор работника.
     * @return Объект {@link Worker} с указанным идентификатором.
     * @throws NoSuchElementException Если элемент с указанным идентификатором не найден.
     */
    public Worker getById(Long id) {
        return workersCollection.stream().filter(v -> v.getId().equals(id)).findFirst().get();
    }

    /**
     * Проверяет, содержит ли коллекция объект с указанным идентификатором.
     *
     * @param id Идентификатор работника.
     * @return true, если коллекция содержит объект с указанным идентификатором, иначе false.
     */
    public boolean containsId(Long id) {
        return workersCollection.stream().anyMatch(v -> v.getId().equals(id));
    }

    /**
     * Возвращает строку с информацией о коллекции, включая тип коллекции,
     * дату инициализации и количество элементов.
     *
     * @return Строка с информацией о коллекции.
     */
    public String collectionInfo() {
        return "Тип коллекции: " + workersCollection.getClass() + "\n" +
                "Дата инициализации: " + getInitializationDate().toString() +
                "\n" + "Количество элементов в коллекции: " + workersCollection.size();
    }

    /**
     * Очищает коллекцию, удаляя все элементы.
     */
    public void clearCollection() {
        workersCollection.clear();
        System.out.println("Коллекция очищена.");
    }

    /**
     * Добавляет новый объект {@link Worker} в коллекцию.
     *
     * @param worker Объект {@link Worker} для добавления.
     */
    public void addToCollection(Worker worker) {
        workersCollection.add(worker);
        System.out.println("Элемент был добавлен в коллекцию.");
    }

    /**
     * Добавляет новый объект {@link Worker} в коллекцию, если его значение превышает
     * значение наибольшего элемента коллекции.
     *
     * @param worker Объект {@link Worker} для добавления.
     */
    public void addIfMax(Worker worker){
        if (workersCollection.isEmpty()) {
            worker.setCreationDate(Date.from(Instant.now()));
            workersCollection.add(worker);
            System.out.println("Элемент был добавлен в коллекцию.");
        } else {
            Worker maxWorker = Collections.max(workersCollection);
            if (worker.compareTo(maxWorker) > 0) {
                worker.setCreationDate(Date.from(Instant.now()));
                workersCollection.add(worker);
                System.out.println("Элемент был добавлен в коллекцию.");
            }
            else {
                System.out.println("Элемент не был добавлен в коллекцию.");
            }

        }
    }

    /**
     * Обновляет объект {@link Worker} в коллекции по его идентификатору.
     *
     * @param worker Объект {@link Worker} для обновления.
     */
    public void update(Long id, Worker worker) {
        removeFromCollectionById(id);
        workersCollection.add(worker);
        System.out.println("Элемент коллекции с id = " + worker.getId() + " был обновлен.");
    }

    /**
     * Сохраняет коллекцию в файл, указанный в {@code filePath}.
     */
    public void save() {
        try {
            new CSVWriter().writeCollection(workersCollection, filePath);
        } catch (NullPointerException | IOException e) {
            System.out.println("Изменения не были сохранены из-за некой ошибки!");
        }
    }

    /**
     * Удаляет указанный объект {@link Worker} из коллекции.
     *
     * @param worker Объект {@link Worker} для удаления.
     */
    public void removeFromCollection(Worker worker){
        workersCollection.remove(worker);
    }

    /**
     * Удаляет объект {@link Worker} из коллекции по его идентификатору.
     *
     * @param id Идентификатор работника.
     */
    public void removeFromCollectionById(Long id) {
        workersCollection.stream()
                .filter(worker -> Objects.equals(worker.getId(), id))
                .findFirst()
                .ifPresent(this::removeFromCollection);
    }

    /**
     * Выводит содержимое коллекции в консоль.
     */
    public void showCollection() {
        if (workersCollection == null || workersCollection.isEmpty()) {
            System.out.println("Коллекция пуста.");
        } else
            for (Worker worker : workersCollection) {
            System.out.println(worker.toString());
        }
    }

    /**
     * Удаляет из коллекции все элементы, которые меньше указанного объекта {@link Worker}.
     *
     * @param worker Объект {@link Worker} для сравнения.
     */
    public void removeLower(Worker worker) {
        workersCollection.removeIf(e -> e.compareTo(worker) < 0);
    }

    /**
     * Выводит количество элементов, значение поля {@link Person} которых больше указанного.
     *
     * @param lowPerson Объект {@link Person} для сравнения.
     */
    public void countGreaterThanPerson(Person lowPerson) {
        long count = workersCollection.stream()
                .filter(worker -> worker.getPerson() != null && worker.getPerson().compareTo(lowPerson) > 0)
                .count();
        System.out.println("Количество работников, значение поля person которых больше " + lowPerson + " равно " + count + ".");
    }

    /**
     * Выводит элементы коллекции, значение поля {@code salary} которых меньше указанного.
     *
     * @param maxSalary Максимальное значение зарплаты.
     */
    public void filterLessThanSalary(long maxSalary) {
        List<Worker> workerArrayList =  workersCollection.stream()
                .filter(worker -> worker.getSalary() < maxSalary)
                .collect(Collectors.toList());
        if (workerArrayList.isEmpty()) {
            System.out.println("Отсутствуют значения поля salary меньшие, чем заданное.");
        } else {
            System.out.println("Работники с зарплатой меньше, чем " + maxSalary + ":");
            for (Worker worker : workerArrayList) {
                System.out.println(worker.toString());
            }
        }
    }

    /**
     * Выводит значения поля {@link Person} всех элементов коллекции в порядке возрастания.
     */
    public void printFieldAscendingPerson(){
        ArrayList<Person> people = workersCollection.stream()
                .map(Worker::getPerson).sorted().collect(Collectors.toCollection(ArrayList::new));
        if (people.isEmpty()) {
            System.out.println("Коллекция пуста. Отсутствуют значения поля Person для отображения.");
        }
        else {
            System.out.println("Все значения поля Person в порядке возрастания: \n");
            for (Person person : people) {
                System.out.println(person.toString());
            }
        }
    }

    /**
     * Генерирует уникальный идентификатор для нового элемента коллекции.
     *
     * @return Уникальный идентификатор.
     */
    public Long generateId() {
        int count = 0;
        Long id = 1L;
        while (count != workersCollection.size()) {
            for (Worker worker : workersCollection) {
                count++;
                if (Objects.equals(worker.getId(), id)) {
                    id++;
                    count = 0;
                    break;
                }
            }
        }
        return id;
    }
}

# Лабораторная работа № 5

***
Эта и последующие лабораторные работы выполняются в рамках реструктуризации
по дисциплине "Программирование" с ипользованием языка `Java`.
***

**Вариант: 52941**

Реализовать консольное приложение,
которое реализует управление коллекцией объектов в интерактивном режиме.

В коллекции необходимо хранить объекты класса `Worker`,
описание которого приведено ниже.

Разработанная программа должна удовлетворять следующим **требованиям**:

- Класс, коллекцией экземпляров которого управляет программа, должен реализовывать сортировку по умолчанию.
- Все требования к полям класса (указанные в виде комментариев) должны быть выполнены.
- Для хранения необходимо использовать коллекцию типа `java.util.Vector`.
- При запуске приложения коллекция должна автоматически заполняться значениями из файла.
- Имя файла должно передаваться программе с помощью: **аргумента командной строки**.
- Данные должны храниться в файле в формате `csv`.
- Чтение данных из файла необходимо реализовать с помощью класса `java.io.InputStreamReader`.
- Запись данных в файл необходимо реализовать с помощью класса `java.io.FileOutputStream`.
- Все классы в программе должны быть задокументированы в формате javadoc.
- Программа должна корректно работать с неправильными данными (ошибки пользовательского ввода, отсутствие прав доступа к файлу и т.п.).

В интерактивном режиме программа должна поддерживать выполнение следующих **команд**:

- `help` : вывести справку по доступным командам
- `info` : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
- `show` : вывести в стандартный поток вывода все элементы коллекции в строковом представлении
- `add {element}` : добавить новый элемент в коллекцию
- `update id {element}` : обновить значение элемента коллекции, id которого равен заданному
- `remove_by_id id` : удалить элемент из коллекции по его id
- `clear` : очистить коллекцию
- `save` : сохранить коллекцию в файл
- `execute_script file_name` : считать и исполнить скрипт из указанного файла.
В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.
- `exit` : завершить программу (без сохранения в файл)
- `add_if_max` : добавить новый элемент в коллекцию, если его значение превышает значение наибольшего элемента этой коллекции
- `remove_lower {element}` : удалить из коллекции все элементы, меньшие, чем заданный
- `history` : вывести последние 5 команд (без их аргументов)
- `count_greater_than_person person` : вывести количество элементов, значение поля person которых больше заданного
- `filter_less_than_salary salary` : вывести элементы, значение поля salary которых меньше заданного
- `print_field_ascending_person` : вывести значения поля person всех элементов в порядке возрастания

**Формат ввода команд**:

- Все аргументы команды, являющиеся стандартными типами данных (примитивные типы, классы-оболочки, String, классы для хранения дат), должны вводиться в той же строке, что и имя команды.
- Все составные типы данных (объекты классов, хранящиеся в коллекции) должны вводиться по одному полю в строку.
- При вводе составных типов данных пользователю должно показываться приглашение к вводу, содержащее имя поля (например, "Введите дату рождения:")
- Если поле является enum'ом, то вводится имя одной из его констант (при этом список констант должен быть предварительно выведен).
- При некорректном пользовательском вводе (введена строка, не являющаяся именем константы в enum'е; введена строка вместо числа; введённое число не входит в указанные границы и т.п.) должно быть показано сообщение об ошибке и предложено повторить ввод поля.
- Для ввода значений `null` использовать пустую строку.
- Поля с комментарием "Значение этого поля должно генерироваться автоматически" не должны вводиться пользователем вручную при добавлении.

**Описание хранимых в коллекции классов:**
```java
public class Worker {
    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private long salary; //Значение поля должно быть больше 0
    private Position position; //Поле не может быть null
    private Status status; //Поле может быть null
    private Person person; //Поле не может быть null
}
public class Coordinates {
    private Long x; //Значение поля должно быть больше -975, Поле не может быть null
    private long y;
}
public class Person {
    private Float height; //Поле не может быть null, Значение поля должно быть больше 0
    private Color eyeColor; //Поле может быть null
    private Color hairColor; //Поле может быть null
    private Country nationality; //Поле не может быть null
}
public enum Position {
    ENGINEER,
    HEAD_OF_DEPARTMENT,
    DEVELOPER;
}
public enum Status {
    FIRED,
    HIRED,
    REGULAR,
    PROBATION;
}
public enum Color {
    RED,
    BLACK,
    YELLOW;
}
public enum Color {
    GREEN,
    RED,
    BLACK,
    BLUE,
    WHITE;
}
public enum Country {
    ITALY,
    THAILAND,
    NORTH_KOREA;
}
```
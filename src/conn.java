import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class conn {
    public static Connection conn;
    public static Statement statmt;
    public static ResultSet resSet;

    static String[] types = new String[]{"Абиссинская кошка",
            "Австралийский мист",
            "Американская жесткошерстная",
            "Американская короткошерстная",
            "Американский бобтейл",
            "Американский кёрл",
            "Балинезийская кошка",
            "Бенгальская кошка",
            "Бирманская кошка",
            "Бомбейская кошка",
            "Бразильская короткошёрстная",
            "Британская длинношерстная",
            "Британская короткошерстная",
            "Бурманская кошка",
            "Бурмилла кошка",
            "Гавана",
            "Гималайская кошка",
            "Девон-рекс",
            "Донской сфинкс",
            "Европейская короткошерстная",
            "Египетская мау",
            "Канадский сфинкс",
            "Кимрик",
            "Корат",
            "Корниш-рекс",
            "Курильский бобтейл",
            "Лаперм",
            "Манчкин",
            "Мейн-ку́н",
            "Меконгский бобтейл",
            "Мэнкс кошка",
            "Наполеон",
            "Немецкий рекс",
            "Нибелунг",
            "Норвежская лесная кошка",
            "Ориентальная кошка",
            "Оцикет",
            "Персидская кошка",
            "Петерболд",
            "Пиксибоб",
            "Рагамаффин",
            "Русская голубая кошка",
            "Рэгдолл",
            "Саванна",
            "Селкирк-рекс",
            "Сиамская кошка",
            "Сибирская кошка",
            "Сингапурская кошка",
            "Скоттиш-фолд",
            "Сноу-шу",
            "Сомалийская кошка",
            "Тайская кошка",
            "Тойгер",
            "Тонкинская кошка",
            "Турецкая ангорская кошка",
            "Турецкий ван",
            "Украинский левкой",
            "Чаузи",
            "Шартрез",
            "Экзотическая короткошерстная",
            "Японский бобтейл"
    };

    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

        System.out.println("База Подключена!");
    }

    // --------Создание таблицы--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'type' VARCHAR(100) NOT NULL);");

        System.out.println("Таблица создана или уже существует.");
    }

    // --------Вставка одной записи в таблицу types--------
    public static void insert_type (String s) throws SQLException
    {
        statmt.execute("INSERT INTO 'types' ('type') VALUES ('" + s + "'); ");

        System.out.println("Записано в таблицу types = " + s);
    }

    // --------Заполнение таблицы всеми типами пород кошек---------------
    public static void add_all_types() throws SQLException{

        for (int i = 0;i < types.length;i++) {
            statmt.execute("INSERT INTO 'types' ('type') VALUES ('" + types[i] + "'); ");
        }
        System.out.println("Все породы добавлены в таблицу");
    }

    //-------Удвление одной записи из таблицы types------
    public static void delete_type(int id) throws SQLException{
        statmt.execute("DELETE FROM 'types' WHERE id = " + id + "; ");

        System.out.println("Запись с id " + id + " удалена из таблицы types");
    }

    //-------Обновление одной записи в таблице types------
    public static void update_type(int id, String new_type) throws SQLException{
        statmt.execute("UPDATE 'types' SET 'type' = '" + new_type + "' WHERE id = " + id + "; ");

        System.out.println("Запись с id " + id + " обновлена в таблице types на значение " + new_type);
    }

    //------------Получить тип породы по id-----------
    public static void get_type(int i) throws ClassNotFoundException, SQLException{
        resSet = statmt.executeQuery("SELECT * FROM types WHERE id = " + i);

        int id = resSet.getInt("id");
        String  type = resSet.getString("type");
        System.out.print( "ID = " + id + "; ");
        System.out.println( "тип = " + type );
        System.out.println();
        System.out.println("Запись из таблицы types выведена");
        System.out.println();
    }

    //------------Получить тип породы по условию------
    public static void get_type_where(String where) throws ClassNotFoundException, SQLException{
        resSet = statmt.executeQuery("SELECT * FROM types WHERE " + where);

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  type = resSet.getString("type");
            System.out.print( "ID = " + id + "; ");
            System.out.println( "тип = " + type );
        }
        System.out.println();
        System.out.println("Записи из таблицы types, по условию '" + where + "' выведены");
        System.out.println();
    }

    //------------Получить список всех пород----------
    public static void get_all_types() throws ClassNotFoundException, SQLException{
        resSet = statmt.executeQuery("SELECT * FROM types");

        while(resSet.next())
        {
            int id = resSet.getInt("id");
            String  type = resSet.getString("type");
            System.out.print( "ID = " + id + "; ");
            System.out.println( "тип = " + type );
        }
        System.out.println();
        System.out.println("Таблица types выведена");
        System.out.println();
    }

    // --------Закрытие--------
    public static void CloseDB() throws ClassNotFoundException, SQLException
    {
        conn.close();
        statmt.close();
        resSet.close();

        System.out.println("Соединения закрыты");
    }

}
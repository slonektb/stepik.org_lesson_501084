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

    static String[] names = {"Гарфилд",
            "Том",
            "Гудвин",
            "Рокки",
            "Ленивец",
            "Пушок",
            "Спорти",
            "Бегемот",
            "Пират",
            "Гудини",
            "Зорро",
            "Саймон",
            "Альбус",
            "Базилио",
            "Леопольд",
            "Нарцисс",
            "Атос",
            "Каспер",
            "Валлито",
            "Оксфорд",
            "Бисквит",
            "Соня",
            "Клеопатра",
            "Цунами",
            "Забияка",
            "Матильда",
            "Кнопка",
            "Масяня",
            "Царапка",
            "Серсея",
            "Ворсинка",
            "Амели",
            "Наоми",
            "Маркиза",
            "Изольда",
            "Вальс",
            "Несквик",
            "Златан",
            "Баскет",
            "Изюм",
            "Цукат",
            "Мокко",
            "Месси",
            "Кокос",
            "Адидас",
            "Бейлиз",
            "Тайгер",
            "Зефир",
            "Мохи",
            "Валенсия",
            "Баунти",
            "Свити",
            "Текила",
            "Ириска",
            "Карамель",
            "Виски",
            "Кукуруза",
            "Гренка",
            "Фасолька",
            "Льдинка",
            "Китана",
            "Офелия",
            "Дайкири",
            "Брусника",
            "Аватар",
            "Космос",
            "Призрак",
            "Изумруд",
            "Плинтус",
            "Яндекс",
            "Крисмас",
            "Метеор",
            "Оптимус",
            "Смайлик",
            "Цельсий",
            "Краска",
            "Дейзи",
            "Пенка",
            "Веста",
            "Астра",
            "Эйприл",
            "Среда",
            "Бусинка",
            "Гайка",
            "Елка",
            "Золушка",
            "Мята",
            "Радость",
            "Сиам",
            "Оскар",
            "Феликс",
            "Гарри",
            "Байрон",
            "Чарли",
            "Симба",
            "Тао",
            "Абу",
            "Ватсон",
            "Енисей",
            "Измир",
            "Кайзер",
            "Васаби",
            "Байкал",
            "Багира",
            "Айрис",
            "Диана",
            "Мими",
            "Сакура",
            "Индия",
            "Тиффани",
            "Скарлетт",
            "Пикси",
            "Лиззи",
            "Алиса",
            "Лило",
            "Ямайка",
            "Пэрис",
            "Мальта",
            "Аляска"
    };
    // --------ПОДКЛЮЧЕНИЕ К БАЗЕ ДАННЫХ--------
    public static void Conn() throws ClassNotFoundException, SQLException
    {
        conn = null;
        Class.forName("org.sqlite.JDBC");
        conn = DriverManager.getConnection("jdbc:sqlite:My_cats.db");

        System.out.println("База Подключена!");
    }

    // --------Создание таблиц--------
    public static void CreateDB() throws ClassNotFoundException, SQLException
    {
        statmt = conn.createStatement();
        statmt.execute("CREATE TABLE if not exists 'types' ('id' INTEGER PRIMARY KEY AUTOINCREMENT, 'type' VARCHAR(100) NOT NULL);");

        System.out.println("Таблица types создана или уже существует.");

        statmt.execute("CREATE TABLE if not exists 'cats' " +
                                "('id' INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, " +
                                "'name' VARCHAR(20) NOT NULL," +
                                "'type_id' INTEGER REFERENCES types (id) NOT NULL," +
                                "'age' INTEGER NOT NULL," +
                                "'weight' DOUBLE);");

        System.out.println("Таблица cats создана или уже существует.");

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

    //--------Добавление котиков в базу---------
    public static void insert_cat(String name, String s, int age, Double weight) throws ClassNotFoundException, SQLException{
        // Выполняем проверку на сущещствование породы в базе
        resSet = statmt.executeQuery("SELECT * FROM types WHERE type = '" + s+ "'");
        boolean empty = true;
        int id_type = 0;
        while( resSet.next() ) {
            // Если resSet не пустой, то возвращаем лож
            empty = false;
            id_type = resSet.getInt("id");

        }

        if( empty ) {
            // resSet оказался пустым, записываем новый тип породы в базу
            statmt.execute("INSERT INTO 'types' ('type') VALUES ('" + s + "'); ");
            resSet = statmt.executeQuery("SELECT last_insert_rowid()");

            id_type = resSet.getInt(1);
        }
        // Записываем нового котика в базу
        statmt.execute("INSERT INTO 'cats' ('name','type_id','age','weight') VALUES ('" + name + "', " + id_type + ", " + age + "," + weight + "); ");
        System.out.println("Котик " + name + " добавлен в базу");

    }


    public static void add_more_cats(int n) throws SQLException, ClassNotFoundException {
        for (int i =0;i < n;i++){
            int n_type = (int)Math.floor(Math.random() * types.length);
            int n_name = (int)Math.floor(Math.random() * names.length);
            int n_age = (int)Math.floor(Math.random() * 15);
            double n_weight = Math.floor(Math.random() * 10);
            insert_cat(names[n_name],types[n_type],n_age,n_weight);
        }
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
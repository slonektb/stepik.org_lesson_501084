import java.sql.SQLException;

public class db {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conn.Conn();
        conn.CreateDB();
//        conn.insert_type("Абиссинская кошка");
//        conn.insert_type("Австралийский мист");
//        conn.insert_type("Американская жесткошерстная");
//        conn.add_all_types();
//        conn.delete_type(7);
//        conn.update_type(64, "Чаузи-маузи");
//        conn.get_type(64);
//        conn.get_type_where("id < 15");
//        conn.get_type_where("type LIKE '%а'");
//        conn.get_all_types();
//        conn.insert_cat("Вася","Дворянин",1,0.5); //type_id = 71
//        conn.insert_cat("Мурло","Русская голубая кошка",5,5.0); //type_id = 48
//        conn.insert_cat("Кокс","Черный демон",3,4.5);
//        conn.add_more_cats(5000);
        conn.delete_cat(5);
        conn.delete_cat("name = 'Сингапурская кошка'");
        conn.update_cat(4,"'name' = 'Марфа'","'name' = 'Чаузи'");

        conn.CloseDB();
    }
}
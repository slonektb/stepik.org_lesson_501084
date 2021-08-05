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
        conn.get_type(64);
        conn.get_type_where("id < 15");
        conn.get_type_where("type LIKE '%а'");
        conn.get_all_types();

        conn.CloseDB();
    }
}
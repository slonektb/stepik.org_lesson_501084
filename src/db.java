import java.sql.SQLException;

public class db {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        conn.Conn();
        conn.CreateDB();
//        conn.insert_type("Абиссинская кошка");
//        conn.insert_type("Австралийский мист");
//        conn.insert_type("Американская жесткошерстная");
//        conn.add_all_types();
        conn.delete_type(7);
        conn.update_type(64, "Чаузи-маузи");
        conn.CloseDB();
    }
}
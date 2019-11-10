package app;

public class App {
    public static void main( String[] args )
    {
        User user = new User("Robert", "Kowalski2", "123456789");
        Database db = new Database();
        db.addEntry(user);

        System.out.print(user.getPhone_number());
        System.out.println(db.findUserByName("Robert").getLast_name());
    }
}

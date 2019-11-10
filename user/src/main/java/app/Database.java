package app;

import java.util.ArrayList;
import java.util.List;


public class Database {

    public List<User> database;

    public Database() {
        this.database = new ArrayList<User>();

    }

    public void addEntry(User user) {
        this.database.add(user);
    }


    public User findUserByName(String first_name) throws NullPointerException {
        User result = null;

        for(User user: this.database){
            if(user.getFirst_name() == first_name) {
                return user;
            }
        }

        throw new NullPointerException("User is not present on database");
    }

    public void removeUserByName(String first_name) throws NullPointerException {
        User result = null;
        for(User user: this.database){
            if(user.getFirst_name() == first_name) {
                result = user;
            }
        }
        if(result == null){
            throw new NullPointerException("User was not added to database");
        }
        this.database.remove(result);
    }
}

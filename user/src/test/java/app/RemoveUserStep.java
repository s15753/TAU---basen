package app;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class RemoveUserStep {

    private User user1;
    private User user2;
    private User result_user;
    Database database;
    Exception exception;


    @Before
    public void setUp(){
        user1 = new User("Robert", "Kowalski", "123456789");
        user2 = new User("Kamil", "Barcik", "234567890");

        database.addEntry(user1);
        database.addEntry(user2);
    }

    @Given("^list of users in database$")
    public void list_of_users_in_database() throws Throwable {
        Assert.assertNotNull(database);
    }

    @When("^try to remove \"([a-zA-Z]+)\"$")
    public void try_to_select(String first_name) throws Throwable {
        database.removeUserByName(first_name);

        try {
            database.findUserByName(first_name);
        }
        catch (Exception e){
            exception = e;
        }
    }

    @Then("^the answer should be: NullPointerException$")
    public void the_answer_should_be() throws Throwable{
        Assert.assertEquals(exception.getMessage(), "User was not added to database");
        Assert.assertEquals(exception.getClass(), NullPointerException.class);
    }
}

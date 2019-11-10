package app;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SelectUserStep {
    private User user1;
    private User user2;
    private User result_user;
    Database database;


    @Before
    public void setUp(){
        user1 = new User("Robert", "Kowalski", "123456789");
        user2 = new User("Kamil", "Barcik", "234567890");

        database.addEntry(user1);
        database.addEntry(user2);
    }

    @Given("^take_list of users in database$")
    public void take_list_of_users_in_database() throws Throwable {
        Assert.assertNotNull(database);
    }

    @When("^try to select \"([a-zA-Z]+)\"$")
    public void try_to_select(String first_name) throws Throwable {
        result_user = database.findUserByName(first_name);
    }

    @Then("^the answer would be: \"([a-zA-Z]+)\"$")
    public void the_answer_would_be(String result) throws Throwable{
        Assert.assertEquals(result_user.getFirst_name(), result);
    }
}

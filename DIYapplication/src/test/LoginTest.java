package test;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
import controller.Controller;
import model.Model;
import view.Login;
import view.View;

class LoginTest {

	private Login a = new Login();
	private Controller controller = new Controller(a);

	@Test
	void testSetNameAndSetEmailString() {
		View view = new View(controller);
		Model m = new Model("testName", "test@email.com");
		controller.loginSuccess(view, m);
		assertEquals("testName", controller.getFirstName());
		assertEquals("test@email.com", controller.getEmailAddress());
	}
}

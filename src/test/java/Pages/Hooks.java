package Pages;

import Utilities.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	
	splashDevPage sDp = new splashDevPage();
	
	@Before
	public void setup() {
		BaseClass.getDriver();
	}
	@After
	public void tearDown() {
		BaseClass.teardDown();
	}
	
	

}

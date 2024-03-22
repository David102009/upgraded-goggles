package Utilities;

import Pages.loginPage;
import Pages.splashDevPage;

public class PageInitializer extends BaseClass {
	
	
	public static splashDevPage sDp;
	public static loginPage lP;

	public static void initialize() {
		
		
		sDp = new splashDevPage();
		lP = new loginPage();
	}
	
	
	
}

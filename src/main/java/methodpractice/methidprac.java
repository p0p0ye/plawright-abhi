package methodpractice;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class methidprac {

	public static void main(String[] args) {
		
		 try (Playwright playwright = Playwright.create()) {
		      Browser browser = playwright.chromium().launch();
		      Page page = browser.newPage();
		      page.navigate("https://playwright.dev/java/");
		page.innerText("#__docusaurus > div.main-wrapper > header > div > h1");
		System.out.println(	page.innerText("#__docusaurus > div.main-wrapper > header > div > h1"));
		      System.out.println(page.title());
		      
		  //    page.textContent(null, null);
	}

	}
}

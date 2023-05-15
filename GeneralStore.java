package API_Automation;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class GeneralStore {

	public static <T> void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub


		File loc=new File("C:\\Users\\rohithm\\Downloads");
		File apk=new File(loc,"General-Store.apk");


		DesiredCapabilities dc=new DesiredCapabilities();

		dc.setCapability(MobileCapabilityType.DEVICE_NAME, "Rohith");

		dc.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());

		dc.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");

		AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),dc);

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		driver.findElementById("android:id/text1").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));").click();
		driver.findElementByXPath("//android.widget.EditText[@text='Enter name here']").sendKeys("Rohith M Bhaktha");
		driver.findElementByXPath("//android.widget.RadioButton[@text='Male']").click();
		driver.findElementById("com.androidsample.generalstore:id/btnLetsShop").click();
		//driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Air Jordan 9 Retro\").instance(0))"));
		//int allproducts = driver.findElementsById("com.androidsample.generalstore:id/productName").size();
		//		for(int i=0; i<=allproducts;i++)
		//		{
		//			String text = driver.findElementsById("com.androidsample.generalstore:id/productName").get(i).getText();
		//			if(text.equalsIgnoreCase("Air Jordan 9 Retro"))
		//			{
		//				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(i).click();
		//		        driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		//				//driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		//				//driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		//				driver.findElementsById("com.androidsample.generalstore:id/productAddCart").get(0).click();
		//
		//			}
		//			
		//			
		//			
		//			driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		//			//driver.findElementById("com.androidsample.generalstore:id/appbar_btn_back").click();
		//		}

		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementsByXPath("//*[@text='ADD TO CART']").get(0).click();
		driver.findElementById("com.androidsample.generalstore:id/appbar_btn_cart").click();
		String price1 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(0).getText();
		String price2 = driver.findElementsById("com.androidsample.generalstore:id/productPrice").get(1).getText();

		String onlyprice = price1.substring(1);
		double number = Double.parseDouble(onlyprice);
		System.out.println("Air jordan 4 Retro price is "+onlyprice);


		String onlyprice1 = price2.substring(1);
		double number1 = Double.parseDouble(onlyprice1);

		System.out.println("Air jordan 1 Mid SE price is "+onlyprice1);
		double total = number1 + number;
		System.out.println("Total Amount for both shoe is ="+total);

		//		AndroidElement title = driver.findElementById("com.androidsample.generalstore:id/toolbar_title");
		//		Assert.assertEquals(title.getText(), "Cart");
	}
}




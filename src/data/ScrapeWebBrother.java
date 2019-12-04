package data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrapeWebBrother extends Scraper{

	@Override
	public void createPrinterList(String ip) {
		try {
            logIn(ip);
            Thread.sleep(800);
            List<String> printerInfo = getPrinterInfo(webDriver.getCurrentUrl());
            Thread.sleep(800);
            List<Integer> printerLevels = getPrinterLevels();
            Thread.sleep(800);
            webDriver.quit();

            Printer p = new Printer(printerInfo, printerLevels);
            printerList.add(p);

        } catch (Exception e) {
            System.out.println(e);
        }
	}
	
	private void logIn(String address) throws InterruptedException, IOException {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\carrilloc.YGA\\Documents\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-position=-32000,-32000");
        webDriver = new ChromeDriver(options);
        webDriver.get(address);
    }
	
	private List<String> getPrinterInfo(String address) {
        List<String> printerInfo = new ArrayList<>();
        List<String> info = new ArrayList<>();
        doc = Jsoup.parse(webDriver.getPageSource());
        
        el = doc.getElementsByTag("dd");
        el.forEach(e->printerInfo.add(e.text().toString()));
        
        info = printerInfo.subList(0,  2);
        info.add(webDriver.getCurrentUrl().toString());

        return info;
    }
	
	
	private List<Integer> getPrinterLevels() throws InterruptedException {
		List<String> printerInfo = new ArrayList<>();
		List<String> stringPrinterLevels = new ArrayList<>();
        List<Integer> printerLevels = new ArrayList<>();

        doc = Jsoup.parse(webDriver.getPageSource());

        el = doc.getElementsByTag("dd");
        el.forEach(e->printerInfo.add(e.text().toString()));

        printerInfo.removeIf(e->e.contains("pages") || 
        		e.isEmpty() || e.equals("0"));
        printerInfo.subList(2, 18).clear();
        printerInfo.subList(13, printerInfo.size()).clear();
        
        List<String> toners = printerInfo.subList(9, printerInfo.size());
        List<String> IU = printerInfo.subList(2, 6);
        List<String> belts = new ArrayList<>(printerInfo.subList(6, 9));
        
        String paperFeed = belts.get(2);
        belts.add(1, paperFeed);
        belts.remove(belts.size()-1);
        
        toners = stripExtraChars(toners);
        IU = stripExtraChars(IU);
        belts = stripExtraChars(belts);
        
        stringPrinterLevels.addAll(toners);
        stringPrinterLevels.addAll(IU);
        stringPrinterLevels.addAll(belts);
        
        stringPrinterLevels.stream()
        .forEach(e-> {
        		int parsed = (int)Math.floor(Double.parseDouble(e));
        		printerLevels.add(parsed);
        	});
        return printerLevels;
    }
	
	private List<String> stripExtraChars(List<String> list) {
		return list.stream()
		.map(e->e.replace("(", ""))
		.map(e->e.replace(")", ""))
		.map(e->e.replace("%", ""))
		.collect(Collectors.toList());
	}
	

}

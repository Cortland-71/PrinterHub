package data;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;


import org.jsoup.Jsoup;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ScrapeWebSmallKonica extends Scraper {

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

        WebElement radio = webDriver.findElement(By.id("public"));
        radio.click();
        WebElement submit = webDriver.findElement(By.cssSelector("input[type='submit'][value='Log in']"));
        submit.click();
    }

    private List<String> getPrinterInfo(String address) {
        List<String> printerInfo = new ArrayList<>();
        doc = Jsoup.parse(webDriver.getPageSource());
        el = doc.getElementsByClass("main1_i");

        el.forEach(e->printerInfo.add(e.text().toString()));
        printerInfo.removeIf(e->e.equals(""));
        IntStream.range(0,2).forEach(e->printerInfo.remove(0));
        IntStream.range(0,4).forEach(e->printerInfo.remove(1));
        printerInfo.add(address);
        return printerInfo;
    }

    private List<Integer> getPrinterLevels() throws InterruptedException {
        List<String> printerPercents = new ArrayList<>();
        List<String> printerLevelsStrings = new ArrayList<>();
        List<Integer> printerLevels = new ArrayList<>();

        WebElement consumableButton = webDriver.findElement(By.linkText("Consumables"));
        consumableButton.click();

        doc = Jsoup.parse(webDriver.getPageSource());
        el = doc.select("td.consumable[headers=num]");
        el.forEach(e->printerPercents.add(e.text().toString()));

        printerLevelsStrings = printerPercents.stream()
                .map(e->e.replace("%", ""))
                .collect(Collectors.toList());

        printerLevelsStrings.removeIf(e->e.equals(""));

        printerLevels = printerLevelsStrings.stream()
                .map(Integer::parseInt).collect(Collectors.toList());

        return printerLevels;
    }
}

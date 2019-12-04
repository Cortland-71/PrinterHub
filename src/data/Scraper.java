package data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;

public abstract class Scraper {
	
	protected static WebDriver webDriver;
    protected static Document doc;
    protected static Elements el;
    protected List<String> ipList = new ArrayList<>();
    protected List<Printer> printerList = new ArrayList<>();
    
    public void readIPCSV(String path) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(path));
        while (sc.hasNext()) {
            ipList.add(sc.next());
        }
        sc.close();
    }
    
    public abstract void createPrinterList(String ip);

    public List<String> getIpList() {
        return ipList;
    }

    public List<Printer> getPrinterList() {
        return printerList;
    }

}

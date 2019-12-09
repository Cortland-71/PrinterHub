package controller;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.*;

import data.*;
import view.View;

public class Driver {
	
	private static List<Printer> allPrinters = new ArrayList<>();

    public static void main(String[] args) throws IOException, InterruptedException {

    	String smallKonicaPath = "C:\\Users\\carrilloc.YGA\\Desktop\\PrinterURLs\\SmallKonicaIPs.csv";
    	String brotherPath = "C:\\Users\\carrilloc.YGA\\Desktop\\PrinterURLs\\BrotherIPs.csv";
    	
        ScrapeWebSmallKonica smallKonicaScrape = new ScrapeWebSmallKonica();
        ScrapeWebBrother brotherScrape = new ScrapeWebBrother();
        
        smallKonicaScrape.readIPCSV(smallKonicaPath);
        brotherScrape.readIPCSV(brotherPath);

        while (true) {
        	
            for (String ip : smallKonicaScrape.getIpList()) {
                smallKonicaScrape.createPrinterList(ip);
                smallKonicaScrape.getWebDriver().quit();
            }
            
            
            for (String ip : brotherScrape.getIpList()) {
            	brotherScrape.createPrinterList(ip);
            	brotherScrape.getWebDriver().quit();
            }
            
            
            allPrinters.addAll(smallKonicaScrape.getPrinterList());
            allPrinters.addAll(brotherScrape.getPrinterList());
            
            View view = View.getInstance(allPrinters);
            view.getFrame().setVisible(true);
            view.updateView();
            TimeUnit.MINUTES.sleep(120);
            allPrinters.clear();
            smallKonicaScrape.getPrinterList().clear();
            brotherScrape.getPrinterList().clear();
        }
    }
}

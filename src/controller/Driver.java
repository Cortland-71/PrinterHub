package controller;
import data.ScrapeWebSmallKonica;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import view.*;

public class Driver {

    public static void main(String[] args) throws IOException, InterruptedException {

        ScrapeWebSmallKonica smallKonicaScrape = new ScrapeWebSmallKonica();
        smallKonicaScrape.readSmallKonicaIpCSV();

        while (true) {
            for (String ip : smallKonicaScrape.getIpList()) {
                smallKonicaScrape.createPrinterList(ip);
            }
            View view = View.getInstance(smallKonicaScrape.getPrinterList());
            view.getFrame().setVisible(true);
            view.updateView();
            TimeUnit.MINUTES.sleep(1);
            smallKonicaScrape.getPrinterList().clear();
        }
    }
}

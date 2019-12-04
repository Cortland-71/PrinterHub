package data;

import java.util.*;

public class Printer {

    private String name = "Error";
    private String serialNumber = "Error";
    private String ip;

    private int cyanToner = 0;
    private int magentaToner = 0;
    private int yellowToner = 0;
    private int blackToner = 0;

    private int cyanIU = 0;
    private int magentaIU = 0;
    private int yellowIU = 0;
    private int blackIU = 0;

    private int transferBelt = 0;
    private int transferRoller = 0;
    private int fuserUnit = 0;

    public Printer(List<String> printerInfo, List<Integer> printerLevels) {
        this.name = printerInfo.get(0);
        this.serialNumber = printerInfo.get(1);
        this.ip = printerInfo.get(2);

        this.cyanToner = printerLevels.get(0);
        this.magentaToner = printerLevels.get(1);
        this.yellowToner = printerLevels.get(2);
        this.blackToner = printerLevels.get(3);

        this.cyanIU = printerLevels.get(4);
        this.magentaIU = printerLevels.get(5);
        this.yellowIU = printerLevels.get(6);
        this.blackIU = printerLevels.get(7);

        this.transferBelt = printerLevels.get(8);
        this.transferRoller = printerLevels.get(9);
        this.fuserUnit = printerLevels.get(10);
    }

    @Override
    public String toString() {
        return "data.Printer{" +
                "name='" + name + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", ip='" + ip + '\'' +
                ", cyanToner=" + cyanToner +
                ", magentaToner=" + magentaToner +
                ", yellowToner=" + yellowToner +
                ", blackToner=" + blackToner +
                ", cyanIU=" + cyanIU +
                ", magentaIU=" + magentaIU +
                ", yellowIU=" + yellowIU +
                ", blackIU=" + blackIU +
                ", transferBelt=" + transferBelt +
                ", transferRoller=" + transferRoller +
                ", fuserUnit=" + fuserUnit +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getIp() {
        return ip;
    }

    public int getCyanToner() {
        return cyanToner;
    }

    public int getMagentaToner() {
        return magentaToner;
    }

    public int getYellowToner() {
        return yellowToner;
    }

    public int getBlackToner() {
        return blackToner;
    }

    public int getCyanIU() {
        return cyanIU;
    }

    public int getMagentaIU() {
        return magentaIU;
    }

    public int getYellowIU() {
        return yellowIU;
    }

    public int getBlackIU() {
        return blackIU;
    }

    public int getTransferBelt() {
        return transferBelt;
    }

    public int getTransferRoller() {
        return transferRoller;
    }

    public int getFuserUnit() {
        return fuserUnit;
    }
}

package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import data.Printer;

public class View {

    private static List<Printer> printerList = new ArrayList<>();
    private static List<PrinterOutputView> outputList = new ArrayList<>();
    public static final Color STD_BG = new Color(41,41,41);
    public static final Color STD_FG = new Color(255,177,43);

    private static View singleView = null;

    private JFrame frame;
    private View() throws IOException {
        frame = new JFrame("Cortland's Printer HUB v1.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1080,800);
        frame.setLocation(1924, 0);
        frame.add(mainPanel());
    }

    public static View getInstance(List<Printer> p) throws IOException {
        printerList = p;
        if (singleView == null)
            singleView = new View();

        return singleView;
    }

    public JFrame getFrame() {
        return this.frame;
    }

    private JPanel mainPanel() throws IOException {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(logoPanel(), BorderLayout.NORTH);
        mainPanel.add(scrollPane(), BorderLayout.CENTER);
        return mainPanel;
    }
    
    private JPanel logoPanel() throws IOException {
    	JPanel logoPanel = new JPanel();
    	logoPanel.setBackground(STD_BG);
    	BufferedImage background = ImageIO.read(getClass().getResource("/PrinterLogo5.png"));
    	logoPanel.add(new JLabel(new ImageIcon(background)));
    	return logoPanel;
    }

    private JScrollPane scrollPane() {
        JScrollPane scrollPane = new JScrollPane(scrollPanePanel());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        return scrollPane;
    }

    private JPanel scrollPanePanel;
    private JPanel scrollPanePanel() {
        scrollPanePanel = new JPanel();
        scrollPanePanel.setLayout(new GridLayout(printerList.size(),1));
        PrinterOutputView pov = null;

        for (@SuppressWarnings("unused") Printer p : printerList) {
            pov = new PrinterOutputView();
            outputList.add(pov);
        }

        for (PrinterOutputView outputView : outputList) {
            scrollPanePanel.add(outputView.outputPanel());
        }
        return scrollPanePanel;
    }

    public void updateView() {
        for (int i=0; i<outputList.size(); i++) {
            outputList.get(i).setNameLabel(printerList.get(i).getName());
            outputList.get(i).setIPLabel(printerList.get(i).getIp());
            outputList.get(i).setSNLabel(printerList.get(i).getSerialNumber());

            //Toner
            outputList.get(i).setCyanBar(printerList.get(i).getCyanToner());
            outputList.get(i).setCyanNumberAmountLabel(printerList.get(i).getCyanToner());

            outputList.get(i).setMagentaBar(printerList.get(i).getMagentaToner());
            outputList.get(i).setMagentaNumberAmountLabel(printerList.get(i).getMagentaToner());

            outputList.get(i).setYellowBar(printerList.get(i).getYellowToner());
            outputList.get(i).setYellowNumberAmountLabel(printerList.get(i).getYellowToner());

            outputList.get(i).setBlackBar(printerList.get(i).getBlackToner());
            outputList.get(i).setBlackNumberAmountLabel(printerList.get(i).getBlackToner());

            //IU
            outputList.get(i).setCyanIUBar(printerList.get(i).getCyanIU());
            outputList.get(i).setCyanIUNumberAmountLabel(printerList.get(i).getCyanIU());

            outputList.get(i).setMagentaIUBar(printerList.get(i).getMagentaIU());
            outputList.get(i).setMagentaIUNumberAmountLabel(printerList.get(i).getMagentaIU());

            outputList.get(i).setYellowIUBar(printerList.get(i).getYellowIU());
            outputList.get(i).setYellowIUNumberAmountLabel(printerList.get(i).getYellowIU());

            outputList.get(i).setBlackIUBar(printerList.get(i).getBlackIU());
            outputList.get(i).setBlackIUNumberAmountLabel(printerList.get(i).getBlackIU());

            //Belts and other
            outputList.get(i).setTransferBeltBar(printerList.get(i).getTransferBelt());
            outputList.get(i).setTransferBeltNumberAmountLabel(printerList.get(i).getTransferBelt());

            outputList.get(i).setTransferRollerBar(printerList.get(i).getTransferRoller());
            outputList.get(i).setTransferRollerNumberAmountLabel(printerList.get(i).getTransferRoller());

            outputList.get(i).setFuserUnitBar(printerList.get(i).getFuserUnit());
            outputList.get(i).setFuserUnitNumberAmountLabel(printerList.get(i).getFuserUnit());
        }
    }
}

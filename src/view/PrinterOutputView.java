package view;

import javax.swing.*;
import java.awt.*;

public class PrinterOutputView {

    private final int TOP = 5;
    private final int LEFT = 5;
    private final int BOTTOM = 5;
    private final int RIGHT = 5;
    private final int STD_BAR_WIDTH = 250;
    private final int STD_BAR_HEIGHT = 15;
    private final int LONG_BAR_WIDTH = 600;
    private final int LONG_BAR_HEIGHT = 15;
    private final int LONG_BOTTOM = 20;
    private final int GAP = 10;

    private GridBagConstraints c = new GridBagConstraints();

    //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/
    JPanel outputPanel;
    public JPanel outputPanel() {
        outputPanel = new JPanel();
        outputPanel.setLayout(new BorderLayout());
        outputPanel.setBackground(View.STD_BG);
        outputPanel.setPreferredSize(new Dimension(0,300));
        outputPanel.add(northPanel(), BorderLayout.NORTH);
        outputPanel.add(centerPanel(), BorderLayout.CENTER);
        outputPanel.add(southPanel(), BorderLayout.SOUTH);
        return outputPanel;
    }

    //\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/NORTH PANEL
    JPanel northPanel;
    private JPanel northPanel() {
        northPanel = new JPanel();
        northPanel.setLayout(new BorderLayout());
        northPanel.setBackground(Color.BLACK);
        northPanel.add(westInNorthPanel(), BorderLayout.WEST);
        return northPanel;
    }

    private JPanel westInNorthPanel() {
        JPanel westInNorthPanel = new JPanel();
        westInNorthPanel.setLayout(new GridBagLayout());
        westInNorthPanel.setBackground(null);
        westInNorthPanel.add(nameLabel(), c);
        westInNorthPanel.add(SNLabel(), c);
        westInNorthPanel.add(IPLabel(), c);
        return westInNorthPanel;
    }

    private JLabel nameLabel;
    private JLabel nameLabel() {
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(10,15,10,10);
        nameLabel = new JLabel("Name: ");
        setFont(nameLabel, Color.WHITE, 15);
        return nameLabel;
    }
    public void setNameLabel(String name) {
        nameLabel.setText("Name: " + name);
    }

    private JLabel SNLabel;
    private JLabel SNLabel() {
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(10,10,10,10);
        SNLabel = new JLabel("SN: ");
        setFont(SNLabel, Color.WHITE, 15);
        return SNLabel;
    }
    public void setSNLabel(String sn) {
        SNLabel.setText("SN: " + sn);
    }

    private JLabel IPLabel;
    private JLabel IPLabel() {
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(10,10,10,10);
        IPLabel = new JLabel("IP: ");
        setFont(IPLabel, Color.WHITE, 15);
        return IPLabel;
    }
    public void setIPLabel(String ip) {
        IPLabel.setText("IP: " + ip);
    }

    ////\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/South in output Panel
    private JPanel southPanel() {
        JPanel southInWestPanel = new JPanel();
        southInWestPanel.setBackground(null);
        southInWestPanel.setLayout(new GridBagLayout());

        southInWestPanel.add(transferBeltLabel(), c);
        southInWestPanel.add(transferBeltBar(), c);
        southInWestPanel.add(transferBeltNumberAmountLabel(), c);

        southInWestPanel.add(transferRollerLabel(), c);
        southInWestPanel.add(transferRollerBar(), c);
        southInWestPanel.add(transferRollerNumberAmountLabel(), c);

        southInWestPanel.add(fuserUnitLabel(), c);
        southInWestPanel.add(fuserUnitBar(), c);
        southInWestPanel.add(fuserUnitNumberAmountLabel(), c);
        return southInWestPanel;
    }

    //Transfer Belt
    private JLabel transferBeltLabel() {
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        JLabel transferBeltLabel = new JLabel("Transfer belt");
        setFont(transferBeltLabel, Color.ORANGE, 15);
        return transferBeltLabel;
    }

    private JProgressBar transferBeltBar;
    private JProgressBar transferBeltBar() {
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        transferBeltBar = new JProgressBar();
        transferBeltBar.setPreferredSize(new Dimension(LONG_BAR_WIDTH, LONG_BAR_HEIGHT));
        transferBeltBar.setForeground(new Color(201,201,201));
        transferBeltBar.setBackground(Color.GRAY);
        transferBeltBar.setMaximum(100);
        transferBeltBar.setMinimum(0);
        return transferBeltBar;
    }
    public void setTransferBeltBar(int amount) {
        transferBeltBar.setValue(amount);
    }

    private JLabel transferBeltNumberAmountLabel;
    private JLabel transferBeltNumberAmountLabel() {
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        transferBeltNumberAmountLabel = new JLabel();
        setFont(transferBeltNumberAmountLabel, Color.ORANGE, 15);
        return transferBeltNumberAmountLabel;
    }
    public void setTransferBeltNumberAmountLabel(int amount) {
        transferBeltNumberAmountLabel.setText(amount +"/100");
    }

    //Transfer Roller
    private JLabel transferRollerLabel() {
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        JLabel transferRollerLabel = new JLabel("Transfer belt");
        setFont(transferRollerLabel, Color.ORANGE, 15);
        return transferRollerLabel;
    }

    private JProgressBar transferRollerBar;
    private JProgressBar transferRollerBar() {
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        transferRollerBar = new JProgressBar();
        transferRollerBar.setPreferredSize(new Dimension(LONG_BAR_WIDTH, LONG_BAR_HEIGHT));
        transferRollerBar.setForeground(new Color(201,201,201));
        transferRollerBar.setBackground(Color.GRAY);
        transferRollerBar.setMaximum(100);
        transferRollerBar.setMinimum(0);
        return transferRollerBar;
    }
    public void setTransferRollerBar(int amount) {
        transferRollerBar.setValue(amount);
    }

    private JLabel transferRollerNumberAmountLabel;
    private JLabel transferRollerNumberAmountLabel() {
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        transferRollerNumberAmountLabel = new JLabel();
        setFont(transferRollerNumberAmountLabel, Color.ORANGE, 15);
        return transferRollerNumberAmountLabel;
    }
    public void setTransferRollerNumberAmountLabel(int amount) {
        transferRollerNumberAmountLabel.setText(amount +"/100");
    }

    //Fuser Unit
    private JLabel fuserUnitLabel() {
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, LEFT, LONG_BOTTOM, RIGHT);
        JLabel fuserUnitLabel = new JLabel("Fuser unit");
        setFont(fuserUnitLabel, Color.ORANGE, 15);
        return fuserUnitLabel;
    }

    private JProgressBar fuserUnitBar;
    private JProgressBar fuserUnitBar() {
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(TOP, LEFT, LONG_BOTTOM, RIGHT);
        fuserUnitBar = new JProgressBar();
        fuserUnitBar.setPreferredSize(new Dimension(LONG_BAR_WIDTH, LONG_BAR_HEIGHT));
        fuserUnitBar.setForeground(Color.RED);
        fuserUnitBar.setBackground(Color.GRAY);
        fuserUnitBar.setMaximum(100);
        fuserUnitBar.setMinimum(0);
        return fuserUnitBar;
    }
    public void setFuserUnitBar(int amount) {
        fuserUnitBar.setValue(amount);
    }

    private JLabel fuserUnitNumberAmountLabel;
    private JLabel fuserUnitNumberAmountLabel() {
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(TOP, LEFT, LONG_BOTTOM, RIGHT);
        fuserUnitNumberAmountLabel = new JLabel();
        setFont(fuserUnitNumberAmountLabel, Color.ORANGE, 15);
        return fuserUnitNumberAmountLabel;
    }
    public void setFuserUnitNumberAmountLabel(int amount) {
        fuserUnitNumberAmountLabel.setText(amount +"/100");
    }

    ////\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/Center panel in outputPanel

    private JPanel centerPanel;
    private JPanel centerPanel() {
        centerPanel = new JPanel();
        centerPanel.setLayout(new GridBagLayout());
        centerPanel.setBackground(null);
        centerPanel.add(cyanTonerLabel(), c);
        centerPanel.add(cyanBar(), c);
        centerPanel.add(cyanNumberAmountLabel(), c);

        centerPanel.add(magentaTonerLabel(), c);
        centerPanel.add(magentaBar(), c);
        centerPanel.add(magentaNumberAmountLabel(), c);

        centerPanel.add(yellowTonerLabel(), c);
        centerPanel.add(yellowBar(), c);
        centerPanel.add(yellowNumberAmountLabel(), c);

        centerPanel.add(blackTonerLabel(), c);
        centerPanel.add(blackBar(), c);
        centerPanel.add(blackNumberAmountLabel(), c);

        centerPanel.add(cyanIULabel(), c);
        centerPanel.add(cyanIUBar(), c);
        centerPanel.add(cyanIUNumberAmountLabel(), c);

        centerPanel.add(magentaIULabel(), c);
        centerPanel.add(magentaIUBar(), c);
        centerPanel.add(magentaIUNumberAmountLabel(), c);

        centerPanel.add(yellowIULabel(), c);
        centerPanel.add(yellowIUBar(), c);
        centerPanel.add(yellowIUNumberAmountLabel(), c);

        centerPanel.add(blackIULabel(), c);
        centerPanel.add(blackIUBar(), c);
        centerPanel.add(blackIUNumberAmountLabel(), c);
        return centerPanel;
    }

    //Cyan
    private JLabel cyanTonerLabel() {
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        JLabel cyanTonerLabel = new JLabel("Cyan");
        setFont(cyanTonerLabel, Color.ORANGE, 15);
        return cyanTonerLabel;
    }

    private JProgressBar cyanBar;
    private JProgressBar cyanBar() {
        c.gridx = 1;
        c.gridy = 0;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        cyanBar = new JProgressBar();
        cyanBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        cyanBar.setForeground(Color.CYAN);
        cyanBar.setBackground(Color.GRAY);
        cyanBar.setMaximum(100);
        cyanBar.setMinimum(0);
        return cyanBar;
    }
    public void setCyanBar(int amount) {
        cyanBar.setValue(amount);
    }

    private JLabel cyanNumberAmountLabel;
    private JLabel cyanNumberAmountLabel() {
        c.gridx = 2;
        c.gridy = 0;
        c.insets = new Insets(TOP, LEFT, BOTTOM, GAP);
        cyanNumberAmountLabel = new JLabel();
        setFont(cyanNumberAmountLabel, Color.ORANGE, 15);
        return cyanNumberAmountLabel;
    }
    public void setCyanNumberAmountLabel(int amount) {
        cyanNumberAmountLabel.setText(amount +"/100");
    }

    //Magenta
    private JLabel magentaTonerLabel() {
        c.gridx = 0;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        JLabel magentaTonerLabel = new JLabel("Magenta");
        setFont(magentaTonerLabel, Color.ORANGE, 15);
        return magentaTonerLabel;
    }

    private JProgressBar magentaBar;
    private JProgressBar magentaBar() {
        c.gridx = 1;
        c.gridy = 1;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        magentaBar = new JProgressBar();
        magentaBar.setForeground(Color.MAGENTA);
        magentaBar.setBackground(Color.GRAY);
        magentaBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        magentaBar.setMaximum(100);
        magentaBar.setMinimum(0);
        return magentaBar;
    }
    public void setMagentaBar(int amount) {
        magentaBar.setValue(amount);
    }

    private JLabel magentaNumberAmountLabel;
    private JLabel magentaNumberAmountLabel() {
        c.gridx = 2;
        c.gridy = 1;
        c.insets = new Insets(TOP, LEFT, BOTTOM, GAP);
        magentaNumberAmountLabel = new JLabel();
        setFont(magentaNumberAmountLabel, Color.ORANGE, 15);
        return magentaNumberAmountLabel;
    }
    public void setMagentaNumberAmountLabel(int amount) {
        magentaNumberAmountLabel.setText(amount +"/100");
    }

    //Yellow
    private JLabel yellowTonerLabel() {
        c.gridx = 0;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        JLabel yellowTonerLabel = new JLabel("Yellow");
        setFont(yellowTonerLabel, Color.ORANGE, 15);
        return yellowTonerLabel;
    }

    private JProgressBar yellowBar;
    private JProgressBar yellowBar() {
        c.gridx = 1;
        c.gridy = 2;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        yellowBar = new JProgressBar();
        yellowBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        yellowBar.setForeground(Color.YELLOW);
        yellowBar.setBackground(Color.GRAY);
        yellowBar.setMaximum(100);
        yellowBar.setMinimum(0);
        return yellowBar;
    }
    public void setYellowBar(int amount) {
        yellowBar.setValue(amount);
    }

    private JLabel yellowNumberAmountLabel;
    private JLabel yellowNumberAmountLabel() {
        c.gridx = 2;
        c.gridy = 2;
        c.insets = new Insets(TOP, LEFT, BOTTOM, GAP);
        yellowNumberAmountLabel = new JLabel();
        setFont(yellowNumberAmountLabel, Color.ORANGE, 15);
        return yellowNumberAmountLabel;
    }
    public void setYellowNumberAmountLabel(int amount) {
        yellowNumberAmountLabel.setText(amount +"/100");
    }

    //black
    private JLabel blackTonerLabel() {
        c.gridx = 0;
        c.gridy = 3;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        JLabel blackTonerLabel = new JLabel("Black");
        setFont(blackTonerLabel, Color.ORANGE, 15);
        return blackTonerLabel;
    }

    private JProgressBar blackBar;
    private JProgressBar blackBar() {
        c.gridx = 1;
        c.gridy = 3;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        blackBar = new JProgressBar();
        blackBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        blackBar.setForeground(Color.BLACK);
        blackBar.setBackground(Color.GRAY);
        blackBar.setMaximum(100);
        blackBar.setMinimum(0);
        return blackBar;
    }
    public void setBlackBar(int amount) {
        blackBar.setValue(amount);
    }

    private JLabel blackNumberAmountLabel;
    private JLabel blackNumberAmountLabel() {
        c.gridx = 2;
        c.gridy = 3;
        c.insets = new Insets(TOP, LEFT, BOTTOM, GAP);
        blackNumberAmountLabel = new JLabel();
        setFont(blackNumberAmountLabel, Color.ORANGE, 15);
        return blackNumberAmountLabel;
    }
    public void setBlackNumberAmountLabel(int amount) {
        blackNumberAmountLabel.setText(amount +"/100");
    }

    //IU
    //cyan IU
    private JLabel cyanIULabel() {
        c.gridx = 3;
        c.gridy = 0;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, GAP, BOTTOM, RIGHT);
        JLabel cyanIULabel = new JLabel("Cyan IU");
        setFont(cyanIULabel, Color.ORANGE, 15);
        return cyanIULabel;
    }

    private JProgressBar cyanIUBar;
    private JProgressBar cyanIUBar() {
        c.gridx = 4;
        c.gridy = 0;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        cyanIUBar = new JProgressBar();
        cyanIUBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        cyanIUBar.setForeground(Color.CYAN);
        cyanIUBar.setBackground(Color.GRAY);
        cyanIUBar.setMaximum(100);
        cyanIUBar.setMinimum(0);
        return cyanIUBar;
    }
    public void setCyanIUBar(int amount) {
        cyanIUBar.setValue(amount);
    }

    private JLabel cyanIUNumberAmountLabel;
    private JLabel cyanIUNumberAmountLabel() {
        c.gridx = 5;
        c.gridy = 0;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        cyanIUNumberAmountLabel = new JLabel();
        setFont(cyanIUNumberAmountLabel, Color.ORANGE, 15);
        return cyanIUNumberAmountLabel;
    }
    public void setCyanIUNumberAmountLabel(int amount) {
        cyanIUNumberAmountLabel.setText(amount +"/100");
    }

    //Magenta IU
    private JLabel magentaIULabel() {
        c.gridx = 3;
        c.gridy = 1;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, GAP, BOTTOM, RIGHT);
        JLabel magentaIULabel = new JLabel("Magenta IU");
        setFont(magentaIULabel, Color.ORANGE, 15);
        return magentaIULabel;
    }

    private JProgressBar magentaIUBar;
    private JProgressBar magentaIUBar() {
        c.gridx = 4;
        c.gridy = 1;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        magentaIUBar = new JProgressBar();
        magentaIUBar.setForeground(Color.MAGENTA);
        magentaIUBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        magentaIUBar.setBackground(Color.GRAY);
        magentaIUBar.setMaximum(100);
        magentaIUBar.setMinimum(0);
        return magentaIUBar;
    }
    public void setMagentaIUBar(int amount) {
        magentaIUBar.setValue(amount);
    }

    private JLabel magentaIUNumberAmountLabel;
    private JLabel magentaIUNumberAmountLabel() {
        c.gridx = 5;
        c.gridy = 1;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        magentaIUNumberAmountLabel = new JLabel();
        setFont(magentaIUNumberAmountLabel, Color.ORANGE, 15);
        return magentaIUNumberAmountLabel;
    }
    public void setMagentaIUNumberAmountLabel(int amount) {
        magentaIUNumberAmountLabel.setText(amount +"/100");
    }

    //Yellow IU
    private JLabel yellowIULabel() {
        c.gridx = 3;
        c.gridy = 2;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, GAP, BOTTOM, RIGHT);
        JLabel yellowIULabel = new JLabel("Yellow IU");
        setFont(yellowIULabel, Color.ORANGE, 15);
        return yellowIULabel;
    }

    private JProgressBar yellowIUBar;
    private JProgressBar yellowIUBar() {
        c.gridx = 4;
        c.gridy = 2;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        yellowIUBar = new JProgressBar();
        yellowIUBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        yellowIUBar.setForeground(Color.YELLOW);
        yellowIUBar.setBackground(Color.GRAY);
        yellowIUBar.setMaximum(100);
        yellowIUBar.setMinimum(0);
        return yellowIUBar;
    }
    public void setYellowIUBar(int amount) {
        yellowIUBar.setValue(amount);
    }

    private JLabel yellowIUNumberAmountLabel;
    private JLabel yellowIUNumberAmountLabel() {
        c.gridx = 5;
        c.gridy = 2;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        yellowIUNumberAmountLabel = new JLabel();
        setFont(yellowIUNumberAmountLabel, Color.ORANGE, 15);
        return yellowIUNumberAmountLabel;
    }
    public void setYellowIUNumberAmountLabel(int amount) {
        yellowIUNumberAmountLabel.setText(amount +"/100");
    }

    //black IU
    private JLabel blackIULabel() {
        c.gridx = 3;
        c.gridy = 3;
        c.anchor = GridBagConstraints.EAST;
        c.insets = new Insets(TOP, GAP, BOTTOM, RIGHT);
        JLabel blackIULabel = new JLabel("Black IU");
        setFont(blackIULabel, Color.ORANGE, 15);
        return blackIULabel;
    }

    private JProgressBar blackIUBar;
    private JProgressBar blackIUBar() {
        c.gridx = 4;
        c.gridy = 3;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        blackIUBar = new JProgressBar();
        blackIUBar.setPreferredSize(new Dimension(STD_BAR_WIDTH, STD_BAR_HEIGHT));
        blackIUBar.setForeground(Color.BLACK);
        blackIUBar.setBackground(Color.GRAY);
        blackIUBar.setMaximum(100);
        blackIUBar.setMinimum(0);
        return blackIUBar;
    }
    public void setBlackIUBar(int amount) {
        blackIUBar.setValue(amount);
    }

    private JLabel blackIUNumberAmountLabel;
    private JLabel blackIUNumberAmountLabel() {
        c.gridx = 5;
        c.gridy = 3;
        c.insets = new Insets(TOP, LEFT, BOTTOM, RIGHT);
        blackIUNumberAmountLabel = new JLabel();
        setFont(blackIUNumberAmountLabel, Color.ORANGE, 15);
        return blackIUNumberAmountLabel;
    }
    public void setBlackIUNumberAmountLabel(int amount) {
        blackIUNumberAmountLabel.setText(amount +"/100");
    }

    private void setFont(JLabel comp, Color color, int size) {
        comp.setFont(new Font("Consolas", Font.PLAIN, size));
        comp.setForeground(color);
    }
}

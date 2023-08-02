import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class regularVMview extends javax.swing.JFrame{

    public regularVMview() {
        setBackground(new Color(5,48,86));
        titlePanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        lcdPanel = new javax.swing.JPanel();
        nameTextfield = new javax.swing.JTextField();
        caloriesTextfield = new javax.swing.JTextField();
        priceTextfield = new javax.swing.JTextField();
        purchaseButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        caloriesLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        slotPanel = new javax.swing.JPanel();
        balanceLabel = new javax.swing.JLabel();
        itemTrayTextfield = new javax.swing.JTextField();
        changeTextArea = new javax.swing.JTextArea();
        putmoneyButton = new javax.swing.JButton();
        balanceTextfield = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        buttonsPanel = new javax.swing.JPanel();
        additemButton = new javax.swing.JButton();
        statusRVMTextfield = new javax.swing.JTextField();
        changeScrollPane = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(5, 48, 86));
        setPreferredSize(new java.awt.Dimension(725, 640));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 625));

        titlePanel.setBackground(new java.awt.Color(0, 0, 0));

        titleLabel.setFont(new java.awt.Font("UD Digi Kyokasho NP-R", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(255, 255, 255));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setVisible(true);

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanelLayout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        titlePanelLayout.setVerticalGroup(
                titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanelLayout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        lcdPanel.setBackground(new java.awt.Color(0, 0, 0));

        nameTextfield.setEditable(false);

        caloriesTextfield.setEditable(false);

        priceTextfield.setEditable(false);


        purchaseButton.setText("✅");
        purchaseButton.setEnabled(false);

        cancelButton.setText("❌");
        cancelButton.setEnabled(false);

        nameLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(242, 242, 242));
        nameLabel.setText("Name");

        caloriesLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        caloriesLabel.setForeground(new java.awt.Color(242, 242, 242));
        caloriesLabel.setText("Calories");

        priceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(242, 242, 242));
        priceLabel.setText("Price");

        javax.swing.GroupLayout lcdPanelLayout = new javax.swing.GroupLayout(lcdPanel);
        lcdPanel.setLayout(lcdPanelLayout);
        lcdPanelLayout.setHorizontalGroup(
                lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lcdPanelLayout.createSequentialGroup()
                                                                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(caloriesTextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(caloriesLabel))
                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(priceLabel))
                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(nameLabel)))
                                .addContainerGap(29, Short.MAX_VALUE))
        );
        lcdPanelLayout.setVerticalGroup(
                lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(priceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(caloriesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caloriesTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
        );

        slotPanel.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout slotPanelLayout = new javax.swing.GroupLayout(slotPanel);
        slotPanel.setLayout(slotPanelLayout);
        slotPanelLayout.setHorizontalGroup(
                slotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 470, Short.MAX_VALUE)
        );
        slotPanelLayout.setVerticalGroup(
                slotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 412, Short.MAX_VALUE)
        );

        JPanel newPanelSlots = new JPanel();
        newPanelSlots.setBackground(Color.black);
        newPanelSlots.setSize(470,412);
        newPanelSlots.setLayout(new GridLayout(3,3,5, 5));

        slotPanel.add(newPanelSlots);

        slotPanels = new JPanel[9];
        slotAreas = new JTextArea[9];

        trueSlots = new ArrayList();

        for (int i=0;i<9;i++)
        {
            slotPanels[i] = new JPanel();
            slotAreas[i] = new JTextArea();
        }

        for (int i=0;i<9;i++)
        {
            slotAreas[i].setRows(6);
            slotAreas[i].setSize(new Dimension(40, 40));
            slotAreas[i].setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14));
        }

        for (int i=0;i<9;i++)
        {
            slotPanels[i].setBackground(new java.awt.Color(255, 255, 255));
            slotPanels[i].setSize(new Dimension(40, 40));
            slotPanels[i].add(slotAreas[i]);
        }
        for (int i=0;i<9;i++)
        {
            newPanelSlots.add(slotPanels[i]);
        }


        balanceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        balanceLabel.setText("Balance:");

        itemTrayTextfield.setEditable(false);
        itemTrayTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 20));
        itemTrayTextfield.setHorizontalAlignment(JTextField.CENTER);

        changeTextArea.setEditable(false);
        changeTextArea.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 11));
        changeScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        changeScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));
        changeScrollPane.setViewportView(changeTextArea);

        putmoneyButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        putmoneyButton.setText("Put Money");


        balanceTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        balanceTextfield.setHorizontalAlignment(JTextField.CENTER);
        balanceTextfield.setAutoscrolls(false);
        balanceTextfield.setFocusable(false);
        balanceTextfield.setEditable(false);


        returnButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        returnButton.setText("Return");

        buttonsPanel.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout buttonsPanelLayout = new javax.swing.GroupLayout(buttonsPanel);
        buttonsPanel.setLayout(buttonsPanelLayout);
        buttonsPanelLayout.setHorizontalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        buttonsPanelLayout.setVerticalGroup(
                buttonsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 147, Short.MAX_VALUE)
        );


        JPanel newButtonsPanel = new JPanel();
        newButtonsPanel.setBackground(Color.black);
        newButtonsPanel.setSize(190,151);
        newButtonsPanel.setLayout(new GridLayout(3,3));
        buttonsPanel.add(newButtonsPanel);

        slotPanelButtons = new JButton[9];

        for (int i=0;i<9;i++)
        {
            slotPanelButtons[i] = new JButton(""+i);
        }

        for (int i=0;i<9;i++)
        {
            slotPanelButtons[i].setSize(new Dimension(40, 40));
            slotPanelButtons[i].setEnabled(false);
            slotPanelButtons[i].setFocusable(false);
            slotPanelButtons[i].setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12));
            newButtonsPanel.add(slotPanelButtons[i]);
        }

        statusRVMTextfield.setEditable(false);
        statusRVMTextfield.setText("");
        statusRVMTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14));
        statusRVMTextfield.setHorizontalAlignment(JTextField.CENTER);

        changeTextArea.setColumns(20);
        changeTextArea.setRows(5);
        changeTextArea.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12));

        additemButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        additemButton.setText("Add item");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(22, 22, 22)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(itemTrayTextfield)
                                                                .addGap(11, 11, 11)
                                                                .addComponent(changeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(slotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(24, 24, 24)
                                                .addComponent(putmoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(2, 2, 2)
                                                                .addComponent(additemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                                                .addComponent(returnButton))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addComponent(balanceLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(balanceTextfield))
                                                        .addComponent(lcdPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(statusRVMTextfield))
                                                .addGap(12, 12, 12))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(lcdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(balanceLabel)
                                                        .addComponent(balanceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addComponent(putmoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(buttonsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(slotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(itemTrayTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(changeScrollPane, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(statusRVMTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(returnButton)
                                                                        .addComponent(additemButton))))
                                                .addGap(65, 65, 65))))
        );
        pack();
        setVisible(false);
        setLocationRelativeTo(null);
    }// </editor-fold>


    public JTextField getBalanceTextfield() {
        return balanceTextfield;
    }


    public JTextArea[] getSlotAreas() {
        return slotAreas;
    }

    public JButton[] getSlotPanelButtons() {
        return slotPanelButtons;
    }

    public JTextField getNameTextfield() {
        return nameTextfield;
    }

    public JTextField getPriceTextfield() {
        return priceTextfield;
    }

    public JTextArea getChangeTextArea() {
        return changeTextArea;
    }

    public JTextField getCaloriesTextfield() {
        return caloriesTextfield;
    }

    public JTextField getStatusRVMTextfield() {
        return statusRVMTextfield;
    }

    public JTextField getItemTrayTextfield() {
        return itemTrayTextfield;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public JButton getPurchaseButton() {
        return purchaseButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setreturnButtonListener(ActionListener actionListener) {
        this.returnButton.addActionListener(actionListener);
    }

    public void setpurchaseButtonListener(ActionListener actionListener) {
        this.purchaseButton.addActionListener(actionListener);
    }

    public void setputmoneyButtonListener(ActionListener actionListener) {
        this.putmoneyButton.addActionListener(actionListener);
    }

    public void setadditemButtonListener(ActionListener actionListener) {
        this.additemButton.addActionListener(actionListener);
    }

    public void setslotPanelButtonsListener(ActionListener actionListener)
    {
        for(int i=0;i<5;i++)
        {
            slotPanelButtons[i].addActionListener(actionListener);
        }
    }

    public void setstatusRVMTextfieldListener(ActionListener actionListener) {
        this.statusRVMTextfield.addActionListener(actionListener);
    }

    public void setcancelButtonListener(ActionListener actionListener) {
        this.cancelButton.addActionListener(actionListener);
    }

    public void setitemTrayTextfieldListener(MouseListener MouseListener) {
        this.itemTrayTextfield.addMouseListener(MouseListener);
    }

    public void setchangeTextAreaListener(MouseListener MouseListener) {
        this.changeTextArea.addMouseListener(MouseListener);
    }


    // setVisible(true);
    // pack();
    private javax.swing.JButton additemButton;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTextField balanceTextfield;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel caloriesLabel;
    private javax.swing.JTextField caloriesTextfield;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextArea changeTextArea;
    private javax.swing.JTextField itemTrayTextfield;
    private javax.swing.JPanel lcdPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextfield;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JButton putmoneyButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JPanel slotPanel;
    private javax.swing.JLabel titleLabel;
    private javax.swing.JPanel titlePanel;
    private javax.swing.JTextField statusRVMTextfield;

    private JPanel[] slotPanels;
    private JTextArea[] slotAreas;

    private ArrayList<JPanel> trueSlots;

    private JButton[] slotPanelButtons;
    private javax.swing.JScrollPane changeScrollPane;



}

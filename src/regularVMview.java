import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        changeTextfield = new javax.swing.JTextField();
        putmoneyButton = new javax.swing.JButton();
        balanceTextfield = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        buttonsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(5, 48, 86));
        setPreferredSize(new java.awt.Dimension(725, 625));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 625));

        titlePanel.setBackground(new java.awt.Color(0, 0, 0));

        titleLabel.setFont(new java.awt.Font("UD Digi Kyokasho NP-R", 0, 36)); // NOI18N
        titleLabel.setForeground(new java.awt.Color(242, 242, 242));
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("title");

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

        nameTextfield.setText("Name");

        caloriesTextfield.setText("Calories");

        priceTextfield.setText("Price");

        purchaseButton.setText("Purchase");

        cancelButton.setText("Cancel");

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

        JPanel[] slotPanels = new JPanel[9];

        ArrayList<JPanel> trueSlots = new ArrayList();

        for (int i=0;i<9;i++)
        {
            slotPanels[i] = new JPanel();
        }

        for (int i=0;i<9;i++)
        {
            slotPanels[i].setBackground(new java.awt.Color(255-i*10, 255-i*10, 255-i*10));
            slotPanels[i].setSize(new Dimension(40, 40));
        }
        for (int i=0;i<9;i++)
        {
            trueSlots.add(slotPanels[i]);
        }

        for (int i=0;i<9;i++)
        {
            newPanelSlots.add(trueSlots.get(i));
        }


        balanceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        balanceLabel.setText("Balance:");

        itemTrayTextfield.setText("Item Tray");

        changeTextfield.setText("Change");

        putmoneyButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        putmoneyButton.setText("Put Money");

        balanceTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        balanceTextfield.setText("balance");
        balanceTextfield.setAutoscrolls(false);
        balanceTextfield.setFocusable(false);

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
        newButtonsPanel.setSize(188,147);
        newButtonsPanel.setLayout(new GridLayout(3,3,5, 5));
        buttonsPanel.add(newButtonsPanel);

        JButton[] slotPanelButtons = new JButton[9];

        for (int i=0;i<9;i++)
        {
            slotPanelButtons[i] = new JButton(""+i);
        }

        for (int i=0;i<9;i++)
        {
            slotPanelButtons[i].setSize(new Dimension(40, 40));
            newButtonsPanel.add(slotPanelButtons[i]);
        }

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
                                                                .addComponent(slotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(itemTrayTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(changeTextfield)
                                                                .addGap(6, 6, 6)))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(balanceLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(balanceTextfield))
                                                        .addComponent(buttonsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lcdPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(12, 12, 12))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(36, 36, 36)
                                                                .addComponent(putmoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(54, 54, 54)
                                                                .addComponent(returnButton)))
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
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
                                                .addComponent(slotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(itemTrayTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(changeTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(returnButton))))
                                .addContainerGap(69, Short.MAX_VALUE))
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }// </editor-fold>

    public void setreturnButtonListener(ActionListener actionListener) {
        this.returnButton.addActionListener(actionListener);
    }

    public void setpurchaseButtonListener(ActionListener actionListener) {
        this.purchaseButton.addActionListener(actionListener);
    }

    public void setputmoneyButtonListener(ActionListener actionListener) {
        this.putmoneyButton.addActionListener(actionListener);
    }

    // setVisible(true);
    // pack();
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTextField balanceTextfield;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel caloriesLabel;
    private javax.swing.JTextField caloriesTextfield;
    private javax.swing.JButton cancelButton;
    private javax.swing.JTextField changeTextfield;
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



}

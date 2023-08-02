import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class insertMoneyView extends JFrame {
    private javax.swing.JLabel addMoneyLabel;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JPanel moneySlotPanel;
    private JPanel newMoneySlotPanel;
    private JButton[] moneyPanelButtons;
    private javax.swing.JTextField statusTextField;
    insertMoneyView()
    {
        moneySlotPanel = new javax.swing.JPanel();
        addMoneyLabel = new javax.swing.JLabel();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        newMoneySlotPanel = new JPanel();
        moneyPanelButtons = new JButton[5];
        statusTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        moneySlotPanel.setBackground(new java.awt.Color(0, 0, 0));

        newMoneySlotPanel.setBackground(Color.black);
        newMoneySlotPanel.setSize(428,287);
        newMoneySlotPanel.setLayout(new GridLayout(2,3));

        moneyPanelButtons[0] = new JButton("20");
        moneyPanelButtons[1] = new JButton("50");
        moneyPanelButtons[2] = new JButton("100");
        moneyPanelButtons[3] = new JButton("200");
        moneyPanelButtons[4] = new JButton("500");

        for (int i=0;i<5;i++)
        {
            moneyPanelButtons[i].setSize(new Dimension(100, 10));
            moneyPanelButtons[i].setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 25));
            newMoneySlotPanel.add(moneyPanelButtons[i]);
        }

        moneySlotPanel.add(newMoneySlotPanel);


        statusTextField.setEditable(false);
        statusTextField.setForeground(new java.awt.Color(0, 0, 0));
        statusTextField.setBorder(null);

        javax.swing.GroupLayout moneySlotPanelLayout = new javax.swing.GroupLayout(moneySlotPanel);
        moneySlotPanel.setLayout(moneySlotPanelLayout);
        moneySlotPanelLayout.setHorizontalGroup(
                moneySlotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 428, Short.MAX_VALUE)
        );
        moneySlotPanelLayout.setVerticalGroup(
                moneySlotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 287, Short.MAX_VALUE)
        );

        addMoneyLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 48)); // NOI18N
        addMoneyLabel.setText("Add money");

        confirmButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        confirmButton.setText("Confirm");

        cancelButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        cancelButton.setText("Cancel");

        statusTextField.setEditable(false);
        statusTextField.setBackground(new java.awt.Color(255, 255, 255));
        statusTextField.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 24)); // NOI18N
        statusTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusTextField.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(155, 155, 155)
                                                .addComponent(confirmButton)
                                                .addGap(32, 32, 32)
                                                .addComponent(cancelButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(34, 34, 34)
                                                .addComponent(moneySlotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(addMoneyLabel))))
                                .addContainerGap(38, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addComponent(addMoneyLabel)
                                .addGap(14, 14, 14)
                                .addComponent(statusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(moneySlotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cancelButton)
                                        .addComponent(confirmButton))
                                .addGap(28, 28, 28))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public JButton[] getMoneyPanelButtons() {
        return moneyPanelButtons;
    }

    public void setConfirmButtonVisible(boolean b) {
        confirmButton.setVisible(b);
    }

    public void setconfirmButtonListener(ActionListener actionListener) {
        this.confirmButton.addActionListener(actionListener);
    }

    public void setCancelButtonListener(ActionListener actionListener)
    {
        this.cancelButton.addActionListener(actionListener);
    }

    public JTextField getStatusTextField() {
        return statusTextField;
    }

    public void setmoneyPanelButtonsListener(ActionListener actionListener)
    {
        for(int i=0;i<5;i++)
        {
            moneyPanelButtons[i].addActionListener(actionListener);
        }
    }
}

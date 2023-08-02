import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class replenishMoneyView extends JFrame {

    replenishMoneyView()
    {
        titleLabel = new javax.swing.JLabel();
        statusTextfield = new javax.swing.JTextField();
        buttonPanel = new javax.swing.JPanel();
        returnButton = new javax.swing.JButton();
        eksButton = new javax.swing.JButton();
        checkButton = new javax.swing.JButton();
        quantityTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titleLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 36)); // NOI18N
        titleLabel.setText("Repleneshing Money");

        statusTextfield.setEditable(false);
        statusTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        statusTextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        newbuttonPanel = new JPanel();
        changeButtons = new JButton[7];


        newbuttonPanel.setSize(new Dimension(533,60));
        newbuttonPanel.setLayout(new GridLayout());

        changeButtons[0] = new JButton("1");
        changeButtons[1] = new JButton("5");
        changeButtons[2] = new JButton("10");
        changeButtons[3] = new JButton("20");
        changeButtons[4] = new JButton("50");
        changeButtons[5] = new JButton("100");
        changeButtons[6] = new JButton("200");

        for (int i=0;i<7;i++)
        {
            changeButtons[i].setBackground(new java.awt.Color(255-i*10, 255-i*10, 255-i*10));
        }

        for (int i=0;i<7;i++)
        {
            changeButtons[i].setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14)); // NOI18N
            changeButtons[i].setPreferredSize(new Dimension(40,40));
            newbuttonPanel.add(changeButtons[i]);
        }

        buttonPanel.add(newbuttonPanel);
        setResizable(false);

        javax.swing.GroupLayout buttonPanelLayout = new javax.swing.GroupLayout(buttonPanel);
        buttonPanel.setLayout(buttonPanelLayout);
        buttonPanelLayout.setHorizontalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 533, Short.MAX_VALUE)
        );
        buttonPanelLayout.setVerticalGroup(
                buttonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 60, Short.MAX_VALUE)
        );

        returnButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        returnButton.setText("Return");

        eksButton.setText(" ");
        eksButton.setBackground(Color.red);

        checkButton.setText(" ");
        checkButton.setBackground(Color.green);

        jLabel1.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        jLabel1.setText("Quantity: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(33, 33, 33)
                                                        .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(130, 130, 130)
                                                        .addComponent(titleLabel))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(199, 199, 199)
                                                        .addComponent(statusTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(87, 87, 87)
                                                        .addComponent(jLabel1)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(34, 34, 34)
                                                        .addComponent(checkButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(eksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(134, 134, 134)
                                                .addComponent(returnButton)))
                                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(titleLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(statusTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(eksButton)
                                        .addComponent(checkButton)
                                        .addComponent(quantityTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                                .addComponent(returnButton)
                                .addGap(15, 15, 15))
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void setchangeButtonsListener(ActionListener actionListener)
    {
        for(int i=0;i<7;i++)
        {
            changeButtons[i].addActionListener(actionListener);
        }
    }

    public void setreturnButtonListener(ActionListener actionListener)
    {
        returnButton.addActionListener(actionListener);
    }

    public void setcheckButtonListener(ActionListener actionListener)
    {
        checkButton.addActionListener(actionListener);
    }

    public void seteksButtonListener(ActionListener actionListener)
    {
        eksButton.addActionListener(actionListener);
    }

    public JTextField getStatusTextfield() {
        return statusTextfield;
    }

    public JTextField getQuantityTextField() {
        return quantityTextField;
    }

    public JButton[] getChangeButtons() {
        return changeButtons;
    }




    private JButton changeButtons[];
    private JPanel newbuttonPanel;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton checkButton;
    private javax.swing.JButton eksButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JTextField quantityTextField;
    private javax.swing.JButton returnButton;
    private javax.swing.JTextField statusTextfield;
    private javax.swing.JLabel titleLabel;


}

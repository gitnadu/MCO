import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;


public class maintenanceRVMview extends JFrame {
    private javax.swing.JButton checknewPriceButton;
    private javax.swing.JButton collectEarningsButtons;
    private javax.swing.JTextField collectEarningsTextField;
    private javax.swing.JButton eksNewPriceButton;
    private javax.swing.JButton eksrestockButton;
    private javax.swing.JTextField itemNameTextfield;
    private javax.swing.JLabel itemnameNewPriceLabel;
    private javax.swing.JLabel newPriceLabel;
    private javax.swing.JTextField newpriceTextfield;
    private javax.swing.JTextField newpricenameTextfield;
    private javax.swing.JButton replenishChangeButton;
    private javax.swing.JButton restockButton;
    private javax.swing.JLabel restockItemNameLabel;
    private javax.swing.JLabel restockQuantityLabel;
    private javax.swing.JTextField restockQuantityTextfield;
    private javax.swing.JButton restockcheckButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JButton setnewpriceButton;
    private javax.swing.JLabel titlePanel;
    private javax.swing.JButton totalSalesButton;
    maintenanceRVMview()
    {
        titlePanel = new javax.swing.JLabel();
        restockButton = new javax.swing.JButton();
        collectEarningsButtons = new javax.swing.JButton();
        setnewpriceButton = new javax.swing.JButton();
        replenishChangeButton = new javax.swing.JButton();
        newpricenameTextfield = new javax.swing.JTextField();
        newPriceLabel = new javax.swing.JLabel();
        itemnameNewPriceLabel = new javax.swing.JLabel();
        newpriceTextfield = new javax.swing.JTextField();
        itemNameTextfield = new javax.swing.JTextField();
        restockQuantityLabel = new javax.swing.JLabel();
        restockItemNameLabel = new javax.swing.JLabel();
        restockQuantityTextfield = new javax.swing.JTextField();
        totalSalesButton = new javax.swing.JButton();
        returnButton = new javax.swing.JButton();
        restockcheckButton = new javax.swing.JButton();
        eksrestockButton = new javax.swing.JButton();
        checknewPriceButton = new javax.swing.JButton();
        eksNewPriceButton = new javax.swing.JButton();
        collectEarningsTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        setSize(new Dimension(600,450));
        setPreferredSize(new Dimension(600,450));

        titlePanel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 35)); // NOI18N
        titlePanel.setText("Test Regular Vending Machine");
        titlePanel.setName(""); // NOI18N

        collectEarningsButtons.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        collectEarningsButtons.setText("Collect Earnings");
        collectEarningsButtons.setToolTipText("");

        restockButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        restockButton.setText("Restock item");
        restockButton.setToolTipText("");

        collectEarningsTextField.setEditable(false);


        setnewpriceButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        setnewpriceButton.setText("Set new price");
        setnewpriceButton.setToolTipText("");

        replenishChangeButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        replenishChangeButton.setText("Replenish Change");
        replenishChangeButton.setToolTipText("");

        newpricenameTextfield.setVisible(false); // name of the item to be changed

        newPriceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        newPriceLabel.setText("New Price:");
        newPriceLabel.setVisible(false);

        itemnameNewPriceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        itemnameNewPriceLabel.setText("Item name:");
        itemnameNewPriceLabel.setVisible(false);

        newpriceTextfield.setVisible(false);// new price

        itemNameTextfield.setVisible(false);// item name to be restocked
        setResizable(false);

        restockQuantityLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        restockQuantityLabel.setText("Quantity:");
        restockQuantityLabel.setVisible(false);

        restockItemNameLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        restockItemNameLabel.setText("Item name:");
        restockItemNameLabel.setVisible(false);

        restockQuantityTextfield.setVisible(false);// quantity to be stocked

        totalSalesButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        totalSalesButton.setText("Total Sales");
        totalSalesButton.setToolTipText("");

        returnButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14)); // NOI18N
        returnButton.setText("Return");

        restockcheckButton.setText("jButton1");
        restockcheckButton.setVisible(false);
        restockcheckButton.setEnabled(false);

        eksrestockButton.setText("jButton1");
        eksrestockButton.setVisible(false);
        eksrestockButton.setEnabled(false);

        checknewPriceButton.setText("jButton1");
        checknewPriceButton.setVisible(false);
        checknewPriceButton.setEnabled(false);

        eksNewPriceButton.setText("jButton1");
        eksNewPriceButton.setVisible(false);
        eksNewPriceButton.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(restockItemNameLabel)
                                                        .addComponent(restockQuantityLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(itemNameTextfield)
                                                        .addComponent(restockQuantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(restockButton)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(setnewpriceButton)
                                                .addGap(82, 82, 82))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(returnButton)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(itemnameNewPriceLabel)
                                                                        .addComponent(newPriceLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(newpricenameTextfield)
                                                                        .addComponent(newpriceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(35, 35, 35))))
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                        .addComponent(titlePanel, javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(collectEarningsButtons)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(totalSalesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(2, 2, 2))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(25, 25, 25)
                                                .addComponent(collectEarningsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(107, 107, 107)
                                                .addComponent(replenishChangeButton)))
                                .addContainerGap(69, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(restockcheckButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eksrestockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(checknewPriceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(eksNewPriceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(118, 118, 118))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(titlePanel)
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(restockButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(setnewpriceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(itemNameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(restockItemNameLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(restockQuantityLabel)
                                                        .addComponent(restockQuantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newpricenameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(itemnameNewPriceLabel))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(newPriceLabel)
                                                        .addComponent(newpriceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(checknewPriceButton)
                                        .addComponent(eksNewPriceButton)
                                        .addComponent(restockcheckButton)
                                        .addComponent(eksrestockButton))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(totalSalesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(collectEarningsButtons, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(collectEarningsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(replenishChangeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(returnButton)
                                .addGap(20, 20, 20))
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public JTextField getItemNameTextfield() {
        return itemNameTextfield;
    }

    public JTextField getRestockQuantityTextfield() {
        return restockQuantityTextfield;
    }

    public JButton getRestockcheckButton() {
        return restockcheckButton;
    }

    public JButton getEksrestockButton() {
        return eksrestockButton;
    }

    public JTextField getNewpriceTextfield() {
        return newpriceTextfield;
    }

    public JTextField getNewpricenameTextfield() {
        return newpricenameTextfield;
    }

    public JButton getChecknewPriceButton() {
        return checknewPriceButton;
    }

    public JButton getEksNewPriceButton() {
        return eksNewPriceButton;
    }

    public JLabel getRestockQuantityLabel() {
        return restockQuantityLabel;
    }

    public JLabel getRestockItemNameLabel() {
        return restockItemNameLabel;
    }

    public JLabel getItemnameNewPriceLabel() {
        return itemnameNewPriceLabel;
    }
    public JLabel getNewPriceLabel() {
        return newPriceLabel;
    }

    public JTextField getCollectEarningsTextField() {
        return collectEarningsTextField;
    }



    public void setrestockButtonListener(ActionListener actionListener) {
        this.restockButton.addActionListener(actionListener);
    }

    public void setcollectEarningsTextFieldListener(MouseListener MouseListener) {
        this.collectEarningsTextField.addMouseListener(MouseListener);
    }

    public void setsetnewpriceButtonListener(ActionListener actionListener) {
        this.setnewpriceButton.addActionListener(actionListener);
    }

    public void setrestockcheckButtonListener(ActionListener actionListener) {
        this.restockcheckButton.addActionListener(actionListener);
    }

    public void seteksrestockButtonListener(ActionListener actionListener) {
        this.eksrestockButton.addActionListener(actionListener);
    }

    public void setchecknewPriceButtonListener(ActionListener actionListener) {
        this.checknewPriceButton.addActionListener(actionListener);
    }

    public void setceksNewPriceButtonListener(ActionListener actionListener) {
        this.eksNewPriceButton.addActionListener(actionListener);
    }



    public void setcollectEarningsButtonsListener(ActionListener actionListener) {
        this.collectEarningsButtons.addActionListener(actionListener);
    }

    public void setreplenishChangeButtonListener(ActionListener actionListener) {
        this.replenishChangeButton.addActionListener(actionListener);
    }

    public void setreturnButtonListener(ActionListener actionListener) {
        this.returnButton.addActionListener(actionListener);
    }



    public void settotalSalesButtonListener(ActionListener actionListener) {
        this.totalSalesButton.addActionListener(actionListener);
    }
}

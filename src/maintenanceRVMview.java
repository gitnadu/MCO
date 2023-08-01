import javax.swing.*;

public class maintenanceRVMview extends JFrame {
    private javax.swing.JButton collectEarningsButtons;
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
        totalSalesButton = new javax.swing.JButton();
        newpricenameTextfield = new javax.swing.JTextField();
        newPriceLabel = new javax.swing.JLabel();
        itemnameNewPriceLabel = new javax.swing.JLabel();
        newpriceTextfield = new javax.swing.JTextField();
        itemNameTextfield = new javax.swing.JTextField();
        restockQuantityLabel = new javax.swing.JLabel();
        restockItemNameLabel = new javax.swing.JLabel();
        restockQuantityTextfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        titlePanel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 35)); // NOI18N
        titlePanel.setText("Test Regular Vending Machine");
        titlePanel.setName(""); // NOI18N

        restockButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        restockButton.setText("Restock item");
        restockButton.setToolTipText("");

        collectEarningsButtons.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        collectEarningsButtons.setText("Collect Earnings");
        collectEarningsButtons.setToolTipText("");

        setnewpriceButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        setnewpriceButton.setText("Set new price");
        setnewpriceButton.setToolTipText("");

        replenishChangeButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        replenishChangeButton.setText("Replenish Change");
        replenishChangeButton.setToolTipText("");

        totalSalesButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        totalSalesButton.setText("Total Sales");
        totalSalesButton.setToolTipText("");

        newpricenameTextfield.setText("Item Name");

        newPriceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        newPriceLabel.setText("New Price:");

        itemnameNewPriceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        itemnameNewPriceLabel.setText("Item name:");

        newpriceTextfield.setText("New Price");

        itemNameTextfield.setText("Item name");

        restockQuantityLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        restockQuantityLabel.setText("Quantity:");

        restockItemNameLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        restockItemNameLabel.setText("Item name:");

        restockQuantityTextfield.setText("Quantity");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(collectEarningsButtons)
                                                .addGap(85, 85, 85)
                                                .addComponent(totalSalesButton))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(119, 119, 119)
                                                .addComponent(replenishChangeButton)))
                                .addContainerGap(124, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
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
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(itemnameNewPriceLabel)
                                                                        .addComponent(newPriceLabel))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(newpricenameTextfield)
                                                                        .addComponent(newpriceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(35, 35, 35))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(setnewpriceButton)
                                                                .addGap(82, 82, 82))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(titlePanel)
                                                .addGap(0, 0, Short.MAX_VALUE))))
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
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(totalSalesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(collectEarningsButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(replenishChangeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(35, 35, 35))
        );
    }
}

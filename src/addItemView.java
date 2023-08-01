import javax.swing.*;
import java.awt.event.ActionListener;

public class addItemView extends JFrame {
    private javax.swing.JLabel calorieLabel;
    private javax.swing.JTextField caloriesTextfield;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton confirmButton;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextfield;
    private javax.swing.JLabel quantityLabel;
    private javax.swing.JTextField quantityTextfield;
    private javax.swing.JTextField statusTextfield;
    private javax.swing.JLabel titleLabel;
    addItemView()
    {
        quantityLabel = new javax.swing.JLabel();
        caloriesTextfield = new javax.swing.JTextField();
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        calorieLabel = new javax.swing.JLabel();
        nameTextfield = new javax.swing.JTextField();
        quantityTextfield = new javax.swing.JTextField();
        priceTextfield = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        statusTextfield = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        quantityLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        quantityLabel.setText("Quantity:");

        caloriesTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N

        titleLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 40)); // NOI18N
        titleLabel.setText("Adding item");

        nameLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        nameLabel.setText("Name:");

        priceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        priceLabel.setText("Price Tag:");

        calorieLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        calorieLabel.setText("Calories:");

        nameTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N

        quantityTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N

        priceTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N

        confirmButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        confirmButton.setText("Confirm");

        cancelButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        cancelButton.setText("Cancel");

        statusTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        statusTextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusTextfield.setText("status ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(44, 44, 44)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(calorieLabel)
                                                                        .addComponent(priceLabel)
                                                                        .addComponent(nameLabel))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(caloriesTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addGroup(layout.createSequentialGroup()
                                                                                .addGap(10, 10, 10)
                                                                                .addComponent(titleLabel))))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(5, 5, 5)
                                                                .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(176, 176, 176)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(statusTextfield)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(confirmButton)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(cancelButton)))))
                                .addContainerGap(45, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(titleLabel)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(priceLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(calorieLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(caloriesTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(quantityLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(quantityTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(confirmButton)
                                        .addComponent(cancelButton))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(statusTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public JTextField getNameTextfield() {
        return nameTextfield;
    }

    public JTextField getPriceTextfield() {
        return priceTextfield;
    }

    public JTextField getCaloriesTextfield() {
        return caloriesTextfield;
    }

    public JTextField getQuantityTextfield() {
        return quantityTextfield;
    }

    public JTextField getStatusTextfield() {
        return statusTextfield;
    }

    public void setconfirmButtonListener(ActionListener actionListener) {
        this.confirmButton.addActionListener(actionListener);
    }

    public void setcancelButtonListener(ActionListener actionListener) {
        this.cancelButton.addActionListener(actionListener);
    }
}

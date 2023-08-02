import javax.swing.*;
import java.awt.event.ActionListener;

public class specialvmOptionsView extends JFrame {

    specialvmOptionsView()
    {
        title = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        maintenanceButton = new javax.swing.JButton();
        createSpecialVMButton = new javax.swing.JButton();
        testSpecialVMButton = new javax.swing.JButton();
        statusTextfield = new javax.swing.JTextField();
        confirmButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 375));;
        setSize(new java.awt.Dimension(600, 375));
        setResizable(false);

        title.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 35)); // NOI18N
        title.setText("Special Vending Machine");
        title.setName(""); // NOI18N

        returnButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        returnButton.setText("Return");
        returnButton.setToolTipText("");

        maintenanceButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        maintenanceButton.setText("Machine Maintenance");
        maintenanceButton.setToolTipText("");

        createSpecialVMButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        createSpecialVMButton.setText("Create vending machine");
        createSpecialVMButton.setToolTipText("");

        testSpecialVMButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        testSpecialVMButton.setText("Test Vending Features");
        testSpecialVMButton.setToolTipText("");


        statusTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        statusTextfield.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        statusTextfield.setVisible(true);
        statusTextfield.setEditable(false);

        confirmButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14)); // NOI18N
        confirmButton.setText("Confirm");
        confirmButton.setVisible(false);
        confirmButton.setEnabled(false);

        setResizable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGap(96, 96, 96)
                                                        .addComponent(title)
                                                        .addGap(8, 8, 8))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(93, 93, 93)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(maintenanceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(createSpecialVMButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(testSpecialVMButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(146, 146, 146)
                                                .addComponent(statusTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(35, 35, 35)
                                                .addComponent(confirmButton)))
                                .addContainerGap(97, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createSpecialVMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(testSpecialVMButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(statusTextfield, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                                        .addComponent(confirmButton))
                                .addGap(12, 12, 12)
                                .addComponent(returnButton)
                                .addGap(29, 29, 29))
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JTextField getStatusTextfield() {
        return statusTextfield;
    }

    public void setcreateSpecialVMButtonListener(ActionListener actionListener) {
        this.createSpecialVMButton.addActionListener(actionListener);
    }

    public void setreturnButtonListener(ActionListener actionListener) {
        this.returnButton.addActionListener(actionListener);
    }

    public void setmaintenanceButtonListener(ActionListener actionListener) {
        this.maintenanceButton.addActionListener(actionListener);
    }

    public void settestSpecialVMButtonListener(ActionListener actionListener) {
        this.testSpecialVMButton.addActionListener(actionListener);
    }

    public void setconfirmButtonListener(ActionListener actionListener) {
        this.confirmButton.addActionListener(actionListener);
    }


    private javax.swing.JButton returnButton;
    private javax.swing.JButton maintenanceButton;
    private javax.swing.JButton createSpecialVMButton;
    private javax.swing.JButton testSpecialVMButton;
    private javax.swing.JLabel title;
    private javax.swing.JTextField statusTextfield;
    private javax.swing.JButton confirmButton;
}

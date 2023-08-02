import javax.swing.*;

public class specialvmOptionsView extends JFrame {

    specialvmOptionsView()
    {
        title = new javax.swing.JLabel();
        returnButton = new javax.swing.JButton();
        maintenanceButton = new javax.swing.JButton();
        createSpecialVM = new javax.swing.JButton();
        testSpecialVM = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 35));
        title.setText("Special Vending Machine");
        title.setName(""); // NOI18N

        returnButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18));
        returnButton.setText("Return");
        returnButton.setToolTipText("");
        

        maintenanceButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18));
        maintenanceButton.setText("Machine Maintenance");
        maintenanceButton.setToolTipText("");

        createSpecialVM.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18));
        createSpecialVM.setText("Create vending machine");
        createSpecialVM.setToolTipText("");

        testSpecialVM.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18));
        testSpecialVM.setText("Test Vending Features");
        testSpecialVM.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(95, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(maintenanceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createSpecialVM, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                        .addComponent(testSpecialVM, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(95, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(returnButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(title)
                                .addGap(106, 106, 106))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createSpecialVM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(testSpecialVM, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(returnButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    private javax.swing.JButton returnButton;
    private javax.swing.JButton maintenanceButton;
    private javax.swing.JButton createSpecialVM;
    private javax.swing.JButton testSpecialVM;
    private javax.swing.JLabel title;
}

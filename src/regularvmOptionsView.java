import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularvmOptionsView extends JFrame {

    regularvmOptionsView()
    {
        title = new javax.swing.JLabel();
        returnBut = new javax.swing.JButton();
        maintenanceButton = new javax.swing.JButton();
        createMachineButton = new javax.swing.JButton();
        testFeaturesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI Light", 0, 35)); // NOI18N
        title.setText("Regular Vending Machine");
        title.setName(""); // NOI18N

        returnBut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnBut.setText("Return");
        returnBut.setToolTipText("");

        maintenanceButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        maintenanceButton.setText("Machine Maintenance");
        maintenanceButton.setToolTipText("");

        createMachineButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createMachineButton.setText("Create vending machine");
        createMachineButton.setToolTipText("");

        testFeaturesButton.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        testFeaturesButton.setText("Test Vending Features");
        testFeaturesButton.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(maintenanceButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createMachineButton, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                        .addComponent(testFeaturesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(returnBut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(115, Short.MAX_VALUE)
                                .addComponent(title)
                                .addGap(103, 103, 103))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(title)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(createMachineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(testFeaturesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maintenanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(returnBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, Short.MAX_VALUE)
                                .addGap(11, 11, 11))



        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public void setreturnButListener(ActionListener actionListener) {
        this.returnBut.addActionListener(actionListener);
    }

    public void setmaintenanceButtonListener(ActionListener actionListener) {
        this.maintenanceButton.addActionListener(actionListener);
    }

    public void setcreateMachineButtonListener(ActionListener actionListener) {
        this.createMachineButton.addActionListener(actionListener);
    }

    public void settestFeaturesButtonListener(ActionListener actionListener) {
        this.testFeaturesButton.addActionListener(actionListener);
    }

    private javax.swing.JButton returnBut;
    private javax.swing.JButton maintenanceButton;
    private javax.swing.JButton createMachineButton;
    private javax.swing.JButton testFeaturesButton;
    private javax.swing.JLabel title;
}

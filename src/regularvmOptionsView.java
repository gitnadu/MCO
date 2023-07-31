import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularvmOptionsView extends JFrame {

    regularvmOptionsView()
    {
        title = new javax.swing.JLabel();
        returnBut = new javax.swing.JButton();
        maintenanceBut = new javax.swing.JButton();
        createMachineBut = new javax.swing.JButton();
        testFeaturesBut = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Segoe UI Light", 0, 35)); // NOI18N
        title.setText("Regular Vending Machine");
        title.setName(""); // NOI18N

        returnBut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        returnBut.setText("Return");
        returnBut.setToolTipText("");

        maintenanceBut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        maintenanceBut.setText("Machine Maintenance");
        maintenanceBut.setToolTipText("");

        createMachineBut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createMachineBut.setText("Create vending machine");
        createMachineBut.setToolTipText("");

        testFeaturesBut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        testFeaturesBut.setText("Test Vending Features");
        testFeaturesBut.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(maintenanceBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(createMachineBut, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                                        .addComponent(testFeaturesBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addComponent(createMachineBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(testFeaturesBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(maintenanceBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    public void setmaintenanceButListener(ActionListener actionListener) {
        this.maintenanceBut.addActionListener(actionListener);
    }

    public void setcreateMachineButListener(ActionListener actionListener) {
        this.createMachineBut.addActionListener(actionListener);
    }

    public void settestFeaturesButListener(ActionListener actionListener) {
        this.testFeaturesBut.addActionListener(actionListener);
    }

    private javax.swing.JButton returnBut;
    private javax.swing.JButton maintenanceBut;
    private javax.swing.JButton createMachineBut;
    private javax.swing.JButton testFeaturesBut;
    private javax.swing.JLabel title;
}

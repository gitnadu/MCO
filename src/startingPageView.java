
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;

public class startingPageView extends javax.swing.JFrame{

    private JButton createREG;
    private JButton createSPE;
    private JLabel mainTitle;
    private JButton quitBut;
    startingPageView()
    {
        mainTitle = new JLabel();
        createREG = new JButton();
        createSPE = new JButton();
        quitBut = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainTitle.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 33));
        mainTitle.setText("Vending Machine Factory");
        mainTitle.setName(""); // NOI18N


        createREG.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18));
        createREG.setText("Create Regular Vending Machine");
        createREG.setToolTipText("");

        createSPE.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18));
        createSPE.setText("Create Special Vending Machine");
        createSPE.setToolTipText("");


        quitBut.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18));
        quitBut.setText("Quit");
        quitBut.setToolTipText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(95, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(mainTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(quitBut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(createSPE, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(createREG, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)))
                                .addContainerGap(95, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(mainTitle)
                                .addGap(18, 18, 18)
                                .addComponent(createREG, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(createSPE, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(quitBut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54))
        );

        pack();
        setVisible(true);
        setLocationRelativeTo(null);
    }

    public void setcreateREGListener(ActionListener actionListener) {
        this.createREG.addActionListener(actionListener);
    }

    public void setcreateSPEListener(ActionListener actionListener) {
        this.createSPE.addActionListener(actionListener);
    }

    public void setQuitButListener(ActionListener actionListener) {
        this.quitBut.addActionListener(actionListener);
    }
}


import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class startingPage extends javax.swing.JFrame implements MouseListener {

    private JButton createREG;
    private JButton createSPE;
    private JLabel mainTitle;
    private JButton quitBut;
    startingPage()
    {
        mainTitle = new JLabel();
        createREG = new JButton();
        createSPE = new JButton();
        quitBut = new JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainTitle.setFont(new java.awt.Font("Segoe UI Light", 0, 35)); // NOI18N
        mainTitle.setText("Vending Machine Factory");
        mainTitle.setName(""); // NOI18N
        mainTitle.addMouseListener(this)
        {
            public void mouseClicked(MouseEvent e) {

            }
        }

        createREG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createREG.setText("Create Regular Vending Machine");
        createREG.setToolTipText("");

        createSPE.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        createSPE.setText("Create Special Vending Machine");
        createSPE.setToolTipText("");


        quitBut.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
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
}

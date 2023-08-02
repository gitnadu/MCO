import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class totalSalesSpecialView extends JFrame {

    totalSalesSpecialView()
    {
        totalSalesLabel = new javax.swing.JLabel();
        salesScrollPane = new javax.swing.JScrollPane();
        salesTextArea = new javax.swing.JTextArea();
        returnButton = new javax.swing.JButton();

        setResizable(false);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        totalSalesLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 36)); // NOI18N
        totalSalesLabel.setText("Total Sales: ");

        salesTextArea.setColumns(20);
        salesTextArea.setRows(5);
        salesTextArea.setEditable(false);
        salesScrollPane.setViewportView(salesTextArea);


        salesScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        salesScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));

        salesTextArea.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 19));

        returnButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14)); // NOI18N
        returnButton.setText("Return");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(39, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(returnButton)
                                        .addComponent(salesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(154, 154, 154)
                                .addComponent(totalSalesLabel)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(totalSalesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(salesScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(returnButton)
                                .addContainerGap(47, Short.MAX_VALUE))
        );
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public void setreturnButtonListener(ActionListener actionListener) {
        this.returnButton.addActionListener(actionListener);
    }

    public JTextArea getSalesTextArea() {
        return salesTextArea;
    }

    private javax.swing.JButton returnButton;
    private javax.swing.JScrollPane salesScrollPane;
    private javax.swing.JTextArea salesTextArea;
    private javax.swing.JLabel totalSalesLabel;
}

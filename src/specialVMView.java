import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

public class specialVMView extends javax.swing.JFrame{

    public specialVMView()
    {

        balanceTextfield = new javax.swing.JTextField();
        returnButton = new javax.swing.JButton();
        titlePanel1 = new javax.swing.JPanel();
        titleLabel1 = new javax.swing.JLabel();
        statusSVMTextField = new javax.swing.JTextField();
        lcdPanel = new javax.swing.JPanel();
        nameTextfield = new javax.swing.JTextField();
        caloriesTextfield = new javax.swing.JTextField();
        priceTextfield = new javax.swing.JTextField();
        purchaseButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        nameLabel = new javax.swing.JLabel();
        caloriesLabel = new javax.swing.JLabel();
        priceLabel = new javax.swing.JLabel();
        slotPanel = new javax.swing.JPanel();
        putmoneyButton = new javax.swing.JButton();
        additemButton = new javax.swing.JButton();
        balanceLabel = new javax.swing.JLabel();
        changeScrollPane = new javax.swing.JScrollPane();
        changeTextArea = new javax.swing.JTextArea();
        customizeScrollPane = new javax.swing.JScrollPane();
        customizeTextArea = new javax.swing.JTextArea();
        customizeButton = new javax.swing.JButton();
        itemTrayScrollPane = new javax.swing.JScrollPane();
        itemTrayTextArea = new javax.swing.JTextArea();
        baseItemPanel = new javax.swing.JPanel();
        OtherItemPanel = new javax.swing.JPanel();
        resetButton = new javax.swing.JButton();
        refreshButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        statusSVMTextField.setEditable(false);
        statusSVMTextField.setHorizontalAlignment(JTextField.CENTER);

        balanceTextfield.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        balanceTextfield.setEditable(false);
        balanceTextfield.setFocusable(false);
        balanceTextfield.setAutoscrolls(true);
        balanceTextfield.setPreferredSize(new Dimension(75, 15));

        returnButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        returnButton.setText("Return");

        titlePanel1.setBackground(new java.awt.Color(0, 0, 0));

        titleLabel1.setFont(new java.awt.Font("UD Digi Kyokasho NP-R", 0, 36)); // NOI18N
        titleLabel1.setForeground(new java.awt.Color(242, 242, 242));
        titleLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel1.setText("title");

        javax.swing.GroupLayout titlePanel1Layout = new javax.swing.GroupLayout(titlePanel1);
        titlePanel1.setLayout(titlePanel1Layout);
        titlePanel1Layout.setHorizontalGroup(
                titlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        titlePanel1Layout.setVerticalGroup(
                titlePanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(titlePanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(titleLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(17, Short.MAX_VALUE))
        );

        lcdPanel.setBackground(new java.awt.Color(0, 0, 0));

        nameTextfield.setEditable(false);


        caloriesTextfield.setEditable(false);

        priceTextfield.setEditable(false);

        purchaseButton.setText("✅");
        purchaseButton.setEnabled(false);

        cancelButton.setText("❌");
        cancelButton.setEnabled(false);

        resetButton.setText("↻");

        refreshButton.setText("⟳");


        nameLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        nameLabel.setForeground(new java.awt.Color(242, 242, 242));
        nameLabel.setText("Name");

        caloriesLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        caloriesLabel.setForeground(new java.awt.Color(242, 242, 242));
        caloriesLabel.setText("Calories");

        priceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 16)); // NOI18N
        priceLabel.setForeground(new java.awt.Color(242, 242, 242));
        priceLabel.setText("Price");

        javax.swing.GroupLayout lcdPanelLayout = new javax.swing.GroupLayout(lcdPanel);
        lcdPanel.setLayout(lcdPanelLayout);
        lcdPanelLayout.setHorizontalGroup(
                lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                                .addGap(1, 1, 1)
                                                                .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, lcdPanelLayout.createSequentialGroup()
                                                                .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(caloriesTextfield, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(caloriesLabel))
                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(priceLabel))
                                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(nameLabel)))
                                .addContainerGap(32, Short.MAX_VALUE))
        );
        lcdPanelLayout.setVerticalGroup(
                lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(lcdPanelLayout.createSequentialGroup()
                                .addContainerGap(22, Short.MAX_VALUE)
                                .addComponent(nameLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(priceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(priceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)
                                .addComponent(caloriesLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(caloriesTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(lcdPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(purchaseButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))
        );



        newslotPanel = new JPanel();
        slotPanels = new JPanel[9];
        slotTextAreas = new JTextArea[9];
        slotButtons = new JButton[9];

        newslotPanel.setSize(new Dimension(470,404));
        newslotPanel.setPreferredSize(new Dimension(470,404));
        newslotPanel.setLayout(new GridLayout(3,3,5,5));

        for (int i=0;i<9;i++)
        {
            slotPanels[i] = new JPanel();
            slotTextAreas[i] = new JTextArea();
            slotButtons[i] = new JButton(""+i);
        }

        // for the text area
        for (int i=0;i<9;i++)
        {
            slotTextAreas[i].setRows(6);
            slotTextAreas[i].setEditable(false);
            slotTextAreas[i].setSize(new Dimension(40, 40));
            slotTextAreas[i].setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14));
        }

        // for the panels
        for (int i=0;i<9;i++)
        {
            slotPanels[i].setBackground(new java.awt.Color(255, 255, 255));
            slotPanels[i].setSize(new Dimension(40, 40));
        }

        // for the panel layouts
        for (int i=0;i<9;i++)
        {
            slotPanels[i].setLayout(new BorderLayout());
            slotPanels[i].add(slotTextAreas[i],  BorderLayout.NORTH);
            slotPanels[i].add(slotButtons[i], BorderLayout.SOUTH);
            slotButtons[i].setPreferredSize(new Dimension(20,20));
            slotButtons[i].setEnabled(false);
        }

        // adds all the panels in the main panel
        for (int i=0;i<9;i++)
        {
            newslotPanel.add(slotPanels[i]);
        }

        slotPanel.add(newslotPanel);




        javax.swing.GroupLayout slotPanelLayout = new javax.swing.GroupLayout(slotPanel);
        slotPanel.setLayout(slotPanelLayout);
        slotPanelLayout.setHorizontalGroup(
                slotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 470, Short.MAX_VALUE)
        );
        slotPanelLayout.setVerticalGroup(
                slotPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 404, Short.MAX_VALUE)
        );

        putmoneyButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        putmoneyButton.setText("Put Money");

        additemButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 12)); // NOI18N
        additemButton.setText("Add item");

        balanceLabel.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        balanceLabel.setText("Balance:");

        changeTextArea.setColumns(20);
        changeTextArea.setRows(5);
        changeTextArea.setEditable(false);

        changeScrollPane.setViewportView(changeTextArea);
        changeScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        changeScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));


        customizeTextArea.setColumns(20);
        customizeTextArea.setRows(5);
        customizeTextArea.setEditable(false);
        customizeScrollPane.setViewportView(customizeTextArea);
        customizeScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        customizeScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));


        customizeButton.setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 18)); // NOI18N
        customizeButton.setText("Customize");

        itemTrayTextArea.setColumns(20);
        itemTrayTextArea.setRows(5);
        itemTrayScrollPane.setViewportView(itemTrayTextArea);
        itemTrayScrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0,0));
        itemTrayScrollPane.getHorizontalScrollBar().setPreferredSize(new Dimension(0,0));

        newBasePanel = new JPanel();
        basePanels = new JPanel[3];
        baseTextAreas = new JTextArea[3];
        baseButtons = new JButton[3];

        newBasePanel.setSize(new Dimension(390,112));
        newBasePanel.setLayout(new GridLayout(0,3,5,0));
        for (int i=0;i<3;i++)
        {
            basePanels[i] = new JPanel();
            baseTextAreas[i] = new JTextArea();
            baseButtons[i] = new JButton();
        }

        // for the text area
        for (int i=0;i<3;i++)
        {
            baseTextAreas[i].setRows(6);
            baseTextAreas[i].setBackground(new Color(255,255,255));
            baseTextAreas[i].setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14));
            baseTextAreas[i].setEditable(false);
        }

        // for the panels
        for (int i=0;i<3;i++)
        {
            basePanels[i].setBackground(new java.awt.Color(255, 255, 255));
        }

        // for the panel layouts
        for (int i=0;i<3;i++)
        {
            basePanels[i].setLayout(new BorderLayout());
            basePanels[i].add(baseTextAreas[i],  BorderLayout.NORTH);
            basePanels[i].add(baseButtons[i], BorderLayout.SOUTH);
            baseButtons[i].setPreferredSize(new Dimension(20,15));
            baseButtons[i].setEnabled(false);
        }

        // adds all the panels in the main panel
        for (int i=0;i<3;i++)
        {
            newBasePanel.add(basePanels[i]);
        }

        baseItemPanel.add(newBasePanel);

        javax.swing.GroupLayout baseItemPanelLayout = new javax.swing.GroupLayout(baseItemPanel);
        baseItemPanel.setLayout(baseItemPanelLayout);
        baseItemPanelLayout.setHorizontalGroup(
                baseItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        baseItemPanelLayout.setVerticalGroup(
                baseItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 112, Short.MAX_VALUE)
        );

        OtherItemPanel.setBackground(new java.awt.Color(0, 0, 0));

        newItemPanel = new JPanel();
        itemPanels = new JPanel[12];
        itemTextAreas = new JTextArea[12];
        itemButtons = new JButton[12];

        itemTrayTextArea.setEditable(false);

        newItemPanel.setSize(new Dimension(393,432));
        newItemPanel.setLayout(new GridLayout(4,3,6,6));
        for (int i=0;i<12;i++)
        {
            itemPanels[i] = new JPanel();
            itemTextAreas[i] = new JTextArea();
            itemButtons[i] = new JButton();
        }

        // for the text area
        for (int i=0;i<12;i++)
        {
            itemTextAreas[i].setRows(5);
            itemTextAreas[i].setEditable(false);
            itemTextAreas[i].setFont(new java.awt.Font("UD Digi Kyokasho N-B", 0, 14));
        }

        // for the panels
        for (int i=0;i<12;i++)
        {
            itemPanels[i].setBackground(new java.awt.Color(255,255,255));
            itemButtons[i].setPreferredSize(new Dimension(20,10));
        }

        // for the panel layouts
        for (int i=0;i<12;i++)
        {
            itemPanels[i].setLayout(new BorderLayout());
            itemPanels[i].add(itemTextAreas[i],  BorderLayout.NORTH);
            itemPanels[i].add(itemButtons[i], BorderLayout.SOUTH);
            itemButtons[i].setPreferredSize(new Dimension(20,15));
            itemButtons[i].setEnabled(false);
        }

        // adds all the panels in the main panel
        for (int i=0;i<12;i++)
        {
            newItemPanel.add(itemPanels[i]);
        }

        OtherItemPanel.add(newItemPanel);


        javax.swing.GroupLayout OtherItemPanelLayout = new javax.swing.GroupLayout(OtherItemPanel);
        OtherItemPanel.setLayout(OtherItemPanelLayout);
        OtherItemPanelLayout.setHorizontalGroup(
                OtherItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 395, Short.MAX_VALUE)
        );
        OtherItemPanelLayout.setVerticalGroup(
                OtherItemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        resetButton.setText("🔄");

        refreshButton.setText("refreshButton");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(22, 22, 22)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(3, 3, 3)
                                                .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(itemTrayScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(changeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(slotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(statusSVMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(customizeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGap(3, 3, 3)
                                                                        .addComponent(lcdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addComponent(customizeButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(12, 12, 12)
                                                                .addComponent(putmoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(balanceLabel)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(balanceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(additemButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(returnButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(refreshButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(OtherItemPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(baseItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(resetButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(titlePanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(slotPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(itemTrayScrollPane)
                                                        .addComponent(changeScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(baseItemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(OtherItemPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(customizeScrollPane)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(customizeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                                        .addComponent(balanceLabel)
                                                                        .addComponent(balanceTextfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(putmoneyButton, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(lcdPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addComponent(statusSVMTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(additemButton)
                                                        .addComponent(returnButton)
                                                        .addComponent(resetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(refreshButton))))
                                .addGap(61, 61, 61))
        );

        pack();
        setVisible(false);
        setLocationRelativeTo(null);

    }

    public JButton[] getBaseButtons() {
        return baseButtons;
    }

    public JButton[] getItemButtons() {
        return itemButtons;
    }

    public JTextArea[] getItemTextAreas() {
        return itemTextAreas;
    }

    public JTextArea[] getBaseTextAreas() {
        return baseTextAreas;
    }

    public JTextArea[] getSlotTextAreas() {
        return slotTextAreas;
    }


    public JTextField getBalanceTextfield() {
        return balanceTextfield;
    }

    public JTextField getStatusSVMTextfield() {
        return statusSVMTextField;
    }
    public JLabel getTitleLabel1() {
        return titleLabel1;
    }

    public JTextArea getChangeTextArea() {
        return changeTextArea;
    }

    public JButton[] getSlotButtons() {
        return slotButtons;
    }

    public void setcustomizeButtonListener(ActionListener actionListener) {
        this.customizeButton.addActionListener(actionListener);
    }

    public void setcancelButtonListener(ActionListener actionListener) {
        this.cancelButton.addActionListener(actionListener);
    }

    public void setadditemButtonListener(ActionListener actionListener) {
        this.additemButton.addActionListener(actionListener);
    }

    public void setputmoneyButtonListener(ActionListener actionListener) {
        this.putmoneyButton.addActionListener(actionListener);
    }

    public void setresetButtonListener(ActionListener actionListener) {
        this.resetButton.addActionListener(actionListener);
    }

    public void setstatusSVMTextfieldListener(MouseListener MouseListener) {
        this.statusSVMTextField.addMouseListener(MouseListener);
    }

    public void setpurchaseButtonListener(ActionListener actionListener) {
        this.purchaseButton.addActionListener(actionListener);
    }
    public void setslotButtonsListener(ActionListener actionListener) {
        for(int i=0;i<9;i++)
        {
            this.slotButtons[i].addActionListener(actionListener);
        }
    }

    public void setreturnButtonListener(ActionListener actionListener) {
        this.returnButton.addActionListener(actionListener);
    }

    public void setitemTrayTextAreaListener(MouseListener MouseListener) {
        this.itemTrayTextArea.addMouseListener(MouseListener);
    }

    public void setchangeTextAreaListener(MouseListener MouseListener) {
        this.changeTextArea.addMouseListener(MouseListener);
    }

    public void setbaseButtonsListener(ActionListener actionListener) {
        for(int i=0;i<3;i++)
        {
            this.baseButtons[i].addActionListener(actionListener);
        }
    }

    public JButton getPurchaseButton() {
        return purchaseButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }

    public void setrefreshButtonListener(ActionListener actionListener) {
        for(int i=0;i<3;i++)
        {
            this.refreshButton.addActionListener(actionListener);
        }
    }

    public void setitemButtonsListener(ActionListener actionListener) {
        for(int i=0;i<9;i++)
        {
            this.itemButtons[i].addActionListener(actionListener);
        }
    }

    public JTextArea getItemTrayTextArea() {
        return itemTrayTextArea;
    }

    public JTextArea getCustomizeTextArea() {
        return customizeTextArea;
    }

    public JTextField getPriceTextfield() {
        return priceTextfield;
    }

    public JTextField getCaloriesTextfield() {
        return caloriesTextfield;
    }

    public JTextField getNameTextfield() {
        return nameTextfield;
    }

    // setVisible(true);
    // pack();
    private javax.swing.JPanel OtherItemPanel;
    private javax.swing.JButton additemButton;
    private javax.swing.JLabel balanceLabel;
    private javax.swing.JTextField balanceTextfield;
    private javax.swing.JPanel baseItemPanel;
    private javax.swing.JLabel caloriesLabel;
    private javax.swing.JTextField caloriesTextfield;
    private javax.swing.JButton cancelButton;
    private javax.swing.JScrollPane changeScrollPane;
    private javax.swing.JTextArea changeTextArea;
    private javax.swing.JButton customizeButton;
    private javax.swing.JScrollPane customizeScrollPane;
    private javax.swing.JTextArea customizeTextArea;
    private javax.swing.JScrollPane itemTrayScrollPane;
    private javax.swing.JTextArea itemTrayTextArea;
    private javax.swing.JPanel lcdPanel;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextfield;
    private javax.swing.JLabel priceLabel;
    private javax.swing.JTextField priceTextfield;
    private javax.swing.JButton purchaseButton;
    private javax.swing.JButton putmoneyButton;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton returnButton;
    private javax.swing.JPanel slotPanel;
    private javax.swing.JTextField statusSVMTextField;
    private javax.swing.JLabel titleLabel1;
    private javax.swing.JPanel titlePanel1;
    private javax.swing.JButton refreshButton;

    private JPanel newslotPanel;
    private JPanel[] slotPanels;
    private JTextArea[] slotTextAreas;
    private JButton[] slotButtons;

    private JPanel newBasePanel;
    private JPanel[] basePanels;
    private JTextArea[] baseTextAreas;
    private JButton[] baseButtons;

    private JPanel newItemPanel;
    private JPanel[] itemPanels;
    private JTextArea[] itemTextAreas;
    private JButton[] itemButtons;
    
}

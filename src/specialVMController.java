import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class specialVMController {

    specialVMView SVMview;
    SpecialVendingMachine SVMmodel;
    specialvmOptionsView specialoptionsView;




    specialVMController(specialVMView specialvmview, SpecialVendingMachine specialvendingmachine, specialvmOptionsView specialvmoptionsview, String VMtitle)
    {

        SVMview = specialvmview;
        SVMmodel = specialvendingmachine;
        specialoptionsView = specialvmoptionsview;
        SVMview.setTitle(VMtitle);
        SVMview.getTitleLabel1().setText(VMtitle);

        SVMview.getBalanceTextfield().setText("            ");


        this.SVMview.setadditemButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                addItemSpecialView additemspeciaview = new addItemSpecialView();
                additemSpecialController additemspecialcontroller =  new additemSpecialController(additemspeciaview, specialvendingmachine,specialvmview);
            }
        });

        this.SVMview.setcustomizeButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                for (int i=0;i<3;i++)
                {
                    (SVMview.getBaseButtons())[i].setEnabled(true);
                    (SVMview.getBaseTextAreas())[i].setBackground(new java.awt.Color(194,231,249));
                }
                for(int i=0;i<9;i++)
                {
                    (SVMview.getSlotButtons())[i].setEnabled(false);
                }

            }
        });

        this.SVMview.setitemTrayTextAreaListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                SVMview.getItemTrayTextArea().setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        this.SVMview.setchangeTextAreaListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                SVMview.getChangeTextArea().setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        //

        this.SVMview.setputmoneyButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                insertMoneySpecialView insertmoneyspecialview = new insertMoneySpecialView();
                insertMoneySpecialController insertmoneyspecialcontroller = new insertMoneySpecialController(insertmoneyspecialview, specialvendingmachine, SVMview);
            }
        });

        this.SVMview.setrefreshButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                refreshslots();
                refreshitemslots();
                refreshbaseslots();
                refreshCustomizingLCD();
            }
        });

        this.SVMview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                SVMmodel.setStoredCash(0);
                SVMview.getChangeTextArea().setText("");
                SVMview.setVisible(false);
                SVMview.getBalanceTextfield().setText(""+0);
                specialvmoptionsview.setVisible(true);
                SVMmodel.getCustomizedItem().clear();

            }
        });



        this.SVMview.setpurchaseButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                if (SVMmodel.getCustomizedItem().size() == 0)
                {
                    if (!((SVMmodel.getStoredCash() - SVMmodel.getSelectedItem().getPrice() ) >= 0))
                    {
                        SVMview.getStatusSVMTextfield().setText("Insufficient Funds!");
                    }
                    else if (SVMmodel.checkIfItemAvailable(SVMmodel.getSelectedItem()))
                    {
                        if (SVMmodel.doTransaction(SVMmodel.getSelectedItem()))
                        {
                            SVMview.getStatusSVMTextfield().setText("Purchase Success");

                            SVMview.getItemTrayTextArea().setText("" + SVMmodel.getSelectedItem().getName());

                            SVMview.getBalanceTextfield().setText("" +SVMmodel.getStoredCash());

                            SVMmodel.setSelectedItem(null);
                        }
                        else
                        {
                            SVMview.getStatusSVMTextfield().setText("Error");
                        }
                    }

                    refreshslots();
                }
                else
                {
                    if (!((SVMmodel.getStoredCash() - SVMmodel.getPriceCustomizedItem()) >= 0))
                    {
                        SVMview.getStatusSVMTextfield().setText("Insufficient Funds");
                    }
                    else
                    {
                        if (SVMmodel.doSpecialTransaction())
                        {
                            SVMview.getStatusSVMTextfield().setText("Succesfully purchased");
                            SVMview.getBalanceTextfield().setText("" +SVMmodel.getStoredCash());
                            SVMview.getItemTrayTextArea().setText(SVMmodel.getCustomizedItem().get(0).getName() + "\n");
                            for (int i=1;i<SVMmodel.getCustomizedItem().size();i++)
                            {
                                SVMview.getItemTrayTextArea().append("" + SVMmodel.getCustomizedItem().get(i).getName() + "\n");
                            }
                            SVMmodel.purchaseCustomizedItem();



                        }
                        else
                        {
                            SVMview.getStatusSVMTextfield().setText("Purchase unsuccessful");
                        }
                    }

                    refreshbaseslots();
                    refreshslots();
                    refreshitemslots();
                }
            }
        });

        this.SVMview.setcancelButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                ArrayList<Integer> changeHolder = new ArrayList<>();
                changeHolder = SVMmodel.giveChange(SVMmodel.getStoredCash());
                SVMview.getChangeTextArea().setText(changeHolder.get(0).toString() + "\n");
                if (changeHolder.size()>0)
                {
                    for(int i=1;i<changeHolder.size();i++)
                    {
                        SVMview.getChangeTextArea().append(changeHolder.get(i).toString() + "\n");
                    }
                }
                SVMview.getNameTextfield().setText("");
                SVMview.getPriceTextfield().setText("");
                SVMview.getCaloriesTextfield().setText("");

                SVMview.getStatusSVMTextfield().setText("Purchase Cancelled");

                SVMview.getPurchaseButton().setEnabled(false);
                SVMview.getCancelButton().setEnabled(false);

                SVMmodel.setStoredCash(0);
                SVMview.getBalanceTextfield().setText(""+SVMmodel.getStoredCash());
            }
        });
        this.SVMview.setresetButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                for (int i=0;i<3;i++)
                {
                    (SVMview.getBaseButtons())[i].setEnabled(false);
                    (SVMview.getBaseTextAreas())[i].setBackground(new java.awt.Color(255,255,255));
                }
                for (int i=0;i<12;i++)
                {
                    (SVMview.getItemButtons())[i].setEnabled(false);
                    (SVMview.getItemTextAreas())[i].setBackground(new java.awt.Color(255,255,255));
                }

                for (int i=0;i<12;i++)
                {
                    (SVMview.getSlotButtons())[i].setEnabled(true);
                }


            }
        });

        this.SVMview.setbaseButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int counter = 0;
                for(int i=0;i<3;i++)
                {
                    if (e.getSource() == (SVMview.getBaseButtons())[i])
                    {
                        SVMview.getPurchaseButton().setEnabled(true);
                        SVMview.getCancelButton().setEnabled(true);
                        int index = SVMmodel.getBaseItemIndex().get(i);
                        SVMview.getStatusSVMTextfield().setText("Base item: " + index);

                        SVMview.getNameTextfield().setText("" +(SVMmodel.getExclusiveItemRecord())[index].getName());
                        SVMview.getPriceTextfield().setText("" +(SVMmodel.getExclusiveItemRecord())[index].getPrice());
                        SVMview.getCaloriesTextfield().setText("" +(SVMmodel.getExclusiveItemRecord())[index].getCalories());


                        if (SVMmodel.isExclusiveItemAvailable((SVMmodel.getExclusiveItemRecord())[index]))
                        {
                            SVMmodel.customizingItem(SVMmodel.getExclusiveItemRecord()[index]);

                            for (int j = 0;j<3;j++)
                            {
                                (SVMview.getBaseButtons())[j].setEnabled(false);
                            }
                        }
                        else
                        {
                            SVMview.getStatusSVMTextfield().setText("Unavailable");
                        }

                        for (int j=0;j<12;j++)
                        {
                            (SVMview.getItemButtons())[j].setEnabled(true);
                            (SVMview.getSlotButtons())[j].setEnabled(true);
                            (SVMview.getItemTextAreas())[j].setBackground(new java.awt.Color(194,231,249));
                        }

                    }
                }
            }
        });

        this.SVMview.setitemButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                int counter = 0;
                for(int i=0;i<9;i++)
                {
                    if (e.getSource() == (SVMview.getItemButtons())[i])
                    {
                        SVMview.getPurchaseButton().setEnabled(true);
                        SVMview.getCancelButton().setEnabled(true);
                        int index = SVMmodel.getOtherItemIndex().get(i);
                        SVMview.getStatusSVMTextfield().setText("Other item: " + index);

                        SVMview.getNameTextfield().setText("" +(SVMmodel.getExclusiveItemRecord())[index].getName());
                        SVMview.getPriceTextfield().setText("" +(SVMmodel.getExclusiveItemRecord())[index].getPrice());
                        SVMview.getCaloriesTextfield().setText("" +(SVMmodel.getExclusiveItemRecord())[index].getCalories());
                        if (SVMmodel.getCustomizedItem().size() < 5)
                        {
                            SVMmodel.getCustomizedItem().add((SVMmodel.getExclusiveItemRecord())[index]);
                            SVMview.getStatusSVMTextfield().setText("Added! ");
                        }
                        else
                        {
                            SVMview.getStatusSVMTextfield().setText("You can only add up to 4 items");
                            for(int j=0;j<12;j++)
                            {
                                (SVMview.getItemButtons())[j].setEnabled(false);
                            }

                        }

                    }
                }
            }
        });

        this.SVMview.setslotButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 9; i++) {
                    if (e.getSource() == (SVMview.getSlotButtons())[i])
                    {
                        if (!(SVMmodel.getCustomizedItem().size()>0))
                        {
                            SVMview.getNameTextfield().setText("" + SVMmodel.getSlot(i).getPrimaryItem().getName());
                            SVMview.getPriceTextfield().setText("" + SVMmodel.getSlot(i).getPrimaryItem().getPrice());
                            SVMview.getCaloriesTextfield().setText("" + SVMmodel.getSlot(i).getPrimaryItem().getCalories());
                            SVMview.getStatusSVMTextfield().setText("Selecting "+ SVMmodel.getSlot(i).getPrimaryItem().getName());

                            SVMmodel.setSelectedItem(SVMmodel.getSlot(i).getPrimaryItem());
                            SVMview.getPurchaseButton().setEnabled(true);
                            SVMview.getCancelButton().setEnabled(true);
                        }
                        else
                        {
                            if(SVMmodel.checkIfItemAvailable(SVMmodel.getSlot(i).getPrimaryItem()))
                            {
                                SVMmodel.getCustomizedItem().add(SVMmodel.getSlot(i).getPrimaryItem());
                            }
                            else
                            {
                                SVMview.getStatusSVMTextfield().setText("Unavailable");
                            }
                        }

                    }
                }
            }
        });


    }
    public specialVMView getSpecialvmview() {
        return SVMview;
    }

    public void refreshslots()
    {
        for(int i=0;i<SVMmodel.getCURRENTnumberOfItems();i++)
        {
            (SVMview.getSlotTextAreas())[i].setText("Item: " + SVMmodel.getSlot(i).getPrimaryItem().getName());
            (SVMview.getSlotTextAreas())[i].append("\nPrice: " + SVMmodel.getSlot(i).getPrimaryItem().getPrice());
            (SVMview.getSlotTextAreas())[i].append("\nCalories: "+ SVMmodel.getSlot(i).getPrimaryItem().getCalories());
            (SVMview.getSlotTextAreas())[i].append("\nQuantity: " + (SVMmodel.getItem())[i].size());
        }
    }
    public void refreshbaseslots()
    {
        int j = 0;
        for(int i=0;i<SVMmodel.getCURRENTnumberOfExclusiveItems();i++)
        {
            Item tempItem = (SVMmodel.getExclusiveItemRecord())[i];
            if ( tempItem instanceof BaseItem)
            {
                (SVMview.getBaseTextAreas())[j].setText("\nItem: " + (SVMmodel.getExclusiveSlot())[i].getPrimaryItem().getName());
                (SVMview.getBaseTextAreas())[j].append("\nPrice: " + (SVMmodel.getExclusiveSlot())[i].getPrimaryItem().getPrice());
                (SVMview.getBaseTextAreas())[j].append("\nCalories: "+ (SVMmodel.getExclusiveSlot())[i].getPrimaryItem().getCalories());
                (SVMview.getBaseTextAreas())[j].append("\nQuantity: " + (SVMmodel.getExclusiveItems())[i].size());
                j++;
            }

        }
    }

    public void refreshCustomizingLCD()
    {
        SVMview.getCustomizeTextArea().setText("Customizing Items: \n");

        if (SVMmodel.getCURRENTnumberOfExclusiveItems() > 0)
        {
            for (int i = 0; i < SVMmodel.getCustomizedItem().size() ; i++)
            {
                SVMview.getCustomizeTextArea().append("Item: " + SVMmodel.getCustomizedItem().get(i).getName() + "\n");
            }
        }
        SVMview.getCustomizeTextArea().append("Total Calories: " + SVMmodel.getCaloriesCustomizedItem());
        SVMview.getCustomizeTextArea().append("\nTotal Price: " + SVMmodel.getPriceCustomizedItem());
    }


    public void refreshitemslots()
    {
        int j=0;

        for(int i=0;i<SVMmodel.getCURRENTnumberOfExclusiveItems();i++)
        {
            Item tempItem = (SVMmodel.getExclusiveItemRecord())[i];
            if (tempItem instanceof DependentItem)
            {
                (SVMview.getItemTextAreas())[j].setText("Item: " + (SVMmodel.getExclusiveSlot())[i].getPrimaryItem().getName());
                (SVMview.getItemTextAreas())[j].append("\nPrice: " + (SVMmodel.getExclusiveSlot())[i].getPrimaryItem().getPrice());
                (SVMview.getItemTextAreas())[j].append("\nCalories: "+ (SVMmodel.getExclusiveSlot())[i].getPrimaryItem().getCalories());
                (SVMview.getItemTextAreas())[j].append("\nQuantity: " + (SVMmodel.getExclusiveItems())[i].size());
                j++;
            }

        }
    }



}

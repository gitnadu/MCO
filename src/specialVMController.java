import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
                for (int i=0;i<12;i++)
                {
                    (SVMview.getItemButtons())[i].setEnabled(true);
                    (SVMview.getItemTextAreas())[i].setBackground(new java.awt.Color(194,231,249));
                }
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

        this.SVMview.setpurchaseButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                if (!((SVMview.getBaseButtons())[0].isEnabled()))
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
                        }
                        else
                        {
                            SVMview.getStatusSVMTextfield().setText("Error");
                        }
                    }
                }
                {
                    if (!((SVMmodel.getStoredCash() - SVMmodel.getPriceCustomizedItem()) >= 0))
                    {
                        SVMview.getStatusSVMTextfield().setText("Insufficient Funds!");
                    }
                    else
                    {
                        if (SVMmodel.doSpecialTransaction())
                        {
                            SVMview.getStatusSVMTextfield().setText("Purchase Success");
                            SVMview.getItemTrayTextArea().setText(SVMmodel.getCustomizedItem().get(0).getName() + "\n");
                            for (int i=1;i<SVMmodel.getCURRENTnumberOfExclusiveItems();i++)
                            {
                                SVMview.getItemTrayTextArea().append("" + SVMmodel.getCustomizedItem().get(0).getName() + "\n");
                            }
                            SVMmodel.purchaseCustomizedItem();
                            SVMview.getBalanceTextfield().setText("" +SVMmodel.getStoredCash());
                        }
                        else
                        {
                            SVMview.getStatusSVMTextfield().setText("Error");
                        }
                    }
                }


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
                        counter = i+1;
                        for (int j=0; j<12;j++)
                        {
                            if ( (SVMmodel.getExclusiveItemRecord())[j] instanceof BaseItem)
                            {
                                counter--;

                                if (counter == 0)
                                {
                                    SVMview.getNameTextfield().setText(""+ (SVMmodel.getExclusiveItemRecord())[j].getName());
                                    SVMview.getPriceTextfield().setText(""+ (SVMmodel.getExclusiveItemRecord())[j].getPrice());
                                    SVMview.getCaloriesTextfield().setText(""+ (SVMmodel.getExclusiveItemRecord())[j].getCalories());
                                    SVMmodel.getCustomizedItem().add((SVMmodel.getExclusiveItemRecord())[j]);
                                }
                            }
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
                        counter = i+1;
                        for (int j=0; j<12;j++)
                        {
                            if ( (SVMmodel.getExclusiveItemRecord())[j] instanceof DependentItem)
                            {
                                counter--;

                                if (counter == 0)
                                {
                                    SVMview.getNameTextfield().setText(""+ (SVMmodel.getExclusiveItemRecord())[j].getName());
                                    SVMview.getPriceTextfield().setText(""+ (SVMmodel.getExclusiveItemRecord())[j].getPrice());
                                    SVMview.getCaloriesTextfield().setText(""+ (SVMmodel.getExclusiveItemRecord())[j].getCalories());
                                    SVMmodel.getCustomizedItem().add((SVMmodel.getExclusiveItemRecord())[j]);
                                }
                            }
                        }
                    }
                }
            }
        });

        this.SVMview.setslotButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                for (int i = 9; i < 9; i++) {
                    if (e.getSource() == (SVMview.getSlotButtons())[i])
                    {


                            SVMview.getNameTextfield().setText("" + SVMmodel.getSlot(i).getPrimaryItem().getName());
                            SVMview.getPriceTextfield().setText("" + SVMmodel.getSlot(i).getPrimaryItem().getPrice());
                            SVMview.getCaloriesTextfield().setText("" + SVMmodel.getSlot(i).getPrimaryItem().getCalories());

                            SVMmodel.setSelectedItem(SVMmodel.getSlot(i).getPrimaryItem());



                            SVMview.getStatusSVMTextfield().setText("mali yan");
                            SVMview.getNameTextfield().setText(""+ SVMmodel.getSlot(i).getPrimaryItem().getName());
                            SVMview.getPriceTextfield().setText(""+ SVMmodel.getSlot(i).getPrimaryItem().getPrice());
                            SVMview.getCaloriesTextfield().setText(""+ SVMmodel.getSlot(i).getPrimaryItem().getCalories());
                            SVMmodel.getCustomizedItem().add(SVMmodel.getSlot(i).getPrimaryItem());

                    }
                }
            }
        });

        //

        this.SVMview.setstatusSVMTextFieldListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                refreshbaseslots();
                refreshslots();
                refreshitemslots();
                refreshCustomizingLCD();
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
            for (int i = 0; i < SVMmodel.getCURRENTnumberOfExclusiveItems(); i++)
            {
                SVMview.getCustomizeTextArea().append("Item: " + SVMmodel.getCustomizedItem().get(i).getName() + "\n");
            }
        }

        SVMview.getCustomizeTextArea().append("Total Calories: " + SVMmodel.getCaloriesCustomizedItem());
        SVMview.getCustomizeTextArea().append("Total Price: " + SVMmodel.getPriceCustomizedItem());
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

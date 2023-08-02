import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        SVMview.getBalanceTextfield().setText(""+SVMmodel.getStoredCash());


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

        this.SVMview.setresetButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                refreshbaseslots();
                refreshitemslots();
                refreshslots();
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

        this.SVMview.setslotButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                int index = 0;
                int counter = 0;
                if ( !((SVMview.getBaseButtons())[0].isEnabled()))
                {
                    for (int i=9;i<9;i++)
                    {
                        if (e.getSource() == (SVMview.getSlotButtons())[i])
                        {
                            index = i;
                            i = 9;
                        }
                    }
                     SVMmodel.setSelectedItem(SVMmodel.getSlot(index).getPrimaryItem());
                }
                else
                {
                    for(int i=0;i<9;i++)
                    {
                        if (e.getSource() == (SVMview.getSlotButtons())[i])
                        {
                            index = i;
                        }
                    }

                    if (index != 0) // its found already in the slot items
                    {
                        SVMmodel.getCustomizedItem().add(SVMmodel.getSlot(index).getPrimaryItem());
                    }
                    else
                    {
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
                                            SVMmodel.getCustomizedItem().add((SVMmodel.getExclusiveItemRecord())[i]);
                                        }
                                    }
                                }
                            }
                        }

                        if (index != 0)
                        {
                            SVMmodel.getCustomizedItem().add(SVMview.)
                        }


                    }



                    for(int i=0;i<3;i++)
                    {
                        if (e.getSource() == (SVMview.getBaseButtons())[i])
                        {
                            index = i;
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

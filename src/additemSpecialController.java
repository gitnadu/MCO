import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class additemSpecialController {
    addItemSpecialView additemspecialview;
    SpecialVendingMachine specialvendingmachine;
    specialVMView SVMview;
    additemSpecialController(addItemSpecialView additemspecialview,SpecialVendingMachine specialvendingmachine, specialVMView specialvmview)
    {
        this.additemspecialview = additemspecialview;
        this.specialvendingmachine = specialvendingmachine;
        this.SVMview = specialvmview;

        if(specialvendingmachine.getBaseItemIndex().size() > 0)
        {
            additemspecialview.getOtherItemRButton().setEnabled(true);
        }

        this.additemspecialview.setconfirmButtonListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                String itemName;
                Float itemPrice;
                Float itemCalories;
                Integer itemQuantity;

                itemName = additemspecialview.getNameTextfield().getText();
                itemPrice = Float.parseFloat(additemspecialview.getPriceTextfield().getText());
                itemCalories = Float.parseFloat(additemspecialview.getCaloriesTextfield().getText());
                itemQuantity = Integer.parseInt(additemspecialview.getQuantityTextfield().getText());
                if (itemQuantity < 10)
                {
                    additemspecialview.getStatusTextfield().setText("Add at least 10");
                }
                else if (additemspecialview.getNameTextfield().getText().isEmpty() || additemspecialview.getPriceTextfield().getText().isEmpty() || additemspecialview.getCaloriesTextfield().getText().isEmpty() || additemspecialview.getQuantityTextfield().getText().isEmpty())
                {
                    if (!(additemspecialview.getBaseItemRButton().isSelected()) && !(additemspecialview.getSlotItemRButton().isSelected()) && !(additemspecialview.getOtherItemRButton().isSelected())) {
                        additemspecialview.getStatusTextfield().setText("Error...");
                    }
                    else
                    {
                        additemspecialview.getStatusTextfield().setText("Incomplete details");
                    }
                }
                else if(itemPrice < 0 || itemCalories < 0 ||itemQuantity < 0)
                {
                    additemspecialview.getStatusTextfield().setText("Invalid input..");
                }
                else
                {
                    if (!(additemspecialview.getBaseItemRButton().isSelected()) && !(additemspecialview.getSlotItemRButton().isSelected()) && !(additemspecialview.getOtherItemRButton().isSelected())) {
                        additemspecialview.getStatusTextfield().setText("Select one please...");
                    }
                    else
                    {
                        if (additemspecialview.getBaseItemRButton().isSelected())
                        {
                            boolean exists = false;
                            for (int i=0;i<specialvendingmachine.getBaseItemIndex().size();i++)
                            {
                                int index = (specialvendingmachine.getBaseItemIndex()).get(i);
                                if (itemName.compareTo( (specialvendingmachine.getExclusiveItemRecord())[index].getName())==0)
                                {
                                    exists = true;
                                }
                            }
                            if (exists)
                            {
                                additemspecialview.getStatusTextfield().setText("Already exists");
                            }
                            else if (specialvendingmachine.getBaseItemIndex().size() > 2)
                            {
                                additemspecialview.getStatusTextfield().setText("Slots Full..");
                            }
                            else
                            {
                                additemspecialview.getStatusTextfield().setText("Successfully Added!");
                                specialvendingmachine.addBaseItem(itemName,itemPrice,itemCalories,itemQuantity);
                                SVMview.getCustomizeButton().setEnabled(true);
                                additemspecialview.getOtherItemRButton().setEnabled(true);
                            }

                        }
                        else if (additemspecialview.getSlotItemRButton().isSelected())
                        {
                            boolean exists = false;
                            for (int i=0;i<9;i++)
                            {
                                if (itemName.compareTo((specialvendingmachine.getItemRecord())[i].getName())==0)
                                {
                                    exists = true;
                                }
                            }

                            if (exists)
                            {
                                additemspecialview.getStatusTextfield().setText("Already exists");
                            }
                            else if (specialvendingmachine.getCURRENTnumberOfItems() > 8)
                            {
                                additemspecialview.getStatusTextfield().setText("Slots Full..");
                            }
                            else
                            {
                                additemspecialview.getStatusTextfield().setText("Successfully Added!");
                                specialvendingmachine.addItem(itemName,itemPrice,itemCalories,itemQuantity);
                                (SVMview.getSlotButtons())[specialvendingmachine.getCURRENTnumberOfItems()-1].setEnabled(true);
                            }

                        }
                        else if (additemspecialview.getOtherItemRButton().isSelected())
                        {
                            boolean exists = false;
                            for (int i=0;i<specialvendingmachine.getOtherItemIndex().size();i++)
                            {
                                int index = (specialvendingmachine.getOtherItemIndex()).get(i);
                                if (itemName.compareTo( (specialvendingmachine.getExclusiveItemRecord())[index].getName())==0)
                                {
                                    exists = true;
                                }
                            }

                            if (exists)
                            {
                                additemspecialview.getStatusTextfield().setText("Already exists");
                            }
                            else if (specialvendingmachine.getOtherItemIndex().size() > 8)
                            {
                                additemspecialview.getStatusTextfield().setText("Slots Full");
                            }
                            else
                            {
                                specialvendingmachine.addOtherItem(itemName,itemPrice,itemCalories,itemQuantity);
                                additemspecialview.getStatusTextfield().setText("Successfully Added!");
                            }

                        }

                    }
                }

                additemspecialview.getNameTextfield().setText("");
                additemspecialview.getPriceTextfield().setText("");
                additemspecialview.getCaloriesTextfield().setText("");
                additemspecialview.getQuantityTextfield().setText("");

            }
        });

        this.additemspecialview.setcancelButtonListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                additemspecialview.setVisible(false);
                additemspecialview.getNameTextfield().setText("");
                additemspecialview.getPriceTextfield().setText("");
                additemspecialview.getCaloriesTextfield().setText("");
                additemspecialview.getQuantityTextfield().setText("");
            }
        });

        this.additemspecialview.setslotItemRButtonListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                additemspecialview.getSlotItemRButton().setSelected(true);
                additemspecialview.getOtherItemRButton().setSelected(false);
                additemspecialview.getBaseItemRButton().setSelected(false);
            }
        });


        this.additemspecialview.setbaseItemRButtonListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){

                additemspecialview.getSlotItemRButton().setSelected(false);
                additemspecialview.getOtherItemRButton().setSelected(false);
                additemspecialview.getBaseItemRButton().setSelected(true);
            }
        });

        this.additemspecialview.setotherItemRButtonListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){

                additemspecialview.getSlotItemRButton().setSelected(false);
                additemspecialview.getBaseItemRButton().setSelected(false);
                additemspecialview.getOtherItemRButton().setSelected(true);
            }
        });
    }



}

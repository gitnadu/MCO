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

        this.additemspecialview.setconfirmButtonListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e){
                if (additemspecialview.getNameTextfield().getText().isEmpty() || additemspecialview.getPriceTextfield().getText().isEmpty() || additemspecialview.getCaloriesTextfield().getText().isEmpty() || additemspecialview.getQuantityTextfield().getText().isEmpty())
                {
                    if (!(additemspecialview.getBaseItemRButton().isSelected()) && !(additemspecialview.getSlotItemRButton().isSelected()) && !(additemspecialview.getOtherItemRButton().isSelected())) {
                        additemspecialview.getStatusTextfield().setText("Error...");
                    }
                    else
                    {
                        additemspecialview.getStatusTextfield().setText("Incomplete details");
                    }
                }
                else
                {
                    if (!(additemspecialview.getBaseItemRButton().isSelected()) && !(additemspecialview.getSlotItemRButton().isSelected()) && !(additemspecialview.getOtherItemRButton().isSelected())) {
                        additemspecialview.getStatusTextfield().setText("Select one please...");
                    }
                    else
                    {
                        String itemName;
                        Float itemPrice;
                        Float itemCalories;
                        Integer itemQuantity;

                        itemName = additemspecialview.getNameTextfield().getText();
                        itemPrice = Float.parseFloat(additemspecialview.getPriceTextfield().getText());
                        itemCalories = Float.parseFloat(additemspecialview.getCaloriesTextfield().getText());
                        itemQuantity = Integer.parseInt(additemspecialview.getQuantityTextfield().getText());

                        if (additemspecialview.getBaseItemRButton().isSelected())
                        {
                            SVMview.getStatusSVMTextfield().setText("base");
                            specialvendingmachine.addBaseItem(itemName,itemPrice,itemCalories,itemQuantity);
                        }
                        else if (additemspecialview.getSlotItemRButton().isSelected())
                        {
                            SVMview.getStatusSVMTextfield().setText("slot");
                            specialvendingmachine.addItem(itemName,itemPrice,itemCalories,itemQuantity);
                            (SVMview.getSlotButtons())[specialvendingmachine.getCURRENTnumberOfItems()-1].setEnabled(true);
                        }
                        else if (additemspecialview.getOtherItemRButton().isSelected())
                        {
                            SVMview.getStatusSVMTextfield().setText("toppings");
                            specialvendingmachine.addOtherItem(itemName,itemPrice,itemCalories,itemQuantity);
                        }
                        additemspecialview.getStatusTextfield().setText("Successfully Added!");
                        }
                }

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

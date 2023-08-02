

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class addItemController {

    addItemView additemview;
    RegularVendingMachine VMmodel;
    regularVMview VMview;


    addItemController(addItemView additemview, RegularVendingMachine VMmodel, regularVMview VMview)
    {
        this.additemview = additemview;
        this.VMmodel = VMmodel;
        this.VMview = VMview;

        this.additemview.setconfirmButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (VMmodel.addItem(additemview.getNameTextfield().getText(), Float.parseFloat(additemview.getPriceTextfield().getText()), Float.parseFloat(additemview.getCaloriesTextfield().getText()), Integer.parseInt(additemview.getQuantityTextfield().getText())))
                {
                    (VMview.getSlotPanelButtons())[(VMmodel.getCURRENTnumberOfItems() - 1)].setEnabled(true);
                    additemview.dispose();
                    refreshSlots();
                }
                else
                {
                    additemview.getStatusTextfield().setText("Error, invalid item. Please check");
                }
            }
        });

        this.additemview.setcancelButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                additemview.dispose();
            }
        });
    }

    public void refreshSlots()
    {
        for (int i=0;i< VMmodel.getCURRENTnumberOfSlots();i++)
        {
            (VMview.getSlotAreas())[i].setText("\nSlot " + i);
            (VMview.getSlotAreas())[i].append("\n\nName: " + VMmodel.getSlot(i).getPrimaryItem().getName() + "\n" + "Price: " + VMmodel.getSlot(i).getPrimaryItem().getPrice() + "\n" + "Calories: " + VMmodel.getSlot(i).getPrimaryItem().getCalories() + "\n");
            (VMview.getSlotAreas())[i].append("Remaining: " +  VMmodel.getquantityOfItem(VMmodel.getSlot(i).getPrimaryItem()));
        }
    }


}

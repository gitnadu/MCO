import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularVMController {
    regularVMview machineView;
    RegularVendingMachine VMmodel;
    Item tempSelectedItem;

    regularVMController(regularVMview regularMachineView, RegularVendingMachine VMmodel)
    {
        this.machineView = regularMachineView;
        this.VMmodel = VMmodel;

        machineView.getBalanceTextfield().setText("" + VMmodel.getStoredCash());

        this.machineView.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                machineView.setVisible(false);
                regularvmOptionsView regularoptionsview = new regularvmOptionsView();
                regularvmOptionsController regularoptionsviewcontroller = new regularvmOptionsController(regularoptionsview);
            }
        });

        this.machineView.setputmoneyButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                insertMoneyView moneyMachine = new insertMoneyView();
                insertMoneyController moneyMachineController = new insertMoneyController(moneyMachine,VMmodel,machineView);
            }
        });

        this.machineView.setpurchaseButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (VMmodel.doTransaction(VMmodel.getSelectedItem()))
                {
                    machineView.getStatusRVMTextfield().setText("Purchase Success");
                    machineView.getItemTrayTextfield().setText("" + VMmodel.getSelectedItem().getName());
                }
            }
        });

        this.machineView.setstatusRVMTextfieldListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!(machineView.getItemTrayTextfield().getText().isEmpty()))
                {
                    machineView.getItemTrayTextfield().setText("");
                }
            }
        });

        this.machineView.setadditemButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                addItemView additemview = new addItemView();
                addItemController additemcontroller =  new addItemController(additemview,VMmodel,machineView);
            }
        });

        this.machineView.setslotPanelButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                for(int i=0;i<VMmodel.getCURRENTnumberOfSlots();i++)
                {
                    if (e.getSource() == ((machineView.getSlotPanelButtons())[i]))
                    {
                        VMmodel.setSelectedItem(VMmodel.getSlot(i).getPrimaryItem());
                        machineView.getStatusRVMTextfield().setText("Selecting Item " + i);
                        refreshLCD(i);
                    }
                }
            }
        });

    }

    public void refreshSlots()
    {
        for (int i=0;i<9;i++)
        {
            (machineView.getSlotAreas())[i].setText("Name: " + VMmodel.getSlot(i).getPrimaryItem().getName() + "\n" + "Price: " + VMmodel.getSlot(i).getPrimaryItem().getPrice() + "\n" + "Calories: " + VMmodel.getSlot(i).getPrimaryItem().getCalories() + "\n");
            (machineView.getSlotAreas())[i].append("Slot" + i);
        }
    }

    public void refreshLCD(int slotNumber)
    {
        machineView.getNameTextfield().setText("" +VMmodel.getSlot(slotNumber).getPrimaryItem().getName());
        machineView.getPriceTextfield().setText("" +VMmodel.getSlot(slotNumber).getPrimaryItem().getPrice());
        machineView.getCaloriesTextfield().setText("" +VMmodel.getSlot(slotNumber).getPrimaryItem().getCalories());
    }

}

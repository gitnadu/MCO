import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularVMController {
    regularvmOptionsView regularoptionsview;
    regularVMview machineView;
    RegularVendingMachine VMmodel;
    Item tempSelectedItem;

    regularVMController(regularVMview regularMachineView, RegularVendingMachine VMmodel, regularvmOptionsView regularoptionsview)
    {
        this.machineView = regularMachineView;
        this.VMmodel = VMmodel;
        this.regularoptionsview = regularoptionsview;

        machineView.getBalanceTextfield().setText("" + VMmodel.getStoredCash());
        machineView.getTitleLabel().setText(VMmodel.getName());



        this.machineView.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                machineView.setVisible(false);
                regularoptionsview.setVisible(true);
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
                if(VMmodel.getSelectedItem() == null)
                {
                    machineView.getStatusRVMTextfield().setText("Please select item..");
                }
                if ( (VMmodel.getStoredCash() - VMmodel.getSelectedItem().getPrice()) < -1)
                {
                    machineView.getStatusRVMTextfield().setText("Insufficient Funds!");
                }
                else if (VMmodel.checkIfItemAvailable(VMmodel.getSelectedItem()))
                {
                    if (VMmodel.doTransaction(VMmodel.getSelectedItem()))
                    {
                        machineView.getStatusRVMTextfield().setText("Purchase Success");
                        machineView.getItemTrayTextfield().setText("" + VMmodel.getSelectedItem().getName());

                        refreshSlots();
                    }
                    else
                    {
                        machineView.getStatusRVMTextfield().setText("Error");
                    }
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

        this.machineView.setcancelButtonListener(new ActionListener()
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
                        if (VMmodel.getquantityOfItem(VMmodel.getSlot(i).getPrimaryItem()) > 0 )
                        {
                            VMmodel.setSelectedItem(VMmodel.getSlot(i).getPrimaryItem());
                            machineView.getStatusRVMTextfield().setText("Selecting Item " + i);
                            refreshLCD(i);
                        }
                        else
                        {
                            machineView.getStatusRVMTextfield().setText("No more stock !!");
                        }
                    }
                }
            }
        });

    }

    public regularVMview getMachineView() {
        return machineView;
    }

    public void refreshSlots()
    {
        for (int i=0;i<VMmodel.getCURRENTnumberOfSlots();i++)
        {
            (machineView.getSlotAreas())[i].setText("\nSlot " + i);
            (machineView.getSlotAreas())[i].append("\n\nName: " + VMmodel.getSlot(i).getPrimaryItem().getName() + "\n" + "Price: " + VMmodel.getSlot(i).getPrimaryItem().getPrice() + "\n" + "Calories: " + VMmodel.getSlot(i).getPrimaryItem().getCalories() + "\n");
            (machineView.getSlotAreas())[i].append("Remaining" +  VMmodel.getquantityOfItem(VMmodel.getSlot(i).getPrimaryItem()));

            machineView.getBalanceTextfield().setText(""+VMmodel.getStoredCash());
        }
    }

    public void refreshLCD(int slotNumber)
    {
        machineView.getNameTextfield().setText("" +VMmodel.getSlot(slotNumber).getPrimaryItem().getName());
        machineView.getPriceTextfield().setText("" +VMmodel.getSlot(slotNumber).getPrimaryItem().getPrice());
        machineView.getCaloriesTextfield().setText("" +VMmodel.getSlot(slotNumber).getPrimaryItem().getCalories());
    }

}

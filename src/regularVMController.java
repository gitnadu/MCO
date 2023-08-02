import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class regularVMController {
    regularvmOptionsView regularoptionsview;
    regularVMview machineView;
    RegularVendingMachine VMmodel;

    regularVMController(regularVMview regularMachineView, RegularVendingMachine VMmodel, regularvmOptionsView regularoptionsview, String title)
    {
        this.machineView = regularMachineView;
        this.VMmodel = VMmodel;
        this.regularoptionsview = regularoptionsview;

        machineView.setTitle(title);

        machineView.getBalanceTextfield().setText("" + VMmodel.getStoredCash());
        machineView.getTitleLabel().setText(VMmodel.getName());

        this.machineView.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                VMmodel.setStoredCash(0);
                machineView.getChangeTextArea().setText("");
                machineView.setVisible(false);
                machineView.getBalanceTextfield().setText(""+0);
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

                if (!((VMmodel.getStoredCash() - VMmodel.getSelectedItem().getPrice() ) >= 0))
                {
                    machineView.getStatusRVMTextfield().setText("Insufficient Funds!");
                }
                else if (VMmodel.checkIfItemAvailable(VMmodel.getSelectedItem()))
                {
                    if (VMmodel.doTransaction(VMmodel.getSelectedItem()))
                    {
                        machineView.getStatusRVMTextfield().setText("Purchase Success");

                        machineView.getItemTrayTextfield().setText("" + VMmodel.getSelectedItem().getName());

                        machineView.getBalanceTextfield().setText("" +VMmodel.getStoredCash());
                        refreshSlots();
                    }
                    else
                    {
                        machineView.getStatusRVMTextfield().setText("Error");
                    }
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
                ArrayList<Integer> changeHolder = new ArrayList<>();
                changeHolder = VMmodel.giveChange(VMmodel.getStoredCash());
                machineView.getChangeTextArea().setText(changeHolder.get(0).toString() + "\n");
                if (changeHolder.size()>0)
                {
                    for(int i=1;i<changeHolder.size();i++)
                    {
                        machineView.getChangeTextArea().append(changeHolder.get(i).toString() + "\n");
                    }
                }
                machineView.getNameTextfield().setText("");
                machineView.getPriceTextfield().setText("");
                machineView.getCaloriesTextfield().setText("");

                machineView.getStatusRVMTextfield().setText("Purchase Cancelled");

                machineView.getPurchaseButton().setEnabled(false);
                machineView.getCancelButton().setEnabled(false);

                VMmodel.setStoredCash(0);
                machineView.getBalanceTextfield().setText(""+VMmodel.getStoredCash());
            }
        });

        this.machineView.setchangeTextAreaListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if( !(regularMachineView.getChangeTextArea().getText().isEmpty()))
                {
                    regularMachineView.getChangeTextArea().setText("");
                }
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

        this.machineView.setitemTrayTextfieldListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if( !(regularMachineView.getItemTrayTextfield().getText().isEmpty()))
                {
                    regularMachineView.getItemTrayTextfield().setText("");
                }
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
                            machineView.getPurchaseButton().setEnabled(true);
                            machineView.getCancelButton().setEnabled(true);
                            refreshLCD(i);
                            refreshSlots();
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
            (machineView.getSlotAreas())[i].append("Remaining: " +  VMmodel.getquantityOfItem(VMmodel.getSlot(i).getPrimaryItem()));

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

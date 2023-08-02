import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class replenishMoneyController {

    replenishMoneyView replenishmoneyview;
    maintenanceRVMview maintenancervmview;
    RegularVendingMachine VMmodel;

    int selectedBill;
    // view of itself
    // view of the maintenance view
    // VM model
    replenishMoneyController(replenishMoneyView replenishmoneyview, maintenanceRVMview maintenancervmview,RegularVendingMachine VMmodel)
    {
        this.replenishmoneyview = replenishmoneyview;
        this.maintenancervmview = maintenancervmview;
        this.VMmodel = VMmodel;

        this.selectedBill = 0;

        this.replenishmoneyview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                replenishmoneyview.setVisible(false);
                maintenancervmview.setVisible(true);
                maintenancervmview.setEnabled(true);
            }
        });

        this.replenishmoneyview.setcheckButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Integer quantity;
                quantity = Integer.parseInt(replenishmoneyview.getQuantityTextField().getText());

                // add new money in the change bank
                (VMmodel.getCash())[selectedBill].setCount((VMmodel.getCash())[selectedBill].getCount() + quantity);

            }
        });

        this.replenishmoneyview.seteksButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                replenishmoneyview.getQuantityTextField().setText("");
            }
        });

        this.replenishmoneyview.setchangeButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i<7;i++)
                {
                    if (e.getSource() == (replenishmoneyview.getChangeButtons())[i])
                    {
                        replenishmoneyview.getStatusTextfield().setText("Adding "+ (VMmodel.getCash())[i].getValue());
                        selectedBill = i;
                    }
                }
            }
        });


    }




}

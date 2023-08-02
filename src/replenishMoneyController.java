import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class replenishMoneyController {

    replenishMoneyView replenishmoneyview;
    maintenanceRVMview maintenancervmview;
    RegularVendingMachine VMmodel;
    int selectedBill;

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
                Boolean caught = false;
                Integer quantity = 0;
                try {
                    quantity = Integer.parseInt(replenishmoneyview.getQuantityTextField().getText());
                } catch (Exception f) {
                    caught = true;
                }
                if(caught)
                {
                    replenishmoneyview.getStatusTextfield().setText("Invalid input ");
                }
                else
                {
                    (VMmodel.getCash())[selectedBill].setCount((VMmodel.getCash())[selectedBill].getCount() + quantity);
                    (VMmodel.getCash())[selectedBill].setTotalValue((VMmodel.getCash())[selectedBill].getValue() * (VMmodel.getCash())[selectedBill].getCount());

                    replenishmoneyview.getStatusTextfield().setText("Money Added!");
                    replenishmoneyview.getQuantityTextField().setText("");
                    System.out.print("Money added");
                }


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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class replenishMoneySpecialController {

    replenishMoneySpecialView replenishmoneyspecialview;
    maintenanceSVMview maintenancesvmview;
    SpecialVendingMachine SVMmodel;

    int selectedBill;
    // view of itself
    // view of the maintenance view
    // VM model
    replenishMoneySpecialController(replenishMoneySpecialView replenishmoneyspecialview, maintenanceSVMview maintenancesvmview,SpecialVendingMachine SVMmodel)
    {
        this.replenishmoneyspecialview = replenishmoneyspecialview;
        this.maintenancesvmview = maintenancesvmview;
        this.SVMmodel = SVMmodel;

        this.selectedBill = 0;

        this.replenishmoneyspecialview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                replenishmoneyspecialview.setVisible(false);
                maintenancesvmview.setVisible(true);
                maintenancesvmview.setEnabled(true);
            }
        });

        this.replenishmoneyspecialview.setcheckButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                boolean caught = false;
                Integer quantity = 0;

                try {
                    quantity = Integer.parseInt(replenishmoneyspecialview.getQuantityTextField().getText());
                } catch (Exception f) {
                    caught = true;
                }
                if(caught)
                {
                    replenishmoneyspecialview.getStatusTextfield().setText("Invalid input ");
                }
                else
                {
                    (SVMmodel.getCash())[selectedBill].setCount((SVMmodel.getCash())[selectedBill].getCount() + quantity);
                    (SVMmodel.getCash())[selectedBill].setTotalValue((SVMmodel.getCash())[selectedBill].getTotalValue() *(SVMmodel.getCash())[selectedBill].getCount());
                    replenishmoneyspecialview.getStatusTextfield().setText("Money Added!");
                    replenishmoneyspecialview.getQuantityTextField().setText("");
                    System.out.print("Money added");
                }


            }
        });

        this.replenishmoneyspecialview.seteksButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                replenishmoneyspecialview.getQuantityTextField().setText("");
            }
        });

        this.replenishmoneyspecialview.setchangeButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i<7;i++)
                {
                    if (e.getSource() == (replenishmoneyspecialview.getChangeButtons())[i])
                    {
                        replenishmoneyspecialview.getStatusTextfield().setText("Adding "+ (SVMmodel.getCash())[i].getValue());
                        selectedBill = i;
                    }
                }
            }
        });


    }




}

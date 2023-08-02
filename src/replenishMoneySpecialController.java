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
    replenishMoneySpecialController(replenishMoneySpecialView replenishmoneyview, maintenanceSVMview maintenancesvmview,SpecialVendingMachine SVMmodel)
    {
        this.replenishmoneyspecialview = replenishmoneyview;
        this.maintenancesvmview = maintenancesvmview;
        this.SVMmodel = SVMmodel;

        this.selectedBill = 0;

        this.replenishmoneyspecialview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                replenishmoneyview.setVisible(false);
                maintenancesvmview.setVisible(true);
                maintenancesvmview.setEnabled(true);
            }
        });

        this.replenishmoneyspecialview.setcheckButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Integer quantity;
                if (!(replenishmoneyview.getQuantityTextField().getText().compareTo("")==0))
                {
                    quantity = Integer.parseInt(replenishmoneyview.getQuantityTextField().getText());

                    // add new money in the change bank
                    (SVMmodel.getCash())[selectedBill].setCount((SVMmodel.getCash())[selectedBill].getCount() + quantity);
                }


            }
        });

        this.replenishmoneyspecialview.seteksButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                replenishmoneyview.getQuantityTextField().setText("");
            }
        });

        this.replenishmoneyspecialview.setchangeButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                for(int i=0;i<7;i++)
                {
                    if (e.getSource() == (replenishmoneyview.getChangeButtons())[i])
                    {
                        replenishmoneyview.getStatusTextfield().setText("Adding "+ (SVMmodel.getCash())[i].getValue());
                        selectedBill = i;
                    }
                }
            }
        });


    }




}

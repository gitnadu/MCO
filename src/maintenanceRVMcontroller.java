import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.InetSocketAddress;

public class maintenanceRVMcontroller {

    maintenanceRVMview maintenanceRVMview;
    RegularVendingMachine RVMmodel;
    regularvmOptionsView regularvmoptionsview;

    maintenanceRVMcontroller(maintenanceRVMview maintenanceRVMview, RegularVendingMachine RVMmodel, regularvmOptionsView regularvmoptionsview)
    {
        this.maintenanceRVMview = maintenanceRVMview;
        this.RVMmodel = RVMmodel;
        this.regularvmoptionsview = regularvmoptionsview;

        this.maintenanceRVMview.settotalSalesButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceRVMview.setVisible(false);
                totalSalesView totalsalesview = new totalSalesView();
                totalSalesController totalsalescontroller =  new totalSalesController(totalsalesview,RVMmodel,maintenanceRVMview);
            }
        });

        this.maintenanceRVMview.setrestockButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // text fields
                maintenanceRVMview.getRestockItemNameLabel().setVisible(true);
                maintenanceRVMview.getRestockQuantityLabel().setVisible(true);

                maintenanceRVMview.getItemNameTextfield().setVisible(true);
                maintenanceRVMview.getRestockQuantityTextfield().setVisible(true);

                // buttons
                maintenanceRVMview.getEksrestockButton().setVisible(true);
                maintenanceRVMview.getEksrestockButton().setEnabled(true);
                maintenanceRVMview.getRestockcheckButton().setVisible(true);
                maintenanceRVMview.getRestockcheckButton().setEnabled(true);

            }
        });

        this.maintenanceRVMview.setsetnewpriceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceRVMview.getItemnameNewPriceLabel().setVisible(true);
                maintenanceRVMview.getNewPriceLabel().setVisible(true);

                maintenanceRVMview.getNewpriceTextfield().setVisible(true);
                maintenanceRVMview.getNewpricenameTextfield().setVisible(true);

                maintenanceRVMview.getChecknewPriceButton().setVisible(true);
                maintenanceRVMview.getChecknewPriceButton().setEnabled(true);
                maintenanceRVMview.getEksNewPriceButton().setVisible(true);
                maintenanceRVMview.getEksNewPriceButton().setEnabled(true);
            }
        });

        this.maintenanceRVMview.setrestockcheckButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Integer newQuantity;
                String itemName;

                itemName = maintenanceRVMview.getItemNameTextfield().getText();
                newQuantity = Integer.parseInt(maintenanceRVMview.getRestockQuantityTextfield().getText());

                if (RVMmodel.restockItem(itemName, newQuantity))
                {
                    maintenanceRVMview.getRestockQuantityTextfield().setText("Success");
                }
            }

        });

        this.maintenanceRVMview.seteksrestockButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceRVMview.getRestockItemNameLabel().setVisible(false);
                maintenanceRVMview.getRestockQuantityLabel().setVisible(false);

                maintenanceRVMview.getItemNameTextfield().setText("");
                maintenanceRVMview.getRestockQuantityTextfield().setText("");


                maintenanceRVMview.getItemNameTextfield().setVisible(false);
                maintenanceRVMview.getRestockQuantityTextfield().setVisible(false);

                // buttons
                maintenanceRVMview.getEksrestockButton().setVisible(false);
                maintenanceRVMview.getRestockcheckButton().setVisible(false);
            }
        });

        this.maintenanceRVMview.setchecknewPriceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Integer newPrice;
                String itemName;
                itemName = maintenanceRVMview.getNewpricenameTextfield().getText();
                newPrice = Integer.parseInt(maintenanceRVMview.getNewpriceTextfield().getText());

                for (int i=0;i<RVMmodel.getCURRENTnumberOfItems();i++) {
                    // if found
                    if (itemName.equalsIgnoreCase(((RVMmodel.getItemRecord())[i].getName()))) {

                        (RVMmodel.getItemRecord())[i].setPrice(newPrice);// changes the item record

                        // changes the price of every item in existence
                        if ((RVMmodel.getItem())[i].size() > 0)
                        {
                            for (int j = 0; i < (RVMmodel.getItem())[i].size(); i++) {
                                (RVMmodel.getItem())[i].get(j).setPrice((RVMmodel.getItemRecord())[i].getPrice());
                            }
                        }

                        // changes the price of the item in the slot
                        for (int j = 0; i < RVMmodel.getCURRENTnumberOfSlots(); i++) {
                            if (itemName.equalsIgnoreCase(RVMmodel.getSlot(i).getPrimaryItem().getName()))
                            {
                                RVMmodel.getSlot(j).setPrimaryItem((RVMmodel.getItemRecord())[i]);

                            }
                        }
                    }
                }
            }
        });

        this.maintenanceRVMview.setceksNewPriceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceRVMview.getItemnameNewPriceLabel().setVisible(false);
                maintenanceRVMview.getNewPriceLabel().setVisible(false);

                maintenanceRVMview.getNewpriceTextfield().setVisible(false);
                maintenanceRVMview.getNewpricenameTextfield().setVisible(false);

                maintenanceRVMview.getChecknewPriceButton().setVisible(false);
                maintenanceRVMview.getEksNewPriceButton().setVisible(false);
                maintenanceRVMview.getChecknewPriceButton().setEnabled(false);
                maintenanceRVMview.getEksNewPriceButton().setEnabled(false);
            }
        });

        this.maintenanceRVMview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceRVMview.setVisible(false);
                regularvmoptionsview.setVisible(true);
                regularvmoptionsview.setEnabled(true);
            }
        });

        this.maintenanceRVMview.setcollectEarningsButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceRVMview.getCollectEarningsTextField().setText("Collect -> " + RVMmodel.collectEarnings());
            }
        });


        this.maintenanceRVMview.setcollectEarningsTextFieldListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                maintenanceRVMview.getCollectEarningsTextField().setText("");
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

        //

        this.maintenanceRVMview.setreplenishChangeButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceRVMview.setVisible(false);
                replenishMoneyView replenishmoneyview = new replenishMoneyView();
                replenishMoneyController replenishmoneycontroller = new replenishMoneyController(replenishmoneyview,maintenanceRVMview,RVMmodel);
            }
        });

    }





}

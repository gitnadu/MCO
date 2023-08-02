import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.InetSocketAddress;

public class maintenanceSVMController {

    maintenanceSVMview maintenanceSVMview;
    SpecialVendingMachine SVMmodel;
    specialvmOptionsView specialvmoptionsview;

    maintenanceSVMController(maintenanceSVMview maintenanceSVMview, SpecialVendingMachine SVMmodel, specialvmOptionsView specialvmoptionsview)
    {
        this.maintenanceSVMview = maintenanceSVMview;
        this.SVMmodel = SVMmodel;
        this.specialvmoptionsview = specialvmoptionsview;

        this.maintenanceSVMview.settotalSalesButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceSVMview.setVisible(false);
                totalSalesSpecialView totalsalesspecialview = new totalSalesSpecialView();
                totalSalesSpecialController totalsalescontroller =  new totalSalesSpecialController(totalsalesspecialview,SVMmodel,maintenanceSVMview);
            }
        });

        this.maintenanceSVMview.setrestockButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                // text fields
                maintenanceSVMview.getRestockItemNameLabel().setVisible(true);
                maintenanceSVMview.getRestockQuantityLabel().setVisible(true);

                maintenanceSVMview.getItemNameTextfield().setVisible(true);
                maintenanceSVMview.getRestockQuantityTextfield().setVisible(true);

                // buttons
                maintenanceSVMview.getEksrestockButton().setVisible(true);
                maintenanceSVMview.getEksrestockButton().setEnabled(true);
                maintenanceSVMview.getRestockcheckButton().setVisible(true);
                maintenanceSVMview.getRestockcheckButton().setEnabled(true);

            }
        });

        this.maintenanceSVMview.setsetnewpriceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceSVMview.getItemnameNewPriceLabel().setVisible(true);
                maintenanceSVMview.getNewPriceLabel().setVisible(true);

                maintenanceSVMview.getNewpriceTextfield().setVisible(true);
                maintenanceSVMview.getNewpricenameTextfield().setVisible(true);

                maintenanceSVMview.getChecknewPriceButton().setVisible(true);
                maintenanceSVMview.getChecknewPriceButton().setEnabled(true);
                maintenanceSVMview.getEksNewPriceButton().setVisible(true);
                maintenanceSVMview.getEksNewPriceButton().setEnabled(true);
            }
        });

        this.maintenanceSVMview.setrestockcheckButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Integer newQuantity;
                String itemName;
                itemName = maintenanceSVMview.getItemNameTextfield().getText();
                newQuantity = Integer.parseInt(maintenanceSVMview.getRestockQuantityTextfield().getText());


                for (int i=0;i<9;i++)
                {
                    if (itemName.compareTo(SVMmodel.itemRecord[i].getName())==0)
                    {
                        if (SVMmodel.restockItem(itemName, newQuantity))
                        {
                            maintenanceSVMview.getRestockQuantityTextfield().setText("Success");
                        }
                    }
                }

                for (int i=0;i<12;i++)
                {
                    if (itemName.compareTo(SVMmodel.getExclusiveItemRecord()[i].getName())==0)
                    {
                        for (int j=0;j<newQuantity;j++)
                        {
                            (SVMmodel.getExclusiveItems())[i].add((SVMmodel.getExclusiveItemRecord())[i]);
                        }
                    }
                }

            }

        });

        this.maintenanceSVMview.seteksrestockButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceSVMview.getRestockItemNameLabel().setVisible(false);
                maintenanceSVMview.getRestockQuantityLabel().setVisible(false);

                maintenanceSVMview.getItemNameTextfield().setText("");
                maintenanceSVMview.getRestockQuantityTextfield().setText("");


                maintenanceSVMview.getItemNameTextfield().setVisible(false);
                maintenanceSVMview.getRestockQuantityTextfield().setVisible(false);

                // buttons
                maintenanceSVMview.getEksrestockButton().setVisible(false);
                maintenanceSVMview.getRestockcheckButton().setVisible(false);
            }
        });

        this.maintenanceSVMview.setchecknewPriceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                Integer newPrice;
                String itemName;
                itemName = maintenanceSVMview.getNewpricenameTextfield().getText();
                newPrice = Integer.parseInt(maintenanceSVMview.getNewpriceTextfield().getText());

                for (int i=0;i<SVMmodel.getCURRENTnumberOfItems();i++)
                {

                    // if found
                    if (itemName.equalsIgnoreCase(((SVMmodel.getItemRecord())[i].getName()))) {

                        (SVMmodel.getItemRecord())[i].setPrice(newPrice);// changes the item record

                        // changes the price of every item in existence
                        if ((SVMmodel.getItem())[i].size()>0)
                        {
                            for (int j = 0; j < (SVMmodel.getItem())[i].size(); j++) {
                                (SVMmodel.getItem())[i].get(j).setPrice((SVMmodel.getItemRecord())[i].getPrice());
                            }
                        }

                        // changes the price of the item in the slot
                        for (int j = 0; j < SVMmodel.getCURRENTnumberOfSlots(); j++) {
                            if (itemName.equalsIgnoreCase(SVMmodel.getSlot(j).getPrimaryItem().getName()))
                            {
                                SVMmodel.getSlot(j).setPrimaryItem((SVMmodel.getItemRecord())[i]);

                            }
                        }
                    }
                }

                for (int i=0;i<SVMmodel.getCURRENTnumberOfExclusiveItems();i++)
                {
                    // if found
                    if (itemName.equalsIgnoreCase(((SVMmodel.getExclusiveItemRecord())[i].getName()))) {

                        (SVMmodel.getExclusiveItemRecord())[i].setPrice(newPrice);// changes the item record

                        // changes the price of every item in existence
                        if((SVMmodel.getExclusiveItems())[i].size() > 0)
                        {
                            for (int j = 0; j < (SVMmodel.getExclusiveItems())[i].size(); j++) {
                                (SVMmodel.getExclusiveItems())[i].get(j).setPrice((SVMmodel.getExclusiveItemRecord())[i].getPrice());
                            }
                        }


                        // changes the price of the item in the slot
                        for (int j = 0; j < SVMmodel.getCURRENTnumberOfExclusiveSlots(); j++) {
                            if (itemName.equalsIgnoreCase((SVMmodel.getExclusiveSlot())[j].getPrimaryItem().getName()))
                            {
                                (SVMmodel.getExclusiveSlot())[j].setPrimaryItem((SVMmodel.getExclusiveItemRecord())[i]);
                            }
                        }
                    }
                }
            }
        });

        this.maintenanceSVMview.setceksNewPriceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceSVMview.getItemnameNewPriceLabel().setVisible(false);
                maintenanceSVMview.getNewPriceLabel().setVisible(false);

                maintenanceSVMview.getNewpriceTextfield().setVisible(false);
                maintenanceSVMview.getNewpricenameTextfield().setVisible(false);

                maintenanceSVMview.getChecknewPriceButton().setVisible(false);
                maintenanceSVMview.getEksNewPriceButton().setVisible(false);
                maintenanceSVMview.getChecknewPriceButton().setEnabled(false);
                maintenanceSVMview.getEksNewPriceButton().setEnabled(false);
            }
        });

        this.maintenanceSVMview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceSVMview.setVisible(false);
                specialvmoptionsview.setVisible(true);
                specialvmoptionsview.setEnabled(true);
            }
        });

        this.maintenanceSVMview.setcollectEarningsButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceSVMview.getCollectEarningsTextField().setText("Collect -> " + SVMmodel.collectEarnings());
            }
        });


        this.maintenanceSVMview.setcollectEarningsTextFieldListener(new MouseListener()
        {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                maintenanceSVMview.getCollectEarningsTextField().setText("");
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

        this.maintenanceSVMview.setreplenishChangeButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                maintenanceSVMview.setVisible(false);
                replenishMoneySpecialView replenishmoneyspecialview = new replenishMoneySpecialView();
                replenishMoneySpecialController replenishmoneyspecialcontroller = new replenishMoneySpecialController(replenishmoneyspecialview,maintenanceSVMview,SVMmodel);
            }
        });

    }





}

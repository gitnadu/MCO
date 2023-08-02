import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class totalSalesSpecialController {
    totalSalesSpecialView totalsalesspecialview;
    SpecialVendingMachine SVMmodel;
    maintenanceSVMview maintenanceSVMview;

    totalSalesSpecialController(totalSalesSpecialView totalsalesspecialview, SpecialVendingMachine SVMmodel, maintenanceSVMview maintenanceSVMview)
    {
        this.totalsalesspecialview = totalsalesspecialview;
        this.SVMmodel = SVMmodel;
        this.maintenanceSVMview = maintenanceSVMview;

        totalsalesspecialview.getSalesTextArea().setText("Items sold: \n");

        if (SVMmodel.getCURRENTnumberOfItems() == 0 && SVMmodel.getCURRENTnumberOfExclusiveItems() == 0)
        {
            totalsalesspecialview.getSalesTextArea().setText("No items sold...");
        }

        if (SVMmodel.getCURRENTnumberOfItems() > 0)
        {
            for (int i=0;i<SVMmodel.getCURRENTnumberOfItems();i++)
            {
                totalsalesspecialview.getSalesTextArea().append("\nItem: " + (SVMmodel.getItemRecord())[i].getName() + "   Total Sold: " + (SVMmodel.getItemRecord())[i].getTotalSold() + " items/");
            }
        }

        if (SVMmodel.getCURRENTnumberOfExclusiveItems() > 0)
        {
            for (int i=0;i<SVMmodel.getCURRENTnumberOfExclusiveItems();i++)
            {
                totalsalesspecialview.getSalesTextArea().append("\nItem: " + (SVMmodel.getExclusiveItemRecord())[i].getName() + "   Total Sold: " + (SVMmodel.getExclusiveItemRecord())[i].getTotalSold() + " items/");
            }
        }




        this.totalsalesspecialview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                totalsalesspecialview.setVisible(false);
                maintenanceSVMview.setVisible(true);
                maintenanceSVMview.setEnabled(true);
            }
        });

    }



}

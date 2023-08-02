import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class totalSalesController {
    totalSalesView totalsalesview;
    RegularVendingMachine VMmodel;
    maintenanceRVMview maintenanceRVMview;

    totalSalesController(totalSalesView totalsalesview, RegularVendingMachine VMmodel, maintenanceRVMview maintenanceRVMview)
    {
        this.totalsalesview = totalsalesview;
        this.VMmodel = VMmodel;
        this.maintenanceRVMview = maintenanceRVMview;


        if (VMmodel.getCURRENTnumberOfItems() > 0)
        {
            totalsalesview.getSalesTextArea().setText("Item: " + (VMmodel.getItemRecord())[0].getName() + "   Total Sold: " + (VMmodel.getItemRecord())[0].getTotalSold() + " item/s");

            for (int i=1;i<VMmodel.getCURRENTnumberOfItems();i++)
            {
                totalsalesview.getSalesTextArea().append("\nItem: " + (VMmodel.getItemRecord())[0].getName() + "   Total Sold: " + (VMmodel.getItemRecord())[0].getTotalSold() + " items/");
            }
        }
        else
        {
            totalsalesview.getSalesTextArea().setText("No items sold...");
        }


        this.totalsalesview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                totalsalesview.setVisible(false);
                maintenanceRVMview.setVisible(true);
                maintenanceRVMview.setEnabled(true);
            }
        });

    }



}

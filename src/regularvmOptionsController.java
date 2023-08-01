import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularvmOptionsController {

    regularvmOptionsView regularvmOptionsView;
    regularvmOptionsController(regularvmOptionsView regularvmoptionsview)
    {
        this.regularvmOptionsView = regularvmoptionsview;

        this.regularvmOptionsView. setreturnButListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                regularvmOptionsView.dispose();
                startingPageView startingpagevew = new startingPageView();
                startingPageController startingPageController = new startingPageController(startingpagevew);
            }
        });


        this.regularvmOptionsView.setcreateMachineButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.regularvmOptionsView.setmaintenanceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                regularvmOptionsView.dispose();
                regularVMview regularmachine = new regularVMview();
                RegularVendingMachine VMmodel = new RegularVendingMachine("Pizzaria");
                regularVMController regularmachinecontroller = new regularVMController(regularmachine,VMmodel);
                maintenanceRVMview maintenancervmview = new maintenanceRVMview();
                maintenanceRVMcontroller maintenanceRVMcontroller = new maintenanceRVMcontroller(maintenancervmview);
            }
        });

        this.regularvmOptionsView.settestFeaturesButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                regularvmOptionsView.dispose();
                regularVMview regularmachine = new regularVMview();
                RegularVendingMachine VMmodel = new RegularVendingMachine("Pizzaria");
                regularVMController regularmachinecontroller = new regularVMController(regularmachine,VMmodel);
                maintenanceRVMview maintenancervmview = new maintenanceRVMview();
                maintenanceRVMcontroller maintenanceRVMcontroller = new maintenanceRVMcontroller(maintenancervmview);
            }
        });
    }
}

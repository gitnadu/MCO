import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularvmOptionsController {

    regularvmOptionsView regularvmOptionsView;
    regularVMview regularmachine;
    RegularVendingMachine VMmodel;
    regularVMController VMcontroller;
    regularvmOptionsController(regularvmOptionsView regularvmoptionsview)
    {
        this.regularvmOptionsView = regularvmoptionsview;

        this.regularvmOptionsView.setreturnButListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                    regularvmOptionsView.setVisible(false);
                    regularvmOptionsView.setEnabled(false);
                    startingPageView startingpagevew = new startingPageView();
                    startingPageController startingPageController = new startingPageController(startingpagevew);
            }
        });


        this.regularvmOptionsView.setcreateMachineButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                regularvmOptionsView.getConfirmButton().setEnabled(true);
                regularvmOptionsView.getConfirmButton().setVisible(true);
                regularvmOptionsView.getStatusTextfield().setVisible(true);
                regularvmOptionsView.getStatusTextfield().setEditable(true);
                regularvmOptionsView.getStatusTextfield().setText("Enter name ");
            }
        });

        this.regularvmOptionsView.settestFeaturesButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (VMmodel == null)
                {
                    regularvmOptionsView.getStatusTextfield().setText("No machine created...");
                }
                else
                {
                    regularvmOptionsView.setVisible(false);
                    VMcontroller.getMachineView().setVisible(true);
                }
            }
        });

        this.regularvmOptionsView.setmaintenanceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (VMmodel == null)
                {
                    regularvmOptionsView.getStatusTextfield().setText("No Machine Created...");
                }
                else
                {
                    maintenanceRVMview maintenancervmview = new maintenanceRVMview();
                    maintenanceRVMcontroller maintenanceRVMcontroller = new maintenanceRVMcontroller(maintenancervmview,VMmodel,regularvmOptionsView);
                    regularvmOptionsView.setVisible(false);
                    regularvmOptionsView.setEnabled(false);
                }

            }
        });

        this.regularvmOptionsView.setconfirmButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!(regularvmoptionsview.getStatusTextfield().getText().isEmpty()) || (regularvmoptionsview.getStatusTextfield().getText().compareTo("Enter name ") == 0)){
                    VMmodel = new RegularVendingMachine(regularvmoptionsview.getStatusTextfield().getText()); // created the vending machine
                    regularvmOptionsView.getStatusTextfield().setText("Machine Created !!");
                    regularmachine = new regularVMview();
                    VMcontroller = new regularVMController(regularmachine, VMmodel,regularvmOptionsView);
                }
                else
                {
                regularvmOptionsView.getStatusTextfield().setText("Enter name ");
                }

            }
        });


    }
}

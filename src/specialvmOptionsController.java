import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class specialvmOptionsController {

    // options view
    specialvmOptionsView specialvmoptionsview;

    // svm model
    SpecialVendingMachine specialvendingmachine;
    // svm controller
    specialVMController SVMController;
    // svm view
    specialVMView SVMview;

    specialvmOptionsController(specialvmOptionsView specialvmoptionsview)
    {
        this.specialvmoptionsview = specialvmoptionsview;
        this.specialvmoptionsview.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                specialvmoptionsview.setVisible(false);
                specialvmoptionsview.setEnabled(false);
                startingPageView startingpagevew = new startingPageView();
                startingPageController startingPageController = new startingPageController(startingpagevew);
            }
        });


        this.specialvmoptionsview.setcreateSpecialVMButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                specialvmoptionsview.getConfirmButton().setEnabled(true);
                specialvmoptionsview.getConfirmButton().setVisible(true);
                specialvmoptionsview.getStatusTextfield().setVisible(true);
                specialvmoptionsview.getStatusTextfield().setEditable(true);
                specialvmoptionsview.getStatusTextfield().setText("<Name>");
            }
        });

        this.specialvmoptionsview.settestSpecialVMButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (specialvendingmachine == null)
                {
                    specialvmoptionsview.getStatusTextfield().setText("Machine nonexistent..");
                }
                else
                {
                    specialvmoptionsview.setVisible(false);
                    SVMController.getSpecialvmview().setVisible(true);
                }
            }
        });

        this.specialvmoptionsview.setconfirmButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (!(specialvmoptionsview.getStatusTextfield().getText().isEmpty()) || (specialvmoptionsview.getStatusTextfield().getText().compareTo("Enter name ") == 0)){
                    String VMtitle = specialvmoptionsview.getStatusTextfield().getText();
                    specialvendingmachine = new SpecialVendingMachine(VMtitle); // created the vending machine
                    specialvmoptionsview.getStatusTextfield().setText("Machine Created !!");

                    SVMview = new specialVMView();
                    SVMController = new specialVMController(SVMview, specialvendingmachine,specialvmoptionsview, VMtitle);

                }
                else
                {
                    specialvmoptionsview.getStatusTextfield().setText("Try again... ");
                }

            }
        });

        this.specialvmoptionsview.setmaintenanceButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (specialvendingmachine == null)
                {
                    specialvmoptionsview.getStatusTextfield().setText("Machine nonexistent..");
                }
                else
                {
                    maintenanceSVMview maintenancesvmview = new maintenanceSVMview();
                    maintenanceSVMController maintenanceSVMcontroller = new maintenanceSVMController(maintenancesvmview,specialvendingmachine,specialvmoptionsview);
                    specialvmoptionsview.setVisible(false);
                    specialvmoptionsview.setEnabled(false);
                }

            }
        });
    }
}

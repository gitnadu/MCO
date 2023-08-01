import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularVMController {
    regularVMview machineView;
    RegularVendingMachine VMmodel;
    regularVMController(regularVMview regularMachineView, RegularVendingMachine VMmodel)
    {
        this.machineView = regularMachineView;
        this.VMmodel = VMmodel;

        machineView.getBalanceTextfield().setText("" + VMmodel.getStoredCash());

        this.machineView.setreturnButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                machineView.setVisible(false);
                regularvmOptionsView regularoptionsview = new regularvmOptionsView();
                regularvmOptionsController regularoptionsviewcontroller = new regularvmOptionsController(regularoptionsview);
            }
        });

        this.machineView.setputmoneyButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                insertMoneyView moneyMachine = new insertMoneyView();
                insertMoneyController moneyMachineController = new insertMoneyController(moneyMachine,VMmodel,regularMachineView);
            }
        });

        this.machineView.setpurchaseButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                VMmodel.doTransaction(VMmodel.getCurrentTransaction().getSelectedItem());

            }
        });

    }

}

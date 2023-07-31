import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class regularVMController {
    regularVMview machineView;
    regularVMController(regularVMview regularMachineView)
    {
        this.machineView = regularMachineView;

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
                machineView.setVisible(false);
                regularvmOptionsView regularoptionsview = new regularvmOptionsView();
                regularvmOptionsController regularoptionsviewcontroller = new regularvmOptionsController(regularoptionsview);
            }
        });


    }
}

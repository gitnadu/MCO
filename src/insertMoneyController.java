import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class insertMoneyController {
    insertMoneyView moneymachine;
    RegularVendingMachine RVMmodel;
    regularVMview RVMview;
    Cash temp;


    insertMoneyController(insertMoneyView moneymachine, RegularVendingMachine RVMmodel, regularVMview RVMview)
    {
        this.moneymachine = moneymachine;
        this.RVMmodel = RVMmodel;
        this.RVMview = RVMview;
        this.temp = new Cash(0);


        this.moneymachine.setconfirmButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                RVMmodel.addStoredCash(temp.getTotalValue());
                RVMview.getBalanceTextfield().setText("" + RVMmodel.getStoredCash());
                moneymachine.dispose();
            }
        });

        this.moneymachine.setCancelButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                moneymachine.dispose();
            }
        });

        this.moneymachine.setmoneyPanelButtonsListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {

                if (e.getSource() == (moneymachine.getMoneyPanelButtons())[0] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(20);
                    temp.setCount(1);
                    temp.setTotalValue(20);
                    moneymachine.getStatusTextField().setText("Adding" + 20);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[1] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(50);
                    temp.setCount(1);
                    temp.setTotalValue(50);
                    moneymachine.getStatusTextField().setText("Adding" + 50);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[2] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(100);
                    temp.setCount(1);
                    temp.setTotalValue(100);
                    moneymachine.getStatusTextField().setText("Adding" + 100);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[3] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(200);
                    temp.setCount(1);
                    temp.setTotalValue(200);
                    moneymachine.getStatusTextField().setText("Adding" + 200);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[4] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(500);
                    temp.setCount(1);
                    temp.setTotalValue(500);
                    moneymachine.getStatusTextField().setText("Adding" + 500);
                }

            }
        });

    }
}

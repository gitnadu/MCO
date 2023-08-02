import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class insertMoneySpecialController {
    insertMoneySpecialView moneymachine;
    SpecialVendingMachine SVMmodel;
    specialVMView SVMview;
    Cash temp;


    insertMoneySpecialController(insertMoneySpecialView moneymachine, SpecialVendingMachine SVMmodel, specialVMView SVMview)
    {
        this.moneymachine = moneymachine;
        this.SVMmodel = SVMmodel;
        this.SVMview = SVMview;
        this.temp = new Cash(0);


        this.moneymachine.setconfirmButtonListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                SVMmodel.addStoredCash(temp.getTotalValue());
                SVMview.getBalanceTextfield().setText("" + SVMmodel.getStoredCash());
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
                    moneymachine.getStatusTextField().setText("Inserting " + 20);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[1] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(50);
                    temp.setCount(1);
                    temp.setTotalValue(50);
                    moneymachine.getStatusTextField().setText("Inserting " + 50);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[2] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(100);
                    temp.setCount(1);
                    temp.setTotalValue(100);
                    moneymachine.getStatusTextField().setText("Inserting " + 100);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[3] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(200);
                    temp.setCount(1);
                    temp.setTotalValue(200);
                    moneymachine.getStatusTextField().setText("Inserting " + 200);
                }
                else if (e.getSource() == (moneymachine.getMoneyPanelButtons())[4] )
                {
                    moneymachine.setConfirmButtonVisible(true);
                    temp.setValue(500);
                    temp.setCount(1);
                    temp.setTotalValue(500);
                    moneymachine.getStatusTextField().setText("Inserting " + 500);
                }

            }
        });

    }

}

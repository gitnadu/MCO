
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startingPageController {
    private startingPageView startingpageview;

    startingPageController(startingPageView startingPageView)
    {
        this.startingpageview = startingPageView;

        this.startingpageview.setcreateREGListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                startingpageview.setVisible(false);
                regularvmOptionsView regularOptionPage = new regularvmOptionsView();
                regularvmOptionsController regularoptioncontroller = new regularvmOptionsController(regularOptionPage);
            }
        });

        this.startingpageview.setcreateSPEListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                startingpageview.setVisible(false);
                specialvmOptionsView specialOptionPage = new specialvmOptionsView();
            }
        });

        this.startingpageview.setQuitButListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


    }
}

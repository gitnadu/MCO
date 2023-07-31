
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
                startingpageview.dispose();
                regularVM regular = new regularVM();
            }
        });

        this.startingpageview.setcreateSPEListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) {
                specialVM regular = new specialVM();
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

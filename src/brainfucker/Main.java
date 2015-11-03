package brainfucker;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {}catch (ClassNotFoundException e) {}catch (InstantiationException e) {}catch (IllegalAccessException e) {}
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                Frame Frame = new Frame();
                Frame.setTitle("BrainFucker");
                try
                {
                    URL imgURL = getClass().getResource("favicon.gif");
                    Image img = Toolkit.getDefaultToolkit().getImage(imgURL);
                    Frame.setIconImage(img);
                }
                catch (Exception e) {}
                Frame.setLocationRelativeTo(null);
                Frame.setVisible(true);
                Frame.generateProblem();
                Frame.assignListeners();
            }
        });
    }
}

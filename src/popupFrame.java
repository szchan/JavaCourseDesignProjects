import javax.swing.*;
import java.awt.*;

public class popupFrame {
    public static void successResevat(){
        JFrame frame = new JFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setBounds(screenSize.width/4,screenSize.height/4,screenSize.width/2,screenSize.height/2);
        JLabel background = new JLabel(new ImageIcon("/Users/chenshaoze/Documents/Courses Files/Java/JavaCourseDesign/Projects/src/img/reSuccess.jpg"));
        frame.add(background);
        frame.setVisible(true);
    }

    public static void successcancelResevat(){
        JFrame frame = new JFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setBounds(screenSize.width/4,screenSize.height/4,screenSize.width/2,screenSize.height/2);
        JLabel background = new JLabel(new ImageIcon("/Users/chenshaoze/Documents/Courses Files/Java/JavaCourseDesign/Projects/src/img/cansuccess.jpg"));
        frame.add(background);
        frame.setVisible(true);
    }
}

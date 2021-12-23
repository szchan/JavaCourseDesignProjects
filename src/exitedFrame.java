import javax.swing.*;
import java.awt.*;

public class exitedFrame {
    public static void exited() {
        JFrame frame = new JFrame();
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setBounds(screenSize.width / 4, screenSize.height / 4, screenSize.width / 2, screenSize.height / 2);



        JLabel background = new JLabel(new ImageIcon("/Users/chenshaoze/Documents/Courses Files/Java/JavaCourseDesign/Projects/src/img/exit.jpg"));
        frame.add(background);
        frame.setVisible(true);
    }

}

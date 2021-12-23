import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;

public class failFrame {
    public failFrame(){

    }

    public static void fail (){



        //初始化窗口
        JFrame frame = new JFrame("错误");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        frame.setBounds(screenSize.width/4,screenSize.height/4,screenSize.width/2,screenSize.height/2);
        frame.setLayout(new BorderLayout());

        //背景面板
        JPanel failPanel = new JPanel();
        failPanel.setLayout(new BorderLayout());

        //返回按钮
        JPanel buttonPanel = new JPanel();
        JButton button = new JButton("返回");
        buttonPanel.add(button);


        JLabel background = new JLabel(new ImageIcon("/Users/chenshaoze/Documents/Courses Files/Java/JavaCourseDesign/Projects/src/img/fail.jpg"));
        failPanel.add(background);
        frame.add(failPanel,BorderLayout.CENTER);
       // frame.add(buttonPanel,BorderLayout.SOUTH);
        frame.setVisible(true);
    }

}

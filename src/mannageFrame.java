import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class mannageFrame {
    public static String user;
    public static String pass;
    static TextField userField = new TextField(20);
    static TextField passField = new TextField(20);
    public static void mannageFrame(){
        //初始化事件监听器
        ActionListener manager = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand){
                    //确认动作
                    case "确定":
                        user = userField.getText();
                        pass = passField.getText();
                        try {
                            DBConnecter.addWaiter(user,pass);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "返回":

                        break;
                }
            }
        };
        //初始化窗口
        JFrame mannageFrame = new JFrame("酒店管理系统");

        mannageFrame.setLayout(new BorderLayout());

        //初始化面板
        Panel chooseRoomPanel = new Panel();
        Panel actionPanel = new Panel();

        //文本框和文本标签
        JLabel userLabel = new JLabel("用户名");
        JLabel passLabel = new JLabel("密码");

        //初始化按钮
        Button checkButton = new Button("确定");
        Button gobackButton = new Button("返回");

        //为按钮添加事件监听器
        checkButton.addActionListener(manager);
        gobackButton.addActionListener(manager);

        //将按钮添加进面板
        actionPanel.add(checkButton);
        actionPanel.add(gobackButton);

        //获取显示器尺寸
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();

        //指定窗口大小
        mannageFrame.setBounds(screenSize.width/4,screenSize.height/4,screenSize.width/2,screenSize.height/2);

        //将面板添加进窗口
        mannageFrame.add(chooseRoomPanel,BorderLayout.CENTER);
        mannageFrame.add(actionPanel,BorderLayout.SOUTH);

        //将窗口设置为可见
        mannageFrame.setVisible(true);
    }
}

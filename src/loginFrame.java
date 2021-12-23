import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class loginFrame {
    static String username;
    static String password;
    static TextField textField = new TextField(40);
    static TextField passwordField = new TextField(40);

    public static void frame (){

        ActionListener loginAction = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand) {
                    case "登陆":
                        username = textField.getText();
                        password = passwordField.getText();
                        try {
                            if(DBConnecter.queryUser(username,password)){
                                waiterFrame.room();
                            }else{
                                failFrame.fail();
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "注册":
                        try {
                            DBConnecter.addUser(username, password);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                }
            }
        };

        //登陆窗口
        JFrame loginFrame = new JFrame("登陆");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        loginFrame.setLocation(screenSize.width/4,screenSize.height/4);
        loginFrame.setSize(screenSize.width/2, screenSize.height/2);
        loginFrame.setLayout(new BorderLayout());

        Container contenPane100 = loginFrame.getContentPane();
        SpringLayout springLayout = new SpringLayout();
        JPanel centerPanel100 = new JPanel(springLayout);
        JLabel userNameLabel5 = new JLabel("用户名:");
        userNameLabel5.setFont(new Font("华文行楷", Font.PLAIN, 30));
        centerPanel100.add(userNameLabel5);
        centerPanel100.add(userNameLabel5);
        centerPanel100.add(textField);
        JLabel userNameLabel55 = new JLabel("密码:");
        userNameLabel55.setFont(new Font("华文行楷", Font.PLAIN, 30));
        springLayout.putConstraint(SpringLayout.NORTH, userNameLabel55, 60, SpringLayout.NORTH, userNameLabel5);
        springLayout.putConstraint(SpringLayout.WEST, userNameLabel55, 0, SpringLayout.WEST, userNameLabel5);
        springLayout.putConstraint(SpringLayout.NORTH, passwordField, 0, SpringLayout.NORTH, userNameLabel55);
        springLayout.putConstraint(SpringLayout.WEST, passwordField, 0, SpringLayout.WEST, textField);
        springLayout.putConstraint(SpringLayout.NORTH, userNameLabel5, 130, SpringLayout.NORTH, centerPanel100);
        springLayout.putConstraint(SpringLayout.WEST, userNameLabel5, 60, SpringLayout.WEST, centerPanel100);
        springLayout.putConstraint(SpringLayout.NORTH, textField, 0, SpringLayout.NORTH, userNameLabel5);
        springLayout.putConstraint(SpringLayout.WEST, textField, 60, SpringLayout.EAST, userNameLabel5);
        centerPanel100.add(userNameLabel55);
        centerPanel100.add(passwordField);
        JButton qrsc = new JButton("注册");
        qrsc.setFont(new Font("华文行楷", Font.PLAIN, 40));
        springLayout.putConstraint(SpringLayout.NORTH, qrsc, 40, SpringLayout.SOUTH, passwordField);
        springLayout.putConstraint(SpringLayout.WEST, qrsc, 0, SpringLayout.WEST, passwordField);
        qrsc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                passwordField.setText("");
                textField.setText("");

            }
        });
        JButton fanhui5 = new JButton("登陆");
        fanhui5.setFont(new Font("华文行楷", Font.PLAIN, 40));
        springLayout.putConstraint(SpringLayout.NORTH, fanhui5, 0, SpringLayout.NORTH, qrsc);
        springLayout.putConstraint(SpringLayout.WEST, fanhui5, 30, SpringLayout.EAST, passwordField);
        fanhui5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField.setText("");
                passwordField.setText("");
            }
        });
        JLabel jl3 =new JLabel(new ImageIcon("/Users/chenshaoze/Documents/Courses Files/Java/JavaCourseDesign/Projects/src/img/login.jpg"));
        centerPanel100.add(qrsc);
        centerPanel100.add(fanhui5);
        centerPanel100.add(jl3);
        contenPane100.add(centerPanel100, BorderLayout.CENTER);

        fanhui5.addActionListener(loginAction);
        qrsc.addActionListener(loginAction);

        //让登陆窗口可见
        loginFrame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException {
        waiterFrame.room();
    }
}



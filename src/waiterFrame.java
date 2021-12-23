import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class waiterFrame {
    static String room;
    static String date;
    //初始化文本框
    static TextField dateField = new TextField(20);
    static TextField roomField = new TextField(20);

    public static void room() throws SQLException {

        //初始化事件监听器
        ActionListener waiterListener = new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                switch (actionCommand){
                    case "确认预定":
                        room = roomField.getText();
                        date = dateField.getText();
                        try {
                            //如果房间没有被预定就预定房间
                            if(DBConnecter.userQueryRoom(switchDB.userQueryRoom(room), date)) {
                                try {
                                    DBConnecter.reservatRoom(switchDB.reservatRoom(room), date, loginFrame.username);
                                    //弹出预定成功提示框
                                    popupFrame.successResevat();
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                                //如果房间已经被预定就弹出房间已经被预定提示框
                            }else{
                                exitedFrame.exited();
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "取消预定":
                        try {
                            DBConnecter.cancelreservatRoom(switchDB.cancelresevatRoom(room),date);
                            popupFrame.successcancelResevat();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                        break;
                    case "退出":
                        System.exit(0);
                        break;
                    case "查询":

                        break;
                }
            }
        };

        //初始化窗口
        JFrame waiterFrame = new JFrame("酒店服务系统");

        //表格
        JTable table = new JTable();

        //存储表格第一行：标题
        String[] columnNames = {"房号","日期"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);


        //初始化面板
        Panel roomPanel = new Panel();
        Panel buttonPanel = new Panel();
        JScrollPane tableScrollPane = new JScrollPane(table);

        //初始化按钮
        Button chooseButton = new Button("确认预定");
        Button cancelButton = new Button("取消预定");
        Button exitButton = new Button("退出");
        Button queryButton = new Button("查询");

        //为按钮添加监听器
        chooseButton.addActionListener(waiterListener);
        cancelButton.addActionListener(waiterListener);
        exitButton.addActionListener(waiterListener);
        queryButton.addActionListener(waiterListener);

        //将按钮加入面板
        buttonPanel.add(chooseButton);
        buttonPanel.add(cancelButton);
        buttonPanel.add(exitButton);

        //查询面板
        roomPanel.add(new Label("房号"));
        roomPanel.add(roomField);
        roomPanel.add(new Label("日期"));
        roomPanel.add(dateField);
        roomPanel.add(queryButton);

        //指定窗口的位置和大小
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        waiterFrame.setBounds(0,0,screenSize.width,screenSize.height);

        //添加面板
        waiterFrame.add(roomPanel,BorderLayout.NORTH);
        waiterFrame.add(tableScrollPane,BorderLayout.CENTER);
        waiterFrame.add(buttonPanel,BorderLayout.SOUTH);

        //让窗口可见
        waiterFrame.setVisible(true);

    }
}
package com.codebind;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 3/25/2017.
 */
public class App {
    private JPanel panelCLOCKIN;
    private JTextField textFieldInput;
    private JButton buttonDEL;
    private JButton buttonZERO;
    private JButton buttonOK;
    private JButton buttonONE;
    private JButton buttonTWO;
    private JButton buttonTHREE;
    private JButton buttonFOUR;
    private JButton buttonFIVE;
    private JButton buttonSIX;
    private JButton buttonSEVEN;
    private JButton buttonEIGHT;
    private JButton buttonNINE;
    private JPanel panelCHEF;
    private JTabbedPane tabbedPane;
    public JTable tableCHEF;
    private JButton CHEFADDTEST;
    private JButton buttonDELETE;
    private JPanel panelWaiter;
    private JTable tableWAIT;
    private JButton buttonDELwait;

    private JScrollPane ScrollPaneCHEF;
    private JScrollPane ScrollPaneWAIT;

    String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server"};
    Object[][] rowdata;

    String selectedOrderCHEF;
    String selectedNotesCHEF;
    String selectedTableNoCHEF;
    String selectedServerCHEF;
    int selectedRowIDCHEF;

    String selectedOrderWAIT;
    String selectedNotesWAIT;
    String selectedTableNoWAIT;
    String selectedServerWAIT;
    int selectedRowIDWAIT;


    AbstractTableModel datamodelCHEF;
    AbstractTableModel datamodelWAIT;

    public App() {

        datamodelCHEF = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public int getColumnCount() {
                return CHEFcolNames.length;
            }

            @Override
            public String getColumnName(int index){
                return CHEFcolNames[index];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowIndex * columnIndex;
            }
        };

        tableCHEF.setModel(datamodelCHEF);

        datamodelWAIT = new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return 0;
            }

            @Override
            public int getColumnCount() {
                return CHEFcolNames.length;
            }

            @Override
            public String getColumnName(int index){
                return CHEFcolNames[index];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                return rowIndex * columnIndex;
            }
        };

        tableWAIT.setModel(datamodelWAIT);



        tableCHEF.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                int i = tableCHEF.getSelectedRow();
                selectedRowIDCHEF = tableCHEF.getSelectedRow();

                TableModel model = tableCHEF.getModel();

                // Display Slected Row In JTexteFields
                selectedOrderCHEF = model.getValueAt(i,0).toString();
                selectedNotesCHEF = model.getValueAt(i,1).toString();
                selectedTableNoCHEF = model.getValueAt(i,2).toString();
                selectedServerCHEF = model.getValueAt(i,3).toString();

                System.out.println(tableCHEF.getValueAt(tableCHEF.getSelectedRow(), 0).toString());
            }
        });

        tableWAIT.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                // do some actions here, for example
                // print first column value from selected row
                int i = tableWAIT.getSelectedRow();
                selectedRowIDWAIT = tableWAIT.getSelectedRow();

                TableModel model = tableWAIT.getModel();

                // Display Slected Row In JTexteFields
                selectedOrderWAIT = model.getValueAt(i,0).toString();
                selectedNotesWAIT = model.getValueAt(i,1).toString();
                selectedTableNoWAIT = model.getValueAt(i,2).toString();
                selectedServerWAIT = model.getValueAt(i,3).toString();

                System.out.println(tableWAIT.getValueAt(tableWAIT.getSelectedRow(), 0).toString());
            }
        });

        buttonONE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "1");
            }
        });
        buttonZERO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "0");
            }
        });
        buttonTWO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "2");
            }
        });
        buttonTHREE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "3");
            }
        });
        buttonFOUR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "4");
            }
        });
        buttonFIVE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "5");
            }
        });
        buttonSIX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "6");
            }
        });
        buttonSEVEN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "7");
            }
        });
        buttonEIGHT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "8");
            }
        });
        buttonNINE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldInput.setText(textFieldInput.getText() + "9");
            }
        });
        buttonDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = textFieldInput.getText().length();
                int number = textFieldInput.getText().length() - 1;
                String store;

                if(length > 0){
                    StringBuilder back = new StringBuilder(textFieldInput.getText());
                    back.deleteCharAt(number);
                    store = back.toString();
                    textFieldInput.setText(store);
                }
            }
        });
        CHEFADDTEST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new updateCHEF();
            }
        });

        buttonDELETE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Connection connection = getConnection();
                String sql = "DELETE FROM chefslist WHERE `Order` = ?";
                try {
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, selectedOrderCHEF);
                    int deleteCount = pstmt.executeUpdate();


                } catch (Exception ee){
                    ee.printStackTrace();
                }
                ArrayList<ChefsList> list = getUsersListChef();
                rowdata = new Object [list.size()][4];

                for(int i = 0; i < list.size();i++){
                    rowdata[i][0] = list.get(i).getOrder();
                    rowdata[i][1] = list.get(i).getNotes();
                    rowdata[i][2] = list.get(i).getTableNo();
                    rowdata[i][3] = list.get(i).getServer();
                }

                datamodelCHEF = new AbstractTableModel() {
                    @Override
                    public int getRowCount() {
                        return rowdata.length;
                    }

                    @Override
                    public int getColumnCount() {
                        return CHEFcolNames.length;
                    }

                    @Override
                    public String getColumnName(int index){
                        return CHEFcolNames[index];
                    }

                    @Override
                    public Object getValueAt(int row, int col) {
                        return rowdata[row][col];
                    }


                };

                tableCHEF.setModel(datamodelCHEF);
                datamodelCHEF.fireTableDataChanged();
                ScrollPaneCHEF.revalidate();
                ScrollPaneCHEF.repaint();
                panelCHEF.revalidate();
                panelCHEF.repaint();
            }
        });
    }

    public Connection getConnection(){
        Connection con;
        try{
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/chef","amd","drworm");
            return con;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }

    }


    public ArrayList<ChefsList> getUsersListChef()
    {
        ArrayList<ChefsList> usersList = new ArrayList<>();
        Connection connection = getConnection();

        String query = "SELECT * FROM  `chefslist` ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            ChefsList chefsList;

            while(rs.next())
            {
                chefsList = new ChefsList(rs.getString("Order"),rs.getString("Notes"),rs.getInt("TableNo"),rs.getString("Server"));
                usersList.add(chefsList);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public ArrayList<ChefsList> getUsersListWait()
    {
        ArrayList<ChefsList> usersList = new ArrayList<>();
        Connection connection = getConnection();

        String query = "SELECT * FROM  `waiterslist` ";
        Statement st;
        ResultSet rs;

        try {
            st = connection.createStatement();
            rs = st.executeQuery(query);

            ChefsList chefsList;

            while(rs.next())
            {
                chefsList = new ChefsList(rs.getString("Order"),rs.getString("Notes"),rs.getInt("TableNo"),rs.getString("Server"));
                usersList.add(chefsList);
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return usersList;
    }

    // display data in CHEF JTable
    public class updateCHEF{
        String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server"};
         //= {{"Cheeseburger French Fries","Well done","7","Kathy"},{"Lobster Bisque","none","5","Jay"}};

        public updateCHEF(){
            ArrayList<ChefsList> list = getUsersListChef();
            rowdata = new Object [list.size()][4];

            for(int i = 0; i < list.size();i++){
                rowdata[i][0] = list.get(i).getOrder();
                rowdata[i][1] = list.get(i).getNotes();
                rowdata[i][2] = list.get(i).getTableNo();
                rowdata[i][3] = list.get(i).getServer();
            }

            datamodelCHEF = new AbstractTableModel() {
                @Override
                public int getRowCount() {
                    return rowdata.length;
                }

                @Override
                public int getColumnCount() {
                    return CHEFcolNames.length;
                }

                @Override
                public String getColumnName(int index){
                    return CHEFcolNames[index];
                }

                @Override
                public Object getValueAt(int row, int col) {
                    return rowdata[row][col];
                }


            };

            tableCHEF.setModel(datamodelCHEF);
        }
    }

    public class updateWAIT{
        String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server"};
        //= {{"Cheeseburger French Fries","Well done","7","Kathy"},{"Lobster Bisque","none","5","Jay"}};

        public updateWAIT(){
            ArrayList<ChefsList> list = getUsersListChef();
            rowdata = new Object [list.size()][4];

            for(int i = 0; i < list.size();i++){
                rowdata[i][0] = list.get(i).getOrder();
                rowdata[i][1] = list.get(i).getNotes();
                rowdata[i][2] = list.get(i).getTableNo();
                rowdata[i][3] = list.get(i).getServer();
            }

            datamodelCHEF = new AbstractTableModel() {
                @Override
                public int getRowCount() {
                    return rowdata.length;
                }

                @Override
                public int getColumnCount() {
                    return CHEFcolNames.length;
                }

                @Override
                public String getColumnName(int index){
                    return CHEFcolNames[index];
                }

                @Override
                public Object getValueAt(int row, int col) {
                    return rowdata[row][col];
                }


            };

            tableWAIT.setModel(datamodelWAIT);
        }
    }











    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}

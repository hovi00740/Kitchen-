package com.codebind;

//import com.mysql.jdbc.PreparedStatement;

import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;


public class App {
    // Keypad Buttons used for Kitchen Login Screen
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

    String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server","id"};
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


    //AbstractTableModel datamodelCHEF;
    //AbstractTableModel datamodelWAIT;

    //DefaultTableModel datamodelCHEF = (DefaultTableModel)tableCHEF.getModel();
    //DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();

    public App() {
        // Creates a new instances of a data model for the chef screen

        DefaultTableModel datamodelCHEF = (DefaultTableModel)tableCHEF.getModel();
        datamodelCHEF.setDataVector(rowdata, CHEFcolNames);
        datamodelCHEF.fireTableDataChanged();
       //Uploads the new data model saved in  datamodelCHEF
        //tableCHEF.setModel(datamodelCHEF);

        DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
        datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
        datamodelWAIT.fireTableDataChanged();


        //Uploads the new data model saved in  datamodelCHEF
        //tableWAIT.setModel(datamodelWAIT);



        /*tableCHEF.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {

                int i = tableCHEF.getSelectedRow();
                selectedRowIDCHEF = tableCHEF.getSelectedRow();

                DefaultTableModel model = (DefaultTableModel)tableCHEF.getModel();

                // Display Selected Row In JTexteFields
                selectedOrderCHEF = model.getValueAt(i,0).toString();
                selectedNotesCHEF = model.getValueAt(i,1).toString();
                selectedTableNoCHEF = model.getValueAt(i,2).toString();
                selectedServerCHEF = model.getValueAt(i,3).toString();

                System.out.println(tableCHEF.getValueAt(tableCHEF.getSelectedRow(), 0).toString());
            }
        });

        tableWAIT.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
            public void valueChanged(ListSelectionEvent event) {
                int i = tableWAIT.getSelectedRow();
                selectedRowIDWAIT = tableWAIT.getSelectedRow();

                DefaultTableModel model = (DefaultTableModel)tableWAIT.getModel();

                // Display Slected Row In JTexteFields
                selectedOrderWAIT = model.getValueAt(i,0).toString();
                selectedNotesWAIT = model.getValueAt(i,1).toString();
                selectedTableNoWAIT = model.getValueAt(i,2).toString();
                selectedServerWAIT = model.getValueAt(i,3).toString();

                System.out.println(tableWAIT.getValueAt(tableWAIT.getSelectedRow(), 0).toString());
            }
        });*/
        // Action Listeners for the keypad buttons
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
        //Updates the table of elements whenever a item is deleted
        buttonDEL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int length = textFieldInput.getText().length();
                int number = textFieldInput.getText().length() - 1;
                String store;

                //If there is a value build a string using the string builder in the text field, if not keep it blank

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
                DefaultTableModel datamodelCHEF = (DefaultTableModel)tableCHEF.getModel();
                Connection connection = getConnection();
                String sql = "DELETE FROM chefslist WHERE `id` = ?";
                String selOrderCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),0).toString();
                String selNotesCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),1).toString();
                String selTableNoCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),2).toString();
                String selServerCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),3).toString();
                String selidCHEF = datamodelCHEF.getValueAt(tableCHEF.getSelectedRow(),4).toString();
                try {
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, selidCHEF);
                    int deleteCount = pstmt.executeUpdate();


                } catch (Exception ee){
                    ee.printStackTrace();
                }

                ArrayList<ChefsList> list = getUsersListWait();

                sql = "INSERT INTO waiterslist values(?,?,?,?,?)";
                try{
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, selOrderCHEF);
                    pstmt.setString(2, selNotesCHEF);
                    pstmt.setString(3, selTableNoCHEF);
                    pstmt.setString(4, selServerCHEF);
                    pstmt.setString(5, String.valueOf(list.size() + 1));
                    int deleteCount = pstmt.executeUpdate();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }




                list = getUsersListChef();
                rowdata = new Object [list.size()][5];

                for(int i = 0; i < list.size();i++){
                    rowdata[i][0] = list.get(i).getOrder();
                    rowdata[i][1] = list.get(i).getNotes();
                    rowdata[i][2] = list.get(i).getTableNo();
                    rowdata[i][3] = list.get(i).getServer();
                    rowdata[i][4] = i + 1;
                }

                datamodelCHEF.setDataVector(rowdata, CHEFcolNames);
                datamodelCHEF.fireTableDataChanged();

                list = getUsersListWait();
                rowdata = new Object [list.size()][5];

                for(int i = 0; i < list.size();i++){
                    rowdata[i][0] = list.get(i).getOrder();
                    rowdata[i][1] = list.get(i).getNotes();
                    rowdata[i][2] = list.get(i).getTableNo();
                    rowdata[i][3] = list.get(i).getServer();
                    rowdata[i][4] = i + 1;
                }

                DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
                datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
                datamodelWAIT.fireTableDataChanged();




                //tableCHEF.setModel(datamodelCHEF);
                //datamodelCHEF.fireTableDataChanged();
               // ScrollPaneCHEF.revalidate();
              //  ScrollPaneCHEF.repaint();
              //  panelCHEF.revalidate();
               // panelCHEF.repaint();
            }
        });

        
        // WAITER TAB
        buttonDELwait.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
                Connection connection = getConnection();
                String sql = "DELETE FROM waiterslist WHERE `Order` = ?";
                String selOrderWAIT = datamodelWAIT.getValueAt(tableWAIT.getSelectedRow(),0).toString();
                try {
                    java.sql.PreparedStatement pstmt = connection.prepareStatement(sql);
                    pstmt.setString(1, selOrderWAIT);
                    int deleteCount = pstmt.executeUpdate();


                } catch (Exception ee){
                    ee.printStackTrace();
                }
                ArrayList<ChefsList> list = getUsersListWait();
                rowdata = new Object [list.size()][5];

                for(int i = 0; i < list.size();i++){
                    rowdata[i][0] = list.get(i).getOrder();
                    rowdata[i][1] = list.get(i).getNotes();
                    rowdata[i][2] = list.get(i).getTableNo();
                    rowdata[i][3] = list.get(i).getServer();
                    rowdata[i][4] = i + 1;
                }


                datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
                datamodelWAIT.fireTableDataChanged();

                //tableCHEF.setModel(datamodelCHEF);
                //datamodelCHEF.fireTableDataChanged();
            }
        });
        // Action listener for the java swing ok button that logins in the entry Pre-Condition: Must be a five digit number, Post-Condition: information is pushed to the
        //database upon completion. Success Prompt "YOU DID IT!".
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(textFieldInput.getText().length() != 5){
                   JOptionPane.showMessageDialog(null, "Clock-in pin must be 5 digits.");
               }
               else{
                   String firstName = "Jim";
                   String lastName = "Jimmerson";

                   JOptionPane.showMessageDialog(null, "YOU DID IT!");

                   String toFind = textFieldInput.getText();

                   Connection connection = getConnection();
                   String query = "SELECT FirstName, LastName from clockin WHERE idClockIn = ?";
                   try {

                       java.sql.PreparedStatement pstmt = connection.prepareStatement(query);
                       pstmt.setString(1, toFind);
                       ResultSet rs;

                       rs = pstmt.executeQuery();
                       while(rs.next()){
                           firstName = rs.getString("FirstName");
                           lastName = rs.getString("LastName");
                       }

                       String messageString = firstName + lastName + " has been clocked!";

                       JOptionPane.showMessageDialog(null, messageString);

                       connection.close();


                   }
                   catch(Exception ee){
                        JOptionPane.showMessageDialog(null,"Error in finding the id entered!");
                        System.err.println(ee.getMessage());
                   }
               }
            }
        });
    }
    // Creates a JDBC connection to a data source using the Driver Manager which is part of the
    // Java sql library. Returns a connections to the data source
    public static Connection getConnection(){
        Connection con = null;
        try{
            String url = "jdbc:mysql://chef.clvbnnnbtnmd.us-west-2.rds.amazonaws.com:3306/chef";
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,"amd","password");
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
                chefsList = new ChefsList(rs.getString("Order"),rs.getString("Notes"),rs.getInt("TableNo"),rs.getString("Server"),rs.getInt("id"));
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
                chefsList = new ChefsList(rs.getString("Order"),rs.getString("Notes"),rs.getInt("TableNo"),rs.getString("Server"),rs.getInt("id"));
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
        String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server","id"};
         //= {{"Cheeseburger French Fries","Well done","7","Kathy"},{"Lobster Bisque","none","5","Jay"}};

        public updateCHEF(){
            ArrayList<ChefsList> list = getUsersListChef();
            rowdata = new Object [list.size()][5];

            for(int i = 0; i < list.size();i++){
                rowdata[i][0] = list.get(i).getOrder();
                rowdata[i][1] = list.get(i).getNotes();
                rowdata[i][2] = list.get(i).getTableNo();
                rowdata[i][3] = list.get(i).getServer();
                rowdata[i][4] = i + 1;
            }

            DefaultTableModel datamodelCHEF = (DefaultTableModel)tableCHEF.getModel();
            datamodelCHEF.setDataVector(rowdata, CHEFcolNames);
            datamodelCHEF.fireTableDataChanged();


            //tableCHEF.setModel(datamodelCHEF);
        }
    }

    public class updateWAIT{
        String[] CHEFcolNames = {"Order Name", "Notes", "Table","Server","id"};
        //= {{"Cheeseburger French Fries","Well done","7","Kathy"},{"Lobster Bisque","none","5","Jay"}};

        public updateWAIT(){
            ArrayList<ChefsList> list = getUsersListChef();
            rowdata = new Object [list.size()][5];

            for(int i = 0; i < list.size();i++){
                rowdata[i][0] = list.get(i).getOrder();
                rowdata[i][1] = list.get(i).getNotes();
                rowdata[i][2] = list.get(i).getTableNo();
                rowdata[i][3] = list.get(i).getServer();
                rowdata[i][4] = i + 1;
            }

            DefaultTableModel datamodelWAIT = (DefaultTableModel)tableWAIT.getModel();
            datamodelWAIT.setDataVector(rowdata, CHEFcolNames);
            datamodelWAIT.fireTableDataChanged();

            tableWAIT.setModel(datamodelWAIT);
        }
    }

/*START OF THE MAIN FUNCTION*/
    public static void main(String[] args) {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new App().tabbedPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);


    }
}
/*END OF THE MAIN FUNCTION*/
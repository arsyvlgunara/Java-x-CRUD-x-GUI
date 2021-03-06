import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteData extends JFrame {
    Statement statement;
    ResultSet resultSet;
    String[][] datas = new String[500][4];
    String[] kolom = {"NAMA", "NO TELP"};
    JLabel lTitle;
    JButton bDelete, bBack;
    JTable tTable;
    JScrollPane scrollPane;

    public DeleteData() throws SQLException, ClassNotFoundException {
        lTitle = new JLabel ("Seluruh Data Kontak");
        bDelete = new JButton ("Delete");
        bBack = new JButton ("Kembali");
        tTable = new JTable(datas, kolom);
        scrollPane = new JScrollPane(tTable);

        setTitle("Hapus Data Kontak");
        DBConnection connec = new DBConnection();
        statement = connec.getConnection().createStatement();
        String sql = "SELECT * FROM tb_kontak";
        resultSet = statement.executeQuery(sql);
        int row = 0;
        while (resultSet.next()){
            datas[row][0] = resultSet.getString("nama");
            datas[row][1] = resultSet.getString("no_telp");
            row++;
        }
        setLayout(null);
        add(lTitle);
        add(bDelete);
        add(bBack);
        add(scrollPane);

        lTitle.setBounds(160, 30, 300, 30);
        scrollPane.setBounds(70, 70, 400, 400);
        bDelete.setBounds(170, 490, 90, 25);
        bBack.setBounds(280, 490, 90, 25);

        setSize(550,650);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        bBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });

        bDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProcessDelete hapus = new ProcessDelete();
                hapus.ProsesDelete();
                setVisible(false);
            }
        });
    }
}

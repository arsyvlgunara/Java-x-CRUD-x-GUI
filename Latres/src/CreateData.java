import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;


class CreateData extends JFrame{
    Statement statement;
    final JTextField fnama = new JTextField(10);
    final JTextField fnotelp = new JTextField(10);
    private JLabel stat;
    JButton btnSave = new JButton("Save");
    JButton btnBack = new JButton("Kembali");

    JLabel lnama = new JLabel("Nama: ");
    JLabel lnotelp = new JLabel("No Telepon: ");


    public CreateData() {
        setTitle("** Menyimpan Kontak **");
        setSize(440, 300);
        stat = new JLabel("Status: Null ");

        setLayout(null);
        add(lnama);
        add(fnama);
        add(lnotelp);
        add(fnotelp);

        add(stat);
        add(btnSave);
        add(btnBack);

        lnama.setBounds(10, 10, 120, 25);
        fnama.setBounds(130, 10, 270, 25);
        lnotelp.setBounds(10, 40, 120, 25);
        fnotelp.setBounds(130, 40, 270, 25);
        stat.setBounds(10, 160, 390, 45);
        btnSave.setBounds(30, 210, 110, 30);
        btnBack.setBounds(150, 210, 110, 30);


        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String nama = fnama.getText();
                    int notelp = Integer.parseInt(fnotelp.getText());

                    Data data = new Data(nama, notelp);

                    DBConnection connec = new DBConnection();
                    try {
                        statement = connec.getConnection().createStatement();
                        statement.executeUpdate("INSERT INTO tb_kontak VALUES('" + data.getNama() + "','" + data.getNotelp() + "')");
                        JOptionPane.showMessageDialog(rootPane, "Data Berhasil Disimpan");
                    } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(CreateData.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (SQLException ex) {
                        java.util.logging.Logger.getLogger(CreateData.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Tipe Data Salah");
                } catch (Error ext) {
                    JOptionPane.showMessageDialog(rootPane, "SALAH!!");
                }

                setVisible(false);
            }
        });
        btnBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new Main();
            }
        });
    }
}
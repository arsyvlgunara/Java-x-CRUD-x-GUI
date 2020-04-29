import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProsesUpdate extends JFrame {
    JLabel lTitle, lNama, lNIM, lAlamat, lNoTelp;
    JTextField fNama, fNIM, fAlamat, fNoTelp;
    JButton bSave, bBack;
    Statement statement;

    public ProsesUpdate() {

        setTitle("FORM EDIT DATA");
        lTitle = new JLabel("Edit Berdasarkan Nama");
        lNama = new JLabel("Nama ");
        fNama = new JTextField();
        lNoTelp = new JLabel("No Telp ");
        fNoTelp= new JTextField();
        bSave = new JButton("Simpan");
        bBack = new JButton("Kembali");
        bBack.setBackground(new Color(158, 158, 230));

        setLayout(null);
        add(lTitle);
        add(lNama);
        add(fNama);
        add(lNoTelp);
        add(fNoTelp);
        add(bSave);
        add(bBack);

        lTitle.setBounds(120, 20, 250, 30);
        lNama.setBounds(30, 70, 120, 30);
        fNama.setBounds(110, 73,270,25);
        lNoTelp.setBounds(30, 110, 120, 30);
        fNoTelp.setBounds(110, 113, 270, 25);
        bSave.setBounds(120, 245, 90, 30);
        bBack.setBounds(220, 245, 90,30);

        setSize(440, 350);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                btnUpdateactionListener();
            }

            private void btnUpdateactionListener() {
                DBConnection connec = new DBConnection();
                try {
                    statement = connec.getConnection().createStatement();
                    statement.executeUpdate("UPDATE tb_kontak SET  nama='" +
                            fNama.getText() + "'," + "no_telp='" + fNoTelp.getText() + "'WHERE nama='" + fNama.getText() + "'");

                    JOptionPane.showMessageDialog(null, "Data berhasil di Update!", "Hasil", JOptionPane.INFORMATION_MESSAGE);
                    statement.close();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Data gagal diupdate!", "Hasil", JOptionPane.ERROR_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "Driver Tidak Ditemukan!", "Hasil", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        bBack.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent ae) {
                setVisible(false);
                try {
                    new UpdateData();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ProsesUpdate.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    Logger.getLogger(ProsesUpdate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
import javax.swing.*;

class Output extends JFrame{
    JLabel lnama = new JLabel("Nama : ");
    JLabel lnotelp = new JLabel("No Telepon: ");

    public Output(String nama, String notelp){
        setTitle("Hasil Data Formulir");
        setDefaultCloseOperation(3);
        setSize(440,400);
        JLabel n = new JLabel(nama);
        JLabel t = new JLabel(notelp);

        add(lnama);
        add(lnotelp);
        add(n);
        add(t);

        setLayout(null);
        lnama.setBounds(10,10,120,25);
        n.setBounds(130,10,220,25);
        lnotelp.setBounds(10, 40,120,25);
        t.setBounds(130,40,220,25);

        setVisible(true);
    }

}

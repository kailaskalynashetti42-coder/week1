import java.awt.*;
import java.awt.event.*;

public class Calsi extends Frame implements ActionListener {

    Label l1, l2, l3, title;
    TextField t1, t2, tResult;
    Button bAdd, bSub, bMul, bDiv, bMod, bPow, bClear;

    public Calsi() {

        setLayout(null);
        setSize(420, 520);
        setTitle("AWT Advanced Calculator");
        setBackground(new Color(30, 30, 30));

        Font boldFont = new Font("Segoe UI", Font.BOLD, 14);
        Font titleFont = new Font("Segoe UI", Font.BOLD, 20);

        title = new Label("AWT Advanced Calculator", Label.CENTER);
        title.setBounds(50, 40, 320, 30);
        title.setFont(titleFont);
        title.setForeground(Color.WHITE);
        add(title);

        l1 = new Label("value 1:");
        l1.setBounds(50, 90, 160, 20);
        l1.setForeground(Color.WHITE);
        l1.setFont(boldFont);
        add(l1);

        t1 = new TextField();
        t1.setBounds(50, 115, 320, 30);
        t1.setFont(boldFont);
        add(t1);

        l2 = new Label("value 2:");
        l2.setBounds(50, 160, 160, 20);
        l2.setForeground(Color.WHITE);
        l2.setFont(boldFont);
        add(l2);

        t2 = new TextField();
        t2.setBounds(50, 185, 320, 30);
        t2.setFont(boldFont);
        add(t2);

        bAdd = new Button("ADD");
        bAdd.setBounds(50, 240, 60, 40);
        bAdd.addActionListener(this);
        add(bAdd);

        bSub = new Button("SUB");
        bSub.setBounds(115, 240, 60, 40);
        bSub.addActionListener(this);
        add(bSub);

        bMul = new Button("*");
        bMul.setBounds(180, 240, 60, 40);
        bMul.addActionListener(this);
        add(bMul);

        bDiv = new Button("/");
        bDiv.setBounds(245, 240, 60, 40);
        bDiv.addActionListener(this);
        add(bDiv);

        bMod = new Button("MOD");
        bMod.setBounds(310, 240, 60, 40);
        bMod.addActionListener(this);
        add(bMod);

        bPow = new Button("^");
        bPow.setBounds(120, 290, 180, 40);
        bPow.addActionListener(this);
        add(bPow);

        bClear = new Button("CLEAR");
        bClear.setBounds(50, 340, 320, 35);
        bClear.addActionListener(this);
        add(bClear);

        l3 = new Label("Result:");
        l3.setBounds(50, 390, 150, 20);
        l3.setForeground(Color.WHITE);
        l3.setFont(boldFont);
        add(l3);

        tResult = new TextField();
        tResult.setBounds(50, 415, 320, 40);
        tResult.setEditable(false);
        add(tResult);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bClear) {
            t1.setText("");
            t2.setText("");
            tResult.setText("");
            return;
        }

        try {
            double n1 = Double.parseDouble(t1.getText());
            double n2 = Double.parseDouble(t2.getText());
            double res = 0;

            if (e.getSource() == bAdd) res = n1 + n2;
            else if (e.getSource() == bSub) res = n1 - n2;
            else if (e.getSource() == bMul) res = n1 * n2;
            else if (e.getSource() == bDiv) res = n1 / n2;
            else if (e.getSource() == bMod) res = n1 % n2;
            else if (e.getSource() == bPow) res = Math.pow(n1, n2);

            tResult.setText(String.valueOf(res));

        } catch (Exception ex) {
            tResult.setText("Error");
        }
    }

    public static void main(String[] args) {
        new Calsi();
    }
}
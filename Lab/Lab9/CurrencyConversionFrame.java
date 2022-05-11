import java.awt.event.*;
import java.util.HashMap;
import javax.swing.*;

import java.awt.GridLayout;

public class CurrencyConversionFrame extends JFrame {
    JLabel labelTitle, labelFrom, labelTo;
    JButton convertButton, exitButton;
    String[] currency = {"Rupiah", "Euro", "US Dollar"};
    HashMap<String, Integer> kurs = new HashMap<String, Integer>();

    public CurrencyConversionFrame() {
        kurs.put("Rupiah", 1);
        kurs.put("Euro", 15000);
        kurs.put("US Dollar", 14000);

        // TO DO: Menentukan layout dan size yang ingin digunakan 
        // 4 rows, 1 column, and gap 5 diantaranya
        setLayout(new GridLayout(4, 1, 2,0));
        // ukuran 300x300
        setSize(500, 300);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setTitle("Currency Converter");

        // TO DO: Membuat Panel sesuai kebutuhan
        JPanel panel1 = new JPanel(); // panel untuk From
        JPanel panel2 = new JPanel(); // panel untuk To
        JPanel panel3 = new JPanel(); // panel untuk button

        
        labelTitle = new JLabel();
        labelTitle.setText("Welcome to Currency Converter");

        // membuat labelTitle menjadi center
        labelTitle.setHorizontalAlignment(SwingConstants.CENTER);

        // TO DO: Membuat dropdown menu
        JComboBox<String> dropdownMenuFrom = new JComboBox<>(currency);
        JComboBox<String> dropdownMenuTo = new JComboBox<>(currency);
        dropdownMenuTo.setSelectedIndex(1); // set default selected value dropdownMenuTo ke Euro

        labelFrom = new JLabel("From");
        labelTo = new JLabel("To");
                
        // TO DO: Membuat textfield 
        JTextField textFieldFrom = new JTextField(20);
        JTextField textFieldTo = new JTextField(20);
        textFieldTo.setEditable(false); // set textfieldTo menjadi tidak bisa diubah


        convertButton = new JButton("Convert");
        exitButton = new JButton("Exit");
        
        // TO DO: Masukkan widget ke panel yang tepat
        panel1.add(labelFrom);
        panel1.add(dropdownMenuFrom);
        panel1.add(textFieldFrom);
        panel2.add(labelTo);
        panel2.add(dropdownMenuTo);
        panel2.add(textFieldTo);
        panel3.add(convertButton);
        panel3.add(exitButton);

        add(labelTitle);
        // TO DO: Masukkan panel ke dalam frame
        add(panel1);
        add(panel2);
        add(panel3);


        setVisible(true);

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // TO DO: implementasikan pemanggilan method ConvertCurrency
                // mendapatkan jenis currency dari From
                String fromCurrency = (String) dropdownMenuFrom.getSelectedItem();
                // mendapatkan jenis currency dari To
                String toCurrency = (String) dropdownMenuTo.getSelectedItem();
                // mendapatkan nilai yg ingin dikonversi
                String fromValue = textFieldFrom.getText();
                // mengonversi nilai
                String toValue = ConvertCurrency(fromValue, fromCurrency, toCurrency);
                // menampilkan hasil konversi di textfieldTo
                textFieldTo.setText(toValue);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                // TO DO: hentikan eksekusi program
                System.exit(0);
            }
        });
    }
    
    // Method converter
    public String ConvertCurrency(String originalValue, String tipeCurrencyFrom, String tipeCurrencyTo) {
        double value = Double.valueOf(originalValue);
        double fromValue = value * kurs.get(tipeCurrencyFrom);
        double convertedValue = fromValue / kurs.get(tipeCurrencyTo);
        return String.format("%.2f", convertedValue);
    }
}

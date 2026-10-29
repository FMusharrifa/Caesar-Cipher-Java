/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ceasercipher;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *s
 * @author student
 */
public  class CeaserCipher extends javax.swing.JFrame implements ActionListener {
 private static JTextField inputText,shiftField;
 private static JTextArea outputText;
 private static JButton encryptBtn,decryptBtn,clearBtn;

    public CeaserCipher(){
        setTitle("Caesar Cipher Encryption/Decryption");
        setSize(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        JPanel inputPanel =new JPanel(new GridLayout(3,2,10,10));
        inputPanel.add(new JLabel("Enter Text:"));
        inputText =new JTextField();
        inputPanel.add(inputText);
        inputPanel.add(new JLabel("Key Value:"));
        shiftField =new JTextField();
        inputPanel.add(shiftField);
        add(inputPanel,BorderLayout.NORTH);
          
        JPanel buttonPanel=new JPanel();
        encryptBtn=new JButton("Encrypt");
        decryptBtn=new JButton("Decrypt");
        clearBtn=new JButton("Clear");
        encryptBtn.addActionListener(this);
        decryptBtn.addActionListener(this);
        clearBtn.addActionListener(this);
         buttonPanel.add(encryptBtn);
         buttonPanel.add(decryptBtn);
         buttonPanel.add(clearBtn);
         add(buttonPanel,BorderLayout.CENTER);
         outputText=new JTextArea();
         outputText.setEditable(false);
        outputText.setBorder(BorderFactory.createTitledBorder("Output"));
        add(new JScrollPane(outputText),BorderLayout.SOUTH);
        
    }   
    
    
    private String encrypt(String text,int key){
StringBuilder result=new StringBuilder();

key=key % 26;

for(char c:text.toCharArray()){
    if(Character.isUpperCase(c)){
        result.append((char)((c-'A'+key+26)%26+'a'));
    }else if (Character.isLowerCase(c)){
        result.append((char)((c-'a'+key+26)%26+'A'));
    }else{
        result.append(c);
    }
}
return result.toString();
}
    private String decrypt(String text,int shift){
        return encrypt(text,-shift);
    }
       

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String text=inputText.getText();
            int shift=Integer.parseInt(shiftField.getText());
             if(e.getSource()==encryptBtn){
                 outputText.setText("Encrypted Text:"+encrypt(text,shift));
             }else if(e.getSource()==decryptBtn){
                  outputText.setText("Decrypted Text:"+decrypt(text,shift));    
             }else if(e.getSource()==clearBtn){
                 inputText.setText("");
                 shiftField.setText("");
                 outputText.setText("");
             }
        }catch(NumberFormatException ex){
            JOptionPane.showMessageDialog(this,"Please enter a valid number for shift value" );
        } 
    }
    
public static void main(String[] args) {
        
        new CeaserCipher().setVisible(true);
    }
}

    


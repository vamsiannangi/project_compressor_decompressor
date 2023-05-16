package GUI;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import comp_decomp.compressor;
import comp_decomp.decompressor;

import java.awt.event.ActionListener;
import java.io.File;
import java.security.cert.Extension;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class AppFrame extends JFrame implements ActionListener{
    JButton compressButton;
    JButton decompressButton;
    String extension ;
    
    AppFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

  compressButton=new JButton("Select file to compress");
  compressButton.setBounds(20,20,200,150);
  this.setLayout(null);
  compressButton.setVisible(true);
  //compressButton.setSize(400,200);
  compressButton.addActionListener(this);

  decompressButton=new JButton("Select file to decompress");
  decompressButton.setBounds(250,20, 200,150);
 // decompressButton.setSize(400,200);
  decompressButton.addActionListener(this) ;
  this.add(compressButton);
  this.add(decompressButton);
  this.setSize(800,500);
  this.getContentPane().setBackground(Color.GRAY);
  this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
   if(e.getSource()==compressButton){
    JFileChooser filechooser=new JFileChooser();
    int response=filechooser.showSaveDialog(null);
    if(response==JFileChooser.APPROVE_OPTION){
        File file=new File(filechooser.getSelectedFile().toString());
        //.getAbsolutePath()
        String fileName = file.toString();

   int index = fileName.lastIndexOf('.');

    if(index > 0) {
      extension = fileName.substring(index + 1);
     // System.out.println("File extension is " + extension);
    
     System.out.print("compressed file"+file);
      try{
        compressor.method(file);
      }

      catch(Exception ee){
        JOptionPane.showMessageDialog(null,ee.toString());
      }
    }
    }
   }
   
   
   if(e.getSource()==decompressButton){
    JFileChooser filechooser=new JFileChooser();
    int response=filechooser.showSaveDialog(null);
    if(response==JFileChooser.APPROVE_OPTION){
        File file=new File(filechooser.getSelectedFile().getAbsolutePath());
        String fileName = file.toString();

    // int index = fileName.lastIndexOf('.');
    // if(index > 0) {
    //   String extension = fileName.substring(index + 1);
      //System.out.println("File extension is " + extension);
    
      System.out.print("decompressed file"+file);
      try{
        decompressor.method(file,extension);
      }
      catch(Exception ee){
        JOptionPane.showMessageDialog(null,ee.toString());
    }
    }
   }
   }
    }

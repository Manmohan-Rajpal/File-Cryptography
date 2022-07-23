import java.awt.FlowLayout;
import java.awt.Font;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
public class IMOCRO{

    public static void operate(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        try
        {
            String word=" Encrypted_file";
            boolean flag =false;
            Scanner sc2 = new Scanner(new FileInputStream(file));
            while(sc2.hasNextLine()) {
            String line = sc2.nextLine();
            if(line.indexOf(word)!=-1) {
                flag = true;
            }
        }
            if(flag==true){
                JOptionPane.showMessageDialog(null, "File is already encrypted");
            
            }
            else{
                FileInputStream fis=new FileInputStream(file);

            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            int count=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
                count=count+1;
            }
            FileInputStream in =new FileInputStream("need.txt");
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            int c;
            for(c=count;(c=in.read()) !=-1;c++)
            {
               fos.write(c);
            }
            fos.close();
            in.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
        }

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    public static void operate2(int key)
    {

        JFileChooser fileChooser=new JFileChooser();
        fileChooser.showOpenDialog(null);
        File file=fileChooser.getSelectedFile();
        try
        {
            String word=" Encrypted_file";
            boolean flag =false;
            Scanner sc2 = new Scanner(new FileInputStream(file));
            while(sc2.hasNextLine()) {
            String line = sc2.nextLine();
            if(line.indexOf(word)!=-1) {
                flag = true;
            }
        }
            if(flag==true){
            FileInputStream fis=new FileInputStream(file);
            byte []data=new byte[fis.available()];
            fis.read(data);
            int i=0;
            int count=0;
            for(byte b:data)
            {
                System.out.println(b);
                data[i]=(byte)(b^key);
                i++;
                count=count+1;
            }
            PrintWriter writer = new PrintWriter(file);
            for(int k=count;k<=13;k++)
            {
                writer.print(""); 
            }
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(data);
            fos.close();
            fis.close();
            JOptionPane.showMessageDialog(null, "Done");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "File is not encrypted");

        } 

        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        
        System.out.println("this is testing");

        JFrame f=new JFrame();
        f.setTitle("Image Operation");
        f.setSize(270,270);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Font font=new Font("Courier",Font.BOLD,10);
        Font f1=new Font("Courier",Font.BOLD,18);
        JLabel l1 =new JLabel("IMAGE CRYPTOGRAPHY");
        l1.setFont(f1);

        JLabel l2 =new JLabel("KEY FOR ENCRPTION");
        l2.setFont(font);
        JTextField T1=new JTextField(10);
        T1.setFont(font);

        JLabel l3 =new JLabel("KEY FOR DECRYPTION");
        l3.setFont(font);
        JTextField T2=new JTextField(10);
        T2.setFont(font);

        JButton b1=new JButton();
        b1.setText("ENCRYPTION");
        b1.setFont(font);

        JButton b2=new JButton();
        b2.setText("DECRYPTION");
        b2.setFont(font);

        b1.addActionListener(e->{
            System.out.println("button1 clicked");
            String text1=T1.getText();
            int temp1=Integer.parseInt(text1);
            operate(temp1);
        });

        b2.addActionListener(e->{
            System.out.println("button2 clicked");
            String text2=T2.getText();
            int temp2=Integer.parseInt(text2);
            operate2(temp2);
        });
        

        f.setLayout(new FlowLayout());
        f.add(l1);
        f.add(l2);
        f.add(T1);
        f.add(l3);
        f.add(T2);
        f.add(b1);
        f.add(b2);
        f.setVisible(true);

    }
}
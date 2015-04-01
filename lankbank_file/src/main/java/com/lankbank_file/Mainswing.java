package com.lankbank_file;

import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.Font;

/**
 * @author 50123
 * @version 1.0
 * @category 土銀整批續保檔轉受理檔
 */
public class Mainswing
{
    private JFrame frame;
    private JFileChooser fc=new JFileChooser();
    private File obj=null;
    private StringWriter sw=new StringWriter();
    private PrintWriter pw=new PrintWriter(sw);

    public static void main(String[] args)
    {
	EventQueue.invokeLater(new Runnable()
	{
	    public void run()
	    {
		try
		{
		    Mainswing window=new Mainswing();
		    window.frame.setVisible(true);
		}
		catch (Exception e)
		{
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the application.
     */
    public Mainswing()
    {
	initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize()
    {
	frame=new JFrame();
	frame.setTitle("轉出受理檔");
	frame.setBounds(100,100,306,124);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.getContentPane().setLayout(null);

	JLabel lblNewLabel=new JLabel("選擇檔案：");
	lblNewLabel.setFont(new Font("微軟正黑體",Font.PLAIN,16));
	lblNewLabel.setBounds(96,13,80,19);
	frame.getContentPane().add(lblNewLabel);

	JButton btnNewButton=new JButton("開啟");
	btnNewButton.setFont(new Font("微軟正黑體",Font.PLAIN,16));
	btnNewButton.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent arg0)
	    {
		fc.showOpenDialog(null);
		obj=fc.getSelectedFile();

	    }
	});
	btnNewButton.setBounds(189,8,101,29);
	frame.getContentPane().add(btnNewButton);

	JButton button=new JButton("轉出");
	button.setFont(new Font("微軟正黑體",Font.PLAIN,16));
	button.addActionListener(new ActionListener()
	{
	    public void actionPerformed(ActionEvent e)
	    {
		try
		{
		    if(obj!=null)
		    {
			new CreateData(new CreatePolicy().GetDatas(obj)).CreateOutData();
		    }
		    else
		    {
			JOptionPane.showMessageDialog(null,"未選擇檔案");
		    }

		}
		catch (IOException e1)
		{
		    e1.printStackTrace(pw);
		    JOptionPane.showMessageDialog(null,sw.toString());
		}
	    }
	});
	button.setBounds(189,48,101,29);
	frame.getContentPane().add(button);

	JLabel label=new JLabel("轉出自動續保受理檔：");
	label.setFont(new Font("微軟正黑體",Font.PLAIN,16));
	label.setBounds(14,45,173,19);
	frame.getContentPane().add(label);
	frame.setLocationRelativeTo(null);
	frame.setResizable(false);
    }
}

import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.util.*;
import java.util.Random;

class Apps extends JFrame implements ActionListener{
	JLabel lab1,lab2;
	ImageIcon []icon;
	JButton []btn;
	TextArea txa1;
	int[]Answer;
	int swap1=0,swap2=0;
	int count=0;
	
	public Apps(){
		
		String id1 =JOptionPane.showInputDialog("請輸入玩家名稱");
		this.setTitle(id1);
		
		swap1=swap2=0;
		Answer=new int[11];
		icon=new ImageIcon[12];
		
		Font fnt = new Font("serif",Font.BOLD,15);
		
		for(int i=0;i<=10;i++){
			icon[i]=new ImageIcon("ccard"+i+".jpg");
		}
		icon[11]=new ImageIcon("true.jpg");
		
		
		Answer[1]=1;Answer[2]=2;Answer[3]=2;Answer[4]=1;Answer[5]=3;
		Answer[6]=3;Answer[7]=4;Answer[8]=4;Answer[9]=5;Answer[10]=5;
		
		btn=new JButton[11];
		
		for(int i=1;i<=10;i=i+1){
			btn[i]=new JButton(icon[0]);
			this.add(btn[i]);
			btn[i].addActionListener(this);
		}
		btn[1].setBounds(10+10,10+60,100,150);
		btn[2].setBounds(10+120+10,10+60,100,150);
		btn[3].setBounds(10+120*2+10,10+60,100,150);
		btn[4].setBounds(10+120*3+10,10+60,100,150);
		btn[5].setBounds(10+120*4+10,10+60,100,150);
		btn[6].setBounds(10+10,10+170+60,100,150);
		btn[7].setBounds(10+120*1+10,10+170+60,100,150);
		btn[8].setBounds(10+120*2+10,10+170+60,100,150);
		btn[9].setBounds(10+120*3+10,10+170+60,100,150);
		btn[10].setBounds(10+120*4+10,10+170+60,100,150);
		
		
		
		int j = (int) (Math.random() * 10) ;
		int k = (int) (Math.random() * 10) ;
		int z = (int) (Math.random() * 10) ;
		int p = (int) (Math.random() * 10) ;
		int y = (int) (Math.random() * 10) ;
		int x = (int) (Math.random() * 10) ;
		
		JButton tmp = btn[j]; 
        btn[j] = btn[k]; 
        btn[k] =btn[z];
        btn[z] =btn[p];
        btn[p] =btn[y];
        btn[y] =btn[x];
        btn[x] = tmp;
		
        /*label*/
        
		lab1=new JLabel("玩家名稱："+id1);
		lab1.setForeground(Color.darkGray);
		lab1.setBounds(30,20,200,20);
		lab1.setFont(new Font("宋体", Font.BOLD, 20));
		
		lab2=new JLabel(icon[11]);
		lab2.setBounds(0,0,650,450);
		/*txa*/
		
		txa1= new TextArea("目前共翻"+count+"次",6,10,TextArea.SCROLLBARS_NONE);
		txa1.setForeground(Color.darkGray);
		txa1.setBounds(380,20,200,30);
		txa1.setFont(new Font("宋体", Font.BOLD, 20));
		txa1.setEditable(false); 
		
		
		this.add(lab1);
		this.add(txa1);
		this.add(lab2);
	}
	
	public void actionPerformed(ActionEvent e){
		
		JButton btnx=(JButton)e.getSource();
		if(swap1!=0 && swap2!=0){
			 if(Answer[swap1]==Answer[swap2]){
				btn[swap1].setEnabled(false);
				btn[swap2].setEnabled(false);
				swap1=swap2=0;
				count+=1;
				txa1.setText("目前共翻"+count+"次");
			 }
			 else {
				 btn[swap1].setIcon(icon[0]);
				 btn[swap2].setIcon(icon[0]);
				 swap1=swap2=0;
				 count+=1;
				 txa1.setText("目前共翻"+count+"次");
			 }
		}
		
		for(int i=1;i<=10;i++){
			if(btnx==btn[i]){
				btn[i].setIcon(icon[i]);
				if(swap1==0)swap1=i;
				else swap2=i;
				count+=1;
				txa1.setText("目前共翻"+count+"次");
			}
		}
	}
}

class brand
{
	public static void main(String[]args)
	{
		Apps frm=new Apps();
		frm.setTitle("撲克牌遊戲");
		frm.setLayout(null);
		frm.setBounds(0,0,650,450);
		frm.setVisible(true);
		frm.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing(WindowEvent e)
				{
					System.exit(0);
				}
			}
		);	
	}
}
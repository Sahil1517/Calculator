import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
 

public class Calculator extends JFrame implements ActionListener {
	JPanel textPanel = new JPanel();
	Container c = getContentPane();
	JTextField t;
	JPanel buttonPanel = new JPanel();
	JButton b7, b8, b9, b4, b5, b6, b1, b2, b3, b0;
	JButton bBS, bCE, bClr, bPlus, bMinus, bMultiply, bDivide, bDot, bEquals;
	JButton bBlank, bSqrt, bPercent, bReci, bPosNeg;
	boolean error;

	boolean isDot = false;
	double acc1 = 0, acc2 = 0, acc3 = 10;
	String oper = "";
	String tempNum,decimalUsed;

	//constructor
	public Calculator()
	{
		setTitle("Calculator");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		c.setLayout(new BorderLayout());

		textPanel.setLayout(new FlowLayout());
		t = new JTextField(14);
		t.setEditable(false);
		t.setFont(new Font("Tahoma", Font.BOLD, 18));
		textPanel.add(t);

		buttonPanel.setLayout(new FlowLayout());
		buttonPanel.setBackground(Color.cyan);

		bBlank = new JButton(" ");
		bBlank.addActionListener(this);
		bBlank.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bBlank);

		bBS = new JButton("BackSpace");
		bBS.addActionListener(this);
		bBS.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bBS);

		bCE = new JButton("CE");
		bCE.addActionListener(this);
		bCE.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bCE);

		bClr = new JButton("C");
		bClr.addActionListener(this);
		bClr.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bClr);

		b7 = new JButton(" 7 ");
		b7.addActionListener(this);
		b7.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b7);

		b8 = new JButton(" 8 ");
		b8.addActionListener(this);
		b8.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b8);

		b9 = new JButton(" 9 ");
		b9.addActionListener(this);
		b9.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b9);

		bPlus = new JButton("+");
		bPlus.addActionListener(this);
		bPlus.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bPlus);

		bSqrt = new JButton("Sqrt");
		bSqrt.addActionListener(this);
		bSqrt.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bSqrt);

		b4 = new JButton(" 4 ");
		b4.addActionListener(this);
		b4.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b4);

		b5 = new JButton(" 5 ");
		b5.addActionListener(this);
		b5.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b5);

		b6 = new JButton(" 6 ");
		b6.addActionListener(this);
		b6.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b6);

		bMinus = new JButton(" -");
		bMinus.addActionListener(this);
		bMinus.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bMinus);

		bPercent = new JButton("1/x ");
		bPercent.addActionListener(this);
		bPercent.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bPercent);

		b1 = new JButton(" 1 ");
		b1.addActionListener(this);
		b1.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b1);

		b2 = new JButton(" 2 ");
		b2.addActionListener(this);
		b2.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b2);

		b3 = new JButton(" 3 ");
		b3.addActionListener(this);
		b3.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b3);

		bMultiply = new JButton("*");
		bMultiply.addActionListener(this);
		bMultiply.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bMultiply);

		bReci = new JButton(" X^3 ");
		bReci.addActionListener(this);
		bReci.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bReci);

		b0 = new JButton(" 0 ");
		b0.addActionListener(this);
		b0.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(b0);

		bDot = new JButton(" . ");
		bDot.addActionListener(this);
		bDot.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bDot);

		bEquals = new JButton(" = ");
		bEquals.addActionListener(this);
		bEquals.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bEquals);

		bDivide = new JButton("/");
		bDivide.addActionListener(this);
		bDivide.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bDivide);

		bPosNeg = new JButton("+/- ");
		bPosNeg.addActionListener(this);
		bPosNeg.setFont(new Font("Tahoma", Font.BOLD, 16));
		buttonPanel.add(bPosNeg);

		c.add(textPanel, BorderLayout.NORTH);
		c.add(buttonPanel, BorderLayout.CENTER);

		setVisible(true);
		setSize(350, 300);
		show();
	}

	public static void main(String args[])
	{
		Calculator cal = new Calculator();
	}

	public void actionPerformed(ActionEvent e)
	{
		String s = e.getActionCommand().trim();


		if(s.equals("0"))
		{
			addNumber(0);
		}
		else if (s.equals("1"))
		{
			addNumber(1);
		}
		else if (s.equals("2"))
		{
			addNumber(2);
		}
		else if (s.equals("3"))
		{
			addNumber(3);
		}
		else if (s.equals("4"))
		{
			addNumber(4);
		}
		else if (s.equals("5"))
		{
			addNumber(5);
		}
		else if (s.equals("6"))
		{
			addNumber(6);
		}
		else if (s.equals("7"))
		{
			addNumber(7);
		}
		else if (s.equals("8"))
		{
			addNumber(8);
		}
		else if (s.equals("9"))
		{
			addNumber(9);
		}

		//dot click
		if(s.equals("."))
		{
			isDot = true;
		}

		// if operator is clicked

		if (s.equals("+"))
		{
			performAction("+");
		}
		else if (s.equals("-"))
		{
			performAction("-");
		}
		else if (s.equals("*"))
		{
			performAction("*");
		}
		else if (s.equals("/"))
		{
			performAction("/");
		}
		else if (s.equals("="))
		{
			performAction("=");
		}


		//if c is clicked; clear memory

		if(s.equals("C"))
		{
			clearMemory();
		}

		//clear
		if(s.equals("CE"))
		{
			CcMemory();
		}

		//for X^3
		if (s.equals("X^3"))
		{
		//	X3memory();
		}

		//backspace
		if(s.equals("BackSpace"))
		if(!error)	{
			if(t.getText().length() < 2)	{
				tempNum = "";
				t.setText("0");
			} else	{
				if((t.getText().charAt(t.getText().length() - 1) == '.' &&
				t.getText().charAt(t.getText().length() - 2) == '0') ||
				(t.getText().length() == 2 && t.getText().charAt(0) == '-'))	{
					tempNum = "";
					t.setText("0");
					isDot = false;
				}	else	{
					if(t.getText().charAt(t.getText().length() - 1) == '.')
					isDot = false;
					tempNum = t.getText().substring(0, t.getText().length() - 1);
					t.setText(tempNum);
				}
			}

		}
	}


	public void addNumber(int _num)
	{
		if (isDot)
		{
			acc1 = acc1 + _num/acc3;
			acc3 = acc3 * 10;
		}
		else
		{
			acc1 = acc1 * 10 + _num;
		}
		t.setText(Double.toString(acc1));
	}

	public void performAction(String currentOper)
	{
		if (oper.equals("+"))
		{
			acc2 = acc2 + acc1;
			acc1 = 0;
		}
		else if (oper.equals("-"))
		{
			acc2 = acc2 - acc1;
			acc1 = 0;
		}
		else if (oper.equals("*"))
		{
			acc2 = acc2 * acc1;
			acc1 = 0;
		}
		else if (oper.equals("/"))
		{
			acc2 = acc2 / acc1;
			acc1 = 0;
			t.setText(""+acc2);
		}
		/*else if (oper.equals("="))
		{
			acc2 = acc1;
			acc1 = 0;
		}*/
		else
		{
			acc2 = acc1;
			acc1 = 0;
		}

		oper = currentOper;
		t.setText(Double.toString(acc2));
		isDot = false;
		acc3 = 10;
	}

	public void clearMemory()
	{
	acc2 = 0;
	acc3 = 0;
	acc1 = 0;
	oper = "";
	t.setText("0");
	//t.setTotal("0");
	}

	public void CcMemory()
	{
		t.setText("0");
		//acc2 = 0;
		acc1 = 0;
	}

	public void X3memory()
	{
	//	acc1 = Math.pow(acc1, 6);
		//oper = currentOper1;
	//	t.setText(Double.toString(acc1));
	//	isDot = false;
	//	acc3 = 10;
	}
}
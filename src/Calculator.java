import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Calculator implements ActionListener{
	
	boolean isDotClicked = false;
	boolean isBracketClicked = false;
	boolean isEqualClicked = false;
	double result;
	String inputValue,temp;
	char last;
	JFrame jf;
	JLabel displayLabel;
	JButton delButton,leftBracket,rightBracket,eightButton,sevenButton,clearButton,divButton,mulButton,minusButton,plusButton,equalButton,dotButton,zeroButton,oneButton,twoButton,threeButton,fourButton,fiveButton,sixButton,nineButton;
	
	public Calculator() {
		jf = new JFrame("Calculator");
		jf.setLayout(null);
		jf.setSize(600,600);
		jf.setLocation(350,80);
		
		displayLabel=new JLabel();	
		displayLabel.setBounds(30, 50, 540, 40);
		displayLabel.setBackground(Color.gray);
		displayLabel.setOpaque(true);
		displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		displayLabel.setForeground(Color.white);
		jf.add(displayLabel);
		
		sevenButton=new JButton("7");
		sevenButton.setBounds(30,130,80,80);
		sevenButton.setFont(new Font("Arial", Font.PLAIN, 30));
		sevenButton.addActionListener(this);
		jf.add(sevenButton);
		
		eightButton=new JButton("8");
		eightButton.setBounds(130,130,80,80);
		eightButton.setFont(new Font("Arial", Font.PLAIN, 30));
		eightButton.addActionListener(this);
		jf.add(eightButton);
		
		nineButton=new JButton("9");
		nineButton.setBounds(230,130,80,80);
		nineButton.setFont(new Font("Arial", Font.PLAIN, 30));
		nineButton.addActionListener(this);
		jf.add(nineButton);
		
		fourButton=new JButton("4");
		fourButton.setBounds(30,230,80,80);
		fourButton.setFont(new Font("Arial", Font.PLAIN, 30));
		fourButton.addActionListener(this);
		jf.add(fourButton);
		
		fiveButton=new JButton("5");
		fiveButton.setBounds(130,230,80,80);
		fiveButton.setFont(new Font("Arial", Font.PLAIN, 30));
		fiveButton.addActionListener(this);
		jf.add(fiveButton);
		
		sixButton=new JButton("6");
		sixButton.setBounds(230,230,80,80);
		sixButton.setFont(new Font("Arial", Font.PLAIN, 30));
		sixButton.addActionListener(this);
		jf.add(sixButton);
		
		oneButton=new JButton("1");
		oneButton.setBounds(30,330,80,80);
		oneButton.setFont(new Font("Arial", Font.PLAIN, 30));
		oneButton.addActionListener(this);
		jf.add(oneButton);
		
		twoButton=new JButton("2");
		twoButton.setBounds(130,330,80,80);
		twoButton.setFont(new Font("Arial", Font.PLAIN, 30));
		twoButton.addActionListener(this);
		jf.add(twoButton);
		
		threeButton=new JButton("3");
		threeButton.setBounds(230,330,80,80);
		threeButton.setFont(new Font("Arial", Font.PLAIN, 30));
		threeButton.addActionListener(this);
		jf.add(threeButton);
		
		dotButton=new JButton(".");
		dotButton.setBounds(30,430,80,80);
		dotButton.setFont(new Font("Arial", Font.PLAIN, 30));
		dotButton.addActionListener(this);
		jf.add(dotButton);
		
		zeroButton=new JButton("0");
		zeroButton.setBounds(130,430,80,80);
		zeroButton.setFont(new Font("Arial", Font.PLAIN, 30));
		zeroButton.addActionListener(this);
		jf.add(zeroButton);
		
		equalButton=new JButton("=");
		equalButton.setBounds(230,430,80,80);
		equalButton.setFont(new Font("Arial", Font.PLAIN, 30));
		equalButton.addActionListener(this);
		jf.add(equalButton);
		
		divButton=new JButton("/");
		divButton.setBounds(330,130,80,80);
		divButton.setFont(new Font("Arial", Font.PLAIN, 30));
		divButton.addActionListener(this);
		jf.add(divButton);
		
		mulButton=new JButton("*");
		mulButton.setBounds(330,230,80,80);
		mulButton.setFont(new Font("Arial", Font.PLAIN, 30));
		mulButton.addActionListener(this);
		jf.add(mulButton);
		
		minusButton=new JButton("-");
		minusButton.setBounds(330,330,80,80);
		minusButton.setFont(new Font("Arial", Font.PLAIN, 30));
		minusButton.addActionListener(this);
		jf.add(minusButton);	
		
		clearButton=new JButton("Clear");
	    clearButton.setBounds(430,430,130,80);
	    clearButton.setFont(new Font("Arial", Font.PLAIN, 30));
	    clearButton.addActionListener(this);
		jf.add(clearButton);
		
		delButton=new JButton("Delete");
		delButton.setBounds(430,130,130,80);
		delButton.setFont(new Font("Arial", Font.PLAIN, 30));
		delButton.addActionListener(this);
		jf.add(delButton);
		
		plusButton=new JButton("+");
		plusButton.setBounds(330,430,80,80);
		plusButton.setFont(new Font("Arial", Font.PLAIN, 30));
		plusButton.addActionListener(this);
		jf.add(plusButton);
		
		leftBracket =new JButton("(");
		leftBracket.setBounds(430,330,80,80);
		leftBracket.setFont(new Font("Arial", Font.PLAIN, 30));
		leftBracket.addActionListener(this);
		jf.add(leftBracket);
		
		rightBracket=new JButton(")");
		rightBracket.setBounds(430,230,80,80);
		rightBracket.setFont(new Font("Arial", Font.PLAIN, 30));
		rightBracket.addActionListener(this);
		jf.add(rightBracket);
		
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		last = EvaluateString.endOfString(displayLabel.getText());
		
		if(e.getSource() == sevenButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"7");
			}
		}else if(e.getSource() == eightButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"8");
			}
		}else if(e.getSource() == nineButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"9");
			}
		}else if(e.getSource() == zeroButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"0");
			}
		}else if(e.getSource() == oneButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"1");
			}
		}else if(e.getSource() == twoButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"2");
			}
		}else if(e.getSource() == threeButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"3");
			}
		}else if(e.getSource() == fourButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"4");
			}
		}else if(e.getSource() == fiveButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"5");
			}
		}else if(e.getSource() == sixButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"6");
			}
		}else if(e.getSource() == nineButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				displayLabel.setText(displayLabel.getText()+"9");
			}
		}else if(e.getSource() == clearButton) {
			displayLabel.setText("");
			isDotClicked = false;
			isEqualClicked = false;
		}else if(e.getSource() == mulButton) {
			if(last != '+' && last != '-' && last != '*' && last != '(' && last != '/' && last != '\0' && !isEqualClicked) {
				isDotClicked = false;
				displayLabel.setText(displayLabel.getText()+"*");
			}
		}else if(e.getSource() == divButton) {
			if(last != '+' && last != '-' && last != '*' && last != '(' && last != '/' && last != '\0' && !isEqualClicked) {
				isDotClicked = false;
				displayLabel.setText(displayLabel.getText()+"/");
			}
		}else if(e.getSource() == plusButton) {
			if(last != '+' && last != '-' && last != '*' && last != '(' && last != '/' && last != '\0' && !isEqualClicked) {
				isDotClicked = false;
				displayLabel.setText(displayLabel.getText()+"+");
			}
		}else if(e.getSource() == minusButton) {
			if(last != '+' && last != '-' && last != '*' && last != '(' && last != '/' && last != '\0' && !isEqualClicked) {
				isDotClicked = false;
				displayLabel.setText(displayLabel.getText()+"-");
			}
		}else if(e.getSource() == equalButton) {
			if(last != '+' && last != '-' && last != '*' && last != '(' && last != '/' && last != '\0') {
				isDotClicked = false;
				isEqualClicked = true;
				if(EvaluateString.areBracketsBalanced(displayLabel.getText())) {
					result = EvaluateString.evaluate(displayLabel.getText());
					displayLabel.setText(String.valueOf(result));
				}else {
					displayLabel.setText("Bad Expression");
				}
			}
			
		}else if(e.getSource() == dotButton) {
			if(isEqualClicked) {
				displayLabel.setText("");
				isEqualClicked = false;
			}
			if(last != ')') {
				if(!isDotClicked) {
					isDotClicked = true;
					displayLabel.setText(displayLabel.getText()+".");
				}
			}
			
		}else if(e.getSource() == leftBracket) {
			if(last == '+' || last == '-' || last == '*' || last == '(' || last == '/' || last == '\0') {
				displayLabel.setText(displayLabel.getText()+"(");
			}
			
		}else if(e.getSource() == rightBracket) {
			if(last != '+' && last != '-' && last != '*' && last != '(' && last!='/' && last != '\0') {
				displayLabel.setText(displayLabel.getText()+")");
			}
		}else if(e.getSource() == delButton) {
			if(last != '\0' && !isEqualClicked) {
				temp = displayLabel.getText();
				displayLabel.setText(temp.substring(0, temp.length()-1));
			}else if(isEqualClicked) {
				displayLabel.setText("");
			}
		}
		
	}

}
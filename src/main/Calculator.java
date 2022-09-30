package main;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

enum appTheme
{
	initial,
	additional
}

enum buttonType
{
	regular,
	accent
}

enum buttonEvent
{
	backspaceClear,
	totalClear,
	typeNumber,
	floatNumber,
	plusMinus,
	divide,
	multiply,
	subtract,
	add,
	square,
	squareRoot,
	logarithm,
	reverse,
	calculate,
	changeTheme,
	openSpecialFrame,
	exit
}

enum memoryOperation
{
	save,
	load,
	sum,
	clear
}

public class Calculator
{
	private JFrame frame;
	private JTextField textField;
	appTheme currentTheme = appTheme.initial;
	double firstNumber;
	double secondNumber;
	double result;
	String operation;
	String answer;
	boolean resultPrinted = false;

	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					Calculator window = new Calculator();
					window.frame.setVisible(true);
				}
				catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	// Инициализируем фрейм приложения.
	public Calculator()
	{
		initialize();
	}
	
	// Метод, работающий с функциями памяти.
	private void memoryAction(memoryOperation operation)
	{
		switch (operation)
		{
			case save:
				break;
			case load:
				break;
			case sum:
				break;
			case clear:
				break;
		}
	}
	
	private void setButtonEvent(buttonEvent event, JButton button)
	{
		switch (event)
		{
			case backspaceClear:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String backspase = null;
						
						if(textField.getText().length() > 0)
						{
							StringBuilder strB = new StringBuilder(textField.getText());
							strB.deleteCharAt(textField.getText().length()-1);
							backspase = strB.toString();
							textField.setText(backspase);
						}
					}
				});
				break;
			case totalClear:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						textField.setText("0");
					}
				});
				break;
			case typeNumber:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if (resultPrinted)
						{
							textField.setText("");
							resultPrinted = false;
						}
						String chosenNumber = button.getText();
						String currentNumber = textField.getText();
						
						if (chosenNumber != "0")
							textField.setText(currentNumber + chosenNumber);
						else if (currentNumber != null && currentNumber != "0")
							textField.setText(currentNumber + chosenNumber);
					}
				});
				break;
			case floatNumber:
				button.addActionListener(new ActionListener() 
				{
					public void actionPerformed(ActionEvent e)
					{
						String EnterNumber = textField.getText() + button.getText();
						textField.setText(EnterNumber);
					}
				});
				break;
			case plusMinus:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double ops = Double.parseDouble(String.valueOf(textField.getText()));
						ops = ops * (-1);
						textField.setText(String.valueOf(ops));
					}
				});
			case square:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double xox = Double.parseDouble(String.valueOf(textField.getText()));
						xox = xox * xox;
						textField.setText(String.valueOf(xox));
					}
				});
			case squareRoot:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double xax = Double.parseDouble(String.valueOf(textField.getText()));
						xax = Math.sqrt(xax) ;
						textField.setText(String.valueOf(xax));
					}
				});
			case logarithm:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double xyx = Double.parseDouble(String.valueOf(textField.getText()));
						xyx = Math.log(xyx) / Math.log(2);
						textField.setText(String.valueOf(xyx));
					}
				});
			case reverse:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						double xox = Double.parseDouble(String.valueOf(textField.getText()));
						xox = 1/xox;
						textField.setText(String.valueOf(xox));
					}
				});
			case calculate:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String answer;
						secondNumber = Double.parseDouble(textField.getText());
						String format = "#.#";
						
						switch (operation)
						{
							case "+":
								result = firstNumber + secondNumber;
								break;
							case "-":
								result = firstNumber - secondNumber;
								break;
							case "*":
								result = firstNumber * secondNumber;
								break;
							case "/":
								result = firstNumber / secondNumber;
						}
						
						switch (operation)
						{
							case "+":
							case "-":
							case "*":
							case "/":
								answer = new java.text.DecimalFormat(format).format(result);
								textField.setText(answer);
								resultPrinted = true;
						}
					}
				});
				break;
			case changeTheme:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						appTheme newTheme;
						
						switch (currentTheme)
						{
							case additional:
								newTheme = appTheme.initial;
							default:
								newTheme = appTheme.additional;
								break;
						}
						currentTheme = newTheme;
						Component[] components = frame.getComponents();
						
						for (Component component : components)
						{
		                    if (component instanceof JButton)
		                    	setButtonAppearance(buttonType.regular, currentTheme, (JButton)component);
			            }
					}
				});
				break;
			case openSpecialFrame:
				break;
			case exit:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						frame.dispose();
						System.exit(0);
					}
				});
		}

		switch (event)
		{
			case divide:
			case multiply:
			case subtract:
			case add:
			case square:
			case squareRoot:
			case logarithm:
			case reverse:
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						firstNumber = Double.parseDouble(textField.getText());
						textField.setText("");
						operation = button.getText();
					}
				});
		}
	}
	
	private void setButtonAppearance(buttonType type, appTheme theme, JButton button)
	{
		Color colorButtonText = null;
		Color colorButtonRegular = null;
		Color colorButtonAccent = null;
		
		switch (theme)
		{
			case additional:
				break;
			default:
				colorButtonText = new Color(0, 0, 0);
				colorButtonRegular = new Color(255, 158, 78, 255);
				colorButtonAccent = new Color(255, 82, 82);
		}
		
		switch (type)
		{
			case regular:
				button.setBackground(colorButtonRegular);
				break;
			case accent:
				button.setBackground(colorButtonAccent);
		}
		button.setForeground(colorButtonText);
		button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(button);
	}
	
	// Метод инициализирующий содержание главного фрейма.
	private void initialize()
	{
		frame = new JFrame();
		frame.setTitle("ПВАС, ЛР №1, Константинов / Богомолов, ЭАС-312С");
		frame.setBounds(100, 100, 480, 640);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(14, 40, 437, 50);
		textField.setFont(new Font("Times New Roman", Font.BOLD, 18));
		frame.getContentPane().add(textField);
		JLabel mainLabel = new JLabel("Экран калькулятора");
		mainLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		mainLabel.setBounds(14, 11, 437, 29);
		frame.getContentPane().add(mainLabel);
		textField.setColumns(10);
		textField.setEditable(false);
		JButton buttonBackspace = new JButton("Удалить цифру");
		buttonBackspace.setBounds(14, 101, 225, 50);
		setButtonEvent(buttonEvent.backspaceClear, buttonBackspace);
		setButtonAppearance(buttonType.accent, appTheme.initial, buttonBackspace);
		JButton buttonClear = new JButton("Очистить");
		buttonClear.setBounds(249, 101, 202, 50);
		setButtonEvent(buttonEvent.totalClear, buttonClear);
		setButtonAppearance(buttonType.accent, appTheme.initial, buttonClear);
		JButton button1 = new JButton("1");
		button1.setBounds(14, 289, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button1);
		setButtonAppearance(buttonType.regular, appTheme.initial, button1);
		JButton button2 = new JButton("2");
		button2.setBounds(74, 289, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button2);
		setButtonAppearance(buttonType.regular, appTheme.initial, button2);
		frame.getContentPane().add(button2);
		JButton button3 = new JButton("3");
		button3.setBounds(134, 289, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button3);
		setButtonAppearance(buttonType.regular, appTheme.initial, button3);
		JButton button4 = new JButton("4");
		button4.setBounds(14, 226, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button4);
		setButtonAppearance(buttonType.regular, appTheme.initial, button4);
		JButton button5 = new JButton("5");
		button5.setBounds(74, 226, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button5);
		setButtonAppearance(buttonType.regular, appTheme.initial, button5);
		JButton button6 = new JButton("6");
		button6.setBounds(134, 226, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button6);
		setButtonAppearance(buttonType.regular, appTheme.initial, button6);
		JButton button7 = new JButton("7");
		button7.setBounds(14, 162, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button7);
		setButtonAppearance(buttonType.regular, appTheme.initial, button7);
		JButton button8 = new JButton("8");
		button8.setBounds(74, 162, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button8);
		setButtonAppearance(buttonType.regular, appTheme.initial, button8);
		JButton button9 = new JButton("9");
		button9.setBounds(134, 162, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button9);
		setButtonAppearance(buttonType.regular, appTheme.initial, button9);
		JButton button0 = new JButton("0");
		button0.setBounds(14, 350, 50, 50);
		setButtonEvent(buttonEvent.typeNumber, button0);
		setButtonAppearance(buttonType.regular, appTheme.initial, button0);
		JButton buttonDivision = new JButton("/");
		buttonDivision.setBounds(314, 162, 50, 50);
		setButtonEvent(buttonEvent.divide, buttonDivision);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonDivision);
		JButton buttonMultiplication = new JButton("*");
		buttonMultiplication.setBounds(314, 228, 50, 50);
		setButtonEvent(buttonEvent.multiply, buttonMultiplication);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonMultiplication);
		JButton buttonMinus = new JButton("-");
		buttonMinus.setBounds(314, 289, 50, 50);
		setButtonEvent(buttonEvent.subtract, buttonMinus);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonMinus);
		JButton buttonPlus = new JButton("+");
		buttonPlus.setBounds(314, 350, 50, 50);
		setButtonEvent(buttonEvent.add, buttonPlus);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonPlus);
		JButton buttonCalculate = new JButton("=");
		buttonCalculate.setBounds(374, 162, 77, 238);
		setButtonEvent(buttonEvent.calculate, buttonCalculate);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonCalculate);
		JButton buttonFloat = new JButton(".");
		buttonFloat.setBounds(74, 350, 50, 50);
		setButtonEvent(buttonEvent.floatNumber, buttonFloat);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonFloat);
		JButton buttonPlusMinus = new JButton("±");
		buttonPlusMinus.setBounds(134, 350, 50, 50);
		setButtonEvent(buttonEvent.plusMinus, buttonPlusMinus);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonPlusMinus);
		JButton buttonSquare = new JButton("x²");
		buttonSquare.setBounds(194, 162, 110, 50);
		setButtonEvent(buttonEvent.square, buttonSquare);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonSquare);
		JButton buttonSquareRoot = new JButton("√x");
		buttonSquareRoot.setBounds(194, 226, 110, 50);
		setButtonEvent(buttonEvent.squareRoot, buttonSquareRoot);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonSquareRoot);
		JButton buttonLogarithm = new JButton("log2(x)");
		buttonLogarithm.setBounds(194, 289, 110, 50);
		setButtonEvent(buttonEvent.logarithm, buttonLogarithm);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonLogarithm);
		JButton buttonReverse = new JButton("1/x");
		buttonReverse.setBounds(194, 350, 110, 50);
		setButtonEvent(buttonEvent.reverse, buttonReverse);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonReverse);
		JButton changeTheme = new JButton("Сменить тему");
		changeTheme.setBounds(14, 411, 437, 50);
		setButtonEvent(buttonEvent.changeTheme, changeTheme);
		setButtonAppearance(buttonType.regular, appTheme.initial, changeTheme);
		JButton buttonSpecialFrame = new JButton("Специальный расчёт");
		buttonSpecialFrame.setBounds(14, 475, 437, 50);
		setButtonEvent(buttonEvent.openSpecialFrame, buttonSpecialFrame);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonSpecialFrame);
		JButton buttonExit = new JButton("Выход");
		buttonExit.setBounds(14, 540, 437, 50);
		setButtonEvent(buttonEvent.exit, buttonExit);
		setButtonAppearance(buttonType.regular, appTheme.initial, buttonExit);
	}
}

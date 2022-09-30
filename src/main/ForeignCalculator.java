package main;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Toolkit;

public class ForeignCalculator extends Thread {// класс всей программы

	private JFrame frame;// frame первого окна
	private JFrame frame1;// frame второго окна
	private JTextField textField;// текстовое поле
	public CheckboxGroup CbG;// группа переключателей режимов
	public Checkbox[] Cb;// массив переключателей отдельно

	double firstnum;// первая введенная цифра
	double secondnum;// вторая введенная цифра
	double result;// результат который заносится в текстфилд
	double mode;// режим
	double speed;// скорость получаемая из текстового поля
	int peredacha;// передача определяемая из скорости
	double output;// ответ на задачу
	String memory = "0";// память калькулятора
	String operations;// операция кот будет выполнятся
	String answer;// string формат для результата
	Double f;
	Double g;
	int max;
	int min = 999999999;
	String title = "Shakirov Sahiyarov";// название шапки

	public void run() { // запуск таймера для отключения через 5 сек
		try {
			Thread.sleep(5000);// ожидание 5 секунд
			System.exit(0);// закрытие программы
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForeignCalculator window = new ForeignCalculator();// вызов конструктора калькулятора
					window.frame.setVisible(true);// показание окна
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ForeignCalculator() {
		initialize();// инициализация окна
	}

	public void add(JButton btn) {// метод добавления цифры к текст филду (если в начале стоит 0 или ничего то
									// цифра становится в начало иначе она добавляется в конец)
		if ((textField.getText().charAt(0) == '0') || (textField.getText() == null)) {
			String EnterNumber = btn.getText();
			textField.setText(EnterNumber);
		} else {
			String EnterNumber = textField.getText() + btn.getText();
			textField.setText(EnterNumber);
		}
	}

	public void NaN(JButton btn) {// исключения слова NaN при вводе числа
		if ((textField.getText().equalsIgnoreCase("NaN")) || (textField.getText().equalsIgnoreCase("-Infinity"))
				|| (textField.getText().equalsIgnoreCase("Infinity")))
			textField.setText("0");
	}

	// public void check(double c) {
	// int i = 0;
	// f = ;
	// while (f >= 10) {
	// i += 1;
	// f = f / 10;
	// }
	// System.out.println(f);
	// double h = i * 10;
	// g = c % h;
	// System.out.println(g);
	// }

	public void initialize() {// все настройки и решения
		frame = new JFrame();// создание окна
		frame.setTitle(title);// добавление шапки
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrsax\\Downloads\\pngwing.com (1).png"));// иконка
																														// окна
		// frame.setBackground(new Color(128, 255, 0));// фон
		frame.getContentPane().setBackground(new Color(128, 255, 128));// фон
		frame.setBounds(100, 100, 357, 589);// расположение и размер окна
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// завершение программы после закрытия окна
		frame.getContentPane().setLayout(null);
		textField = new JTextField();// текстовое окна создание
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 20));// шрифт
		textField.setText("0");// текст
		textField.setBackground(new Color(255, 255, 255));// фон
		textField.setHorizontalAlignment(SwingConstants.RIGHT);// выравнивание
		textField.setBounds(0, 40, 343, 50);// положение и размер
		frame.getContentPane().add(textField);// добавление в фрейм
		// textField.setColumns(10);
		textField.setEditable(false);// неизменяемая текстовое поле

		JButton btn8 = new JButton("8");// кнопка 8
		btn8.setForeground(new Color(255, 255, 255));
		btn8.setBackground(new Color(1, 50, 32));
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn8);
				add(btn8);
			}
		});
		btn8.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn8.setBounds(85, 252, 86, 50);
		frame.getContentPane().add(btn8);

		JButton btn9 = new JButton("9");// кнопка 9
		btn9.setForeground(new Color(255, 255, 255));
		btn9.setBackground(new Color(1, 50, 32));
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn9);
				add(btn9);
			}
		});
		btn9.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn9.setBounds(171, 252, 86, 50);
		frame.getContentPane().add(btn9);

		JButton btn4 = new JButton("4");// кнопка 4
		btn4.setForeground(new Color(255, 255, 255));
		btn4.setBackground(new Color(1, 50, 32));
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn4);
				add(btn4);
			}
		});
		btn4.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn4.setBounds(0, 301, 86, 50);
		frame.getContentPane().add(btn4);

		JButton btn7 = new JButton("7");// кнопка 7
		btn7.setForeground(new Color(255, 255, 255));
		btn7.setBackground(new Color(1, 50, 32));
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn7);
				add(btn7);
			}
		});
		btn7.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn7.setBounds(0, 252, 86, 50);
		frame.getContentPane().add(btn7);

		JButton btn5 = new JButton("5");// кнопка 5
		btn5.setForeground(new Color(255, 255, 255));
		btn5.setBackground(new Color(1, 50, 32));
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn5);
				add(btn5);
			}
		});
		btn5.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn5.setBounds(85, 301, 86, 50);
		frame.getContentPane().add(btn5);

		JButton btn6 = new JButton("6");// кнопка 6
		btn6.setForeground(new Color(255, 255, 255));
		btn6.setBackground(new Color(1, 50, 32));
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn6);
				add(btn6);
			}
		});
		btn6.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn6.setBounds(171, 301, 86, 50);
		frame.getContentPane().add(btn6);

		JButton btn1 = new JButton("1");// кнопка 1
		btn1.setForeground(new Color(255, 255, 255));
		btn1.setBackground(new Color(1, 50, 32));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn1);
				add(btn1);
			}
		});
		btn1.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn1.setBounds(0, 350, 86, 50);
		frame.getContentPane().add(btn1);

		JButton btn2 = new JButton("2");// кнопка 2
		btn2.setForeground(new Color(255, 255, 255));
		btn2.setBackground(new Color(1, 50, 32));
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn2);
				add(btn2);
			}
		});
		btn2.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn2.setBounds(85, 350, 86, 50);
		frame.getContentPane().add(btn2);

		JButton btn3 = new JButton("3");// кнопка 3
		btn3.setForeground(new Color(255, 255, 255));
		btn3.setBackground(new Color(1, 50, 32));
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NaN(btn3);
				add(btn3);
			}
		});
		btn3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btn3.setBounds(171, 350, 86, 50);
		frame.getContentPane().add(btn3);

		JButton btnPlus = new JButton("+");// кнопка +
		btnPlus.setForeground(new Color(255, 255, 255));
		btnPlus.setBackground(new Color(1, 50, 32));
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());// получение числа из текстового поля
				textField.setText("0");// замена числа на ноль
				operations = "+";
			}
		});
		btnPlus.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnPlus.setBounds(257, 400, 86, 50);
		frame.getContentPane().add(btnPlus);

		JButton btnNewMinus = new JButton("-");
		btnNewMinus.setForeground(new Color(255, 255, 255));
		btnNewMinus.setBackground(new Color(1, 50, 32));
		btnNewMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("0");
				operations = "-";
			}
		});
		btnNewMinus.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewMinus.setBounds(257, 350, 86, 50);
		frame.getContentPane().add(btnNewMinus);

		JButton btnNewdelen = new JButton("/");
		btnNewdelen.setForeground(new Color(255, 255, 255));
		btnNewdelen.setBackground(new Color(1, 50, 32));
		btnNewdelen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("0");
				operations = "/";
			}
		});
		btnNewdelen.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewdelen.setBounds(257, 301, 86, 50);
		frame.getContentPane().add(btnNewdelen);

		JButton btnymno = new JButton("*");
		btnymno.setForeground(new Color(255, 255, 255));
		btnymno.setFont(new Font("Times New Roman", Font.PLAIN, 23));
		btnymno.setBackground(new Color(1, 50, 32));
		btnymno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				firstnum = Double.parseDouble(textField.getText());
				textField.setText("0");
				operations = "*";
			}
		});
		btnymno.setBounds(257, 252, 86, 50);
		frame.getContentPane().add(btnymno);

		JButton btnravno = new JButton("=");
		btnravno.setForeground(new Color(255, 255, 255));
		btnravno.setBackground(new Color(0, 128, 0));
		btnravno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				secondnum = Double.parseDouble(textField.getText());

				if (operations == "+") {
					result = firstnum + secondnum;
					// check(result);
					if ((result > 999999999) || (result < -999999999))
						answer = String.format("%.6e", result);
					else
						answer = String.format("%.10f", result);
					answer = answer.replaceAll(",", ".");// замена запятой точкой
					textField.setText(answer);
				} else if (operations == "-") {
					result = firstnum - secondnum;
					if ((result > 999999999) || (result < -999999999))
						answer = String.format("%.6e", result);
					else
						answer = String.format("%.10f", result);
					answer = answer.replaceAll(",", ".");
					textField.setText(answer);
				} else if (operations == "*") {
					result = firstnum * secondnum;
					if ((result > 999999999) || (result < -999999999))
						answer = String.format("%.6e", result);
					else
						answer = String.format("%.10f", result);
					answer = answer.replaceAll(",", ".");
					textField.setText(answer);
				} else if (operations == "/") {
					result = firstnum / secondnum;
					if ((result > 999999999) || (result < -999999999))
						answer = String.format("%.6e", result);
					else
						answer = String.format("%.10f", result);
					answer = answer.replaceAll(",", ".");
					textField.setText(answer);
				}
			}
		});
		btnravno.setFont(new Font("Times New Roman", Font.BOLD, 30));
		btnravno.setBounds(257, 451, 86, 50);
		frame.getContentPane().add(btnravno);
		JButton btnNewButton = new JButton("Удалить 1 цифру");
		btnNewButton.setBackground(new Color(255, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String backspase = null;
				Double value = Double.parseDouble(textField.getText());
				if ((value >= 10) || (value <= -10)) {
					StringBuilder strB = new StringBuilder(textField.getText());
					strB.deleteCharAt(textField.getText().length() - 1);
					backspase = strB.toString();
					textField.setText(backspase);
				}
				if ((value < 10) && (value > -10)) {
					textField.setText("0");
				}
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnNewButton.setBounds(173, 100, 170, 50);
		frame.getContentPane().add(btnNewButton);

		JButton btnC = new JButton("Очистить");
		btnC.setActionCommand("Очистить");
		btnC.setForeground(new Color(0, 0, 0));
		btnC.setBackground(new Color(255, 128, 128));
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("0");
			}
		});
		btnC.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnC.setBounds(0, 100, 170, 50);
		frame.getContentPane().add(btnC);

		JButton btnNewButton_3 = new JButton("0");
		btnNewButton_3.setForeground(new Color(255, 255, 255));
		btnNewButton_3.setBackground(new Color(1, 50, 32));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((textField.getText().charAt(0) == '0') || (textField.getText() == null)) {
					String EnterNumber = btnNewButton_3.getText();
					textField.setText(EnterNumber);
				} else {
					String EnterNumber = textField.getText() + btnNewButton_3.getText();
					textField.setText(EnterNumber);
				}
			}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton_3.setBounds(85, 400, 86, 50);
		frame.getContentPane().add(btnNewButton_3);

		JButton btnNewButton_4 = new JButton(".");
		btnNewButton_4.setForeground(new Color(255, 255, 255));
		btnNewButton_4.setBackground(new Color(1, 50, 32));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < textField.getText().length(); i++)
					if (textField.getText().charAt(i) == '.') {
						return;
					}
				String EnterNumber = textField.getText() + btnNewButton_4.getText();
				textField.setText(EnterNumber);

			}
		});
		btnNewButton_4.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton_4.setBounds(171, 400, 86, 50);
		frame.getContentPane().add(btnNewButton_4);

		JButton btnNewButton_5 = new JButton("±");
		btnNewButton_5.setForeground(new Color(255, 255, 255));
		btnNewButton_5.setBackground(new Color(1, 50, 32));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double ops = Double.parseDouble(String.valueOf(textField.getText()));
				ops = ops * (-1);
				textField.setText(String.valueOf(ops));
			}
		});
		btnNewButton_5.setFont(new Font("Times New Roman", Font.BOLD, 23));
		btnNewButton_5.setBounds(0, 400, 86, 50);
		frame.getContentPane().add(btnNewButton_5);

		JButton btnNewButton_1 = new JButton("x²");
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(1, 50, 32));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double xox = Double.parseDouble(String.valueOf(textField.getText()));
				xox = xox * xox;
				if ((xox > 999999999) || (xox < -999999999))
					answer = String.format("%.6e", xox);
				else
					answer = String.format("%.10f", xox);
				answer = answer.replaceAll(",", ".");
				textField.setText(answer);
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_1.setBounds(85, 202, 86, 50);
		frame.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_6 = new JButton("√x");
		btnNewButton_6.setForeground(new Color(255, 255, 255));
		btnNewButton_6.setBackground(new Color(1, 50, 32));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double xax = Double.parseDouble(String.valueOf(textField.getText()));
				xax = Math.sqrt(xax);
				if ((xax > 999999999) || (xax < -999999999))
					answer = String.format("%.6e", xax);
				else
					answer = String.format("%.10f", xax);
				answer = answer.replaceAll(",", ".");
				textField.setText(answer);
			}
		});
		btnNewButton_6.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_6.setBounds(171, 202, 86, 50);
		frame.getContentPane().add(btnNewButton_6);

		JButton btnNewButton_7 = new JButton("log2(x)");
		btnNewButton_7.setForeground(new Color(255, 255, 255));
		btnNewButton_7.setBackground(new Color(1, 50, 32));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double xyx = Double.parseDouble(String.valueOf(textField.getText()));
				if (xyx == 0)
					textField.setText("NaN");
				else {
					xyx = Math.log(xyx) / Math.log(2);
					if ((xyx > 999999999) || (xyx < -999999999))
						answer = String.format("%.6e", xyx);
					else
						answer = String.format("%.10f", xyx);
					answer = answer.replaceAll(",", ".");
					textField.setText(answer);
				}
			}
		});
		btnNewButton_7.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton_7.setBounds(257, 202, 86, 50);
		frame.getContentPane().add(btnNewButton_7);

		JButton btnNewButton_8 = new JButton("1/X");
		btnNewButton_8.setForeground(new Color(255, 255, 255));
		btnNewButton_8.setBackground(new Color(1, 50, 32));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double xox = Double.parseDouble(String.valueOf(textField.getText()));
				xox = 1 / xox;
				if ((xox > 999999999) || (xox < -999999999))
					answer = String.format("%.6e", xox);
				else
					answer = String.format("%.10f", xox);
				answer = answer.replaceAll(",", ".");
				textField.setText(answer);
			}
		});
		btnNewButton_8.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_8.setBounds(0, 202, 86, 50);
		frame.getContentPane().add(btnNewButton_8);

		JLabel lblNewLabel = new JLabel("         Экран калькулятора");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(36, 10, 254, 29);
		frame.getContentPane().add(lblNewLabel);

		JButton btnNewButton_9 = new JButton("Переход на спец. расчет по вар.");
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				initializetask();
			}
		});
		btnNewButton_9.setBackground(new Color(255, 128, 192));
		btnNewButton_9.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_9.setBounds(0, 451, 256, 50);
		frame.getContentPane().add(btnNewButton_9);

		JButton btnNewButton_11 = new JButton("MS");
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memory = textField.getText();
			}
		});
		btnNewButton_11.setForeground(Color.WHITE);
		btnNewButton_11.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_11.setBackground(new Color(1, 50, 32));
		btnNewButton_11.setBounds(0, 152, 86, 50);
		frame.getContentPane().add(btnNewButton_11);

		JButton btnNewButton_12 = new JButton("M+");
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double memory1 = Double.parseDouble(memory);
				result = memory1 + Double.parseDouble(textField.getText());
				textField.setText(String.valueOf(result));
			}
		});
		btnNewButton_12.setForeground(Color.WHITE);
		btnNewButton_12.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_12.setBackground(new Color(1, 50, 32));
		btnNewButton_12.setBounds(85, 152, 86, 50);
		frame.getContentPane().add(btnNewButton_12);

		JButton btnNewButton_13 = new JButton("MR");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(memory);
			}
		});
		btnNewButton_13.setForeground(Color.WHITE);
		btnNewButton_13.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_13.setBackground(new Color(1, 50, 32));
		btnNewButton_13.setBounds(171, 152, 86, 50);
		frame.getContentPane().add(btnNewButton_13);

		JButton btnNewButton_14 = new JButton("MC");
		btnNewButton_14.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				memory = "0";
			}
		});
		btnNewButton_14.setForeground(Color.WHITE);
		btnNewButton_14.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnNewButton_14.setBackground(new Color(1, 50, 32));
		btnNewButton_14.setBounds(257, 152, 86, 50);
		frame.getContentPane().add(btnNewButton_14);

		JButton btnNewButton_10 = new JButton("Кнопка замены цвета");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (frame.getContentPane().getBackground().equals(new Color(128, 255, 128))) {
					frame.getContentPane().setBackground(new Color(90, 90, 90));
				} else {
					frame.getContentPane().setBackground(new Color(128, 255, 128));
				}
			}
		});
		btnNewButton_10.setBackground(new Color(128, 128, 128));
		btnNewButton_10.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 13));
		btnNewButton_10.setBounds(0, 502, 171, 50);
		frame.getContentPane().add(btnNewButton_10);

		JButton btnNewButton_exit = new JButton("Выход");
		btnNewButton_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				start();
				for (int i = 0; i <= 15; i++) {
					int bukva = title.charAt(i);
					if (bukva >= max)
						max = bukva;
					if ((bukva <= min) && (bukva != 32))
						min = bukva;
				}
				double k = max - min;
				JOptionPane.showMessageDialog(null,
						"Разность самого большого и самого малого ASCII-кода: " + k + " Решение: " + max + "-" + min,
						null,
						JOptionPane.ERROR_MESSAGE);
			}
		});
		btnNewButton_exit.setForeground(new Color(255, 255, 255));
		btnNewButton_exit.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		btnNewButton_exit.setBackground(new Color(155, 0, 0));
		btnNewButton_exit.setBounds(172, 502, 171, 50);
		frame.getContentPane().add(btnNewButton_exit);
	}

	public void initializetask() {
		frame1 = new JFrame();
		frame1.setTitle("Сахияров Шакиров Задание по варианту");
		frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\mrsax\\Downloads\\pngwing.com (1).png"));
		frame1.setBackground(new Color(0, 0, 0));
		// frame1.getContentPane().setBackground(new Color(128, 255, 128));

		frame1.setName("Лабораторная");
		frame1.setBounds(444, 100, 820, 300);
		// frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.getContentPane().setLayout(null);
		frame1.setVisible(true);

		JLabel lblNewLabel = new JLabel(
				"<html>Расчет расхода топлива автомобиля в зависимо<br>сти от режима движения, среднего расхода топл<br>ива и средней скорости движения;)</html>");
		lblNewLabel.setBackground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel.setBounds(3, 3, 500, 65);
		frame1.getContentPane().add(lblNewLabel);

		JLabel lblNewLabel1 = new JLabel("Выберите режим движения:");
		lblNewLabel1.setBackground(new Color(255, 0, 0));
		lblNewLabel1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel1.setBounds(3, 80, 200, 20);
		frame1.getContentPane().add(lblNewLabel1);

		CbG = new CheckboxGroup();
		Cb = new Checkbox[3];
		Cb[0] = new Checkbox("Город", CbG, true);
		Cb[1] = new Checkbox("Вне города", CbG, false);
		Cb[2] = new Checkbox("Смешанный", CbG, false);
		Cb[0].setBounds(200, 80, 100, 20);
		Cb[1].setBounds(200, 110, 100, 20);
		Cb[2].setBounds(200, 140, 100, 20);
		for (int i = 0; i < 3; i++) {
			Cb[i].setFont(new Font("Times New Roman", Font.BOLD, 12));
			frame1.getContentPane().add(Cb[i]);
		}

		JLabel lblNewLabel2 = new JLabel("Введите среднюю скорость движения:");
		lblNewLabel2.setBackground(new Color(255, 0, 0));
		lblNewLabel2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel2.setBounds(3, 160, 250, 20);
		frame1.getContentPane().add(lblNewLabel2);

		JTextField TF = new JTextField();
		TF.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		TF.setText("");
		TF.setBackground(new Color(255, 255, 255));
		TF.setHorizontalAlignment(SwingConstants.RIGHT);
		TF.setBounds(260, 160, 100, 20);
		frame1.getContentPane().add(TF);
		TF.setColumns(10);

		JButton exe = new JButton("Найти средний расход топлива");
		exe.setForeground(new Color(0, 0, 0));
		exe.setBackground(new Color(255, 128, 128));
		exe.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		exe.setBounds(3, 200, 405, 50);
		exe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					speed = Double.parseDouble(TF.getText());
				} catch (NumberFormatException е) {
					TF.setText("");
					JOptionPane.showMessageDialog(null, "ВВЕДИ НОРМАЛЬНЫЕ ЧИСЛА ЧУРКА!!!!!!!!!!", null,
							JOptionPane.ERROR_MESSAGE);
				}
				frame1.setVisible(false);
				String name = CbG.getSelectedCheckbox().getLabel();
				;
				if ((speed <= 15) && (speed >= 1))
					peredacha = 1;
				else if ((speed > 15) && (speed <= 30))
					peredacha = 3;
				else if ((speed > 30) && (speed <= 60))
					peredacha = 6;
				else if ((speed > 60) && (speed <= 100))
					peredacha = 10;
				else if ((speed > 100) && (speed <= 140))
					peredacha = 15;
				else if ((speed > 140) && (speed <= 220))
					peredacha = 21;
				else if (speed > 220) {
					TF.setText("");
					JOptionPane.showMessageDialog(null, "НЕ ГАЗУЙ БРАТ, ТЫ ЕЩЕ МАТЕРИ НУЖЕН", null,
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				switch (name) {
					case ("Город"):
						mode = 1.3;
						break;
					case ("Вне города"):
						mode = 0.8;
						break;
					case ("Смешанный"):
						mode = 1.1;
						break;
				}
				output = (speed / peredacha) * mode;
				String output_finish = String.format("%.2f", output);
				output_finish = output_finish.replaceAll(",", ".");
				textField.setText(String.valueOf(output_finish));
			}
		});
		frame1.getContentPane().add(exe);

		JLabel LabelPic = new JLabel("");
		LabelPic.setBounds(415, 0, 400, 300);
		ImageIcon icon1 = new ImageIcon("C:\\Users\\mrsax\\Downloads\\123 (1).png");
		LabelPic.setIcon(icon1);
		frame1.getContentPane().add(LabelPic);

		JLabel LabelPalka = new JLabel("");
		LabelPalka.setBounds(430, 0, 100, 500);
		LabelPalka.setBackground(Color.BLACK);
		frame1.getContentPane().add(LabelPalka);

		// frame1.setIcon(icon1);

	}
}

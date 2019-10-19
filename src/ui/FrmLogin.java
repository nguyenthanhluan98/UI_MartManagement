package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class FrmLogin extends JFrame implements ActionListener {

	JCheckBox chkAdmin;
	JPasswordField pwfPass;
	JTextField txtUserName;
	JButton btnConfirm;

	public FrmLogin() {
		super("Đăng nhập");

		setSize(450, 350);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// ----------------------------------------------------------
		JPanel pNorth = new JPanel();
		pNorth.setBackground(new Color(255, 255, 255));

		JLabel lblTitle;
		pNorth.add(lblTitle = new JLabel("Login to App"));
		lblTitle.setFont(new Font("serif", Font.BOLD, 26));

		add(pNorth, BorderLayout.NORTH);

		// ----------------------------------------------------------
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(255, 255, 255));

		JSeparator sprHorizontal2;
		pCenter.add(sprHorizontal2 = new JSeparator());
		sprHorizontal2.setPreferredSize(new Dimension(450, 1));

		sprHorizontal2.setOpaque(true);
		sprHorizontal2.setBackground(Color.GRAY);

		JLabel lblUsername, lblPassword;

		Box b = Box.createVerticalBox();
		b.add(Box.createVerticalStrut(50));
		Box b1, b2, b3;

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(20));
		b1.add(lblUsername = new JLabel("Tên đăng nhập"));
		b1.add(Box.createHorizontalStrut(20));
		b1.add(txtUserName = new JTextField());

		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(40));
		b2.add(lblPassword = new JLabel("Mật khẩu"));
		b2.add(Box.createHorizontalStrut(20));
		b2.add(pwfPass = new JPasswordField());

		b.add(b3 = Box.createHorizontalBox());
		b3.add(chkAdmin = new JCheckBox());
		b3.add(Box.createHorizontalStrut(5));
		b3.add(new JLabel("Quản lý"));
		b3.add(Box.createHorizontalStrut(100));
		b3.add(btnConfirm = new JButton("Đăng nhập"));

		btnConfirm.setFocusPainted(false);
		// btnConfirm.setBorder(new RoundedBorder(5));

		lblPassword.setPreferredSize(lblUsername.getPreferredSize());

		pCenter.add(b);
		add(pCenter, BorderLayout.CENTER);

		btnConfirm.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(btnConfirm)) {
			LoginAction();
		}
	}

	private void LoginAction() {
		String userName = txtUserName.getText();
		String passWord = new String(pwfPass.getPassword());

		System.out.println("password: " + passWord);

		// check login
		// if manager unlock all button
		// else lock some button

	}

}

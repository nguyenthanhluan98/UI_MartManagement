package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrmMain extends JFrame implements ActionListener {

	JFrame frmLogin;
	// frm Login
	JCheckBox chkAdmin;
	JPasswordField pwfPass;
	JTextField txtUserName;
	JButton btnConfirm;

	// frm Main
	JButton btnLogin, btnLogout, btnAccount, btnEmployeeAD, btnExit;
	JButton btnOrder, btnStock, btnOrderList, btnCustomer, btnStatistic, btnReceipt;

	public FrmMain() {
		super("Quản lý cửa hàng");
		setSize(900, 700);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		try {
			setIconImage(ImageIO.read(new File("resources/icon/shop.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// -------------------------------------------------------------------------
		JPanel pNorth = new JPanel();
		pNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
		pNorth.setBackground(new Color(255, 255, 255));

		Box bn = Box.createHorizontalBox();
		Box bn1, bn2;

		bn.add(bn1 = Box.createHorizontalBox());
		bn1.add(Box.createHorizontalStrut(10));
		bn1.add(btnLogin = new JButton("Đăng nhập"));
		btnLogin.setIcon(new ImageIcon("resources/icon/mainframe/menu_only/login_inactive.png"));
		bn1.add(Box.createHorizontalStrut(20));
		bn1.add(btnLogout = new JButton("Đăng xuất"));
		btnLogout.setIcon(new ImageIcon("resources/icon/mainframe/menu_only/logout_inactive.png"));
		bn1.add(Box.createHorizontalStrut(20));
		bn1.add(btnExit = new JButton("Thoát"));
		btnExit.setIcon(new ImageIcon("resources/icon/mainframe/menu_only/exit_inactive.png"));
		bn1.add(Box.createHorizontalStrut(10));

		bn1.setBorder(BorderFactory.createTitledBorder("Điều khiển"));

		bn.add(bn2 = Box.createHorizontalBox());
		bn2.add(Box.createHorizontalStrut(10));
		bn2.setBorder(BorderFactory.createTitledBorder("Phòng nhân sự"));
		bn2.add(btnAccount = new JButton("Tài khoản"));
		btnAccount.setIcon(new ImageIcon("resources/icon/mainframe/admin_only/key_inactive.png"));
		bn2.add(Box.createHorizontalStrut(20));
		bn2.add(btnEmployeeAD = new JButton("Nhân viên"));
		btnEmployeeAD.setIcon(new ImageIcon("resources/icon/mainframe/admin_only/employee_inactive.png"));
		bn2.add(Box.createHorizontalStrut(10));

		pNorth.add(bn);
		add(pNorth, BorderLayout.NORTH);

		// -------------------------------------------------------------------------
		JPanel pCenter = new JPanel();
		pCenter.setBackground(new Color(255, 255, 255));

		Box b = Box.createVerticalBox();
		b.add(Box.createVerticalStrut(90));
		Box b1, b2;

		JSeparator sprHorizontal;

		pCenter.add(sprHorizontal = new JSeparator());
		sprHorizontal.setPreferredSize(new Dimension(900, 1));

		sprHorizontal.setOpaque(true);
		sprHorizontal.setBackground(Color.GRAY);

		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(80));
		b1.add(btnOrder = new JButton("Quản lý bán hàng"));
		btnOrder.setIcon(new ImageIcon("resources/icon/mainframe/money_inactive.png"));
		b1.add(Box.createHorizontalStrut(150));
		b1.add(btnReceipt = new JButton("Hóa đơn"));
		btnReceipt.setIcon(new ImageIcon("resources/icon/mainframe/bill_inactive.png"));

		b.add(b2 = Box.createHorizontalBox());
		b2.add(btnStock = new JButton("Kho hàng"));
		btnStock.setIcon(new ImageIcon("resources/icon/mainframe/stock_inactive.png"));

		b2.add(Box.createHorizontalStrut(150));
		b2.add(btnStatistic = new JButton("Thống kê"));
		btnStatistic.setIcon(new ImageIcon("resources/icon/mainframe/chart_inactive.png"));

		pCenter.add(b);
		add(pCenter, BorderLayout.CENTER);

		// -------------------------------------------------------------------------
		setButton(btnLogin);
		setButton(btnLogout);
		setButton(btnAccount);
		setButton(btnEmployeeAD);
		setButton(btnOrder);

		setButton(btnStock);
		setButton(btnReceipt);
		setButton(btnStatistic);
		setButton(btnExit);

		btnLogin.addActionListener(this);
		btnAccount.addActionListener(this);
		btnExit.addActionListener(this);
		btnLogout.addActionListener(this);
		btnEmployeeAD.addActionListener(this);
		btnOrder.addActionListener(this);
		btnStock.addActionListener(this);
	}

	private void setButton(JButton jb) {
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
		jb.setBorderPainted(false);
		jb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jb.setVerticalTextPosition(SwingConstants.BOTTOM);
		jb.setHorizontalTextPosition(SwingConstants.CENTER);
	}

	public static void main(String[] args) {
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e) { // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		new FrmMain().setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();

		if (obj.equals(btnLogin)) {
			new FrmLogin().setVisible(true);
		} else if (obj.equals(btnAccount)) {
			new FrmAccount().setVisible(true);
		} else if (obj.equals(btnExit)) {
			System.out.println("asdasda");
			System.exit(0);
		} else if (obj.equals(btnLogout)) {
			lockButton();
		} else if (obj.equals(btnEmployeeAD)) {
			new FrmEmployee("temp").setVisible(true);

		} else if(obj.equals(btnOrder)) {
			new Gui_Employee().setVisible(true);
		} else if(obj.equals(btnStock)) {
			//new Gui_Employee().setVisible(true);

		} else if (obj.equals(btnOrder)) {
			new FrmOrder().setVisible(true);

		}
	}

	private void lockButton() {
		btnLogin.setEnabled(true);
		btnLogout.setContentAreaFilled(false);
		btnLogout.setEnabled(false);
		btnAccount.setEnabled(false);
		btnEmployeeAD.setEnabled(false);
		btnReceipt.setEnabled(false);
		btnStatistic.setEnabled(false);
		btnOrder.setEnabled(false);
		btnStock.setEnabled(false);
	}

	private void unlockButton() {
		btnLogin.setEnabled(false);
		btnLogout.setContentAreaFilled(true);
		btnLogout.setEnabled(true);
		btnAccount.setEnabled(true);
		btnEmployeeAD.setEnabled(true);
		btnReceipt.setEnabled(true);
		btnStatistic.setEnabled(true);
		btnOrder.setEnabled(true);
		btnStock.setEnabled(true);
	}
}

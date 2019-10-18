package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class FrmAccount extends JFrame {

	JTextField txtId, txtUserName, txtPass;
	JTextField txtSearch;
	JDateChooser txtStartingDate;
	JRadioButton radActive, radNoActive;
	ButtonGroup gStatus;

	JLabel lblId, lblUserName, lblPass, lblType, lblStartingDate, lblStatus, lblActive, lblNoActive;

	JButton btnAdd, btnRemove, btnModify, btnSave, btnSearch, btnIcon;

	JTable table;
	DefaultTableModel tableModel;

	JComboBox<String> cbbTypeOfAccount;
	DefaultComboBoxModel<String> comboBoxModel;

	public FrmAccount() {
		super("Quản lý tài khoản");
		setSize(950, 650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// --------------------------------------------------------------------------------------
		Box b = Box.createVerticalBox();
		b.add(Box.createVerticalStrut(10));

		Box bc, bc2;
		Box b1, b2, b3, b4, b5, b6, b7;

		b.add(bc = Box.createHorizontalBox());

		bc.setBorder(BorderFactory.createTitledBorder("Form nhập thông tin"));

		bc.add(Box.createHorizontalStrut(30));
		bc.add(btnIcon = new JButton("Tài khoản"));
		btnIcon.setIcon(new ImageIcon("resources/icon/mainframe/admin_only/key.png"));
		bc.add(Box.createHorizontalStrut(30));

		setButtonIcon(btnIcon);

		bc.add(bc2 = Box.createVerticalBox());

		bc2.add(b1 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b1.add(lblId = new JLabel("Mã tài khoản"));
		b1.add(txtId = new JTextField());

		bc2.add(b2 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b2.add(lblUserName = new JLabel("Tên đăng nhập"));
		b2.add(txtUserName = new JTextField());

		bc2.add(b3 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b3.add(lblPass = new JLabel("Mật khẩu"));
		b3.add(txtPass = new JTextField());

		bc2.add(b6 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b6.add(lblStartingDate = new JLabel("Ngày bắt đầu"));
		b6.add(txtStartingDate = new JDateChooser());

		bc2.add(b7 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));

		b7.add(lblStatus = new JLabel("Trạng thái"));
		b7.add(lblActive = new JLabel("Active"));
		b7.add(radActive = new JRadioButton());
		b7.add(Box.createHorizontalStrut(5));
		b7.add(lblNoActive = new JLabel("No Active"));
		b7.add(radNoActive = new JRadioButton());
		b7.add(Box.createHorizontalGlue());
		
		gStatus = new ButtonGroup();
		
		gStatus.add(radActive);
		gStatus.add(radNoActive);

		bc2.add(b4 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));

		String[] string = { "Nhân viên bán hàng", "Phòng nhân sự" };
		// comboBoxModel=new DefaultComboBoxModel<>(string);
		cbbTypeOfAccount = new JComboBox<String>(string);
		// comboBox.addItem(string);
		// comboBox.setSelectedIndex(1);
		b4.add(lblType = new JLabel("Loại tài khoản"));
		b4.add(cbbTypeOfAccount);

		b.add(b5 = Box.createHorizontalBox());

		String[] headers = "Mã tài khoản;Tên đăng nhập;Mật khẩu;Ngày bắt đầu; Trạng thái; Loại tài khoản".split(";");

		tableModel = new DefaultTableModel(headers, 0);

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b5.add(scroll);

		add(b, BorderLayout.CENTER);

		// --------------------------------------------------------------------------------------
		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		JPanel pLeft = new JPanel();

		pLeft.add(btnSearch = new JButton("Tìm"));
		pLeft.add(txtSearch = new JTextField(20));

		txtSearch.setForeground(Color.GRAY);
		txtSearch.setText("Nhập tên tài khoản cần tìm");

		txtSearch.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				if (txtSearch.getText().isEmpty()) {
					txtSearch.setForeground(Color.GRAY);
					txtSearch.setText("Nhập tên tài khoản cần tìm");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				if (txtSearch.getText().equals("Nhập tên tài khoản cần tìm")) {
					txtSearch.setText("");
					txtSearch.setForeground(Color.BLACK);
				}
			}
		});

		split.add(pLeft);

		JPanel pRight = new JPanel();

		pRight.add(btnAdd = new JButton("Thêm"));
		pRight.add(btnModify = new JButton("Sửa"));
		pRight.add(btnRemove = new JButton("Xóa"));
		pRight.add(btnSave = new JButton("Lưu"));

		split.add(pRight);

		add(split, BorderLayout.SOUTH);

		// --------------------------------------------------------------------------------------
		lblPass.setPreferredSize(lblUserName.getPreferredSize());
		lblId.setPreferredSize(lblUserName.getPreferredSize());
		lblType.setPreferredSize(lblUserName.getPreferredSize());
		lblStartingDate.setPreferredSize(lblUserName.getPreferredSize());
		lblStatus.setPreferredSize(lblUserName.getPreferredSize());

		// txtName.requestFocus();
		txtUserName.setMaximumSize(txtPass.getMaximumSize());

		btnSave.setEnabled(false);

		setButton(btnAdd);
		setButton(btnModify);
		setButton(btnRemove);
		setButton(btnSave);
		setButton(btnSearch);

		btnAdd.setIcon(new ImageIcon("resources/icon/add.png"));
		btnModify.setIcon(new ImageIcon("resources/icon/edit.png"));
		btnRemove.setIcon(new ImageIcon("resources/icon/remove.png"));
		btnSave.setIcon(new ImageIcon("resources/icon/save.png"));
		btnSearch.setIcon(new ImageIcon("resources/icon/search.png"));

		/*
		 * table.addMouseListener(this);
		 * 
		 * btnAdd.addActionListener(this); btnSave.addActionListener(this);
		 * btnRemove.addActionListener(this); btnModify.addActionListener(this);
		 * btnSearch.addActionListener(this);
		 */
	}

	private void setButton(JButton btn) {
		btn.setFocusPainted(false);
		btn.setHorizontalTextPosition(SwingConstants.RIGHT);
	}

	private void setButtonIcon(JButton jb) {
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
		jb.setBorderPainted(false);
		// jb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jb.setVerticalTextPosition(SwingConstants.BOTTOM);
		jb.setHorizontalTextPosition(SwingConstants.CENTER);
	}
}

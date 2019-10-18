package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

public class FrmEmployee extends JFrame implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JLabel lblTitle;
	JLabel lblId, lblFullName, lblAddress, lblDateOfBirth;
	JTextField txtId, txtFullName, txtAddress;
	JDateChooser txtDateOfBirth;
	JButton btnAdd, btnSave, btnEdit, btnDelete;

	JComboBox<String> cmbViTri;
	DefaultComboBoxModel<String> modelcmb;

	JLabel lblNam, lblNu;
	JRadioButton radNam, radNu;

	JLabel lblSearch;
	JTextField txtSearch;
	JButton btnSearch;

	JButton btnIcon;

	JTable tableEm;
	DefaultTableModel modelNv;

	public FrmEmployee(String typeOfAccount) {
		super("Quản lý nhân viên");
		setSize(950, 550);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		try {
			setIconImage(ImageIO.read(new File("resources/icon/mainframe/admin_only/employee_inactive.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		/* =*=*= icon NhanVien =*=*= */

		Box bNorth, bLeft, bRight;
		add(bNorth = Box.createHorizontalBox(), BorderLayout.NORTH);

		Box bIcon;

		bNorth.add(bIcon = Box.createHorizontalBox());

		bIcon.add(Box.createHorizontalStrut(30));
		bIcon.add(btnIcon = new JButton("Nhân viên"));
		btnIcon.setIcon(new ImageIcon("resources/icon/mainframe/admin_only/employee_inactive.png"));
		bIcon.add(Box.createHorizontalStrut(30));

		 setButton(btnIcon);

		/* =*=*= North textfields Nhân viên =*=*= */
		bNorth.setBorder(BorderFactory.createTitledBorder("Form Nhân viên"));
		bNorth.add(bLeft = Box.createVerticalBox());
		bNorth.add(Box.createHorizontalStrut(10));
		bNorth.add(bRight = Box.createVerticalBox());

		// ============= bLeft
		Box b1, b2, b3, b4, b5;

		bLeft.add(b1 = Box.createHorizontalBox());
		b1.add(lblId = new JLabel("Mã nhân viên: "));
		b1.add(Box.createHorizontalStrut(7));
		b1.add(txtId = new JTextField());
		b1.add(Box.createHorizontalStrut(100));

		bLeft.add(Box.createVerticalStrut(3));
		bLeft.add(b2 = Box.createHorizontalBox());
		b2.add(lblFullName = new JLabel("Họ tên: "));
		b2.add(Box.createHorizontalStrut(44));
		b2.add(txtFullName = new JTextField());

		bLeft.add(Box.createVerticalStrut(3));
		bLeft.add(b3 = Box.createHorizontalBox());
		b3.add(lblAddress = new JLabel("Địa chỉ: "));
		b3.add(Box.createHorizontalStrut(42));
		b3.add(txtAddress = new JTextField());

		bLeft.add(Box.createVerticalStrut(3));
		bLeft.add(b4 = Box.createHorizontalBox());
		b4.add(lblDateOfBirth = new JLabel("Ngày sinh: "));
		b4.add(Box.createHorizontalStrut(40));
		b4.add(txtDateOfBirth = new JDateChooser());

		
		/* =*=*= table center =*=*= */

		bNorth.add(Box.createVerticalStrut(10));

		Box bCenter = Box.createVerticalBox();
		Box boxTable;

		bCenter.add(boxTable = Box.createHorizontalBox());
		bCenter.add(Box.createVerticalStrut(10));

		// JScrollPane scroll;

		String[] headers = "Mã nhân viên; Họ tên; Ngày sinh; Địa chỉ".split(";");

		modelNv = new DefaultTableModel(headers, 0);

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tableEm = new JTable(modelNv));
		tableEm.setRowHeight(25);
		tableEm.setAutoCreateRowSorter(true);
		tableEm.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		tableEm.setRowHeight(25);
		scroll.setPreferredSize(new Dimension(0, 400));

		boxTable.add(scroll);

		add(scroll, BorderLayout.CENTER);

		/* =*=*= south split chức năng =*=*= */

		JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		add(split, BorderLayout.SOUTH);

		JPanel pLeft, pRight;

		split.add(pLeft = new JPanel());
		split.add(pRight = new JPanel());

		JLabel lblTim;

		pLeft.add(lblSearch = new JLabel("Nhập tên cần tìm:"));
		pLeft.add(txtSearch = new JTextField(5));
		pLeft.add(btnSearch = new JButton("Tìm"));
		btnSearch.setIcon(new ImageIcon("resources/icon/search.png"));

		// pLeft.setPreferredSize(new Dimension(0, 100));

		pRight.add(btnAdd = new JButton("Thêm"));
		btnAdd.setIcon(new ImageIcon("resources/icon/add.png"));

		pRight.add(btnSave = new JButton("Lưu"));
		btnSave.setIcon(new ImageIcon("resources/icon/save.png"));

		pRight.add(btnEdit = new JButton("Sửa"));
		btnEdit.setIcon(new ImageIcon("resources/icon/edit.png"));

		pRight.add(btnDelete = new JButton("Xóa"));
		btnDelete.setIcon(new ImageIcon("resources/icon/remove.png"));

		/* =*=*= add actionListener =*=*= */

		if (typeOfAccount.equalsIgnoreCase("BH")) {
			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnEdit.setEnabled(false);
			btnSave.setEnabled(false);
		}

		btnAdd.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDelete.addActionListener(this);
		btnSave.addActionListener(this);
		btnSearch.addActionListener(this);
	
		tableEm.addMouseListener(this);

		btnIcon.addMouseListener(this);
		btnSave.setEnabled(false);

	}

	public void setButton(JButton jb) {
		jb.setOpaque(false);
		jb.setContentAreaFilled(false);
		jb.setFocusPainted(false);
		jb.setBorderPainted(false);
		jb.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		jb.setVerticalTextPosition(SwingConstants.BOTTOM);
		jb.setHorizontalTextPosition(SwingConstants.CENTER);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
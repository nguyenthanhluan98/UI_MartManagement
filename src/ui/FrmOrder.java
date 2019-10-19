package ui;

import java.awt.BorderLayout;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

public class FrmOrder extends JFrame {

	JTextField txtId, txtUserName, txtPass;
	JTextField txtSearch, txtQuantity, txtPrice;
	
	JLabel lblSearch, lblName, lblQuantity, lblPrice;

	JComboBox<String> cbbName;

	JButton btnAdd, btnRemove, btnModify, btnSave, btnSearch, btnIcon;

	JTable table;
	DefaultTableModel tableModel;


	public FrmOrder() {
		super("Form order");
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
		bc.add(btnIcon = new JButton("Bán hàng"));
		btnIcon.setIcon(new ImageIcon("resources/icon/mainframe/bill_inactive.png"));
		bc.add(Box.createHorizontalStrut(30));

		setButtonIcon(btnIcon);

		bc.add(bc2 = Box.createVerticalBox());

		bc2.add(b1 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b1.add(lblSearch = new JLabel("Tên sản phẩm cần tìm"));
		b1.add(txtSearch = new JTextField());
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnSearch = new JButton("Tìm"));

		bc2.add(b2 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b2.add(lblName = new JLabel("Tên sản phẩm"));
		b2.add(cbbName = new JComboBox());

		bc2.add(b3 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b3.add(lblQuantity = new JLabel("Số lượng"));
		b3.add(txtQuantity = new JTextField());

		bc2.add(b6 = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));
		b6.add(lblPrice = new JLabel("Giá"));
		b6.add(txtPrice = new JTextField());

		Box bListButton;

		bc2.add(bListButton = Box.createHorizontalBox());
		bc2.add(Box.createVerticalStrut(10));

		bListButton.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bListButton.add(btnAdd = new JButton("Thêm"));
		bListButton.add(btnModify = new JButton("Sửa"));
		bListButton.add(btnRemove = new JButton("Xóa"));

		b.add(b5 = Box.createHorizontalBox());

		String[] headers = "Mã sản phẩm;Tên sản phẩm; Số lượng; Giá; Tiền".split(";");

		tableModel = new DefaultTableModel(headers, 0);

		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(table = new JTable(tableModel));
		table.setRowHeight(25);
		table.setAutoCreateRowSorter(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		b5.add(scroll);

		add(b, BorderLayout.CENTER);

		// ------------------------------------------------------------------
		lblName.setPreferredSize(lblSearch.getPreferredSize());
		lblQuantity.setPreferredSize(lblSearch.getPreferredSize());
		lblPrice.setPreferredSize(lblSearch.getPreferredSize());

		setButton(btnAdd);
		setButton(btnModify);
		setButton(btnRemove);

		btnAdd.setIcon(new ImageIcon("resources/icon/add.png"));
		btnModify.setIcon(new ImageIcon("resources/icon/edit.png"));
		btnRemove.setIcon(new ImageIcon("resources/icon/remove.png"));
		btnSearch.setIcon(new ImageIcon("resources/icon/search.png"));

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

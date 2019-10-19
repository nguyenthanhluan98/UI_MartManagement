package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * 
 * @author Doãn Trần Tuấn �?ạt - 16035741 Ngô Tuấn Kiệt - 16044771
 *
 */
public class Gui_Employee extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	///////////////

	///////////////
	private JPasswordField txtmkc, txtmkm, txtnlmkm;
	private JTabbedPane tbpqlcn;

	// Nhân viên
	private JLabel lblId, lblFullName, lblAddress, lblDateOfBirth;
	private JTextField txtId, txtFullName, txtAddress, txtDateOfBirth;

	private JLabel lblOldPass, lblConfirmPass, lblNewPass;
	private JTextField txtOldPass, txtConfirmPass, txtNewPass;

	private JButton btnChangePass, btnCancel;

	// Order

	JTextField txtSearch, txtQuantity, txtPrice;
	JLabel lblSearch, lblName, lblQuantity, lblPrice;
	JButton btnSearch;
	JComboBox<String> cbbName;
	JButton btnAdd, btnRemove, btnModify, btnSave, btnIcon, btnLogout;
	///////////////

	private JTabbedPane tbp;
	private JTable table;
	private DefaultTableModel tablemodel;
	/*
	 * private NhanVienNhanBenhDaos nhanVienNhanBenhDaos; private List<BenhNhan>
	 * dsbn; private List<NhanVien> dsnv;
	 */
	private JButton btnHelp;

	public Gui_Employee() {
		// this.nhanVien = nhanVien;
		// nhanVienNhanBenhDaos = new NhanVienNhanBenhDaos();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1100, 700);
		setResizable(true);
		setTitle("Nhân Viên Nhận Bệnh");
		setIconImage(new ImageIcon(getClass()
				.getResource("/ima/if_H_sign_hospital_hospital_sign_hospital__medical__road_sign_1887039.png"))
						.getImage());
		Box bt = Box.createVerticalBox();// Cái này là quản lý chung của cả frame
		/**
		 * Cái này là tiêu đ�?
		 */
		////////////////////////////////
		Box b1 = Box.createHorizontalBox();
		b1.setMaximumSize(getMaximumSize());
		b1.add(Box.createHorizontalStrut(20));
		b1.add(new JLabel(
				new ImageIcon(getClass().getResource("/ima/if_cv_job_seeker_employee_unemployee_work_2620524.png"))));
		b1.add(Box.createHorizontalStrut(10));
		// b1.add(lblTenDn = new JLabel(nhanVien.getHo() + " " + nhanVien.getTen()));
		// lblTenDn.setFont(new Font("Times new Roman", Font.BOLD, 20));
		// lblTenDn.setForeground(Color.RED);
		b1.add(Box.createHorizontalStrut(400));
		b1.add(btnLogout = new JButton("Đăng Xuất",
				new ImageIcon(getClass().getResource("/ima/if_Logout_105217.png"))));
		bt.add(Box.createVerticalStrut(10));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnHelp = new JButton("Trợ giúp",
				new ImageIcon(getClass().getResource("/ima/if_user_help_1902262.png"))));
		bt.add(b1);
		bt.add(Box.createVerticalStrut(10));
		/////////////////////////////////
		/**
		 * Cái này là quản lý bệnh nhân
		 */
		/////////////////////////////////
		Box bqlbn = Box.createVerticalBox(); // bqlbn là box chung quản lý toàn bộ quản lý bệnh nhân

		Box bqlbn1 = Box.createHorizontalBox(); // bqlbn1 là box để quản lý dòng trên cùng
		Box bqlbn1_ThongTin = Box.createVerticalBox();
		bqlbn1_ThongTin.setBorder(BorderFactory.createTitledBorder("Thông tin bệnh nhân"));

		Box bqlbn1_ThongTin_IdBN = Box.createHorizontalBox();
		bqlbn1_ThongTin_IdBN.add(new JLabel("Tên sản phẩm cần tìm: "));
		bqlbn1_ThongTin_IdBN.add(Box.createHorizontalStrut(20));// Khoảng cách giữa chữ và textfield
		bqlbn1_ThongTin_IdBN.add(txtSearch = new JTextField());
		txtSearch.setPreferredSize(getPreferredSize());
		bqlbn1_ThongTin_IdBN.add(Box.createHorizontalStrut(10));
		bqlbn1_ThongTin_IdBN.add(btnSearch = new JButton("Tìm"));

		Box bqlbn1_ThongTin_Ho = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ho.add(new JLabel("Tên sản phẩm: "));
		bqlbn1_ThongTin_Ho.add(Box.createHorizontalStrut(60));
		bqlbn1_ThongTin_Ho.add(cbbName = new JComboBox<>());
		// cbbName.setPreferredSize(getPreferredSize());

		Box bqlbn1_ThongTin_Ten = Box.createHorizontalBox();
		bqlbn1_ThongTin_Ten.add(new JLabel("Số lượng: "));
		bqlbn1_ThongTin_Ten.add(Box.createHorizontalStrut(90));
		bqlbn1_ThongTin_Ten.add(txtQuantity = new JTextField());
		// txtQuantity.setPreferredSize(getPreferredSize());

		Box bqlbn1_ThongTin_Sdt = Box.createHorizontalBox();
		bqlbn1_ThongTin_Sdt.add(new JLabel("Giá: "));
		bqlbn1_ThongTin_Sdt.add(Box.createHorizontalStrut(120));
		bqlbn1_ThongTin_Sdt.add(txtPrice = new JTextField());
		// txtPrice.setPreferredSize(getPreferredSize());

		bqlbn1_ThongTin.add(bqlbn1_ThongTin_IdBN);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ho);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(10));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Ten);
		bqlbn1_ThongTin.add(Box.createVerticalStrut(5));
		bqlbn1_ThongTin.add(bqlbn1_ThongTin_Sdt);

		bqlbn1.add(bqlbn1_ThongTin);
		bqlbn1.add(Box.createHorizontalStrut(10));// Giản cách giữa hai box thông tin và tìm kiếm
		// bqlbn1.add(bqlbn1_TimKiem_BenhNhan_BacSi);

		Box bqlbn2_ChucNang = Box.createVerticalBox(); // bqlbn2_ChucNang là quản lý dòng các nút chức năng
		bqlbn2_ChucNang.setBorder(BorderFactory.createTitledBorder("Chức năng"));
		bqlbn2_ChucNang.setMaximumSize(getMaximumSize());
		Box bqlbn2_ChucNang_1 = Box.createHorizontalBox();
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1
				.add(btnAdd = new JButton("Thêm", new ImageIcon(getClass().getResource("/ima/if_7_330410.png"))));
		btnAdd.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1.add(btnModify = new JButton("Cập nhật",
				new ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png"))));
		btnModify.setMaximumSize(getMaximumSize());
		bqlbn2_ChucNang_1.add(Box.createHorizontalStrut(10));
		bqlbn2_ChucNang_1
				.add(btnRemove = new JButton("Xoá", new ImageIcon(getClass().getResource("/ima/if_Save_1493294.png"))));
		btnRemove.setMaximumSize(getMaximumSize());

		bqlbn2_ChucNang.add(bqlbn2_ChucNang_1);

		Box bqlbn3_Danhsach = Box.createVerticalBox(); // bqlbn3_Danhsach là quản lý cái bảng danh sách
		bqlbn3_Danhsach.setBorder(BorderFactory.createTitledBorder("Danh sách sản phẩm mua"));
		Box bqlbn3_Danhsach_1 = Box.createHorizontalBox();
		String[] headers = "Mã sản phẩm;Tên sản phẩm; Số lượng; Giá; Tiền".split(";");
		tablemodel = new DefaultTableModel(headers, 0);
		bqlbn3_Danhsach_1.add(new JScrollPane(table = new JTable(tablemodel)));
		table.setDefaultEditor(Object.class, null);
		bqlbn3_Danhsach.add(bqlbn3_Danhsach_1);

		bqlbn.add(bqlbn1);
		bqlbn.add(bqlbn2_ChucNang);
		bqlbn.add(bqlbn3_Danhsach);
		/////////////////////////////////
		/**
		 * Cái này là quản lý cá nhân
		 */
		/////////////////////////////////

		tbpqlcn = new JTabbedPane();

		Box b_BasicInfo, b_ChangePassword;

		b_BasicInfo = Box.createVerticalBox();// b_BasicInfo quản lý chung của xem thông tin

		Box b_BasicInfo_Id = Box.createHorizontalBox();
		b_BasicInfo_Id.add(Box.createHorizontalStrut(10));
		b_BasicInfo_Id.add(lblId = new JLabel("Mã số nhân viên:"));
		lblId.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_Id.add(Box.createHorizontalStrut(50));
		b_BasicInfo_Id.add(txtId = new JTextField());
		b_BasicInfo_Id.add(Box.createHorizontalStrut(50));

		Box b_BasicInfo_FullName = Box.createHorizontalBox();
		b_BasicInfo_FullName.add(Box.createHorizontalStrut(10));
		b_BasicInfo_FullName.add(lblFullName = new JLabel("Họ và tên: "));
		lblFullName.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_FullName.add(Box.createHorizontalStrut(90));
		b_BasicInfo_FullName.add(txtFullName = new JTextField());
		b_BasicInfo_FullName.add(Box.createHorizontalStrut(50));

		Box b_BasicInfo_DOfBirth = Box.createHorizontalBox();
		b_BasicInfo_DOfBirth.add(Box.createHorizontalStrut(10));
		b_BasicInfo_DOfBirth.add(lblDateOfBirth = new JLabel("Ngày sinh:"));
		lblDateOfBirth.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_DOfBirth.add(Box.createHorizontalStrut(90));
		b_BasicInfo_DOfBirth.add(txtDateOfBirth = new JTextField());
		b_BasicInfo_DOfBirth.add(Box.createHorizontalStrut(50));

		Box b_BasicInfo_Address = Box.createHorizontalBox();
		b_BasicInfo_Address.add(Box.createHorizontalStrut(10));
		b_BasicInfo_Address.add(lblAddress = new JLabel("Địa chỉ:"));
		lblAddress.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_BasicInfo_Address.add(Box.createHorizontalStrut(110));
		b_BasicInfo_Address.add(txtAddress = new JTextField());
		b_BasicInfo_Address.add(Box.createHorizontalStrut(50));

		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_Id);
		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_FullName);

		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_DOfBirth);

		b_BasicInfo.add(Box.createVerticalStrut(10));
		b_BasicInfo.add(b_BasicInfo_Address);
		b_BasicInfo.add(Box.createVerticalStrut(300));

		b_ChangePassword = Box.createVerticalBox();// b_ChangePassword là quản lý chung của đổi mật khẩu

		Box b_ChangePassword_mkc = Box.createHorizontalBox();
		b_ChangePassword_mkc.add(Box.createHorizontalStrut(20));
		b_ChangePassword_mkc.add(lblOldPass = new JLabel("Nhập lại mật khẩu cũ"));
		lblOldPass.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_ChangePassword_mkc.add(Box.createHorizontalStrut(50));
		b_ChangePassword_mkc.add(txtOldPass = new JPasswordField());
		b_ChangePassword_mkc.add(Box.createHorizontalStrut(20));

		Box b_ChangePassword_mkm = Box.createHorizontalBox();
		b_ChangePassword_mkm.add(Box.createHorizontalStrut(20));
		b_ChangePassword_mkm.add(lblNewPass = new JLabel("Nhập mật khẩu mới"));
		lblNewPass.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_ChangePassword_mkm.add(Box.createHorizontalStrut(60));
		b_ChangePassword_mkm.add(txtNewPass = new JPasswordField());
		b_ChangePassword_mkm.add(Box.createHorizontalStrut(20));

		Box b_ChangePassword_nlmkm = Box.createHorizontalBox();
		b_ChangePassword_nlmkm.add(Box.createHorizontalStrut(20));
		b_ChangePassword_nlmkm.add(lblConfirmPass = new JLabel("Nhập lại mật khẩu mới"));
		lblConfirmPass.setFont(new Font("Times new roman", Font.PLAIN, 16));
		b_ChangePassword_nlmkm.add(Box.createHorizontalStrut(40));
		b_ChangePassword_nlmkm.add(txtConfirmPass = new JPasswordField());
		b_ChangePassword_nlmkm.add(Box.createHorizontalStrut(20));

		Box b_ChangePassword_button = Box.createHorizontalBox();
		b_ChangePassword_button.add(Box.createHorizontalStrut(20));
		b_ChangePassword_button.add(btnChangePass = new JButton("Đổi mật khẩu",
				new ImageIcon(getClass().getResource("/ima/if_Access_field_pin_input_password_2629858 .png"))));
		btnChangePass.setSize(new Dimension(50, 20));
		b_ChangePassword_button.add(Box.createHorizontalStrut(50));
		b_ChangePassword_button.add(
				btnCancel = new JButton("Hủy", new ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png"))));
		btnCancel.setMaximumSize(new Dimension(150, 60));
		b_ChangePassword_button.add(Box.createHorizontalStrut(20));
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_mkc);
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_mkm);
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_nlmkm);
		b_ChangePassword.add(Box.createVerticalStrut(10));
		b_ChangePassword.add(b_ChangePassword_button);
		b_ChangePassword.add(Box.createVerticalStrut(300));

		tbpqlcn.addTab("Xem Thông tin", b_BasicInfo);
		tbpqlcn.addTab("Đổi mật khẩu", b_ChangePassword);
		tbpqlcn.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		/////////////////////////////////
		/**
		 * Cái này là quản lý các tab
		 */
		/////////////////////////////////
		tbp = new JTabbedPane();
		tbp.addTab("Thông tin cá nhân", tbpqlcn);
		tbp.addTab("Quản lý bán hàng", bqlbn);
		tbp.setFont(new Font("Times new Roman", Font.PLAIN, 20));
		tbp.setTabPlacement(JTabbedPane.LEFT);
		/////////////////////////////////
		/**
		 * Xử ly�? trạng tha�?i ban đầu
		 */
		/////////////////////////////////
		/*
		 * txtmanv.setEditable(false); txttennv.setEditable(false);
		 * txthonv.setEditable(false); txtngaysinhnv.setEditable(false);
		 * txtdiachinv.setEditable(false); txtsdtnv.setEditable(false);
		 */

		// btnLuu.setEnabled(false);
		table.setDefaultEditor(Object.class, null);
		table.setEnabled(false);

		// cmbTimbs.setEnabled(false);

		/////////////////////////////////
		bt.add(tbp);
		add(bt);
		setLocationRelativeTo(null);
		setVisible(true);
		/////////////////////////////////

		/////////////////////////////////
		// LoadBenhNhanVaoBang();
		/// LoadTenBacSi();
		// HienThiThongTinCaNhan();
	}

	/**
	 * các hàm xử lý
	 */
	////////////////////////////////////////////////////////////////////////////////////
	private void XoaTrangDoiMatKhau() {
		txtmkc.setText("");
		txtmkm.setText("");
		txtnlmkm.setText("");
	}

	/*
	 * private void LoadTenBacSi() { dsnv = new ArrayList<>(); dsnv =
	 * nhanVienNhanBenhDaos.GetBacSy(); for (int i = 0; i < dsnv.size(); i++) {
	 * String s = dsnv.get(i).getHo() + " " + dsnv.get(i).getTen();
	 * cmbTimbs.addItem(s); }
	 * 
	 * }
	 * 
	 * private void LoadBenhNhanVaoBang() { dsbn = new ArrayList<>(); dsbn =
	 * nhanVienNhanBenhDaos.LayBenhNhanTuSQL(); for (int i = 0; i < dsbn.size();
	 * i++) { String s[] = { dsbn.get(i).getIDBenhNhan(), dsbn.get(i).getHo(),
	 * dsbn.get(i).getTenBN(), dsbn.get(i).getSDT(), dsbn.get(i).getDiaChi() };
	 * tablemodel.addRow(s); } }
	 * 
	 * private void XoaTrangBenhNhan() { txtidbn.setText(""); txttenbn.setText("");
	 * txthobn.setText(""); txtsdtbn.setText(""); txtdiachibn.setText("");
	 * 
	 * }
	 * 
	 * private void XoaBangBenhNhan() { int a = tablemodel.getRowCount(); for (int i
	 * = a - 1; i >= 0; i--) { tablemodel.removeRow(i); } }
	 * 
	 * private void ChonDongTrongBangBenhNhan() { int a = table.getSelectedRow();
	 * txtidbn.setText(table.getValueAt(a, 0).toString());
	 * txthobn.setText(table.getValueAt(a, 1).toString());
	 * txttenbn.setText(table.getValueAt(a, 2).toString());
	 * txtsdtbn.setText(table.getValueAt(a, 3).toString());
	 * txtdiachibn.setText(table.getValueAt(a, 4).toString()); }
	 * 
	 * private void TrangThaiTextBenhNhan(boolean a) { txtidbn.setEditable(a);
	 * txttenbn.setEditable(a); txthobn.setEditable(a); txtsdtbn.setEditable(a);
	 * txtdiachibn.setEditable(a); }
	 * 
	 * private void HienThiThongTinCaNhan() {
	 * txtmanv.setText(nhanVien.getIDNhanVien());
	 * txttennv.setText(nhanVien.getTen()); txthonv.setText(nhanVien.getHo());
	 * txtdiachinv.setText(nhanVien.getDiaChi());
	 * txtsdtnv.setText(nhanVien.getSDT());
	 * txtngaysinhnv.setText(nhanVien.getNgaySinh().toString()); }
	 * 
	 * /////////////////////////////////////////////////////////////////////////////
	 * /////////// private void ThemAction() { if
	 * (btnThem.getText().equalsIgnoreCase("Thêm")) { TrangThaiTextBenhNhan(true);
	 * btnThem.setText("Hủy"); btnThem.setIcon(new
	 * ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
	 * btnCapNhat.setEnabled(false); btnChuyen.setEnabled(false);
	 * btnLuu.setEnabled(true); txtidbn.requestFocus(); } else if
	 * (btnThem.getText().equalsIgnoreCase("Hủy")) { TrangThaiTextBenhNhan(false);
	 * btnThem.setText("Thêm"); btnThem.setIcon(new
	 * ImageIcon(getClass().getResource("/ima/if_7_330410.png")));
	 * btnCapNhat.setEnabled(true); btnChuyen.setEnabled(true);
	 * btnLuu.setEnabled(false);
	 * 
	 * } }
	 * 
	 * private void LuuAction() { if (btnThem.getText().equalsIgnoreCase("Hủy")) {
	 * BenhNhan benhNhan = new BenhNhan();
	 * benhNhan.setIDBenhNhan(txtidbn.getText()); benhNhan.setHo(txthobn.getText());
	 * benhNhan.setTenBN(txttenbn.getText());
	 * benhNhan.setDiaChi(txtdiachibn.getText());
	 * benhNhan.setSDT(txtsdtbn.getText());
	 * nhanVienNhanBenhDaos.ThemBenhNhanVaoDataBase(benhNhan); XoaBangBenhNhan();
	 * LoadBenhNhanVaoBang(); XoaTrangBenhNhan(); } else if
	 * (btnCapNhat.getText().equals("Hủy")) { if (table.getSelectedRow() >= 0) {
	 * BenhNhan benhNhan = new BenhNhan();
	 * benhNhan.setIDBenhNhan(txtidbn.getText()); benhNhan.setHo(txthobn.getText());
	 * benhNhan.setTenBN(txttenbn.getText());
	 * benhNhan.setDiaChi(txtdiachibn.getText());
	 * benhNhan.setSDT(txtsdtbn.getText());
	 * nhanVienNhanBenhDaos.SuaBenhNhanVaoDatabase(benhNhan); XoaBangBenhNhan();
	 * LoadBenhNhanVaoBang(); XoaTrangBenhNhan(); } else {
	 * JOptionPane.showMessageDialog(new JFrame(),
	 * "Chưa ch�?n bệnh nhân để cập nhật"); XoaTrangBenhNhan(); } } else if
	 * (btnChuyen.getText().equals("Hủy")) {
	 * 
	 * if (table.getSelectedRow() >= 0) { BenhNhan benhNhan = new BenhNhan();
	 * benhNhan.setIDBenhNhan(txtidbn.getText()); benhNhan.setHo(txthobn.getText());
	 * benhNhan.setTenBN(txttenbn.getText());
	 * benhNhan.setDiaChi(txtdiachibn.getText());
	 * benhNhan.setSDT(txtsdtbn.getText()); NhanVien nhanVien = new NhanVien();
	 * nhanVien = dsnv.get(cmbTimbs.getSelectedIndex());
	 * nhanVienNhanBenhDaos.ChuyenBenhNhanQuaBacSy(nhanVien, benhNhan);
	 * XoaBangBenhNhan(); XoaTrangBenhNhan(); } else {
	 * JOptionPane.showMessageDialog(new JFrame(),
	 * "Chưa ch�?n bệnh nhân để chuyển"); txttimbn.setText(""); }
	 * 
	 * }
	 * 
	 * }
	 * 
	 * private void CapNhatAction() { if (btnCapNhat.getText().equals("Cập nhật")) {
	 * TrangThaiTextBenhNhan(true); btnCapNhat.setText("Hủy");
	 * btnCapNhat.setIcon(new
	 * ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
	 * btnThem.setEnabled(false); btnChuyen.setEnabled(false);
	 * btnLuu.setEnabled(true); table.setEnabled(true);
	 * 
	 * XoaTrangBenhNhan(); } else if (btnCapNhat.getText().equals("Hủy")) {
	 * TrangThaiTextBenhNhan(false); btnCapNhat.setText("Cập nhật");
	 * btnCapNhat.setIcon(new
	 * ImageIcon(getClass().getResource("/ima/if_brush-pencil_1055103.png")));
	 * btnThem.setEnabled(true); btnChuyen.setEnabled(true);
	 * btnLuu.setEnabled(false); table.getSelectionModel().clearSelection();
	 * table.setEnabled(true);
	 * 
	 * XoaTrangBenhNhan(); XoaBangBenhNhan(); txttimbn.setText("");
	 * LoadBenhNhanVaoBang(); } }
	 * 
	 * public void ChuyenBenhNhan() { if
	 * (btnChuyen.getText().equals("Chuyển bệnh nhân")) { btnChuyen.setText("Hủy");
	 * btnChuyen.setIcon(new
	 * ImageIcon(getClass().getResource("/ima/if_Delete_1493279.png")));
	 * btnLuu.setText("Chuyển"); btnLuu.setIcon( new
	 * ImageIcon(getClass().getResource(
	 * "/ima/if_control-next-move-forward-future_3209403.png")));
	 * btnThem.setEnabled(false); btnCapNhat.setEnabled(false);
	 * cmbTimbs.setEnabled(true); btnLuu.setEnabled(true);
	 * 
	 * table.setEnabled(true); } else if (btnChuyen.getText().equals("Hủy")) {
	 * XoaBangBenhNhan(); txttimbn.setText("");
	 * btnChuyen.setText("Chuyển bệnh nhân"); btnChuyen.setIcon( new
	 * ImageIcon(getClass().getResource(
	 * "/ima/if_control-next-move-forward-future_3209403.png")));
	 * btnLuu.setText("Lưu"); btnLuu.setIcon(new
	 * ImageIcon(getClass().getResource("/ima/if_Save_1493294.png")));
	 * btnThem.setEnabled(true); btnCapNhat.setEnabled(true);
	 * cmbTimbs.setEnabled(false); btnLuu.setEnabled(false);
	 * 
	 * table.getSelectionModel().clearSelection(); table.setEnabled(false);
	 * LoadBenhNhanVaoBang(); XoaTrangBenhNhan(); } }
	 * 
	 * public void TimBenhNhan() { if (cmbTim.getSelectedIndex() == 0 &&
	 * !txttimbn.getText().isEmpty()) { XoaBangBenhNhan(); dsbn = new ArrayList<>();
	 * dsbn = nhanVienNhanBenhDaos.TimBenhNhanTheoTen(txttimbn.getText()); if (dsbn
	 * != null) { for (int i = 0; i < dsbn.size(); i++) { String s[] = {
	 * dsbn.get(i).getIDBenhNhan(), dsbn.get(i).getHo(), dsbn.get(i).getTenBN(),
	 * dsbn.get(i).getSDT(), dsbn.get(i).getDiaChi() }; tablemodel.addRow(s); }
	 * txttimbn.setText(""); } else { JOptionPane.showMessageDialog(new JFrame(),
	 * "Không tìm thấy"); XoaBangBenhNhan(); LoadBenhNhanVaoBang(); }
	 * 
	 * } else if (cmbTim.getSelectedIndex() == 1 && !txttimbn.getText().isEmpty()) {
	 * XoaBangBenhNhan(); dsbn = new ArrayList<>(); dsbn =
	 * nhanVienNhanBenhDaos.TimBenhNhanTheoSDT(txttimbn.getText()); if
	 * (!dsbn.isEmpty()) { for (int i = 0; i < dsbn.size(); i++) { String s[] = {
	 * dsbn.get(i).getIDBenhNhan(), dsbn.get(i).getHo(), dsbn.get(i).getTenBN(),
	 * dsbn.get(i).getSDT(), dsbn.get(i).getDiaChi() }; tablemodel.addRow(s); }
	 * txttimbn.setText(""); } else { JOptionPane.showMessageDialog(new JFrame(),
	 * "Không tìm thấy"); XoaBangBenhNhan(); LoadBenhNhanVaoBang(); }
	 * 
	 * } else if (txttimbn.getText().equals("")) { XoaBangBenhNhan();
	 * LoadBenhNhanVaoBang(); } }
	 * 
	 * /////////////////////////////////////////////////////////////////////////
	 * private boolean DoiMatKhau() { String mkc = "", mkm = "", nlmkm = ""; char
	 * a[], b[], c[]; a = txtmkc.getPassword(); b = txtmkm.getPassword(); c =
	 * txtnlmkm.getPassword(); for (int i = 0; i < a.length; i++) { mkc = mkc +
	 * a[i]; } for (int i = 0; i < b.length; i++) { mkm = mkm + b[i]; } for (int i =
	 * 0; i < c.length; i++) { nlmkm = nlmkm + c[i]; } if
	 * (!nhanVienNhanBenhDaos.CheckMatKhauCu(nhanVien, mkc)) {
	 * JOptionPane.showMessageDialog(new JFrame(), "Mật khẩu cũ không khớp");
	 * XoaTrangDoiMatKhau(); return false; } else if (!mkm.equals(nlmkm)) {
	 * JOptionPane.showMessageDialog(new JFrame(),
	 * "Nhập lại mật khẩu mới không khớp"); XoaTrangDoiMatKhau(); return false; }
	 * else if (!nhanVienNhanBenhDaos.DoiMatKhau(nhanVien, nlmkm)) {
	 * JOptionPane.showMessageDialog(new JFrame(),
	 * "�?ổi mật khẩu không thành công"); XoaTrangDoiMatKhau(); return false; }
	 * JOptionPane.showMessageDialog(new JFrame(), "�?ổi mật khẩu thành công"); new
	 * Gui_DangNhap(); dispose(); return true; }
	 */
}

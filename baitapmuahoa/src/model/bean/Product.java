package model.bean;

public class Product {
	private int id;
	private String tenHoa;
	private String moTa;
	private String hinhAnh;
	private int giaBan;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTenHoa() {
		return tenHoa;
	}
	public void setTenHoa(String tenHoa) {
		this.tenHoa = tenHoa;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String tenHoa, String moTa, String hinhAnh, int giaBan) {
		super();
		this.id = id;
		this.tenHoa = tenHoa;
		this.moTa = moTa;
		this.hinhAnh = hinhAnh;
		this.giaBan = giaBan;
	}
	
}

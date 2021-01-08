package pojo_Serialization;

import java.util.List;

public class about {
	
	private int id;
	private String name;
	private String department;
	private String college;
	private String[] destination_addresses;
	private List<Rows> rows;


	public List<Rows> getRows() {
		return rows;
	}
	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}
	public String[] getDestination_addresses() {
		return destination_addresses;
	}
	public void setDestination_addresses(String[] destination_addresses) {
		this.destination_addresses = destination_addresses;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDedepartment() {
		return department;
	}
	public void setDedepartment(String dedepartment) {
		this.department = dedepartment;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	
	
}

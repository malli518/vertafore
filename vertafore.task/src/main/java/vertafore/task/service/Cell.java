package vertafore.task.service;

public class Cell {
	
	private int column;
	private int row;
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public int getRow() {
		return row;
	}
	public Cell(int row, int column) {
		super();
		this.column = column;
		this.row = row;
	}
	public void setRow(int row) {
		this.row = row;
	}

}

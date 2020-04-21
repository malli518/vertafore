package vertafore.task.service;

import java.util.HashMap;
import java.util.Set;

public class ITableImplementation implements ITable {
	static HashMap<Cell, Long> cells = new HashMap<Cell, Long>();

	public void set(Cell cell, long value) {
		cells.put(cell, value);
	}

	public long get(Cell cell) {
		if (null != cells.get(cell)) {
			return cells.get(cell);
		}
		return 0;
	}

	public long sum(Cell fromCell, Cell toCell) {
		Set<Cell> cellSet = cells.keySet();
		long sum = 0;
		for (Cell cell : cellSet) {
			if ((cell.getColumn() >= fromCell.getColumn() && cell.getRow() >= fromCell.getRow())
					&& (cell.getColumn() <= toCell.getColumn() && cell.getRow() <= toCell.getRow())) {
				sum = sum + get(cell);
			}
		}
		return sum;
	}

	public long avg(Cell fromCell, Cell toCell) {
		long count = 0;
		long sum = sum(fromCell, toCell);
		Set<Cell> cellSet = cells.keySet();				
		for (Cell cell : cellSet) {
			if ((cell.getColumn() >= fromCell.getColumn() && cell.getRow() >= fromCell.getRow())
					&& (cell.getColumn() <= toCell.getColumn() && cell.getRow() <= toCell.getRow())) {
				count++;
			}
		}
		long totalAvg = sum / count;
		return totalAvg;
	}

	public static void main(String args[]) {

		ITableImplementation iTableImplementation = new ITableImplementation();
		Cell cell1 = new Cell(0, 0);
		Cell cell2 = new Cell(0, 1);
		Cell cell3 = new Cell(1, 0);
		Cell cell4 = new Cell(1, 1);
		iTableImplementation.set(cell1, 1);
		iTableImplementation.set(cell2, 2);
		iTableImplementation.set(cell3, 3);
		iTableImplementation.set(cell4, 4);

		System.out.println("Get Value (1,0)::  " + iTableImplementation.get(cell3));
		System.out.println("Get Sum (0,0), (1,1)::  " + iTableImplementation.sum(cell1, cell4));
		System.out.println("Get Avg (0,0) (1,1) ::  " + iTableImplementation.avg(cell1, cell4));
		System.out.println("Get Value (1,2) not Present in the Map ::  " + iTableImplementation.get(new Cell(1, 2)));

	}

}

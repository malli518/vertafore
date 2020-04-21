package vertafore.task.service;

public interface ITable {

	void set(Cell cell,long value);
	long get(Cell cell);
	long sum(Cell fromCell,Cell toCell);
	long avg(Cell fromCell,Cell toCell);
	
}

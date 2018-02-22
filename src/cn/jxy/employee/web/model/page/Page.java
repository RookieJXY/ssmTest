package cn.jxy.employee.web.model.page;

/**
 * 该类用于分页页查询
 */
public class Page {
	private int pageSize = 10;//每页显示行数
	
	private int begin;
	
	private int end;
	
	private int rows;//总行数，由外界传入
	
	private int totalPage;//总页数,get方法中计算
	
	private int currentPage = 1;//用户选择的当前页数，默认为1,可由由外界传入

	public Page() {
		super();
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getBegin() {
		this.begin = (this.currentPage - 1) * pageSize + 1;
		return this.begin;
	}

	public void setBegin(int begin) {
		this.begin = begin;
	}

	public int getEnd() {
		this.end = this.currentPage * pageSize;
		return this.end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getTotalPage() {		
		this.totalPage = rows / pageSize;
		
		if (this.rows % this.pageSize == 0) {
			return this.totalPage;
		} else {
			return this.totalPage + 1;
		}
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
}

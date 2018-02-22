package cn.jxy.employee.web.model.page;

public class UserPage extends Page{

	@Override
	public String toString() {
		return "UserPage [getPageSize()=" + getPageSize() + ", getBegin()="
				+ getBegin() + ", getEnd()=" + getEnd() + ", getRows()="
				+ getRows() + ", getTotalPage()=" + getTotalPage()
				+ ", getCurrentPage()=" + getCurrentPage() + "]";
	}
}

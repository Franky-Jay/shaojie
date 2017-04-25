package com.mashen.common.domain;

import java.util.List;

public class PageVO<E> {
	private int pageSize = 10;// 分页大小，即1页显示多少条记录
	private int curPage=1;// 当前页
	private long totalPage;// 总页数
	private long totalRecord;// 总记录数
	private List<E> records; // 数据
	private int offset;// 起始位置

	private int size;//当前记录的总数

	// 分页显示相关属性
	private long pageNum = 10;
	private long pageStart;
	private long pageEnd;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	

	public long getPageNum() {
		return pageNum;
	}

	public void setPageNum(long pageNum) {
		this.pageNum = pageNum;
	}

	public long getPageStart() {
		return pageStart;
	}

	public void setPageStart(long pageStart) {
		this.pageStart = pageStart;
	}

	public long getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(long pageEnd) {
		this.pageEnd = pageEnd;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		if (pageSize < 1) {
			pageSize = 10;
		}
		this.pageSize = pageSize;
		this.setCurPage(this.curPage);
	}

	public int getCurPage() {
		return curPage;
	}

	/**
	 * 设置当前页
	 * 
	 * @param curPage
	 */
	public void setCurPage(int curPage) {
		if (curPage < 1) {
			curPage = 1;
		}
		this.curPage = curPage;
		this.offset = (this.curPage - 1) * this.pageSize;
	}

	public long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(long totalPage) {
		this.totalPage = totalPage;
	}

	public long getTotalRecord() {
		return totalRecord;
	}

	/**
	 * 设置总记录数 计算总页数
	 * 
	 * @param totalRecord
	 */
	public void setTotalRecord(long totalRecord) {
		this.totalRecord = totalRecord;
		this.totalPage = this.totalRecord / this.pageSize;
		if (this.totalRecord % this.pageSize != 0) {
			this.totalPage++;
		}
		
		// 分页显示相关算法
		if (curPage <= pageNum / 2 + 1) {
			pageStart = 1;
			pageEnd = pageNum;
		} else if (curPage > pageNum / 2 + 1) {
			pageStart = curPage - pageNum / 2;
			pageEnd = curPage + pageNum / 2 - 1;
		}
		// 对pageEnd 进行校验，并重新赋值
		if (pageEnd > this.totalPage) {
			pageEnd = this.totalPage;
		}
		if (pageEnd <= pageNum) {// 当不足pageNum数目时，要全部显示，所以pageStart要始终置为1
			pageStart = 1;
		}
	}

	public List<E> getRecords() {
		return records;
	}

	public void setRecords(List<E> records) {
		this.records = records;
		this.size=this.records.size();
	}

}

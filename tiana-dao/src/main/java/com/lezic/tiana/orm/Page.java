/**
 * <p>Author		:	cielo</p>
 * <p>Date 			: 	2016年1月16日 上午10:32:07</p>
 */
package com.lezic.tiana.orm;

import java.util.List;

/**
 * 分页对象
 * 
 * @author cielo
 *
 */
public class Page<T> {

	/**
	 * 从第几条记录开始
	 */
	private int offset = 0;

	/**
	 * 第几页
	 */
	private int pageNumber = 1;

	/**
	 * 每页条数
	 */
	private int pageSize = 10;

	/**
	 * 总条数
	 */
	private long total = -1;

	/**
	 * 总页数
	 */
	private long totalPages = -1;

	/**
	 * 结果集
	 */
	private List<?> rows = null;

	/**
	 * 从第几条记录开始
	 * 
	 * @return the offset
	 */
	public int getOffset() {
		if (offset == 0) {
			if (pageNumber < 1 || pageSize < 1) {
				offset = 0;
			} else {
				offset = ((pageNumber - 1) * pageSize);
			}
		}
		return offset;
	}

	/**
	 * 总页数
	 * 
	 * @return the totalPages
	 */
	public long getTotalPages() {
		if (totalPages == -1) {
			if (total != -1) {
				totalPages = (int) (total / pageSize);
				if (total % pageSize > 0) {
					totalPages++;
				}
			}
		}
		return totalPages;
	}

	/* 以下是自动生成的 */

	/**
	 * 总条数
	 * 
	 * @param totalCount
	 *            the totalCount to set
	 */
	public void setTotal(long totalCount) {
		this.total = totalCount;
	}

	public long getTotal() {
		return total;
	}

	/**
	 * 总页数
	 * 
	 * @param totalPages
	 *            the totalPages to set
	 */
	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * 从第几条记录开始
	 * 
	 * @param offset
	 *            the offset to set
	 */
	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * @return the pageNumber
	 */
	public int getPageNumber() {
		return pageNumber;
	}

	/**
	 * @param pageNumber
	 *            the pageNumber to set
	 */
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}

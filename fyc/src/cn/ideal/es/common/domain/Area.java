package cn.ideal.es.common.domain;

import java.io.Serializable;

/**
 * 区域
 * @author Joe
 * 2017年12月4日
 */
public class Area implements Serializable,ClearBean {
	private static final long serialVersionUID = 1L;
	private String id;
	/**
	 * 区码
	 */
	private String code;
	/**
	 * 地区名称
	 */
	private String name;
	/**
	 * 父区码
	 */
	private String pcode;
	private String desc1;

	public Area() {
	}

	public Area(String code, String name, String pcode) {
		this.code = code;
		this.name = name;
		this.pcode = pcode;
	}

	public void clear() {
		id = null;
		code = null;
		name = null;
		pcode = null;
		desc1 = null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc1() {
		return desc1;
	}

	public void setDesc1(String desc1) {
		this.desc1 = desc1;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getPcode() {
		return pcode;
	}

	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", code=" + code + ", name=" + name
				+ ", pcode=" + pcode + ", desc1=" + desc1 + "]";
	}

}

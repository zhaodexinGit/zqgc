package com.rayootech.project.sys.entity;

public class BaseDictionary {
	/**
	 * 主键ID
	 */
    private String BDID;

    /**
	 * 字典类型
	 */
    private String TYPE;

    /**
	 * 父节点
	 */
    private String PID;

    /**
	 * 数值
	 */
    private String NAME;

    /**
	 * 备注
	 */
    private String VALUE;

    /**
	 * 序号
	 */
    private String REMARK;

    /**
	 * 父节点
	 */
    private Integer SNO;

    /**
	 * 所属字典类型
	 */
    private String BELONGTYPE;

    /**
	 * 所属字典数值
	 */
    private String BELONGVALUE;

    public String getBDID() {
        return BDID;
    }

    public void setBDID(String BDID) {
        this.BDID = BDID == null ? null : BDID.trim();
    }

    public String getTYPE() {
        return TYPE;
    }

    public void setTYPE(String TYPE) {
        this.TYPE = TYPE == null ? null : TYPE.trim();
    }

    public String getPID() {
        return PID;
    }

    public void setPID(String PID) {
        this.PID = PID == null ? null : PID.trim();
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME == null ? null : NAME.trim();
    }

    public String getVALUE() {
        return VALUE;
    }

    public void setVALUE(String VALUE) {
        this.VALUE = VALUE == null ? null : VALUE.trim();
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK == null ? null : REMARK.trim();
    }

    public Integer getSNO() {
        return SNO;
    }

    public void setSNO(Integer SNO) {
        this.SNO = SNO;
    }

    public String getBELONGTYPE() {
        return BELONGTYPE;
    }

    public void setBELONGTYPE(String BELONGTYPE) {
        this.BELONGTYPE = BELONGTYPE == null ? null : BELONGTYPE.trim();
    }

    public String getBELONGVALUE() {
        return BELONGVALUE;
    }

    public void setBELONGVALUE(String BELONGVALUE) {
        this.BELONGVALUE = BELONGVALUE == null ? null : BELONGVALUE.trim();
    }
}
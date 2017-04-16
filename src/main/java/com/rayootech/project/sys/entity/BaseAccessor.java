package com.rayootech.project.sys.entity;

public class BaseAccessor {
	/**
	 * 主键ID
	 */
    private String BAID;

    /**
	 * 业务代码
	 */
    private String BUSINESSCODE;

    /**
	 * 业务名称
	 */
    private String BUSINESSNAME;

    /**
	 * 数据主键ID
	 */
    private String DPID;

    /**
	 * 文件名称
	 */
    private String FILENAME;

    /**
	 * 文件地址
	 */
    private String FILEPATH;

    /**
	 * 文件类型
	 */
    private String FILETYPE;

    /**
	 * 文件说明
	 */
    private String FILEEXPLAIN;

//    private NlbTravelprivatecustom nlbTravelprivatecustom;
//    
//    private NlbInsurancePrivateCustom nlbInsurancePrivateCustom;
//    
//    private NlbSunDryingup nlbSunDryingup;
//    
//    

	public String getBAID() {
        return BAID;
    }

    public void setBAID(String BAID) {
        this.BAID = BAID == null ? null : BAID.trim();
    }

    public String getBUSINESSCODE() {
        return BUSINESSCODE;
    }

    public void setBUSINESSCODE(String BUSINESSCODE) {
        this.BUSINESSCODE = BUSINESSCODE == null ? null : BUSINESSCODE.trim();
    }

    public String getBUSINESSNAME() {
        return BUSINESSNAME;
    }

    public void setBUSINESSNAME(String BUSINESSNAME) {
        this.BUSINESSNAME = BUSINESSNAME == null ? null : BUSINESSNAME.trim();
    }

    public String getDPID() {
        return DPID;
    }

    public void setDPID(String DPID) {
        this.DPID = DPID == null ? null : DPID.trim();
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME == null ? null : FILENAME.trim();
    }

    public String getFILEPATH() {
        return FILEPATH;
    }

    public void setFILEPATH(String FILEPATH) {
        this.FILEPATH = FILEPATH == null ? null : FILEPATH.trim();
    }

    public String getFILETYPE() {
        return FILETYPE;
    }

    public void setFILETYPE(String FILETYPE) {
        this.FILETYPE = FILETYPE == null ? null : FILETYPE.trim();
    }

    public String getFILEEXPLAIN() {
        return FILEEXPLAIN;
    }

    public void setFILEEXPLAIN(String FILEEXPLAIN) {
        this.FILEEXPLAIN = FILEEXPLAIN == null ? null : FILEEXPLAIN.trim();
    }
//
//	public NlbTravelprivatecustom getNlbTravelprivatecustom() {
//		return nlbTravelprivatecustom;
//	}
//
//	public void setNlbTravelprivatecustom(
//			NlbTravelprivatecustom nlbTravelprivatecustom) {
//		this.nlbTravelprivatecustom = nlbTravelprivatecustom;
//	}
//
//	public NlbInsurancePrivateCustom getNlbInsurancePrivateCustom() {
//		return nlbInsurancePrivateCustom;
//	}
//
//	public void setNlbInsurancePrivateCustom(
//			NlbInsurancePrivateCustom nlbInsurancePrivateCustom) {
//		this.nlbInsurancePrivateCustom = nlbInsurancePrivateCustom;
//	}
//    
//	public NlbSunDryingup getNlbSunDryingup() {
//		return nlbSunDryingup;
//	}
//
//	public void setNlbSunDryingup(NlbSunDryingup nlbSunDryingup) {
//		this.nlbSunDryingup = nlbSunDryingup;
//	}	
}
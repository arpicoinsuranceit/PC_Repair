package com.arpico.groupit.pc_repair.util;

public class AppConstant {

	public static final Integer ENABLE = 1;
	public static final Integer DISABLE = 0;

	public static final String SEND = "SNTH";
	public static final String SEND_REC = "SEND_REC";
	public static final String RETURN = "RETURN";
	public static final String RETURN_REC = "RETURN_REC";
	public static final String COMPLETE = "COMPLETE";
	public static final String RETURN_B = "RECB";
	public static final String RETURN_H = "RECH";
	public static final String SEND_BACK = "BACKUP_SEND";
	public static final String RETURN_BACK = "BACKUP_RETURN";
	
	public static final String[] RETURN_ALL = {RETURN_B,RETURN_H} ;
	
	public static final String PARTSTATUS_AVAILABLE = "AVAILABLE";
	public static final String PARTSTATUS_SET_TO_ASSET = "SET_TO_ASSET";
	public static final String PARTSTATUS_DAMAGED = "DAMAGED";
	public static final String PARTSTATUS_WARRENTY = "WARRENTY";

	public static final String[] PART_STATUS = { PARTSTATUS_AVAILABLE, PARTSTATUS_SET_TO_ASSET, PARTSTATUS_DAMAGED,
			PARTSTATUS_WARRENTY };

}

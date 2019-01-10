package com.arpico.groupit.pc_repair.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.iterators.ArrayListIterator;

public class AppConstant {

	public static final Integer ENABLE = 1;
	public static final Integer DISABLE = 0;

	public static final String SEND = "SNTH";
	public static final String SEND_REC = "SEND_REC";
	public static final String RETURN = "RETURN";
	public static final String RETURN_REC = "RETURN_REC";
	public static final String COMPLETE = "COMPLETE";

	public static final String PARTSTATUS_AVAILABLE = "AVAILABLE";
	public static final String PARTSTATUS_SET_TO_ASSET = "SET_TO_ASSET";
	public static final String PARTSTATUS_DAMAGED = "DAMAGED";
	public static final String PARTSTATUS_WARRENTY = "WARRENTY";

	public static final String[] PART_STATUS = { PARTSTATUS_AVAILABLE, PARTSTATUS_SET_TO_ASSET, PARTSTATUS_DAMAGED,
			PARTSTATUS_WARRENTY };

}

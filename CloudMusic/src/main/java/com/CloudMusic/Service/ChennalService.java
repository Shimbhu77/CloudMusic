package com.CloudMusic.Service;

import com.CloudMusic.Exceptions.ChennalException;
import com.CloudMusic.Exceptions.UserException;
import com.CloudMusic.Model.Chennal;
import com.CloudMusic.Model.DTO.ChennalDTO1;

public interface ChennalService {

	public Chennal createChennal(ChennalDTO1 dto ) throws ChennalException, UserException;
	public Chennal updateChennal(ChennalDTO1 dto ) throws ChennalException, UserException;
	public Chennal deleteChennal() throws ChennalException, UserException;
	public Chennal viewMyChennal() throws ChennalException,UserException;
}

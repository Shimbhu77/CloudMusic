package com.CloudMusic.Service;

import java.util.List;

import com.CloudMusic.Exceptions.SingerException;
import com.CloudMusic.Model.Singer;

import com.CloudMusic.Model.DTO.SingerDTO1;
import com.CloudMusic.Model.DTO.SingerDTO2;
import com.CloudMusic.Model.DTO.SingerDTO3;

public interface SingerService {

	public Singer addSinger(SingerDTO1 dto ) throws SingerException;
	public Singer updateSinger(SingerDTO2 dto ) throws SingerException;
	public Singer deleteSinger(Integer id) throws SingerException;
	public Singer viewSingerById(Integer id) throws SingerException;
	public List<Singer> viewAllSinger() throws SingerException;
}

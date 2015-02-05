package com.nursery.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NurseryGrowth")
public class NurseryGrowth
{
	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "TreeGuid")
	private String TreeGuid;

	@Column(name = "TXiongJing")
	private double TXiongJing;

	@Column(name = "TGanJing")
	private double TGanJing;

	@Column(name = "TDiJing")
	private double TDiJing;

	@Column(name = "THeight")
	private double THeight;

	@Column(name = "TDiameter")
	private String TDiameter;

	@Column(name = "TThickness")
	private String TThickness;

	@Column(name = "TPengXing")
	private String TPengXing;

	@Column(name = "NewPrice")
	private double NewPrice;

	@Column(name = "UserName")
	private String UserName;

	@Column(name = "PostTime")
	private Date PostTime;

	@Column(name = "Remark")
	private String Remark;

	@Column(name = "PkId")
	private int PkId;

	@Column(name = "RemainNum")
	private double RemainNum;

	public int getId()
	{
		return Id;
	}

	public void setId(int id)
	{
		Id = id;
	}

	public String getTreeGuid()
	{
		return TreeGuid;
	}

	public void setTreeGuid(String treeGuid)
	{
		TreeGuid = treeGuid;
	}

	public double getTXiongJing()
	{
		return TXiongJing;
	}

	public void setTXiongJing(double tXiongJing)
	{
		TXiongJing = tXiongJing;
	}

	public double getTGanJing()
	{
		return TGanJing;
	}

	public void setTGanJing(double tGanJing)
	{
		TGanJing = tGanJing;
	}

	public double getTDiJing()
	{
		return TDiJing;
	}

	public void setTDiJing(double tDiJing)
	{
		TDiJing = tDiJing;
	}

	public double getTHeight()
	{
		return THeight;
	}

	public void setTHeight(double tHeight)
	{
		THeight = tHeight;
	}

	public String getTDiameter()
	{
		return TDiameter;
	}

	public void setTDiameter(String tDiameter)
	{
		TDiameter = tDiameter;
	}

	public String getTThickness()
	{
		return TThickness;
	}

	public void setTThickness(String tThickness)
	{
		TThickness = tThickness;
	}

	public String getTPengXing()
	{
		return TPengXing;
	}

	public void setTPengXing(String tPengXing)
	{
		TPengXing = tPengXing;
	}

	public double getNewPrice()
	{
		return NewPrice;
	}

	public void setNewPrice(double newPrice)
	{
		NewPrice = newPrice;
	}

	public String getUserName()
	{
		return UserName;
	}

	public void setUserName(String userName)
	{
		UserName = userName;
	}

	public Date getPostTime()
	{
		return PostTime;
	}

	public void setPostTime(Date postTime)
	{
		PostTime = postTime;
	}

	public String getRemark()
	{
		return Remark;
	}

	public void setRemark(String remark)
	{
		Remark = remark;
	}

	public int getPkId()
	{
		return PkId;
	}

	public void setPkId(int pkId)
	{
		PkId = pkId;
	}

	public double getRemainNum()
	{
		return RemainNum;
	}

	public void setRemainNum(double remainNum)
	{
		RemainNum = remainNum;
	}

}

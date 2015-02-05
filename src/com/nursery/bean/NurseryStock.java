package com.nursery.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NurseryStock")
public class NurseryStock
{

	@Id
	@GeneratedValue
	@Column(name = "Id")
	private int Id;

	@Column(name = "TreeId")
	private int TreeId;

	@Column(name = "TreeGuid")
	private String TreeGuid;

	@Column(name = "TreeName")
	private String TreeName;

	@Column(name = "HelpCode")
	private String HelpCode;

	@Column(name = "TXiongJing")
	private double TXiongJing;

	@Column(name = "TGanJing")
	private double TGanJing;

	@Column(name = "THeight")
	private double THeight;

	@Column(name = "TDiJing")
	private double TDiJing;

	@Column(name = "TDiameter")
	private String TDiameter;

	@Column(name = "TThickness")
	private String TThickness;

	@Column(name = "TPengXing")
	private String TPengXing;

	@Column(name = "Units")
	private String Units;

	@Column(name = "PurchasePrice")
	private double PurchasePrice;

	@Column(name = "NewPrice")
	private double NewPrice;

	@Column(name = "PurchaseNum")
	private double PurchaseNum;

	@Column(name = "RemainNum")
	private double RemainNum;

	@Column(name = "FromArea")
	private String FromArea;

	@Column(name = "Remark")
	private String Remark;

	@Column(name = "PurchaseDate")
	private Date PurchaseDate;

	@Column(name = "PostTime")
	private Date PostTime;

	@Column(name = "Attach")
	private String Attach;

	@Column(name = "Attach1")
	private String Attach1;

	@Column(name = "ApplyId")
	private int ApplyId;

	public int getId()
	{
		return Id;
	}

	public void setId(int id)
	{
		Id = id;
	}

	public int getTreeId()
	{
		return TreeId;
	}

	public void setTreeId(int treeId)
	{
		TreeId = treeId;
	}

	public String getTreeGuid()
	{
		return TreeGuid;
	}

	public void setTreeGuid(String treeGuid)
	{
		TreeGuid = treeGuid;
	}

	public String getTreeName()
	{
		return TreeName;
	}

	public void setTreeName(String treeName)
	{
		TreeName = treeName;
	}

	public String getHelpCode()
	{
		return HelpCode;
	}

	public void setHelpCode(String helpCode)
	{
		HelpCode = helpCode;
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

	public double getTHeight()
	{
		return THeight;
	}

	public void setTHeight(double tHeight)
	{
		THeight = tHeight;
	}

	public double getTDiJing()
	{
		return TDiJing;
	}

	public void setTDiJing(double tDiJing)
	{
		TDiJing = tDiJing;
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

	public String getUnits()
	{
		return Units;
	}

	public void setUnits(String units)
	{
		Units = units;
	}

	public double getPurchasePrice()
	{
		return PurchasePrice;
	}

	public void setPurchasePrice(double purchasePrice)
	{
		PurchasePrice = purchasePrice;
	}

	public double getNewPrice()
	{
		return NewPrice;
	}

	public void setNewPrice(double newPrice)
	{
		NewPrice = newPrice;
	}

	public double getPurchaseNum()
	{
		return PurchaseNum;
	}

	public void setPurchaseNum(double purchaseNum)
	{
		PurchaseNum = purchaseNum;
	}

	public double getRemainNum()
	{
		return RemainNum;
	}

	public void setRemainNum(double remainNum)
	{
		RemainNum = remainNum;
	}

	public String getFromArea()
	{
		return FromArea;
	}

	public void setFromArea(String fromArea)
	{
		FromArea = fromArea;
	}

	public String getRemark()
	{
		return Remark;
	}

	public void setRemark(String remark)
	{
		Remark = remark;
	}

	public Date getPurchaseDate()
	{
		return PurchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate)
	{
		PurchaseDate = purchaseDate;
	}

	public Date getPostTime()
	{
		return PostTime;
	}

	public void setPostTime(Date postTime)
	{
		PostTime = postTime;
	}

	public String getAttach()
	{
		return Attach;
	}

	public void setAttach(String attach)
	{
		Attach = attach;
	}

	public String getAttach1()
	{
		return Attach1;
	}

	public void setAttach1(String attach1)
	{
		Attach1 = attach1;
	}

	public int getApplyId()
	{
		return ApplyId;
	}

	public void setApplyId(int applyId)
	{
		ApplyId = applyId;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}

}

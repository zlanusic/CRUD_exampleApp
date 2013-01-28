package com.mypos.terminal;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name = "POS_TerminalAdmin")
public class Terminal implements Serializable {
	
	private static final long serialVersionUID = -7458116015048726052L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "POS_ID")
	private Long posId;
	
	@Column(name = "POS_OWNER")
	private String posOwner;
	
	@Column(name = "POS_LOCATION")
	private String posLocation;
	
	@Column(name = "POS_ACTIVATION")
	private Date posActivation;
	
	//prazni konstr
	public Terminal()
	{
		
	}
	
	//init membera
	public Terminal(Long posId, String posOwner, String posLocation, Date posAvtivation, Date posActivation)
	{
		this.posId = posId;
		this.posOwner = posOwner;
		this.posLocation = posLocation;
		this.posActivation = posActivation;
	}
	
	//getters i setters metode
	public Long getPosId()
	{
		return posId;
	}
	
	public void setPosId(Long posId)
	{
		this.posId = posId;
	}
	
	public String getPosOwner()
	{
		return posOwner;
	}
	
	public void setPosOwner(String posOwner)
	{
		this.posOwner = posOwner;
	}
	
	public String getPosLocation()
	{
		return posLocation;
	}
	
	public void setPosLocation(String posLocation)
	{
		this.posLocation = posLocation;
	}
	
	public Date getPosActivation()
	{
		return posActivation;
	}
	
	public void setPosActivation(Date posActivation)
	{
		this.posActivation = posActivation;
	}

}

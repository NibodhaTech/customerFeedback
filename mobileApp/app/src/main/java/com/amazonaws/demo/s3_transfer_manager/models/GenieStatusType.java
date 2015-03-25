package com.amazonaws.demo.s3_transfer_manager.models;


public class GenieStatusType {

    public static GenieStatusType  OPEN=new GenieStatusType(1,"OPEN");
    public static GenieStatusType CLOSED=new GenieStatusType(2,"CLOSED") ;
    public static GenieStatusType PROGRESS=new GenieStatusType(3,"PROGRESS") ;

    public GenieStatusType(){}
    public GenieStatusType(long id,String type){
        this.id=id; this.type=type;
    }
	private long id;
	
	private String type;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	
}

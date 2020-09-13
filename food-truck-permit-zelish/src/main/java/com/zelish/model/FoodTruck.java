package com.zelish.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "FOOD_TRUCK")
public class FoodTruck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FOOD_TRUCK_ID")
	private Long id;

	@Column(name = "LOCATION_ID")
	private Long locationid;

	@Column(name = "APPLICANT")
	private String applicant;

	@Column(name = "FACILITY_TYPE")
	private String facilityType;

	@Column(name = "CNN")
	private long cnn;

	@Column(name = "LOCATION_DESCRIPTION", length = 200)
	private String locationDescription;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "BLOCKLOT")
	private String blocklot;

	@Column(name = "BLOCK")
	private String block;

	@Column(name = "LOT")
	private String lot;

	@Column(name = "STATUS")
	private String status;

	@Column(name = "FOODITEMS",length = 5000)
	private String foodItems;

	@Column(name = "X")
	private double x;

	@Column(name = "Y")
	private double y;

	@Column(name = "LATITUDE")
	private double latitude;

	@Column(name = "LONGITUDE")
	private double longitude;

	@Column(name = "SCHEDULE")
	private String schedule;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "NOISENT_DATE")
	private Date noiSent;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "APPROVED_DATE")
	private Date approved;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "RECEIVED_DATE")
	private Date received;

	@Column(name = "PRIOR_PERMIT")
	private boolean priorPermit;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "EXPIRATION_DATE")
	private Date expirationDate;

	@Embedded
	@Column(name = "LOCATION")
	private Location location;

	public FoodTruck() {
	}

	public FoodTruck(Long id, Long locationid, String applicant, String facultyType, long cnn,
			String locationDescription, String address, String blocklot, String block, String lot, String status,
			String foodItems, double x, double y, double latitude, double longitude, String schedule, Date noiSent, Date approved,
			Date received, boolean priorPermit, Date expirationDate, Location location) {
		super();
		this.id = id;
		this.locationid = locationid;
		this.applicant = applicant;
		this.facilityType = facilityType;
		this.cnn = cnn;
		this.locationDescription = locationDescription;
		this.address = address;
		this.blocklot = blocklot;
		this.block = block;
		this.lot = lot;
		this.status = status;
		this.foodItems = foodItems;
		this.x = x;
		this.y = y;
		this.latitude = latitude;
		this.longitude = longitude;
		this.schedule = schedule;
		this.noiSent = noiSent;
		this.approved = approved;
		this.received = received;
		this.priorPermit = priorPermit;
		this.expirationDate = expirationDate;
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getLocationid() {
		return locationid;
	}

	public void setLocationid(Long locationid) {
		this.locationid = locationid;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getFacilityType() {
		return facilityType;
	}

	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}

	public long getCnn() {
		return cnn;
	}

	public void setCnn(long cnn) {
		this.cnn = cnn;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBlocklot() {
		return blocklot;
	}

	public void setBlocklot(String blocklot) {
		this.blocklot = blocklot;
	}

	public String getBlock() {
		return block;
	}

	public void setBlock(String block) {
		this.block = block;
	}

	public String getLot() {
		return lot;
	}

	public void setLot(String lot) {
		this.lot = lot;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFoodItems() {
		return foodItems;
	}

	public void setFoodItems(String foodItems) {
		this.foodItems = foodItems;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public Date getNoiSent() {
		return noiSent;
	}

	public void setNoiSent(Date noiSent) {
		this.noiSent = noiSent;
	}

	public Date getApproved() {
		return approved;
	}

	public void setApproved(Date approved) {
		this.approved = approved;
	}

	public Date getReceived() {
		return received;
	}

	public void setReceived(Date received) {
		this.received = received;
	}

	public boolean isPriorPermit() {
		return priorPermit;
	}

	public void setPriorPermit(boolean priorPermit) {
		this.priorPermit = priorPermit;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

}

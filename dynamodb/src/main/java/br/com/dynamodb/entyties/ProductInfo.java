package br.com.dynamodb.entyties;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConvertedJson;

@DynamoDBTable(tableName="prod")
public class ProductInfo implements Serializable {
	
	private static final long serialVersionUID = 4315513094115421813L;
	
	@DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
	private String id;
	
	@DynamoDBAttribute(attributeName = "msrp")	
	@DynamoDBTypeConvertedJson(targetType = Detail.class)
    private Detail msrp;
    
	@DynamoDBAttribute
    private String cost;
	
	public ProductInfo() {
		
	}

	public ProductInfo(Detail msrp, String cost) {		
		this.msrp = msrp;
		this.cost = cost;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Detail getMsrp() {
		return msrp;
	}

	public void setMsrp(Detail msrp) {
		this.msrp = msrp;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cost == null) ? 0 : cost.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((msrp == null) ? 0 : msrp.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductInfo other = (ProductInfo) obj;
		if (cost == null) {
			if (other.cost != null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (msrp == null) {
			if (other.msrp != null)
				return false;
		} else if (!msrp.equals(other.msrp))
			return false;
		return true;
	}	
}
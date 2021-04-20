package app.prod.src.backend_garage.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "")
public class AboutGarage {

	private String id;
	private String adheadline;
	private String describe;
	
	public AboutGarage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AboutGarage(String adheadline, String describe) {
		super();
		this.adheadline = adheadline;
		this.describe = describe;
	}

	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@DynamoDBAttribute
	public String getAdheadline() {
		return adheadline;
	}

	public void setAdheadline(String adheadline) {
		this.adheadline = adheadline;
	}

	@DynamoDBAttribute
	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	@Override
	public String toString() {
		return "AboutGarage [id: " + id + ", adheadline: " + adheadline + ", describe: " + describe + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((adheadline == null) ? 0 : adheadline.hashCode());
		result = prime * result + ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		AboutGarage other = (AboutGarage) obj;
		if (adheadline == null) {
			if (other.adheadline != null)
				return false;
		} else if (!adheadline.equals(other.adheadline))
			return false;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

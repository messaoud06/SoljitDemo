package dz.soljit.soljitdemo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Candidature {
    public Attributes attributes;
    @JsonProperty("Id")
    public String id;
    @JsonProperty("OwnerId")
    public String ownerId;
    @JsonProperty("IsDeleted")
    public boolean isDeleted;
    @JsonProperty("Name")
    public String name;
    @JsonProperty("CreatedDate")
    public Date createdDate;
    @JsonProperty("CreatedById")
    public String createdById;
    @JsonProperty("LastModifiedDate")
    public Date lastModifiedDate;
    @JsonProperty("LastModifiedById")
    public String lastModifiedById;
    @JsonProperty("SystemModstamp")
    public Date systemModstamp;
    @JsonProperty("LastActivityDate")
    public Object lastActivityDate;
    @JsonProperty("LastViewedDate")
    public Date lastViewedDate;
    @JsonProperty("LastReferencedDate")
    public Date lastReferencedDate;
    @JsonProperty("First_Name__c")
    public String first_Name__c;
    @JsonProperty("Last_Name__c")
    public String last_Name__c;
    @JsonProperty("Year_Of_Experience__c")
    public double year_Of_Experience__c;
    @JsonProperty("Type__c")
    public String type__c;
    @JsonProperty("First_Date__c")
    public String first_Date__c;
    @JsonProperty("Year__c")
    public double year__c;
}

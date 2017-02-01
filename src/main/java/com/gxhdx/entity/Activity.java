package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Activity 
 * @Description: TODO(Activity实体类)
 *  
 */  
@Entity
@Table(name = "hdx_activity")
public  class Activity  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "title")  
	    private  String title;  
		@Column(name = "content")  
	    private  String content;
		@Column(name = "activityStartDate")  
	    private  Date activityStartDate;  
		@Column(name = "activityEndDate")  
	    private  Date activityEndDate;  
		@Column(name = "applyStartDate")  
	    private  Date applyStartDate;  
		@Column(name = "applyEndDate")  
	    private  Date applyEndDate;  
		@Column(name = "keyword")  
	    private  String keyword;  
		@Column(name = "url")  
	    private  String url;  
		@Column(name = "depatement")  
	    private  String depatement;  
		@Column(name = "sponsor")  
	    private  String sponsor;  
		@Column(name = "sponsorPhone")  
	    private  String sponsorPhone;  
		@Column(name = "hits")  
	    private  Integer hits;  
		@Column(name = "type")  
	    private  String type;  
		@Column(name = "remark")  
	    private  String remark;  
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	} 
	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
    public void setTitle(String title){  
        this.title=title;  
    }  
      
    public String getTitle(){  
        return   this.title;  
    }  
    public void setContent(String content){  
        this.content=content;  
    }  
      
    public String getContent(){  
        return   this.content;  
    }  
    public void setActivityStartDate(Date activityStartDate){  
        this.activityStartDate=activityStartDate;  
    }  
      
    public Date getActivityStartDate(){  
        return   this.activityStartDate;  
    }  
    public void setActivityEndDate(Date activityEndDate){  
        this.activityEndDate=activityEndDate;  
    }  
      
    public Date getActivityEndDate(){  
        return   this.activityEndDate;  
    }  
    public void setApplyStartDate(Date applyStartDate){  
        this.applyStartDate=applyStartDate;  
    }  
      
    public Date getApplyStartDate(){  
        return   this.applyStartDate;  
    }  
    public void setApplyEndDate(Date applyEndDate){  
        this.applyEndDate=applyEndDate;  
    }  
      
    public Date getApplyEndDate(){  
        return   this.applyEndDate;  
    }  
    public void setKeyword(String keyword){  
        this.keyword=keyword;  
    }  
      
    public String getKeyword(){  
        return   this.keyword;  
    }  
    public void setUrl(String url){  
        this.url=url;  
    }  
      
    public String getUrl(){  
        return   this.url;  
    }  
    public void setDepatement(String depatement){  
        this.depatement=depatement;  
    }  
      
    public String getDepatement(){  
        return   this.depatement;  
    }  
    public void setSponsor(String sponsor){  
        this.sponsor=sponsor;  
    }  
      
    public String getSponsor(){  
        return   this.sponsor;  
    }  
    public void setSponsorPhone(String sponsorPhone){  
        this.sponsorPhone=sponsorPhone;  
    }  
      
    public String getSponsorPhone(){  
        return   this.sponsorPhone;  
    }  
    public void setHits(Integer hits){  
        this.hits=hits;  
    }  
      
    public Integer getHits(){  
        return   this.hits;  
    }  
    public void setType(String type){  
        this.type=type;  
    }  
      
    public String getType(){  
        return   this.type;  
    }  
    public void setRemark(String remark){  
        this.remark=remark;  
    }  
      
    public String getRemark(){  
        return   this.remark;  
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", modifyDate=" + modifyDate +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", activityStartDate=" + activityStartDate +
                ", activityEndDate=" + activityEndDate +
                ", applyStartDate=" + applyStartDate +
                ", applyEndDate=" + applyEndDate +
                ", keyword='" + keyword + '\'' +
                ", url='" + url + '\'' +
                ", depatement='" + depatement + '\'' +
                ", sponsor='" + sponsor + '\'' +
                ", sponsorPhone='" + sponsorPhone + '\'' +
                ", hits=" + hits +
                ", type='" + type + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
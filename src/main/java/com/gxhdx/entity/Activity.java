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
    @Column(name = "keyword")
    private  String keyword;
    @Column(name = "url")
    private  String url;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},
            fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "department_id",referencedColumnName = "id")
    private  Department department;
    @Column(name = "sponsor")
    private  String sponsor;
    @Column(name = "sponsor_phone")
    private  String sponsorPhone;
    @Column(name = "hits")
    private  Integer hits;
    @Column(name = "remark")
    private  String remark;
    @Column(name = "available")
    private  Boolean available = Boolean.FALSE;
    @Column(name = "img_url")
    private  String imgUrl;
    @ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},
            fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "activity_id",referencedColumnName = "id")
    private ActivityType activityType;
	
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
    public void setRemark(String remark){  
        this.remark=remark;  
    }  
      
    public String getRemark(){  
        return   this.remark;  
    }  
    public void setAvailable(Boolean available){  
        this.available=available;  
    }  
      
    public Boolean getAvailable(){  
        return   this.available;  
    }  
    public void setImgUrl(String imgUrl){  
        this.imgUrl=imgUrl;  
    }  
      
    public String getImgUrl(){  
        return   this.imgUrl;  
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
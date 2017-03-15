package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: ActivityType 
 * @Description: TODO(ActivityType实体类)
 *  
 */  
@Entity
@Table(name = "hdx_activity_type")
public  class ActivityType  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "type_name")
	    private  String typeName;  
		@Column(name = "introduction")  
	    private  String introduction;
	@Column(name = "img_url")
	private String imgUrl;
	
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
    public void setTypeName(String typeName){  
        this.typeName=typeName;  
    }  
      
    public String getTypeName(){  
        return   this.typeName;  
    }  
    public void setIntroduction(String introduction){  
        this.introduction=introduction;  
    }  
      
    public String getIntroduction(){  
        return   this.introduction;  
    }

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
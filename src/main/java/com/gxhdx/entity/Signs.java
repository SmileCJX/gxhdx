package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Signs 
 * @Description: TODO(Signs实体类)
 *  
 */  
@Entity
@Table(name = "hdx_signs")
public  class Signs  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
	@Column(name = "title")
	private  String title;
	@Column(name = "apply_name")
	private  String applyName;
	@Column(name = "available")
	private  Boolean available;
	@Column(name = "remind")
	private  Boolean remind;


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
    public void setApplyName(String applyName){  
        this.applyName=applyName;  
    }  
      
    public String getApplyName(){  
        return   this.applyName;  
    }  
    public void setAvailable(Boolean available){  
        this.available=available;  
    }  
      
    public Boolean getAvailable(){  
        return   this.available;  
    }

	public Boolean getRemind() {
		return remind;
	}

	public void setRemind(Boolean remind) {
		this.remind = remind;
	}
}
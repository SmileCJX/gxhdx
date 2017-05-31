package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Comment 
 * @Description: TODO(Comment实体类)
 *  
 */  
@Entity
@Table(name = "hdx_comment")
public  class Comment  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
	@Column(name = "content")
	private  String content;
	@Column(name = "username")
	private  String username;
	@Column(name = "activity_id")
	private  Long activityId;
	
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
    public void setContent(String content){  
        this.content=content;  
    }  
      
    public String getContent(){  
        return   this.content;  
    }  
    public void setUsername(String username){  
        this.username=username;  
    }  
      
    public String getUsername(){  
        return   this.username;  
    }  
    public void setActivityId(Long activityId){
        this.activityId=activityId;  
    }  
      
    public Long getActivityId(){
        return   this.activityId;  
    }  
} 
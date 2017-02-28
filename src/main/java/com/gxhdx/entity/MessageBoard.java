package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: MessageBoard 
 * @Description: TODO(MessageBoard实体类)
 *  
 */  
@Entity
@Table(name = "hdx_message_board")
public  class MessageBoard  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "phone_number")
	    private  String phoneNumber;  
		@Column(name = "title")  
	    private  String title;  
		@Column(name = "content")  
	    private  String content;  
	
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
    public void setPhoneNumber(String phoneNumber){  
        this.phoneNumber=phoneNumber;  
    }  
      
    public String getPhoneNumber(){  
        return   this.phoneNumber;  
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
} 
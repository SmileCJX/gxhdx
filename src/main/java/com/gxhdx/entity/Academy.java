package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Academy 
 * @Description: TODO(Academy实体类)
 *  
 */  
@Entity
@Table(name = "hdx_academy")
public  class Academy  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "academy_name")
	    private  String academyName;  
	
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
    public void setAcademyName(String academyName){  
        this.academyName=academyName;  
    }  
      
    public String getAcademyName(){  
        return   this.academyName;  
    }  
} 
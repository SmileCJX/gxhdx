package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Profession 
 * @Description: TODO(Profession实体类)
 *  
 */  
@Entity
@Table(name = "hdx_profession")
public  class Profession  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "profession_name")
	    private  String professionName;

	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH},
		fetch = FetchType.EAGER,optional = false)
	@JoinColumn(name = "academy_id",referencedColumnName = "id")
	private Academy academy;
	
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
    public void setProfessionName(String professionName){  
        this.professionName=professionName;  
    }  
      
    public String getProfessionName(){  
        return   this.professionName;  
    }

	public Academy getAcademy() {
		return academy;
	}

	public void setAcademy(Academy academy) {
		this.academy = academy;
	}
}
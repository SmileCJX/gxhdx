package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Department 
 * @Description: TODO(Department实体类)
 *  
 */  
@Entity
@Table(name = "hdx_department")
public  class Department  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "dno")  
	    private  String dno;  
		@Column(name = "name")  
	    private  String name;  
		@Column(name = "minister_name")
	    private  String ministerName;  
		@Column(name = "minister_phone")
	    private  String ministerPhone;  
		@Column(name = "totalPersons")  
	    private  Integer totalPersons;  
		@Column(name = "description")  
	    private  String description;  
	
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
    public void setDno(String dno){  
        this.dno=dno;  
    }  
      
    public String getDno(){  
        return   this.dno;  
    }  
    public void setName(String name){  
        this.name=name;  
    }  
      
    public String getName(){  
        return   this.name;  
    }  
    public void setMinisterName(String ministerName){  
        this.ministerName=ministerName;  
    }  
      
    public String getMinisterName(){  
        return   this.ministerName;  
    }  
    public void setMinisterPhone(String ministerPhone){  
        this.ministerPhone=ministerPhone;  
    }  
      
    public String getMinisterPhone(){  
        return   this.ministerPhone;  
    }  
    public void setTotalPersons(Integer totalPersons){  
        this.totalPersons=totalPersons;  
    }  
      
    public Integer getTotalPersons(){  
        return   this.totalPersons;  
    }  
    public void setDescription(String description){  
        this.description=description;  
    }  
      
    public String getDescription(){  
        return   this.description;  
    }  
} 
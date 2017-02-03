package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Teacher 
 * @Description: TODO(Teacher实体类)
 *  
 */  
@Entity
@Table(name = "hdx_teacher")
public  class Teacher  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "teacher_name")
	    private  String teacherName;  
		@Column(name = "tno")  
	    private  String tno;  
		@Column(name = "academy")  
	    private  String academy;  
		@Column(name = "rank")  
	    private  String rank;  
		@Column(name = "research")  
	    private  String research;  
		@Column(name = "honer")  
	    private  String honer;  
		@Column(name = "education")  
	    private  String education;  
		@Column(name = "email")  
	    private  String email;  
		@Column(name = "role")  
	    private  String role;  
		@Column(name = "introduction")  
	    private  String introduction;  
	
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
    public void setTeacherName(String teacherName){  
        this.teacherName=teacherName;  
    }  
      
    public String getTeacherName(){  
        return   this.teacherName;  
    }  
    public void setTno(String tno){  
        this.tno=tno;  
    }  
      
    public String getTno(){  
        return   this.tno;  
    }  
    public void setAcademy(String academy){  
        this.academy=academy;  
    }  
      
    public String getAcademy(){  
        return   this.academy;  
    }  
    public void setRank(String rank){  
        this.rank=rank;  
    }  
      
    public String getRank(){  
        return   this.rank;  
    }  
    public void setResearch(String research){  
        this.research=research;  
    }  
      
    public String getResearch(){  
        return   this.research;  
    }  
    public void setHoner(String honer){  
        this.honer=honer;  
    }  
      
    public String getHoner(){  
        return   this.honer;  
    }  
    public void setEducation(String education){  
        this.education=education;  
    }  
      
    public String getEducation(){  
        return   this.education;  
    }  
    public void setEmail(String email){  
        this.email=email;  
    }  
      
    public String getEmail(){  
        return   this.email;  
    }  
    public void setRole(String role){  
        this.role=role;  
    }  
      
    public String getRole(){  
        return   this.role;  
    }  
    public void setIntroduction(String introduction){  
        this.introduction=introduction;  
    }  
      
    public String getIntroduction(){  
        return   this.introduction;  
    }  
} 
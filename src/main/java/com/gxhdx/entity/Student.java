package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: Student 
 * @Description: TODO(Student实体类)
 *  
 */  
@Entity
@Table(name = "hdx_student")
public  class Student  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "student_name")
	    private  String studentName;  
		@Column(name = "sno")  
	    private  String sno;  
		@Column(name = "grade")  
	    private  String grade;  
		@Column(name = "academy")  
	    private  String academy;  
		@Column(name = "profession")  
	    private  String profession;  
		@Column(name = "classes")  
	    private  String classes;  
		@Column(name = "phone")  
	    private  String phone;  
		@Column(name = "email")  
	    private  String email;  
		@Column(name = "role")  
	    private  String role;  
	
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
    public void setStudentName(String studentName){  
        this.studentName=studentName;  
    }  
      
    public String getStudentName(){  
        return   this.studentName;  
    }  
    public void setSno(String sno){  
        this.sno=sno;  
    }  
      
    public String getSno(){  
        return   this.sno;  
    }  
    public void setGrade(String grade){  
        this.grade=grade;  
    }  
      
    public String getGrade(){  
        return   this.grade;  
    }  
    public void setAcademy(String academy){  
        this.academy=academy;  
    }  
      
    public String getAcademy(){  
        return   this.academy;  
    }  
    public void setProfession(String profession){  
        this.profession=profession;  
    }  
      
    public String getProfession(){  
        return   this.profession;  
    }  
    public void setClasses(String classes){  
        this.classes=classes;  
    }  
      
    public String getClasses(){  
        return   this.classes;  
    }  
    public void setPhone(String phone){  
        this.phone=phone;  
    }  
      
    public String getPhone(){  
        return   this.phone;  
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
} 
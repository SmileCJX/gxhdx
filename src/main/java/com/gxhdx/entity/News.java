package  com.gxhdx.entity;  
  
//这个地方可以事先定义好需要的类   
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/** 
 * @ClassName: News 
 * @Description: TODO(News实体类)
 *  
 */  
@Entity
@Table(name = "hdx_news")
public  class News  implements  Serializable{  
private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;   
	@Column(name = "modify_date")
	private Date modifyDate;   
		@Column(name = "title")  
	    private  String title;
        @Lob
		@Column(name = "content")  
	    private  String content;  
		@Column(name = "publisher")  
	    private  String publisher;  
		@Column(name = "keyword")  
	    private  String keyword;  
		@Column(name = "url")  
	    private  String url;  
		@Column(name = "picurl")  
	    private  String picurl;  
		@Column(name = "hits")  
	    private  Integer hits;
        @Column(name = "available")
        private  Boolean available = Boolean.FALSE;
	
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
    public void setPublisher(String publisher){  
        this.publisher=publisher;  
    }  
      
    public String getPublisher(){  
        return   this.publisher;  
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
    public void setPicurl(String picurl){  
        this.picurl=picurl;  
    }  
      
    public String getPicurl(){  
        return   this.picurl;  
    }  
    public void setHits(Integer hits){  
        this.hits=hits;  
    }  
      
    public Integer getHits(){  
        return   this.hits;  
    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }
}
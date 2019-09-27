package hello.entitiy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String text;
    private String tag;
    public Message(){}

    public Message(String text, String tag) {
        this.text = text;
        this.tag = tag;
    }

    public Integer getId() {
        if (id!=null){
        return id;}
        return 0;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        if(text!=null) {
            return text;
        }return "пусто";
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getTag() {
        if(tag!=null) {
            return tag;
        }return "пусто";
    }

    public void setTag(String tag) {
        this.tag = tag;
    }


}

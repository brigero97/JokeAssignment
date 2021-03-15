package io.neuraljam.entities;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "joke")
public class Joke {

@Id
   @GeneratedValue(strategy = GenerationType.AUTO)
private int id;

@Column(name = "body")
private String body;

@Column(name = "date_time")
private Date date_time;


public Joke() {

}

public Joke(String body, Date date_time) {
this.body = body;
this.date_time = date_time;
}

public int getId() {
return id;
}

public void setId(int id) {
this.id = id;
}

public Date getDate_time() {
return date_time;
}

public void setDate_time(Date date_time) {
this.date_time = date_time;
}

public String getBody() {
	return body;
}

public void setBody(String body) {
	this.body = body;
}



}
package hiber.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Getter
@Setter
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement id
    private long id;
    private String name;
}

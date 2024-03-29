package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id")
    private int id;

    private String branchName;

    private String title;

    private String author;

    private String genre;

    private String status;

    @CreationTimestamp
    private Timestamp dateTime;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "book")
    private List<Transaction> bookTransaction = new ArrayList<>();

    public Book(String branchName, String author, String title, String genre, String status) {
        this.branchName = branchName;
        this.author = author;
        this.title = title;
        this.genre = genre;
        this.status = status;
    }

}


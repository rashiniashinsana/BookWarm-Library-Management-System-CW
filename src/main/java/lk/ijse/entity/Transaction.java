package lk.ijse.entity;

import jakarta.persistence.*;
import lombok.*;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "transaction")
public class Transaction implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private int id;

    private String userName;

    @Column(name = "book_title")
    private String bookTitle;

    private String branch;

    private Date borrowing;

    private Date returning;

    private String status;

    @OneToMany(mappedBy = "transactions")
    private List<BookTransaction> bookTransactions = new ArrayList<>();

    public Transaction(String userName, String bookTitle, String branch, Date borrowing, Date returning) {
        this.userName = userName;
        this.bookTitle = bookTitle;
        this.branch = branch;
        this.borrowing = borrowing;
        this.returning = returning;
    }

}

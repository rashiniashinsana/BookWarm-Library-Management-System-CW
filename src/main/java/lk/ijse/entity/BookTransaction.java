package lk.ijse.entity;

import jakarta.persistence.*;
import lk.ijse.embedded.BookTransactionPK;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "bookTransactions_details")
public class BookTransaction {

    @EmbeddedId
    private BookTransactionPK bookTransactionPK;

    @ManyToOne
    @JoinColumn(name = "bookId" ,insertable = false,updatable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "transactionId",insertable = false,updatable = false)
    private Transaction transaction;

    @CreationTimestamp
    private Timestamp timestamp;

}
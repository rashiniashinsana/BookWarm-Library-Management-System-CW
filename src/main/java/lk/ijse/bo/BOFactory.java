package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;
import lk.ijse.bo.custom.impl.TransactionBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {
    }

    public static BOFactory getBoFactory() {
        return (boFactory == null)? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes{
        USER,ADMIN,BRANCH,BOOK,TRANSACTION
    }

    public SuperBO getBO(BOTypes boTypes) {
        switch (boTypes) {
            case USER:
                return new UserBOImpl();
            case ADMIN:
                return new AdminBOImpl();
            case BRANCH:
                return new BranchBOImpl();
            case BOOK:
                return new BookBOImpl();
            case TRANSACTION:
                return new TransactionBOImpl();
            default:
                return null;
        }
    }
}

package espminvest.poo.wallet.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import espminvest.poo.wallet.common.datatype.CambioTransactionBean;
import espminvest.poo.wallet.common.datatype.WalletBean;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "wallet")
public class WalletModel {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "wallet_id")
    private int id;
    private int user_id;
    @Column(name = "wallet_balance")
    private Double balance;

    public WalletModel(){}

    public WalletModel(WalletBean wallet){
        this.user_id = wallet.getUser();
        this.balance = 0.0;
    }

    public WalletBean toBean() {
        WalletBean wallet = new WalletBean();
        wallet.setId(id);
        wallet.setUser(user_id);
        wallet.setBalance(balance);

        return wallet;
    }

}

package espminvest.poo.wallet.model;


import espminvest.poo.wallet.common.datatype.CambioTransactionBean;
import espminvest.poo.wallet.common.datatype.WalletBean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "wallet")
public class WalletModel {

    @Id
    @Column(name = "wallet_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int user_id;
    @Column(name = "wallet_balance")
    private Double balance;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CambioTransactionBean> cambioTransactions;

    public WalletModel(){}

    public WalletModel(WalletBean wallet){
        this.user_id = wallet.getUser();
        this.balance = wallet.getBalance();
    }

    public WalletBean toBean() {
        WalletBean wallet = new WalletBean();
        wallet.setId(id);
        wallet.setUser(user_id);
        wallet.setBalance(balance);
        wallet.setCambioTransactions(cambioTransactions);

        return wallet;
    }

}

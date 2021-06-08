package espminvest.poo.wallet.model;

import espminvest.poo.wallet.common.datatype.CambioTransactionBean;
import espminvest.poo.wallet.common.datatype.WalletBean;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cambiotransaction")
public class CambioTransactionModel {

    @Id
    @Column(name = "ct_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    @ManyToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "wallet_id")
    private WalletBean wallet_id;
    private int estimate_id;
    @Column(name = "ct_date")
    private Date date;
    @Column(name = "ct_qtd")
    private Double qtd;

    public CambioTransactionModel(){}

    public CambioTransactionModel(CambioTransactionBean cambioTransaction){
        this.wallet_id = cambioTransaction.getWallet();
        this.estimate_id = cambioTransaction.getEstimate();
        this.date = cambioTransaction.getDate();
        this.qtd = cambioTransaction.getQtd();
    }

    public CambioTransactionBean toBean(){
        CambioTransactionBean ct = new CambioTransactionBean();
        ct.setWallet(wallet_id);
        ct.setEstimate(estimate_id);
        ct.setDate(date);
        ct.setQtd(qtd);

        return ct;
    }


}

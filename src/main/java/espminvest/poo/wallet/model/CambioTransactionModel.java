package espminvest.poo.wallet.model;

import espminvest.poo.cambio.common.datatype.EstimateBean;
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
    private int walletId;
    private int estimateId;
    @Column(name = "ct_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Column(name = "ct_qtd")
    private Double qtd;

    public CambioTransactionModel(){}

    public CambioTransactionModel(CambioTransactionBean cambioTransaction){
        this.walletId = cambioTransaction.getWallet().getId();
        this.estimateId = cambioTransaction.getEstimate().getId();
        this.date = cambioTransaction.getDate();
        this.qtd = cambioTransaction.getQtd();

    }

    public CambioTransactionBean toBean(){
        WalletBean wallet = new WalletBean();
        wallet.setId(walletId);

        EstimateBean estimate = new EstimateBean();
        estimate.setId(estimateId);

        CambioTransactionBean ct = new CambioTransactionBean();
        ct.setId(id);
        ct.setWallet(wallet);
        ct.setEstimate(estimate);
        ct.setDate(date);
        ct.setQtd(qtd);

        return ct;
    }


}

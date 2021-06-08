package espminvest.poo.wallet.respository;

import espminvest.poo.wallet.model.WalletModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface WalletRepository extends CrudRepository<WalletModel, Integer> {

    @Override
    WalletModel save(WalletModel wallet);

    @Query("SELECT w FROM WalletModel w WHERE w.user_id = :userId")
    Optional<WalletModel> findById(@Param("userId") Integer userId);


}

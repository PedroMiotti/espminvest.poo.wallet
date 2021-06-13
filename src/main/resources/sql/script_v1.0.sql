CREATE TABLE `espminvest.poo.wallet`.`cambiotransaction` (
  `ct_id` INT NOT NULL AUTO_INCREMENT,
  `wallet_id` INT NULL,
  `estimate_id` INT NULL,
  `ct_date` DATETIME NULL,
  `ct_qtd` DECIMAL(12,2) NULL,
  PRIMARY KEY (`ct_id`));
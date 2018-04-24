DROP table tcr;

ALTER TABLE suprimento DROP PRIMARY KEY;
ALTER TABLE suprimento MODIFY id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE deposito DROP PRIMARY KEY;
ALTER TABLE deposito MODIFY id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE saque DROP PRIMARY KEY;
ALTER TABLE saque MODIFY id INT AUTO_INCREMENT PRIMARY KEY;

ALTER TABLE retirada DROP PRIMARY KEY;
ALTER TABLE retirada MODIFY id INT AUTO_INCREMENT PRIMARY KEY;

create table tcr (id int AUTO_INCREMENT,
				  ds_nome varchar(100) not null,
				  cd_posto int not null,
				  cd_coop int not null,
				  id_tesoureiro_ativo char default 'N' not null ,
				  cd_usuario_alt varchar(10) not null,
				  dt_inclusao datetime not null,
				  dt_alteracao datetime not null,
				  id_limite_excedido_autoriza_tesoureiro char default 'N' not null,
				  id_suprimento int null,
				  id_retirada int null,
				  id_saque int null,
				  id_deposito int null,
				  primary key (id),
				  foreign key (id_suprimento) references suprimento(id),
				  foreign key (id_retirada) references retirada(id),
				  foreign key (id_saque) references saque(id),
				  foreign key (id_deposito) references deposito(id));
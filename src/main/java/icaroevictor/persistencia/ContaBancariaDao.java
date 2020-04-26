package icaroevictor.persistencia;

import java.util.List;
import icaroevictor.entidades.ContaBancaria;

public interface ContaBancariaDao {
    boolean create (ContaBancaria conta);
    List<ContaBancaria> read ();
    boolean update(ContaBancaria conta);
    boolean delete(ContaBancaria conta);

}


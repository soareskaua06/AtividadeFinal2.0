package teste;

import DAO.ConexaoDB;

public class teste {
        public static void main(String[] args) {
        ConexaoDB conecta = new ConexaoDB();
        conecta.getConnection();
    }
}

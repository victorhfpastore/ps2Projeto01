package icaroevictor;

import icaroevictor.entidades.ContaBancaria;
import icaroevictor.persistencia.ContaBancariaDao;
import icaroevictor.persistencia.PaisDAO;
import icaroevictor.entidades.Pais;

import java.util.*;

public class InterfaceUsuario {
    ContaBancariaDao dao;
    PaisDAO dao2;
    Scanner in;

    public InterfaceUsuario(PaisDAO dao2, ContaBancariaDao dao){
        this.dao2=dao2;
        this.dao = dao;
        this.in = new Scanner(System.in);
    }

    public void imprimeboasvindas(){boasvindas();}

    private void boasvindas() {
        System.out.println("\t Olá, bem vindo");
        System.out.println("Já possui uma conta? Se sim digite 1, senão digite 2");
        int resp = in.nextInt();
        if (resp == 2) {
            System.out.println("\t Certo! Então agora vamos iniciar o processo para criar sua conta bancaria!!!");
            System.out.println("\t Primeiro, vamos precisar saber algumas informações sobre seu país!");
            this.create1();
            System.out.println("Ok! Agora vamos criar sua conta!");
            this.create();

        } else {
            System.out.println("OK!");
        }
    }


    private void create1() {
        Pais pais = new Pais();

        System.out.println("\n******************");
        System.out.println(" Informações necessárias ");
        System.out.println("******************");
        System.out.print("Insira o nome do país: ");
        pais.setNome(in.next());
        System.out.println("Insira o continente que está localizado: " );
        pais.setContinente(in.next());
        System.out.println("Qual o tamanho da população? ");
        pais.setPopulacao(in.nextLong());

        if (dao2.create(pais)) {
            System.out.println("As informações do pais foram adicionadas ao nosso banco de Dados!!!");
        } else {
            System.out.println("Ops: problema ao adicionar as informações");
        }
    }





    public void iniciar() {
        imprimirMenu();
    }

    private void imprimirMenu() {
        System.out.println("\tAgora você pode escolher o que deseja fazer(Criar mais uma conta, visualizar, atualizar ou deletar): ");
        int opc = 0;
        do {

            System.out.println("\t==== Menu ====");
            System.out.println("\t1. Create");
            System.out.println("\t2. Read");
            System.out.println("\t3. Update");
            System.out.println("\t4. Delete");
            System.out.println("\t5. sair");
            System.out.print("Escolha uma opção: ");
            opc = in.nextInt();
            in.nextLine();

            switch (opc) {
                case 1:
                    this.create();
                    break;
                case 2:
                    this.read();
                    break;
                case 3:
                    this.update();
                    break;
                case 4:
                    this.delete();
                    break;
                case 5:
                    System.out.println("O programa foi finalizado! Obrigado!");
                    break;
                default:
                    System.out.println("Opção Inválida");
                    break;
            }

        }while (opc != 5);
    }

    private void create() {
        ContaBancaria conta = new ContaBancaria();

        System.out.println("\n******************");
        System.out.println(" Criar nova conta ");
        System.out.println("******************");
        System.out.print("Insira o seu nome: ");
        conta.setNome(in.next());
        System.out.println("Insira seu saldo: " );
        conta.setSaldo(in.nextLong());
        System.out.println("Qual é o número da agência? ");
        conta.setAgencia(in.nextInt());

        if (dao.create(conta)) {
            System.out.println("Nova conta bancaria adicionada ao banco de Dados");
        } else {
            System.out.println("Ops: problema ao adicionar a nova conta");
        }
    }

    private void read() {
        List<ContaBancaria> contas = dao.read();
        System.out.println("*** Lista de contas cadastradas ***");
        for (ContaBancaria conta : contas) {
            System.out.println(conta);
        }
    }

    private void update() {
        ContaBancaria conta = new ContaBancaria();
        System.out.println("Qual conta deseja atualizar?");
        conta.setId(in.nextInt());
        in.nextLine();
        System.out.println("Altere o nome para: ");
        conta.setNome(in.nextLine());
        System.out.println("Atualize o saldo para:");
        conta.setSaldo((in.nextLong()));
        System.out.println("Atualize o número da agência para:");
        conta.setAgencia(in.nextInt());


        if(dao.update(conta)){
            System.out.println("Conta Bancaria atualizada com sucesso!");
        } else{
            System.out.println("Ops, problema ao atualizar a conta");
        }
    }


    private void delete () {
        List<ContaBancaria> contas = dao.read();

        while (true) {
            System.out.println("\n***********************************");
            System.out.println(" Lista de Contas Cadastradas ");
            System.out.println("***********************************");
            int i = 0;
            for (ContaBancaria conta : contas) {
                System.out.println(i + " - " + conta);
                i++;
            }
            System.out.println(i + " - Cancelar operação");

            System.out.print("Qual conta deseja remover? ");
            int opc = in.nextInt();
            in.nextLine();

            if (opc == i) {
                break;
            }

            if (opc >= contas.size() || opc < 0) {
                System.out.println("Esta opção não é válida");
            } else {
                if (dao.delete(contas.get(opc))) {
                    System.out.println("Conta do(a) " + contas.get(opc).getNome() +
                            " foi removida ");
                } else {
                    System.out.println("OPS: falha ao remover");
                }
                break;
            }
        }
    }
}

